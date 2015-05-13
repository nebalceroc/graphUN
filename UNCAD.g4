/** A Java 1.7 grammar for ANTLR v4 derived from ANTLR v3 Java grammar.
 *  Uses ANTLR v4's left-recursive expression notation.
 *  It parses ECJ, Netbeans, JDK etc...
 *
 *  Sam Harwell cleaned this up significantly and updated to 1.7!
 *
 *  You can test with
 *
 *  $ antlr4 Java.g4
 *  $ javac *.java
 *  $ grun Java compilationUnit *.java
 */
grammar UNCAD;


//start parsing file
doc
	:	TAG1INIT CANVAS (COMMA SCALE_X ASSIGN REAL)? (COMMA SCALE_Y ASSIGN REAL)? TAGEND body TAG2INIT CANVAS TAGEND	
	|   TAG1INIT CANVAS (COMMA SCALE_Y ASSIGN REAL)? (COMMA SCALE_X ASSIGN REAL)? TAGEND body TAG2INIT CANVAS TAGEND	
	;

body
	:	body p_tag
	|   body o_tag
	|   p_tag
	|   o_tag   
	;
	
p_tag
	: 	TAG1INIT props TAGEND body TAG2INIT COLOR TAGEND
	;
	
o_tag
	:	TAG1INIT CIRCLE (COMMA props)? TAGEND body TAG2INIT CIRCLE TAGEND
	;
	
props
	:	O_ID ASSIGN ID (COMMA COLOR ASSIGN color)? (COMMA R ASSIGN REAL)?
	|	O_ID ASSIGN ID (COMMA R ASSIGN REAL)?  (COMMA COLOR ASSIGN color)?
	|   COLOR ASSIGN color (COMMA R ASSIGN REAL)? (COMMA O_ID ASSIGN ID)?
	|   COLOR ASSIGN color (COMMA O_ID ASSIGN ID)? (COMMA R ASSIGN REAL)?
	|   R ASSIGN REAL (COMMA COLOR ASSIGN color)? (COMMA O_ID ASSIGN ID)?
	|	R ASSIGN REAL (COMMA O_ID ASSIGN ID)? (COMMA COLOR ASSIGN color)? 
	;

color
	: COLOR_G
	| COLOR_B
	| COLOR_Y
	| COLOR_R
	| COLOR_W
	| COLOR_BLK
	;

newLine
	:	NEWLINE
	;

// LEXER
TAG1INIT	   : '<';
TAG2INIT	   : '</';
TAGEND	       : '>';

CANVAS         : 'canvas';
CIRCLE         : 'circle';

SCALE_X		   : 'x';
SCALE_Y		   : 'y';
O_ID		   : 'id';
COLOR		   : 'color';
R			   : 'r';
H              : 'h';
L			   : 'l';
FILL		   : 'fill';

REAL		   : [0-9]+ ('.' [0-9]+)?;
COLOR_G		   : 'green';
COLOR_Y		   : 'yellow';
COLOR_R        : 'red';
COLOR_B        : 'blue';
COLOR_W		   : 'white';
COLOR_BLK	   : 'black';
ID			   : [a-zA-Z]+ ('_'? [a-zA-Z0-9]+)*;



LPAREN          : '(';
RPAREN          : ')';
LBRACK          : '[';
RBRACK          : ']';
COMMA           : ',';


// §3.12 Operators

ASSIGN          : '=';
//

AT : '@';
ELLIPSIS : '...';

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> skip
    ;

LINE_COMMENT
    :   '//' ~[\r\n]*
        -> skip
    ;

WHITESPACE
    :   [ \t]+
        -> skip
    ;

NEWLINE
    :   (   '\r' '\n'?
        |   '\n'
        )
        
    ;