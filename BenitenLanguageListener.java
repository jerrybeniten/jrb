// Generated from BenitenLanguage.g4 by ANTLR 4.13.0
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link BenitenLanguageParser}.
 */
public interface BenitenLanguageListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(BenitenLanguageParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(BenitenLanguageParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(BenitenLanguageParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(BenitenLanguageParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDecl(BenitenLanguageParser.VarDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDecl(BenitenLanguageParser.VarDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(BenitenLanguageParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#assignment}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(BenitenLanguageParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#echoStmt}.
	 * @param ctx the parse tree
	 */
	void enterEchoStmt(BenitenLanguageParser.EchoStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#echoStmt}.
	 * @param ctx the parse tree
	 */
	void exitEchoStmt(BenitenLanguageParser.EchoStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFuncDecl(BenitenLanguageParser.FuncDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFuncDecl(BenitenLanguageParser.FuncDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#paramList}.
	 * @param ctx the parse tree
	 */
	void enterParamList(BenitenLanguageParser.ParamListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#paramList}.
	 * @param ctx the parse tree
	 */
	void exitParamList(BenitenLanguageParser.ParamListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#param}.
	 * @param ctx the parse tree
	 */
	void enterParam(BenitenLanguageParser.ParamContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#param}.
	 * @param ctx the parse tree
	 */
	void exitParam(BenitenLanguageParser.ParamContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#returnType}.
	 * @param ctx the parse tree
	 */
	void enterReturnType(BenitenLanguageParser.ReturnTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#returnType}.
	 * @param ctx the parse tree
	 */
	void exitReturnType(BenitenLanguageParser.ReturnTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStmt(BenitenLanguageParser.IfStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStmt(BenitenLanguageParser.IfStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStmt(BenitenLanguageParser.WhileStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStmt(BenitenLanguageParser.WhileStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStmt(BenitenLanguageParser.ReturnStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStmt(BenitenLanguageParser.ReturnStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void enterExprStmt(BenitenLanguageParser.ExprStmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#exprStmt}.
	 * @param ctx the parse tree
	 */
	void exitExprStmt(BenitenLanguageParser.ExprStmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(BenitenLanguageParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(BenitenLanguageParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(BenitenLanguageParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(BenitenLanguageParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void enterEqualityExpr(BenitenLanguageParser.EqualityExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#equalityExpr}.
	 * @param ctx the parse tree
	 */
	void exitEqualityExpr(BenitenLanguageParser.EqualityExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void enterRelationalExpr(BenitenLanguageParser.RelationalExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#relationalExpr}.
	 * @param ctx the parse tree
	 */
	void exitRelationalExpr(BenitenLanguageParser.RelationalExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(BenitenLanguageParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#additiveExpr}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(BenitenLanguageParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(BenitenLanguageParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#multiplicativeExpr}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(BenitenLanguageParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void enterUnaryExpr(BenitenLanguageParser.UnaryExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#unaryExpr}.
	 * @param ctx the parse tree
	 */
	void exitUnaryExpr(BenitenLanguageParser.UnaryExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(BenitenLanguageParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(BenitenLanguageParser.PrimaryContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#argList}.
	 * @param ctx the parse tree
	 */
	void enterArgList(BenitenLanguageParser.ArgListContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#argList}.
	 * @param ctx the parse tree
	 */
	void exitArgList(BenitenLanguageParser.ArgListContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(BenitenLanguageParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(BenitenLanguageParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(BenitenLanguageParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(BenitenLanguageParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(BenitenLanguageParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(BenitenLanguageParser.TypeContext ctx);
}