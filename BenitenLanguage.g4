grammar BenitenLanguage;

// ----------------- Parser rules -----------------

program
    : statement* EOF
    ;

statement
    : varDecl
    | assignment
    | echoStmt
    | funcDecl
    | ifStmt
    | whileStmt
    | returnStmt
    | exprStmt
    ;

varDecl
    : type VARIABLE '=' expr ';'
    ;

assignment
    : VARIABLE '=' expr ';'
    ;

echoStmt
    : ECHO expr ';'
    ;

funcDecl
    : FUNCTION ID '(' paramList? ')' returnType? block
    ;

paramList
    : param (',' param)*
    ;

param
    : type VARIABLE
    ;

returnType
    : ':' type
    ;

ifStmt
    : IF '(' expr ')' block ( ELSE ( ifStmt | block ) )?
    ;

whileStmt
    : WHILE '(' expr ')' block
    ;

returnStmt
    : RETURN expr? ';'
    ;

exprStmt
    : expr ';'
    ;

// A block is a brace-delimited list of statements
block
    : '{' statement* '}'
    ;

// -------------- Expressions ---------------

expr
    : equalityExpr
    ;

equalityExpr
    : relationalExpr ( (EQ | SEQ | NEQ | SNEQ) relationalExpr )*
    ;

relationalExpr
    : additiveExpr ( (LT | LE | GT | GE) additiveExpr )*
    ;

additiveExpr
    : multiplicativeExpr ( ('+' | '-') multiplicativeExpr )*
    ;

multiplicativeExpr
    : unaryExpr ( ('*' | '/') unaryExpr )*
    ;

unaryExpr
    : ('+' | '-' | '!') unaryExpr
    | primary
    ;

primary
    : literal
    | VARIABLE
    | ID '(' argList? ')'
    | '(' expr ')'
    ;

argList
    : arg (',' arg)*
    ;

arg
    : expr (type)?
    ;

literal
    : INT_LITERAL
    | FLOAT_LITERAL
    | STRING
    | BOOL_LITERAL
    ;

type
    : 'int'
    | 'float'
    | 'string'
    | 'bool'
    ;

// ----------------- Lexer rules -----------------

FUNCTION : 'function' ;
ECHO     : 'echo' ;
IF       : 'if' ;
ELSE     : 'else' ;
WHILE    : 'while' ;
RETURN   : 'return' ;

EQ  : '==' ;
SEQ : '===' ;
NEQ : '!=' ;
SNEQ: '!==' ;
LT  : '<' ;
GT  : '>' ;
LE  : '<=' ;
GE  : '>=' ;

BOOL_LITERAL
    : 'true'
    | 'false'
    ;

VARIABLE
    : '$' [a-zA-Z_] [a-zA-Z0-9_]*
    ;

ID
    : [a-zA-Z_] [a-zA-Z0-9_]*
    ;

FLOAT_LITERAL
    : [0-9]+ '.' [0-9]+
    ;

INT_LITERAL
    : [0-9]+
    ;

STRING
    : '\'' ( ~['\\] | '\\' . )* '\''
    | '"'  ( ~["\\] | '\\' . )* '"'
    ;



LPAR   : '(' ;
RPAR   : ')' ;
LBRACE : '{' ;
RBRACE : '}' ;
SEMI   : ';' ;
COMMA  : ',' ;
COLON  : ':' ;
ASSIGN : '=' ;

LINE_COMMENT
    : '//' ~[\r\n]* -> skip
    ;

BLOCK_COMMENT
    : '/*' .*? '*/' -> skip
    ;

WS
    : [ \t\r\n]+ -> skip
    ;
