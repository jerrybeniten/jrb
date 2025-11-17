grammar BenitenLanguage;

program
    : statement* EOF
    ;

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

varDecl
    : type VARIABLE '=' expression
    ;

arrayDecl
    : type '[' ']' VARIABLE '=' arrayLiteral
    ;

assignStmt
    : VARIABLE '=' expression
    ;

arrayAssignStmt
    : VARIABLE '[' expression ']' '=' expression
    ;

returnStmt
    : 'return' expression
    ;

funcDecl
    : 'function' IDENTIFIER '(' funcParams? ')' (':' type)? block
    ;

funcParams
    : funcParam (',' funcParam)*
    ;

funcParam
    : type VARIABLE
    ;

funcCall
    : IDENTIFIER '(' exprList? ')'
    ;

exprList
    : expression (',' expression)*
    ;

classDecl
    : 'class' IDENTIFIER '{' classMember* '}'
    ;

classMember
    : varDecl ';'
    | funcDecl
    ;

objectCreation
    : type VARIABLE '=' 'new' IDENTIFIER '(' exprList? ')'
    ;

methodCall
    : VARIABLE '.' IDENTIFIER '(' exprList? ')'
    ;

ifStmt
    : 'if' '(' expression ')' block ('else' block)?
    ;

whileStmt
    : 'while' '(' expression ')' block
    ;

block
    : '{' statement* '}'
    ;

echoStmt
    : 'echo' expression
    ;

expression
    : literal
    | VARIABLE
    | VARIABLE '[' expression ']'
    | expression '.' VARIABLE
    | expression '.' IDENTIFIER '(' exprList? ')'
    | funcCall
    | '(' expression ')'
    | expression ('*'|'/') expression
    | expression ('+'|'-') expression
    | expression ('<'|'>'|'<='|'>='|'=='|'!=') expression
    ;

literal
    : INT
    | FLOAT
    | BOOL
    | STRING
    | arrayLiteral
    ;

arrayLiteral
    : '[' exprList? ']'
    ;

type
    : INT_TYPE
    | FLOAT_TYPE
    | STRING_TYPE
    | BOOL_TYPE
    | IDENTIFIER
    ;

INT_TYPE    : 'int';
FLOAT_TYPE  : 'float';
STRING_TYPE : 'string';
BOOL_TYPE   : 'bool';

BOOL        : 'true' | 'false';   // <<< FIXED (moved above IDENTIFIER)

VARIABLE    : '$' [a-zA-Z_] [a-zA-Z0-9_]* ;

IDENTIFIER  : [a-zA-Z_] [a-zA-Z0-9_]* ;

INT         : [0-9]+ ;
FLOAT       : [0-9]+ '.' [0-9]+ ;

STRING
    : '\'' (~['\r\n])* '\''
    | '"' (~["\r\n])* '"'
    ;

WS      : [ \t\r\n]+ -> skip ;
COMMENT : '//' ~[\r\n]* -> skip ;
