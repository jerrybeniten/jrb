import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.*;

/**
 * SemanticAnalyzer: Walks the parse tree, builds symbol table(s) and checks types.
 *
 * Use analyzer.analyze(programCtx) where programCtx is BenitenLanguageParser.ProgramContext.
 *
 * Throws SemanticException on errors with line/column info.
 */
public class SemanticAnalyzer extends BenitenLanguageBaseVisitor<String> {

    // ---------- Types ----------
    public static final String TYPE_INT = "int";
    public static final String TYPE_FLOAT = "float";
    public static final String TYPE_STRING = "string";
    public static final String TYPE_BOOL = "bool";
    public static final String TYPE_VOID = "void"; // used for functions with no returnType

    public static class SemanticException extends RuntimeException {
        public SemanticException(String message) { super(message); }
    }

        // ---------- Optional CLI main for semantic checking ----------
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Usage: java SemanticAnalyzer <file.ben>");
            System.exit(1);
        }

        try {
            CharStream input = CharStreams.fromFileName(args[0]);
            BenitenLanguageLexer lexer = new BenitenLanguageLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            BenitenLanguageParser parser = new BenitenLanguageParser(tokens);

            // Parse
            BenitenLanguageParser.ProgramContext tree = parser.program();

            // Run semantic analysis
            SemanticAnalyzer analyzer = new SemanticAnalyzer();
            analyzer.analyze(tree);

            System.out.println("Semantic analysis passed ✔");

        } catch (SemanticException e) {
            System.err.println("Semantic error: " + e.getMessage());
            System.exit(2);

        } catch (Exception e) {
            System.err.println("Internal error: " + e.getMessage());
            e.printStackTrace();
            System.exit(3);
        }
    }



    // ---------- Symbol / Scope ----------
    static class Scope {
        private final Map<String, String> vars = new LinkedHashMap<>(); // name -> type
        private final Scope parent;
        Scope(Scope parent) { this.parent = parent; }
        boolean containsLocal(String name) { return vars.containsKey(name); }
        void declare(String name, String type) { vars.put(name, type); }
        String lookup(String name) {
            if (vars.containsKey(name)) return vars.get(name);
            if (parent != null) return parent.lookup(name);
            return null;
        }
    }

    // ---------- Function symbol ----------
    static class FunctionSymbol {
        final List<String> paramTypes;     // ordered
        final List<String> paramNames;     // ordered names for duplication checks
        final String returnType;           // may be TYPE_VOID (null in grammar)
        final BenitenLanguageParser.BlockContext blockCtx;
        FunctionSymbol(List<String> paramTypes, List<String> paramNames, String returnType,
                       BenitenLanguageParser.BlockContext blockCtx) {
            this.paramTypes = paramTypes;
            this.paramNames = paramNames;
            this.returnType = returnType;
            this.blockCtx = blockCtx;
        }
    }

    // ---------- Analyzer state ----------
    private Scope currentScope = new Scope(null); // global
    private final Map<String, FunctionSymbol> functions = new HashMap<>();
    private String currentFunctionReturnType = null; // null means not inside a function

    // ---------- Public entry ----------
    public void analyze(BenitenLanguageParser.ProgramContext program) {
        // Pre-scan function declarations first (to support forward calls)
        for (BenitenLanguageParser.StatementContext st : program.statement()) {
            if (st.funcDecl() != null) {
                preRegisterFunction(st.funcDecl());
            }
        }
        // Then visit the whole program
        visit(program);
    }

    // Record function signature (name, param types, return type), check duplicates
    private void preRegisterFunction(BenitenLanguageParser.FuncDeclContext ctx) {
        String name = ctx.ID().getText();
        if (functions.containsKey(name)) {
            throw semanticError(ctx.getStart(), "Function '" + name + "' already declared");
        }
        List<String> types = new ArrayList<>();
        List<String> names = new ArrayList<>();
        if (ctx.paramList() != null) {
            for (BenitenLanguageParser.ParamContext p : ctx.paramList().param()) {
                String t = p.type().getText();
                String v = p.VARIABLE().getText();
                if (names.contains(v)) {
                    throw semanticError(p.getStart(), "Duplicate parameter name '" + v + "' in function " + name);
                }
                names.add(v);
                types.add(t);
            }
        }
        String ret = (ctx.returnType() != null) ? ctx.returnType().type().getText() : TYPE_VOID;
        functions.put(name, new FunctionSymbol(types, names, ret, ctx.block()));
    }

    // ---------- Visitors for statements ----------

    @Override
    public String visitProgram(BenitenLanguageParser.ProgramContext ctx) {
        for (BenitenLanguageParser.StatementContext st : ctx.statement()) {
            visit(st);
        }
        return null;
    }

    @Override
    public String visitVarDecl(BenitenLanguageParser.VarDeclContext ctx) {
        String typ = ctx.type().getText();
        String name = ctx.VARIABLE().getText();

        if (currentScope.containsLocal(name)) {
            throw semanticError(ctx.getStart(), "Variable '" + name + "' already declared in this scope");
        }

        String exprType = visit(ctx.expr());
        if (!isAssignable(typ, exprType)) {
            throw semanticError(ctx.expr().getStart(),
                    "Cannot assign expression of type '" + exprType + "' to variable '" + name + "' of type '" + typ + "'");
        }
        currentScope.declare(name, typ);
        return null;
    }

    @Override
    public String visitAssignment(BenitenLanguageParser.AssignmentContext ctx) {
        String name = ctx.VARIABLE().getText();
        String declared = currentScope.lookup(name);
        if (declared == null) {
            throw semanticError(ctx.getStart(), "Undefined variable " + name);
        }
        String exprType = visit(ctx.expr());
        if (!isAssignable(declared, exprType)) {
            throw semanticError(ctx.expr().getStart(),
                    "Cannot assign expression of type '" + exprType + "' to variable '" + name + "' of type '" + declared + "'");
        }
        return null;
    }

    @Override
    public String visitEchoStmt(BenitenLanguageParser.EchoStmtContext ctx) {
        // echo accepts any type
        visit(ctx.expr());
        return null;
    }

    @Override
    public String visitFuncDecl(BenitenLanguageParser.FuncDeclContext ctx) {
        String name = ctx.ID().getText();
        FunctionSymbol sym = functions.get(name);
        // already pre-registered; double-check duplication was handled
        // Open new scope for function params + body
        Scope savedScope = currentScope;
        currentScope = new Scope(savedScope);
        // declare parameters
        for (int i = 0; i < sym.paramNames.size(); ++i) {
            currentScope.declare(sym.paramNames.get(i), sym.paramTypes.get(i));
        }
        // set current function return type
        String savedReturn = currentFunctionReturnType;
        currentFunctionReturnType = sym.returnType.equals(TYPE_VOID) ? null : sym.returnType;

        // Visit body
        visit(sym.blockCtx);

        // restore
        currentFunctionReturnType = savedReturn;
        currentScope = savedScope;
        return null;
    }

    @Override
    public String visitIfStmt(BenitenLanguageParser.IfStmtContext ctx) {
        String condType = visit(ctx.expr());
        if (!TYPE_BOOL.equals(condType)) {
            throw semanticError(ctx.expr().getStart(), "Condition in if must be boolean, got '" + condType + "'");
        }
        // visit blocks: they will create their own scopes via visitBlock
        visit(ctx.block(0));
        if (ctx.ELSE() != null) {
            if (ctx.ifStmt() != null) visit(ctx.ifStmt());
            else visit(ctx.block(1));
        }
        return null;
    }

    @Override
    public String visitWhileStmt(BenitenLanguageParser.WhileStmtContext ctx) {
        String condType = visit(ctx.expr());
        if (!TYPE_BOOL.equals(condType)) {
            throw semanticError(ctx.expr().getStart(), "Condition in while must be boolean, got '" + condType + "'");
        }
        visit(ctx.block());
        return null;
    }

    @Override
    public String visitReturnStmt(BenitenLanguageParser.ReturnStmtContext ctx) {
        if (currentFunctionReturnType == null) {
            // not in a typed function
            if (ctx.expr() != null) {
                throw semanticError(ctx.getStart(), "Return with a value in a function without return type");
            }
            return null;
        }
        if (ctx.expr() == null) {
            throw semanticError(ctx.getStart(), "Function expected to return '" + currentFunctionReturnType + "' but return has no value");
        }
        String exprType = visit(ctx.expr());
        if (!isAssignable(currentFunctionReturnType, exprType)) {
            throw semanticError(ctx.expr().getStart(),
                    "Return expression type '" + exprType + "' does not match function return type '" + currentFunctionReturnType + "'");
        }
        return null;
    }

    @Override
    public String visitBlock(BenitenLanguageParser.BlockContext ctx) {
        // create block scope
        Scope saved = currentScope;
        currentScope = new Scope(saved);
        for (BenitenLanguageParser.StatementContext st : ctx.statement()) {
            visit(st);
        }
        currentScope = saved;
        return null;
    }

    // ---------- Expressions: each returns the expression type ----------

    @Override
    public String visitEqualityExpr(BenitenLanguageParser.EqualityExprContext ctx) {
        // relationalExpr ( (EQ | SEQ | NEQ | SNEQ) relationalExpr )*
        String leftType = visit(ctx.relationalExpr(0));
        for (int i = 1; i < ctx.relationalExpr().size(); ++i) {
            String rightType = visit(ctx.relationalExpr(i));
            if (!areComparableForEquality(leftType, rightType)) {
                // operator token at child index 2*i-1
                Token opToken = ((TerminalNode) ctx.getChild(2*i-1)).getSymbol();
                throw semanticError(opToken, "Cannot compare types '" + leftType + "' and '" + rightType + "'");
            }
            leftType = TYPE_BOOL; // result of equality is bool for chained comparisons
        }
        return leftType;
    }

    @Override
    public String visitRelationalExpr(BenitenLanguageParser.RelationalExprContext ctx) {
        String leftType = visit(ctx.additiveExpr(0));
        for (int i = 1; i < ctx.additiveExpr().size(); ++i) {
            String rightType = visit(ctx.additiveExpr(i));
            if (!areComparableForRelational(leftType, rightType)) {
                Token opToken = ((TerminalNode) ctx.getChild(2*i-1)).getSymbol();
                throw semanticError(opToken, "Relational operators require numeric or string operands, got '" + leftType + "' and '" + rightType + "'");
            }
            leftType = TYPE_BOOL;
        }
        return leftType;
    }

    @Override
    public String visitAdditiveExpr(BenitenLanguageParser.AdditiveExprContext ctx) {
        String t = visit(ctx.multiplicativeExpr(0));
        for (int i = 1; i < ctx.multiplicativeExpr().size(); ++i) {
            String r = visit(ctx.multiplicativeExpr(i));
            String op = ctx.getChild(2*i-1).getText();
            Token opToken = ((TerminalNode) ctx.getChild(2*i-1)).getSymbol();
            t = typeForAddSub(t, r, op, opToken);
        }
        return t;
    }

    @Override
    public String visitMultiplicativeExpr(BenitenLanguageParser.MultiplicativeExprContext ctx) {
        String t = visit(ctx.unaryExpr(0));
        for (int i = 1; i < ctx.unaryExpr().size(); ++i) {
            String r = visit(ctx.unaryExpr(i));
            String op = ctx.getChild(2*i-1).getText();
            Token opToken = ((TerminalNode) ctx.getChild(2*i-1)).getSymbol();
            t = typeForMulDiv(t, r, op, opToken);
        }
        return t;
    }

    @Override
    public String visitUnaryExpr(BenitenLanguageParser.UnaryExprContext ctx) {
        if (ctx.getChildCount() == 2) {
            String op = ctx.getChild(0).getText();
            String valType = visit(ctx.unaryExpr());
            switch (op) {
                case "!":
                    if (!TYPE_BOOL.equals(valType)) {
                        throw semanticError(ctx.getStart(), "'!' operator requires boolean operand, got '" + valType + "'");
                    }
                    return TYPE_BOOL;
                case "+":
                case "-":
                    if (!isNumeric(valType)) {
                        throw semanticError(ctx.getStart(), "Unary '" + op + "' requires numeric operand, got '" + valType + "'");
                    }
                    return valType;
            }
        }
        return visit(ctx.primary());
    }

    @Override
    public String visitPrimary(BenitenLanguageParser.PrimaryContext ctx) {
        if (ctx.literal() != null) return visit(ctx.literal());
        if (ctx.VARIABLE() != null) {
            String name = ctx.VARIABLE().getText();
            String found = currentScope.lookup(name);
            if (found == null) throw semanticError(ctx.getStart(), "Undefined variable " + name);
            return found;
        }
        if (ctx.ID() != null && ctx.LPAR() != null) {
            // function call
            String fname = ctx.ID().getText();
            FunctionSymbol fs = functions.get(fname);
            if (fs == null) throw semanticError(ctx.getStart(), "Undefined function " + fname);
            List<BenitenLanguageParser.ArgContext> args = (ctx.argList() != null) ? ctx.argList().arg() : Collections.emptyList();
            if (args.size() != fs.paramTypes.size()) {
                throw semanticError(ctx.getStart(), "Function " + fname + " expects " + fs.paramTypes.size()
                        + " args but got " + args.size());
            }
            for (int i = 0; i < args.size(); ++i) {
                String at = visit(args.get(i).expr());
                String expected = fs.paramTypes.get(i);
                if (!isAssignable(expected, at)) {
                    throw semanticError(args.get(i).getStart(),
                            "Argument " + (i+1) + " to function " + fname + " expects '" + expected + "' but got '" + at + "'");
                }
            }
            return fs.returnType.equals(TYPE_VOID) ? null : fs.returnType;
        }
        if (ctx.expr() != null) return visit(ctx.expr());
        throw semanticError(ctx.getStart(), "Unknown primary expression");
    }

    @Override
    public String visitArg(BenitenLanguageParser.ArgContext ctx) {
        return visit(ctx.expr());
    }

    @Override
    public String visitLiteral(BenitenLanguageParser.LiteralContext ctx) {
        if (ctx.INT_LITERAL() != null) return TYPE_INT;
        if (ctx.FLOAT_LITERAL() != null) return TYPE_FLOAT;
        if (ctx.STRING() != null) return TYPE_STRING;
        if (ctx.BOOL_LITERAL() != null) return TYPE_BOOL;
        throw semanticError(ctx.getStart(), "Unknown literal");
    }

    // ---------- Helper type-check functions ----------

    private boolean isNumeric(String t) {
        return TYPE_INT.equals(t) || TYPE_FLOAT.equals(t);
    }

    private boolean areComparableForEquality(String a, String b) {
        if (a == null || b == null) {
            // comparing nulls allowed (but in our language null is not commonly used)
            return true;
        }
        if (a.equals(b)) return true;
        // allow int and float to be compared
        if (isNumeric(a) && isNumeric(b)) return true;
        return false;
    }

    private boolean areComparableForRelational(String a, String b) {
        // numeric vs numeric OR string vs string
        if (a == null || b == null) return false;
        if (isNumeric(a) && isNumeric(b)) return true;
        if (TYPE_STRING.equals(a) && TYPE_STRING.equals(b)) return true;
        return false;
    }

    private boolean isAssignable(String targetType, String valueType) {
        if (targetType == null) return false;
        if (valueType == null) {
            // disallow assigning null (unless we supported null)
            return false;
        }
        if (targetType.equals(valueType)) return true;
        // allow int -> float assignment (implicit widening)
        if (TYPE_FLOAT.equals(targetType) && TYPE_INT.equals(valueType)) return true;
        return false;
    }

    private String typeForAddSub(String left, String right, String op, Token opToken) {
        // '+' supports numeric + string concatenation
        if (op.equals("+")) {
            if (TYPE_STRING.equals(left) && TYPE_STRING.equals(right)) return TYPE_STRING;
            if (isNumeric(left) && isNumeric(right)) {
                // float if either is float
                if (TYPE_FLOAT.equals(left) || TYPE_FLOAT.equals(right)) return TYPE_FLOAT;
                return TYPE_INT;
            }
        } else {
            // '-' expects numeric
            if (isNumeric(left) && isNumeric(right)) {
                if (TYPE_FLOAT.equals(left) || TYPE_FLOAT.equals(right)) return TYPE_FLOAT;
                return TYPE_INT;
            }
        }
        throw semanticError(opToken, "Invalid operands for '" + op + "': " + left + " and " + right);
    }

    private String typeForMulDiv(String left, String right, String op, Token opToken) {
        if (isNumeric(left) && isNumeric(right)) {
            if (TYPE_FLOAT.equals(left) || TYPE_FLOAT.equals(right)) return TYPE_FLOAT;
            // integer division returns float in analyzer for safety
            if (op.equals("/")) return TYPE_FLOAT;
            return TYPE_INT;
        }
        throw semanticError(opToken, "Invalid operands for '" + op + "': " + left + " and " + right);
    }

    // Produce a SemanticException with line/col info
    private SemanticException semanticError(Token t, String message) {
        if (t == null) return new SemanticException(message);
        return new SemanticException("Line " + t.getLine() + ":" + t.getCharPositionInLine() + " - " + message);
    }

    private SemanticException semanticError(ParserRuleContext ctx, String message) {
        if (ctx == null || ctx.getStart() == null) return new SemanticException(message);
        return semanticError(ctx.getStart(), message);
    }
}
