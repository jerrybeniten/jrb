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
	 * Enter a parse tree produced by the {@code varDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclaration(BenitenLanguageParser.VarDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#varDecl}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclaration(BenitenLanguageParser.VarDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void enterArrayDeclaration(BenitenLanguageParser.ArrayDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#arrayDecl}.
	 * @param ctx the parse tree
	 */
	void exitArrayDeclaration(BenitenLanguageParser.ArrayDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link BenitenLanguageParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void enterVarAssignment(BenitenLanguageParser.VarAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varAssignment}
	 * labeled alternative in {@link BenitenLanguageParser#assignStmt}.
	 * @param ctx the parse tree
	 */
	void exitVarAssignment(BenitenLanguageParser.VarAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayAssignment}
	 * labeled alternative in {@link BenitenLanguageParser#arrayAssignStmt}.
	 * @param ctx the parse tree
	 */
	void enterArrayAssignment(BenitenLanguageParser.ArrayAssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayAssignment}
	 * labeled alternative in {@link BenitenLanguageParser#arrayAssignStmt}.
	 * @param ctx the parse tree
	 */
	void exitArrayAssignment(BenitenLanguageParser.ArrayAssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link BenitenLanguageParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void enterReturnStatement(BenitenLanguageParser.ReturnStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStatement}
	 * labeled alternative in {@link BenitenLanguageParser#returnStmt}.
	 * @param ctx the parse tree
	 */
	void exitReturnStatement(BenitenLanguageParser.ReturnStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDeclaration(BenitenLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionDeclaration}
	 * labeled alternative in {@link BenitenLanguageParser#funcDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDeclaration(BenitenLanguageParser.FunctionDeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionParameters}
	 * labeled alternative in {@link BenitenLanguageParser#funcParams}.
	 * @param ctx the parse tree
	 */
	void enterFunctionParameters(BenitenLanguageParser.FunctionParametersContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionParameters}
	 * labeled alternative in {@link BenitenLanguageParser#funcParams}.
	 * @param ctx the parse tree
	 */
	void exitFunctionParameters(BenitenLanguageParser.FunctionParametersContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramTypeFirst}
	 * labeled alternative in {@link BenitenLanguageParser#funcParam}.
	 * @param ctx the parse tree
	 */
	void enterParamTypeFirst(BenitenLanguageParser.ParamTypeFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramTypeFirst}
	 * labeled alternative in {@link BenitenLanguageParser#funcParam}.
	 * @param ctx the parse tree
	 */
	void exitParamTypeFirst(BenitenLanguageParser.ParamTypeFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code paramVarFirst}
	 * labeled alternative in {@link BenitenLanguageParser#funcParam}.
	 * @param ctx the parse tree
	 */
	void enterParamVarFirst(BenitenLanguageParser.ParamVarFirstContext ctx);
	/**
	 * Exit a parse tree produced by the {@code paramVarFirst}
	 * labeled alternative in {@link BenitenLanguageParser#funcParam}.
	 * @param ctx the parse tree
	 */
	void exitParamVarFirst(BenitenLanguageParser.ParamVarFirstContext ctx);
	/**
	 * Enter a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link BenitenLanguageParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void enterFunctionCall(BenitenLanguageParser.FunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code functionCall}
	 * labeled alternative in {@link BenitenLanguageParser#funcCall}.
	 * @param ctx the parse tree
	 */
	void exitFunctionCall(BenitenLanguageParser.FunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expressionList}
	 * labeled alternative in {@link BenitenLanguageParser#exprList}.
	 * @param ctx the parse tree
	 */
	void enterExpressionList(BenitenLanguageParser.ExpressionListContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expressionList}
	 * labeled alternative in {@link BenitenLanguageParser#exprList}.
	 * @param ctx the parse tree
	 */
	void exitExpressionList(BenitenLanguageParser.ExpressionListContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classDefinition}
	 * labeled alternative in {@link BenitenLanguageParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDefinition(BenitenLanguageParser.ClassDefinitionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classDefinition}
	 * labeled alternative in {@link BenitenLanguageParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDefinition(BenitenLanguageParser.ClassDefinitionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classVar}
	 * labeled alternative in {@link BenitenLanguageParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassVar(BenitenLanguageParser.ClassVarContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classVar}
	 * labeled alternative in {@link BenitenLanguageParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassVar(BenitenLanguageParser.ClassVarContext ctx);
	/**
	 * Enter a parse tree produced by the {@code classFunction}
	 * labeled alternative in {@link BenitenLanguageParser#classMember}.
	 * @param ctx the parse tree
	 */
	void enterClassFunction(BenitenLanguageParser.ClassFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code classFunction}
	 * labeled alternative in {@link BenitenLanguageParser#classMember}.
	 * @param ctx the parse tree
	 */
	void exitClassFunction(BenitenLanguageParser.ClassFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code objectCreate}
	 * labeled alternative in {@link BenitenLanguageParser#objectCreation}.
	 * @param ctx the parse tree
	 */
	void enterObjectCreate(BenitenLanguageParser.ObjectCreateContext ctx);
	/**
	 * Exit a parse tree produced by the {@code objectCreate}
	 * labeled alternative in {@link BenitenLanguageParser#objectCreation}.
	 * @param ctx the parse tree
	 */
	void exitObjectCreate(BenitenLanguageParser.ObjectCreateContext ctx);
	/**
	 * Enter a parse tree produced by the {@code methodCallExpr}
	 * labeled alternative in {@link BenitenLanguageParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void enterMethodCallExpr(BenitenLanguageParser.MethodCallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code methodCallExpr}
	 * labeled alternative in {@link BenitenLanguageParser#methodCall}.
	 * @param ctx the parse tree
	 */
	void exitMethodCallExpr(BenitenLanguageParser.MethodCallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link BenitenLanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(BenitenLanguageParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStatement}
	 * labeled alternative in {@link BenitenLanguageParser#ifStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(BenitenLanguageParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link BenitenLanguageParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileStatement(BenitenLanguageParser.WhileStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStatement}
	 * labeled alternative in {@link BenitenLanguageParser#whileStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileStatement(BenitenLanguageParser.WhileStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link BenitenLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlockStatement(BenitenLanguageParser.BlockStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStatement}
	 * labeled alternative in {@link BenitenLanguageParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlockStatement(BenitenLanguageParser.BlockStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code echoStatement}
	 * labeled alternative in {@link BenitenLanguageParser#echoStmt}.
	 * @param ctx the parse tree
	 */
	void enterEchoStatement(BenitenLanguageParser.EchoStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code echoStatement}
	 * labeled alternative in {@link BenitenLanguageParser#echoStmt}.
	 * @param ctx the parse tree
	 */
	void exitEchoStatement(BenitenLanguageParser.EchoStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprParen(BenitenLanguageParser.ExprParenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprParen}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprParen(BenitenLanguageParser.ExprParenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFieldAccess}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprFieldAccess(BenitenLanguageParser.ExprFieldAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFieldAccess}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprFieldAccess(BenitenLanguageParser.ExprFieldAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprVariable}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprVariable(BenitenLanguageParser.ExprVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprVariable}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprVariable(BenitenLanguageParser.ExprVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprAddSub}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprAddSub(BenitenLanguageParser.ExprAddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprAddSub}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprAddSub(BenitenLanguageParser.ExprAddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprComparison}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprComparison(BenitenLanguageParser.ExprComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprComparison}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprComparison(BenitenLanguageParser.ExprComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMethodCall}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMethodCall(BenitenLanguageParser.ExprMethodCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMethodCall}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMethodCall(BenitenLanguageParser.ExprMethodCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprLiteral(BenitenLanguageParser.ExprLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprLiteral(BenitenLanguageParser.ExprLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprArrayAccess}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprArrayAccess(BenitenLanguageParser.ExprArrayAccessContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprArrayAccess}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprArrayAccess(BenitenLanguageParser.ExprArrayAccessContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprMulDiv}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprMulDiv(BenitenLanguageParser.ExprMulDivContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprMulDiv}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprMulDiv(BenitenLanguageParser.ExprMulDivContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprFunctionCall}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExprFunctionCall(BenitenLanguageParser.ExprFunctionCallContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprFunctionCall}
	 * labeled alternative in {@link BenitenLanguageParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExprFunctionCall(BenitenLanguageParser.ExprFunctionCallContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterIntLiteral(BenitenLanguageParser.IntLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitIntLiteral(BenitenLanguageParser.IntLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code floatLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterFloatLiteral(BenitenLanguageParser.FloatLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code floatLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitFloatLiteral(BenitenLanguageParser.FloatLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterBoolLiteral(BenitenLanguageParser.BoolLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitBoolLiteral(BenitenLanguageParser.BoolLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterStringLiteral(BenitenLanguageParser.StringLiteralContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringLiteral}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitStringLiteral(BenitenLanguageParser.StringLiteralContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLiteralExpr}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralExpr(BenitenLanguageParser.ArrayLiteralExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLiteralExpr}
	 * labeled alternative in {@link BenitenLanguageParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralExpr(BenitenLanguageParser.ArrayLiteralExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayLiteralValue}
	 * labeled alternative in {@link BenitenLanguageParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void enterArrayLiteralValue(BenitenLanguageParser.ArrayLiteralValueContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayLiteralValue}
	 * labeled alternative in {@link BenitenLanguageParser#arrayLiteral}.
	 * @param ctx the parse tree
	 */
	void exitArrayLiteralValue(BenitenLanguageParser.ArrayLiteralValueContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeInt(BenitenLanguageParser.TypeIntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeInt}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeInt(BenitenLanguageParser.TypeIntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeFloat}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeFloat(BenitenLanguageParser.TypeFloatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeFloat}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeFloat(BenitenLanguageParser.TypeFloatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeString}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeString(BenitenLanguageParser.TypeStringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeString}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeString(BenitenLanguageParser.TypeStringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeBool(BenitenLanguageParser.TypeBoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeBool}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeBool(BenitenLanguageParser.TypeBoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code typeClassIdentifier}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void enterTypeClassIdentifier(BenitenLanguageParser.TypeClassIdentifierContext ctx);
	/**
	 * Exit a parse tree produced by the {@code typeClassIdentifier}
	 * labeled alternative in {@link BenitenLanguageParser#type}.
	 * @param ctx the parse tree
	 */
	void exitTypeClassIdentifier(BenitenLanguageParser.TypeClassIdentifierContext ctx);
}