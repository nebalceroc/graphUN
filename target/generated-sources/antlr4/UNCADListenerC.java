// Generated from UNCAD.g4 by ANTLR 4.5

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.swing.JFrame;
import java.util.ArrayDeque;
import java.util.ArrayList;

/**
 * This class provides an empty implementation of {@link UNCADListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
public class UNCADBaseListener implements UNCADListener {
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	UNCADParser parser;
	ArrayList<CanvasShape> shapes;
	ArrayDeque<CanvasShape> shape_predeclaration_stack;
	ArrayDeque<CanvasShape> shape_declaration_stack;
	ArrayDeque<String> prop_declaration_stack;
	JFrame frame;
	ProcessingCanvas canvas;
	boolean obj_props = false;
	boolean error_flag = false;
	boolean canvas_flag = false;
	
	ArrayList<String> shape_words;
	
	public UNCADBaseListener(UNCADParser parser,String name) {
		this.parser = parser;
		this.shapes = new ArrayList<CanvasShape>();
		this.frame = new JFrame();
		this.frame.setTitle(name);
		this.shape_words = new ArrayList<String>();
		shape_words.add("circle");
		shape_words.add("ellipse");
		shape_words.add("square");
		shape_words.add("rectangle");
		shape_words.add("triangle");
		this.shape_predeclaration_stack = new ArrayDeque<CanvasShape>();
		this.shape_declaration_stack = new ArrayDeque<CanvasShape>();
	}
	
	
	@Override public void enterDoc(UNCADParser.DocContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDoc(UNCADParser.DocContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas(UNCADParser.CanvasContext ctx) { 		
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCanvas(UNCADParser.CanvasContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas_init(UNCADParser.Canvas_initContext ctx) { 
		System.out.println("canvas init tag detected");
		if(!canvas_flag){
			//System.out.println(ctx.getText());
			canvas_flag = true;
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCanvas_init(UNCADParser.Canvas_initContext ctx) { 
		System.out.println("canvas init tag end \n props suposed to be verified");
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas_end(UNCADParser.Canvas_endContext ctx) {
		System.out.println("canvas end tag detected");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCanvas_end(UNCADParser.Canvas_endContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas_props(UNCADParser.Canvas_propsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCanvas_props(UNCADParser.Canvas_propsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas_scalex(UNCADParser.Canvas_scalexContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCanvas_scalex(UNCADParser.Canvas_scalexContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas_scaley(UNCADParser.Canvas_scaleyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCanvas_scaley(UNCADParser.Canvas_scaleyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBody(UNCADParser.BodyContext ctx) { 
		if(canvas_flag){
			//System.out.println(ctx.getText());
			//if(ctx.getText().contains("<canvas>")){
			if(ctx.getTokens(4).size()>0){
				System.out.println("Error(Line:"+ctx.getTokens(4).get(0).getSymbol().getLine()+") Previous canvas declaration detected.");
			}
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitBody(UNCADParser.BodyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterP_tag(UNCADParser.P_tagContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitP_tag(UNCADParser.P_tagContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterP_tag_init(UNCADParser.P_tag_initContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitP_tag_init(UNCADParser.P_tag_initContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterP_tag_end(UNCADParser.P_tag_endContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitP_tag_end(UNCADParser.P_tag_endContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterO_tag(UNCADParser.O_tagContext ctx) { 
		System.out.println("Object tag pair detected(sin match)");
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitO_tag(UNCADParser.O_tagContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterO_tag_init(UNCADParser.O_tag_initContext ctx) { 
		System.out.println("Object declaration init tag detected");
		String in = ctx.getText();
		in = in.replace("<","");
		in = in.replace(">","");
		String[] split_in = in.split(",");
		String shape_type = split_in[0];
		if(shape_words.contains(shape_type)){
			CanvasShape shape = new CanvasShape(shape_type);
			System.out.println("Shape predeclaration: "+shape_type);
			shape_predeclaration_stack.push(shape);
			//System.out.println(shape_predeclaration_stack.peekFirst().getType());
			
		}else{
			System.out.println("Error(Line:"+ctx.getStart().getLine()+") Shape type not declared. ("+shape_type+")");
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitO_tag_init(UNCADParser.O_tag_initContext ctx) { 
				
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterO_tag_end(UNCADParser.O_tag_endContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitO_tag_end(UNCADParser.O_tag_endContext ctx) { 
		System.out.println("Object declaration end tag detected");
		String in = ctx.getText();
		in = in.replace("</","");
		in = in.replace(">","");
		String[] split_in = in.split(",");
		String shape_type = split_in[0];
		System.out.println(in);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProps(UNCADParser.PropsContext ctx) {
		System.out.println("Object props detected :");
		System.out.println(shape_predeclaration_stack.peekFirst().getType());
		String in = ctx.getText();
		String[] split_in = in.split(",");
		String shape_type = split_in[0];
		
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitProps(UNCADParser.PropsContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterO_scalex(UNCADParser.O_scalexContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitO_scalex(UNCADParser.O_scalexContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterO_scaley(UNCADParser.O_scaleyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitO_scaley(UNCADParser.O_scaleyContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterColor(UNCADParser.ColorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitColor(UNCADParser.ColorContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterNewLine(UNCADParser.NewLineContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitNewLine(UNCADParser.NewLineContext ctx) { }

	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitEveryRule(ParserRuleContext ctx) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitTerminal(TerminalNode node) { }
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void visitErrorNode(ErrorNode node) { }
}