// Generated from BenitenLanguage.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link BenitenLanguageParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface BenitenLanguageVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(BenitenLanguageParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(BenitenLanguageParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDecl(BenitenLanguageParser.VarDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(BenitenLanguageParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#echoStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEchoStmt(BenitenLanguageParser.EchoStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncDecl(BenitenLanguageParser.FuncDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#paramList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamList(BenitenLanguageParser.ParamListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParam(BenitenLanguageParser.ParamContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#returnType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnType(BenitenLanguageParser.ReturnTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStmt(BenitenLanguageParser.IfStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStmt(BenitenLanguageParser.WhileStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(BenitenLanguageParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#exprStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprStmt(BenitenLanguageParser.ExprStmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(BenitenLanguageParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(BenitenLanguageParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#equalityExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(BenitenLanguageParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#relationalExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelationalExpr(BenitenLanguageParser.RelationalExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#additiveExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpr(BenitenLanguageParser.AdditiveExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpr(BenitenLanguageParser.MultiplicativeExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryExpr(BenitenLanguageParser.UnaryExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(BenitenLanguageParser.PrimaryContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#argList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgList(BenitenLanguageParser.ArgListContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(BenitenLanguageParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteral(BenitenLanguageParser.LiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(BenitenLanguageParser.TypeContext ctx);
}