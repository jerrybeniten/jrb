// BenitenInterpreter.java
// Requires ANTLR-generated classes from BenitenLanguage.g4
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;
import java.io.IOException;

/**
 * Single-file interpreter for BenitenLanguage (Java).
 * Assumes ANTLR generated classes: BenitenLanguageLexer, BenitenLanguageParser, BenitenLanguageBaseVisitor
 */
public class BenitenInterpreter {

    // ---------- Typed value wrapper ----------
    static class TypedValue {
        final String type; // "int", "float", "string", "bool"
        final Object value;

        TypedValue(String type, Object value) {
            this.type = type;
            this.value = value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    // ---------- Environment (scope) ----------
    static class Environment {
        private final Map<String, TypedValue> vars = new HashMap<>();
        private final Environment parent;

        Environment(Environment parent) { this.parent = parent; }

        void declare(String name, TypedValue tv) {
            vars.put(name, tv);
        }

        boolean containsLocal(String name) { return vars.containsKey(name); }

        TypedValue get(String name) {
            if (vars.containsKey(name)) return vars.get(name);
            if (parent != null) return parent.get(name);
            throw new RuntimeException("Undefined variable " + name);
        }

        void set(String name, TypedValue tv) {
            if (vars.containsKey(name)) {
                vars.put(name, tv);
                return;
            }
            if (parent != null) {
                parent.set(name, tv);
                return;
            }
            throw new RuntimeException("Undefined variable " + name);
        }
    }

    // ---------- Function representation ----------
    static class FunctionDef {
        final List<Param> params;
        final String returnType; // may be null
        final BenitenLanguageParser.BlockContext block;

        FunctionDef(List<Param> params, String returnType, BenitenLanguageParser.BlockContext block) {
            this.params = params; this.returnType = returnType; this.block = block;
        }
    }

    static class Param {
        final String type;
        final String name;
        Param(String type, String name) { this.type = type; this.name = name; }
    }

    // ---------- Return signal ----------
    static class ReturnSignal extends RuntimeException {
        final TypedValue value;
        ReturnSignal(TypedValue v) { this.value = v; }
    }

    // ---------- The Visitor Interpreter ----------
    static class EvalVisitor extends BenitenLanguageBaseVisitor<TypedValue> {
        private Environment env = new Environment(null);
        private final Map<String, FunctionDef> functions = new HashMap<>();

        // program
        @Override
        public TypedValue visitProgram(BenitenLanguageParser.ProgramContext ctx) {
            for (BenitenLanguageParser.StatementContext st : ctx.statement()) {
                visit(st);
            }
            return null;
        }

        // statement dispatch handled by generated visit methods (we override those we need)

        // varDecl: type VARIABLE '=' expr ';'
        @Override
        public TypedValue visitVarDecl(BenitenLanguageParser.VarDeclContext ctx) {
            String typ = ctx.type().getText();
            String varName = ctx.VARIABLE().getText();
            BenitenLanguageParser.ExprContext expr = ctx.expr();
            TypedValue tv = visit(expr);
            checkTypeCompatibility(typ, tv);
            env.declare(varName, new TypedValue(typ, tv.value));
            return null;
        }

        // assignment: VARIABLE '=' expr ';'
        @Override
        public TypedValue visitAssignment(BenitenLanguageParser.AssignmentContext ctx) {
            String name = ctx.VARIABLE().getText();
            TypedValue cur = env.get(name);
            TypedValue val = visit(ctx.expr());
            checkTypeCompatibility(cur.type, val);
            env.set(name, new TypedValue(cur.type, val.value));
            return null;
        }

        // echoStmt: ECHO expr ';'
        @Override
        public TypedValue visitEchoStmt(BenitenLanguageParser.EchoStmtContext ctx) {
            TypedValue tv = visit(ctx.expr());
            // Print as in examples (strings without quotes)
            System.out.println(tv.value);
            return null;
        }

        // funcDecl: FUNCTION ID '(' paramList? ')' returnType? block
        @Override
        public TypedValue visitFuncDecl(BenitenLanguageParser.FuncDeclContext ctx) {
            String name = ctx.ID().getText();
            List<Param> params = new ArrayList<>();
            if (ctx.paramList() != null) {
                for (BenitenLanguageParser.ParamContext p : ctx.paramList().param()) {
                    String t = p.type().getText();
                    String v = p.VARIABLE().getText();
                    params.add(new Param(t, v));
                }
            }
            String returnType = null;
            if (ctx.returnType() != null) returnType = ctx.returnType().type().getText();
            functions.put(name, new FunctionDef(params, returnType, ctx.block()));
            return null;
        }

        // ifStmt: IF '(' expr ')' block ( ELSE ( ifStmt | block ) )?
        @Override
        public TypedValue visitIfStmt(BenitenLanguageParser.IfStmtContext ctx) {
            TypedValue cond = visit(ctx.expr());
            if (!(cond.value instanceof Boolean)) throw new RuntimeException("If condition must be boolean");
            if ((Boolean)cond.value) {
                visit(ctx.block(0));
            } else {
                if (ctx.ELSE() != null) {
                    if (ctx.ifStmt() != null) {
                        visit(ctx.ifStmt());
                    } else {
                        // else block
                        visit(ctx.block(1));
                    }
                }
            }
            return null;
        }

        // whileStmt: WHILE '(' expr ')' block
        @Override
        public TypedValue visitWhileStmt(BenitenLanguageParser.WhileStmtContext ctx) {
            while (true) {
                TypedValue cond = visit(ctx.expr());
                if (!(cond.value instanceof Boolean)) throw new RuntimeException("While condition must be boolean");
                if (!(Boolean) cond.value) break;
                visit(ctx.block());
            }
            return null;
        }

        // returnStmt: RETURN expr? ';'
        @Override
        public TypedValue visitReturnStmt(BenitenLanguageParser.ReturnStmtContext ctx) {
            if (ctx.expr() != null) {
                TypedValue tv = visit(ctx.expr());
                throw new ReturnSignal(tv);
            } else {
                throw new ReturnSignal(null);
            }
        }

        // block: '{' statement* '}'
        @Override
        public TypedValue visitBlock(BenitenLanguageParser.BlockContext ctx) {
            Environment saved = env;
            env = new Environment(saved);
            try {
                for (BenitenLanguageParser.StatementContext st : ctx.statement()) {
                    visit(st);
                }
            } finally {
                env = saved;
            }
            return null;
        }

        // expr -> uses generated subrules; we implement the relevant visitors

        // equalityExpr: relationalExpr ( (EQ | SEQ | NEQ | SNEQ) relationalExpr )*
        @Override
        public TypedValue visitEqualityExpr(BenitenLanguageParser.EqualityExprContext ctx) {
            TypedValue left = visit(ctx.relationalExpr(0));
            for (int i = 1; i < ctx.relationalExpr().size(); i++) {
                String op = ctx.getChild(2*i -1).getText(); // operator token
                TypedValue right = visit(ctx.relationalExpr(i));
                boolean result;
                if (op.equals("==") || op.equals("===")) {
                    result = equalsLoose(left, right);
                } else { // != or !==
                    result = !equalsLoose(left, right);
                }
                left = new TypedValue("bool", result);
            }
            return left;
        }

        // relationalExpr: additiveExpr ( (LT | LE | GT | GE) additiveExpr )*
        @Override
        public TypedValue visitRelationalExpr(BenitenLanguageParser.RelationalExprContext ctx) {
            TypedValue left = visit(ctx.additiveExpr(0));
            for (int i = 1; i < ctx.additiveExpr().size(); i++) {
                String op = ctx.getChild(2*i -1).getText();
                TypedValue right = visit(ctx.additiveExpr(i));
                boolean result = compareRelational(left, right, op);
                left = new TypedValue("bool", result);
            }
            return left;
        }

        // additiveExpr: multiplicativeExpr ( ('+' | '-') multiplicativeExpr )*
        @Override
        public TypedValue visitAdditiveExpr(BenitenLanguageParser.AdditiveExprContext ctx) {
            TypedValue result = visit(ctx.multiplicativeExpr(0));
            for (int i = 1; i < ctx.multiplicativeExpr().size(); i++) {
                String op = ctx.getChild(2*i -1).getText();
                TypedValue right = visit(ctx.multiplicativeExpr(i));
                result = applyAddSub(result, right, op);
            }
            return result;
        }

        // multiplicativeExpr: unaryExpr ( ('*' | '/') unaryExpr )*
        @Override
        public TypedValue visitMultiplicativeExpr(BenitenLanguageParser.MultiplicativeExprContext ctx) {
            TypedValue result = visit(ctx.unaryExpr(0));
            for (int i = 1; i < ctx.unaryExpr().size(); i++) {
                String op = ctx.getChild(2*i -1).getText();
                TypedValue right = visit(ctx.unaryExpr(i));
                result = applyMulDiv(result, right, op);
            }
            return result;
        }

        // unaryExpr: ('+' | '-' | '!') unaryExpr | primary
        @Override
        public TypedValue visitUnaryExpr(BenitenLanguageParser.UnaryExprContext ctx) {
            if (ctx.getChildCount() == 2) {
                String op = ctx.getChild(0).getText();
                TypedValue val = visit(ctx.unaryExpr());
                switch (op) {
                    case "-":
                        if (val.value instanceof Integer) return new TypedValue("int", -((Integer)val.value));
                        if (val.value instanceof Double) return new TypedValue("float", -((Double)val.value));
                        throw new RuntimeException("Unary - on non-number");
                    case "+":
                        return val;
                    case "!":
                        if (!(val.value instanceof Boolean)) throw new RuntimeException("! operator expects boolean");
                        return new TypedValue("bool", !((Boolean)val.value));
                }
            }
            return visit(ctx.primary());
        }

        // primary: literal | VARIABLE | ID '(' argList? ')' | '(' expr ')'
        @Override
        public TypedValue visitPrimary(BenitenLanguageParser.PrimaryContext ctx) {
            if (ctx.literal() != null) return visit(ctx.literal());
            if (ctx.VARIABLE() != null) {
                return env.get(ctx.VARIABLE().getText());
            }
            if (ctx.ID() != null && ctx.LPAR() != null) {
                // function call
                String name = ctx.ID().getText();
                FunctionDef fn = functions.get(name);
                if (fn == null) throw new RuntimeException("Undefined function " + name);
                // evaluate args
                List<TypedValue> args = new ArrayList<>();
                if (ctx.argList() != null) {
                    for (BenitenLanguageParser.ArgContext a : ctx.argList().arg()) {
                        TypedValue av = visit(a.expr());
                        args.add(av);
                    }
                }
                if (args.size() != fn.params.size()) throw new RuntimeException("Argument count mismatch for " + name);
                // setup local environment
                Environment saved = env;
                env = new Environment(saved);
                try {
                    for (int i = 0; i < fn.params.size(); i++) {
                        Param p = fn.params.get(i);
                        TypedValue av = args.get(i);
                        checkTypeCompatibility(p.type, av);
                        env.declare(p.name, new TypedValue(p.type, av.value));
                    }
                    try {
                        visit(fn.block);
                    } catch (ReturnSignal rs) {
                        TypedValue ret = rs.value;
                        if (fn.returnType != null) {
                            checkTypeCompatibility(fn.returnType, ret);
                        }
                        return ret != null ? ret : new TypedValue("null", null);
                    }
                    if (fn.returnType != null) throw new RuntimeException("Function " + name + " must return a value of type " + fn.returnType);
                    return new TypedValue("null", null);
                } finally {
                    env = saved;
                }
            }
            if (ctx.expr() != null) return visit(ctx.expr());
            throw new RuntimeException("Unknown primary");
        }

        // arg: expr (type)?  -- we only evaluate expr; type in call is ignored here
        @Override
        public TypedValue visitArg(BenitenLanguageParser.ArgContext ctx) {
            return visit(ctx.expr());
        }

        // literal: INT_LITERAL | FLOAT_LITERAL | STRING | BOOL_LITERAL
        @Override
        public TypedValue visitLiteral(BenitenLanguageParser.LiteralContext ctx) {
            if (ctx.INT_LITERAL() != null) {
                return new TypedValue("int", Integer.parseInt(ctx.INT_LITERAL().getText()));
            }
            if (ctx.FLOAT_LITERAL() != null) {
                return new TypedValue("float", Double.parseDouble(ctx.FLOAT_LITERAL().getText()));
            }
            if (ctx.STRING() != null) {
                String raw = ctx.STRING().getText();
                // strip quotes (single or double)
                String s = raw.substring(1, raw.length()-1);
                // simple unescape for common sequences
                s = s.replace("\\\"", "\"").replace("\\'", "'").replace("\\n", "\n").replace("\\t", "\t");
                return new TypedValue("string", s);
            }
            if (ctx.BOOL_LITERAL() != null) {
                return new TypedValue("bool", ctx.BOOL_LITERAL().getText().equals("true"));
            }
            throw new RuntimeException("Unknown literal");
        }

        // Helper: type checking & conversions
        private void checkTypeCompatibility(String expectedType, TypedValue actual) {
            if (expectedType.equals("int")) {
                if (!(actual.value instanceof Integer)) throw new RuntimeException("Type error: expected int but got " + typeOf(actual));
            } else if (expectedType.equals("float")) {
                if (!(actual.value instanceof Double)) throw new RuntimeException("Type error: expected float but got " + typeOf(actual));
            } else if (expectedType.equals("string")) {
                if (!(actual.value instanceof String)) throw new RuntimeException("Type error: expected string but got " + typeOf(actual));
            } else if (expectedType.equals("bool")) {
                if (!(actual.value instanceof Boolean)) throw new RuntimeException("Type error: expected bool but got " + typeOf(actual));
            }
        }

        private String typeOf(TypedValue v) {
            if (v == null) return "null";
            if (v.value == null) return "null";
            if (v.value instanceof Integer) return "int";
            if (v.value instanceof Double) return "float";
            if (v.value instanceof String) return "string";
            if (v.value instanceof Boolean) return "bool";
            return v.value.getClass().getSimpleName();
        }

        // equality loose compare (allows int==float)
        private boolean equalsLoose(TypedValue a, TypedValue b) {
            if (a.value == null && b.value == null) return true;
            if (a.value == null || b.value == null) return false;
            if (a.value instanceof Integer && b.value instanceof Integer) return ((Integer)a.value).equals((Integer)b.value);
            if (a.value instanceof Double && b.value instanceof Double) return ((Double)a.value).equals((Double)b.value);
            if (a.value instanceof Integer && b.value instanceof Double) return ((Integer)a.value).doubleValue() == (Double)b.value;
            if (a.value instanceof Double && b.value instanceof Integer) return ((Double)a.value) == ((Integer)b.value).doubleValue();
            return a.value.equals(b.value);
        }

        private boolean compareRelational(TypedValue a, TypedValue b, String op) {
            if ((a.value instanceof Integer || a.value instanceof Double)
                    && (b.value instanceof Integer || b.value instanceof Double)) {
                double da = (a.value instanceof Integer) ? ((Integer)a.value).doubleValue() : (Double)a.value;
                double db = (b.value instanceof Integer) ? ((Integer)b.value).doubleValue() : (Double)b.value;
                switch (op) {
                    case "<": return da < db;
                    case "<=": return da <= db;
                    case ">": return da > db;
                    case ">=": return da >= db;
                }
            } else if (a.value instanceof String && b.value instanceof String) {
                int cmp = ((String)a.value).compareTo((String)b.value);
                switch (op) {
                    case "<": return cmp < 0;
                    case "<=": return cmp <= 0;
                    case ">": return cmp > 0;
                    case ">=": return cmp >= 0;
                }
            } else {
                throw new RuntimeException("Relational comparison not supported for types: " + typeOf(a) + " and " + typeOf(b));
            }
            return false;
        }

        private TypedValue applyAddSub(TypedValue left, TypedValue right, String op) {
            // If either float, do float math
            if ((left.value instanceof Double) || (right.value instanceof Double)) {
                double a = (left.value instanceof Integer) ? ((Integer)left.value).doubleValue() : (Double)left.value;
                double b = (right.value instanceof Integer) ? ((Integer)right.value).doubleValue() : (Double)right.value;
                switch (op) {
                    case "+": return new TypedValue("float", a + b);
                    case "-": return new TypedValue("float", a - b);
                }
            } else if (left.value instanceof Integer && right.value instanceof Integer) {
                int a = (Integer)left.value;
                int b = (Integer)right.value;
                switch (op) {
                    case "+": return new TypedValue("int", a + b);
                    case "-": return new TypedValue("int", a - b);
                }
            } else if (left.value instanceof String && op.equals("+")) {
                // string concatenation
                return new TypedValue("string", String.valueOf(left.value) + String.valueOf(right.value));
            }
            throw new RuntimeException("Invalid operands for " + op + ": " + typeOf(left) + " and " + typeOf(right));
        }

        private TypedValue applyMulDiv(TypedValue left, TypedValue right, String op) {
            if ((left.value instanceof Double) || (right.value instanceof Double)) {
                double a = (left.value instanceof Integer) ? ((Integer)left.value).doubleValue() : (Double)left.value;
                double b = (right.value instanceof Integer) ? ((Integer)right.value).doubleValue() : (Double)right.value;
                switch (op) {
                    case "*": return new TypedValue("float", a * b);
                    case "/": return new TypedValue("float", a / b);
                }
            } else if (left.value instanceof Integer && right.value instanceof Integer) {
                int a = (Integer)left.value;
                int b = (Integer)right.value;
                switch (op) {
                    case "*": return new TypedValue("int", a * b);
                    case "/": return new TypedValue("int", a / b); // integer division
                }
            }
            throw new RuntimeException("Invalid operands for " + op + ": " + typeOf(left) + " and " + typeOf(right));
        }

        // visitExpr (rule expr delegates to equalityExpr by grammar) - fallback
        @Override
        public TypedValue visitExpr(BenitenLanguageParser.ExprContext ctx) {
            return visitChildren(ctx);
        }
    }

    // ---------- Main runner ----------
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            System.err.println("Usage: java BenitenInterpreter <source.ben>");
            System.exit(1);
        }
        String file = args[0];
        CharStream input = CharStreams.fromFileName(file);
        BenitenLanguageLexer lexer = new BenitenLanguageLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BenitenLanguageParser parser = new BenitenLanguageParser(tokens);
        ParseTree tree = parser.program();

        EvalVisitor visitor = new EvalVisitor();
        visitor.visit(tree);
    }
}
