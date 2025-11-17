grammar BenitenLanguage;

program
    : statement* EOF
    ;

// ---------------------------
// Statements
// ---------------------------
statement
    : varDecl ';'
    | arrayDecl ';'
    | assignStmt ';'
    | arrayAssignStmt ';'
    | funcDecl
    | classDecl
    | objectCreation ';'
    | methodCall ';'
    | funcCall ';'
    | echoStmt ';'
    | returnStmt ';'
    | ifStmt
    | whileStmt
    ;

// ---------------------------
// Declarations / Assignments
// ---------------------------
varDecl
    : type VARIABLE '=' expression                    #varDeclaration
    ;

arrayDecl
    : type '[' ']' VARIABLE '=' arrayLiteral          #arrayDeclaration
    ;

assignStmt
    : VARIABLE '=' expression                         #varAssignment
    ;

arrayAssignStmt
    : VARIABLE '[' expression ']' '=' expression      #arrayAssignment
    ;

// ---------------------------
// Return
// ---------------------------
returnStmt
    : 'return' expression                             #returnStatement
    ;

// ---------------------------
// Functions (unlimited params; permissive param order)
// ---------------------------
// Examples accepted:
//   function f(int $a, string $b): int { ... }
//   function f($a int, $b string): int { ... }
//   function f(int $a, $b string, MyClass $c): void { ... }
funcDecl
    : 'function' IDENTIFIER '(' funcParams? ')' (':' type)? block
        #functionDeclaration
    ;

funcParams
    : funcParam (',' funcParam)*                      #functionParameters
    ;

// Accept both "type VARIABLE" and "VARIABLE type" forms (permissive)
funcParam
    : type VARIABLE                                   #paramTypeFirst
    | VARIABLE type                                   #paramVarFirst
    ;

// ---------------------------
// Function calls
// ---------------------------
funcCall
    : IDENTIFIER '(' exprList? ')'                    #functionCall
    ;

exprList
    : expression (',' expression)*                    #expressionList
    ;

// ---------------------------
// Classes
// ---------------------------
classDecl
    : 'class' IDENTIFIER '{' classMember* '}'         #classDefinition
    ;

classMember
    : varDecl ';'                                     #classVar
    | funcDecl                                        #classFunction
    ;

// ---------------------------
// Objects / Methods
// ---------------------------
objectCreation
    : type VARIABLE '=' 'new' IDENTIFIER '(' exprList? ')'   #objectCreate
    ;

methodCall
    : VARIABLE '.' IDENTIFIER '(' exprList? ')'       #methodCallExpr
    ;

// ---------------------------
// Control flow
// ---------------------------
ifStmt
    : 'if' '(' expression ')' block ('else' block)?   #ifStatement
    ;

whileStmt
    : 'while' '(' expression ')' block                #whileStatement
    ;

// ---------------------------
// Block, echo
// ---------------------------
block
    : '{' statement* '}'                              #blockStatement
    ;

echoStmt
    : 'echo' expression                               #echoStatement
    ;

// ---------------------------
// Expressions (labeled)
// ---------------------------
expression
    : literal                                         #exprLiteral
    | VARIABLE                                        #exprVariable
    | VARIABLE '[' expression ']'                     #exprArrayAccess
    | expression '.' VARIABLE                         #exprFieldAccess
    | expression '.' IDENTIFIER '(' exprList? ')'     #exprMethodCall
    | funcCall                                        #exprFunctionCall
    | '(' expression ')'                              #exprParen
    | expression op=('*'|'/') expression              #exprMulDiv
    | expression op=('+'|'-') expression              #exprAddSub
    | expression op=('<'|'>'|'<='|'>='|'=='|'!=') expression #exprComparison
    ;

// ---------------------------
// Literals
// ---------------------------
literal
    : INT                                             #intLiteral
    | FLOAT                                           #floatLiteral
    | BOOL                                            #boolLiteral
    | STRING                                          #stringLiteral
    | arrayLiteral                                    #arrayLiteralExpr
    ;

arrayLiteral
    : '[' exprList? ']'                               #arrayLiteralValue
    ;

// ---------------------------
// Types
// ---------------------------
type
    : INT_TYPE                                        #typeInt
    | FLOAT_TYPE                                      #typeFloat
    | STRING_TYPE                                     #typeString
    | BOOL_TYPE                                       #typeBool
    | IDENTIFIER                                      #typeClassIdentifier
    ;

// ---------------------------
// LEXER — order matters
// types and keywords MUST appear BEFORE IDENTIFIER
// ---------------------------

// Multi-line comment (C-style) — SKIP
MULTI_COMMENT
    : '/*' .*? '*/' -> skip
    ;

// Single-line comment
LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

// Type keywords (must come before IDENTIFIER)
INT_TYPE    : 'int';
FLOAT_TYPE  : 'float';
STRING_TYPE : 'string';
BOOL_TYPE   : 'bool';

// Boolean literal token
BOOL        : 'true' | 'false' ;

// VARIABLE: explicit regex (no IDENTIFIER reference)
VARIABLE
    : '$' [a-zA-Z_] [a-zA-Z0-9_]*
    ;

// IDENTIFIER (comes after type keywords)
IDENTIFIER
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

// Numbers
INT     : [0-9]+ ;
FLOAT   : [0-9]+ '.' [0-9]+ ;

// Strings: single or double quoted
STRING
    : '\'' (~['\r\n])* '\''
    | '"'  (~["\r\n])* '"'
    ;

// Whitespace
WS      : [ \t\r\n]+ -> skip ;
