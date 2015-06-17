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
	:	(COMMA canvas_scalex)? (COMMA canvas_scaley)?
	;

canvas_scalex
	:	SCALE_X ASSIGN REAL
	;
	
canvas_scaley
	:   SCALE_Y ASSIGN REAL
	;

body
	:	p_tag (body)?
	|   o_tag (body)?
	;
	
p_tag
	: 	 p_tag_init body p_tag_end
	;
	
p_tag_init
	:	 TAG1INIT PROPS COMMA props TAGEND
	;
	
p_tag_end
	:	 TAG2INIT PROPS TAGEND
	;
	
o_tag
	: o_tag_init (body)? o_tag_end
	;
	
o_tag_init
	:	 TAG1INIT CIRCLE (COMMA props)? TAGEND
	|	 TAG1INIT SQUARE (COMMA props)? TAGEND
	|    TAG1INIT TRIANGLE (COMMA props)? TAGEND
	|    TAG1INIT RECTANGLE (COMMA props)? TAGEND
	|    TAG1INIT ELLIPSE (COMMA props)? TAGEND
	|    TAG1INIT LINE (COMMA props)? TAGEND
	|    TAG1INIT POINT (COMMA props)? TAGEND
	;
	
o_tag_end
	:	 TAG2INIT CIRCLE TAGEND
	|	 TAG2INIT SQUARE TAGEND
	|	 TAG2INIT TRIANGLE TAGEND
	|	 TAG2INIT RECTANGLE TAGEND
	|	 TAG2INIT ELLIPSE TAGEND
	|	 TAG2INIT LINE TAGEND
	|	 TAG2INIT POINT TAGEND
	;

	
props
	:	 O_ID ASSIGN ID (COMMA o_scalex)? (COMMA o_scaley)? (COMMA P1 ASSIGN REAL (COMMA P2 ASSIGN REAL (COMMA P3 ASSIGN REAL (COMMA P4 ASSIGN REAL)?)?)?)? (COMMA COLOR ASSIGN color)? (COMMA FILL ASSIGN color)? (COMMA BORDER ASSIGN color)? (COMMA ROTATION ASSIGN REAL )?
	|	 o_scalex (COMMA o_scaley)? (COMMA P1 ASSIGN REAL (COMMA P2 ASSIGN REAL (COMMA P3 ASSIGN REAL (COMMA P4 ASSIGN REAL)?)?)?)? (COMMA COLOR ASSIGN color)? (COMMA FILL ASSIGN color)? (COMMA BORDER ASSIGN color)? (COMMA ROTATION ASSIGN REAL )?
	|	 o_scaley (COMMA P1 ASSIGN REAL (COMMA P2 ASSIGN REAL (COMMA P3 ASSIGN REAL (COMMA P4 ASSIGN REAL)?)?)?)? (COMMA COLOR ASSIGN color)? (COMMA FILL ASSIGN color)? (COMMA BORDER ASSIGN color)? (COMMA ROTATION ASSIGN REAL )?
	|	 COMMA P1 ASSIGN REAL (COMMA P2 ASSIGN REAL (COMMA P3 ASSIGN REAL (COMMA P4 ASSIGN REAL)?)?)? (COMMA COLOR ASSIGN color)? (COMMA FILL ASSIGN color)? (COMMA BORDER ASSIGN color)? (COMMA ROTATION ASSIGN REAL )?
	|	 COLOR ASSIGN color (COMMA FILL ASSIGN color)? (COMMA BORDER ASSIGN color)? (COMMA ROTATION ASSIGN REAL )?
	|	 FILL ASSIGN color (COMMA BORDER ASSIGN color)? (COMMA ROTATION ASSIGN REAL )?
	|	 BORDER ASSIGN color (COMMA ROTATION ASSIGN REAL )?
	|	 ROTATION ASSIGN REAL
	;    

o_scalex
	:	COORD_X ASSIGN REAL
	;
	
o_scaley
	:   COORD_Y ASSIGN REAL
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
LINE		   : 'line';
POINT 		   : 'point';

SCALE_X		   : 'x';
SCALE_Y		   : 'y';
COORD_X		   : 'cx';
COORD_Y		   : 'cy';
O_ID		   : 'id';
COLOR		   : 'color';
P1			   : 'p1';
P2			   : 'p2';
P3			   : 'p3';
P4			   : 'p4';	
ROTATION       : 'rotation';
FILL		   : 'fill';
PROPS		   : 'props';
BORDER		   : 'border';

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