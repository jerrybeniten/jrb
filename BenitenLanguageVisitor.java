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
	 * Visit a parse tree produced by the {@code varDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#varDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarDeclaration(BenitenLanguageParser.VarDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#arrayDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayDeclaration(BenitenLanguageParser.ArrayDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link BenitenLanguageParser#assignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarAssignment(BenitenLanguageParser.VarAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayAssignment}
	 * labeled alternative in {@link BenitenLanguageParser#arrayAssignStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayAssignment(BenitenLanguageParser.ArrayAssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link BenitenLanguageParser#returnStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStatement(BenitenLanguageParser.ReturnStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#funcDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(BenitenLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionParameters}
	 * labeled alternative in {@link BenitenLanguageParser#funcParams}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionParameters(BenitenLanguageParser.FunctionParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramTypeFirst}
	 * labeled alternative in {@link BenitenLanguageParser#funcParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamTypeFirst(BenitenLanguageParser.ParamTypeFirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code paramVarFirst}
	 * labeled alternative in {@link BenitenLanguageParser#funcParam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParamVarFirst(BenitenLanguageParser.ParamVarFirstContext ctx);
	/**
	 * Visit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link BenitenLanguageParser#funcCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(BenitenLanguageParser.FunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code expressionList}
	 * labeled alternative in {@link BenitenLanguageParser#exprList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionList(BenitenLanguageParser.ExpressionListContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classDefinition}
	 * labeled alternative in {@link BenitenLanguageParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDefinition(BenitenLanguageParser.ClassDefinitionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classVar}
	 * labeled alternative in {@link BenitenLanguageParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassVar(BenitenLanguageParser.ClassVarContext ctx);
	/**
	 * Visit a parse tree produced by the {@code classFunction}
	 * labeled alternative in {@link BenitenLanguageParser#classMember}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassFunction(BenitenLanguageParser.ClassFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code objectCreate}
	 * labeled alternative in {@link BenitenLanguageParser#objectCreation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectCreate(BenitenLanguageParser.ObjectCreateContext ctx);
	/**
	 * Visit a parse tree produced by the {@code methodCallExpr}
	 * labeled alternative in {@link BenitenLanguageParser#methodCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMethodCallExpr(BenitenLanguageParser.MethodCallExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link BenitenLanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(BenitenLanguageParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link BenitenLanguageParser#whileStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(BenitenLanguageParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link BenitenLanguageParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockStatement(BenitenLanguageParser.BlockStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code echoStatement}
	 * labeled alternative in {@link BenitenLanguageParser#echoStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEchoStatement(BenitenLanguageParser.EchoStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprParen(BenitenLanguageParser.ExprParenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFieldAccess}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFieldAccess(BenitenLanguageParser.ExprFieldAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprVariable}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprVariable(BenitenLanguageParser.ExprVariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprAddSub}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprAddSub(BenitenLanguageParser.ExprAddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprComparison}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprComparison(BenitenLanguageParser.ExprComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMethodCall}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMethodCall(BenitenLanguageParser.ExprMethodCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprLiteral(BenitenLanguageParser.ExprLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprArrayAccess}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprArrayAccess(BenitenLanguageParser.ExprArrayAccessContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprMulDiv}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprMulDiv(BenitenLanguageParser.ExprMulDivContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exprFunctionCall}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprFunctionCall(BenitenLanguageParser.ExprFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIntLiteral(BenitenLanguageParser.IntLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code floatLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFloatLiteral(BenitenLanguageParser.FloatLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolLiteral(BenitenLanguageParser.BoolLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(BenitenLanguageParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLiteralExpr}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralExpr(BenitenLanguageParser.ArrayLiteralExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code arrayLiteralValue}
	 * labeled alternative in {@link BenitenLanguageParser#arrayLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayLiteralValue(BenitenLanguageParser.ArrayLiteralValueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeInt(BenitenLanguageParser.TypeIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeFloat}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeFloat(BenitenLanguageParser.TypeFloatContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeString}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeString(BenitenLanguageParser.TypeStringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeBool(BenitenLanguageParser.TypeBoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code typeClassIdentifier}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeClassIdentifier(BenitenLanguageParser.TypeClassIdentifierContext ctx);
}