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
	:   canvas
	;

canvas
	:	canvas_init body canvas_end	
	;

canvas_init
	:   TAG1INIT CANVAS canvas_props TAGEND
	;
	
canvas_end
	:   TAG2INIT CANVAS TAGEND
	;
	
canvas_props
	:	(COMMA SCALE_Y ASSIGN REAL)? (COMMA SCALE_X ASSIGN REAL)?
	|	(COMMA SCALE_X ASSIGN REAL)? (COMMA SCALE_Y ASSIGN REAL)?
	;

body
	:	p_tag (body)?
	|   o_tag (body)?
	;
	
p_tag
	: 	 p_tag_init body p_tag_end
	;
	
p_tag_init
	:	 TAG1INIT props TAGEND
	;
	
p_tag_end
	:	 TAG2INIT PROPS TAGEND
	;
	
o_tag
	: o_tag_init (body)? o_tag_end
	;
	
o_tag_init
	:	 TAG1INIT CIRCLE (COMMA props)? TAGEND
	;
	
o_tag_end
	:	 TAG2INIT CIRCLE TAGEND
	;

	
props
	:	O_ID ASSIGN ID (COMMA COLOR ASSIGN color)? (COMMA SIZE ASSIGN REAL)?
	|	O_ID ASSIGN ID (COMMA SIZE ASSIGN REAL)?  (COMMA COLOR ASSIGN color)?
	|   COLOR ASSIGN color (COMMA SIZE ASSIGN REAL)? (COMMA O_ID ASSIGN ID)?
	|   COLOR ASSIGN color (COMMA O_ID ASSIGN ID)? (COMMA SIZE ASSIGN REAL)?
	|   SIZE ASSIGN REAL (COMMA COLOR ASSIGN color)? (COMMA O_ID ASSIGN ID)?
	|	SIZE ASSIGN REAL (COMMA O_ID ASSIGN ID)? (COMMA COLOR ASSIGN color)? 
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
SQUARE         : 'square';
ELLIPSE		   : 'ellipse';
RECTANGLE      : 'rectangle';
TRIANGLE       : 'triangle';


SCALE_X		   : 'x';
SCALE_Y		   : 'y';
O_ID		   : 'id';
PROPS		   : 'props';
COLOR		   : 'color';
SIZE		   : 'size';
POSITION       : 'position';
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