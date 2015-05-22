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
	ArrayDeque<CanvasShape> shape_declaration_stack;
	ArrayDeque<String> prop_declaration_stack;
	JFrame frame;
	ProcessingCanvas canvas;
	boolean obj_props = false;
	boolean error_flag = false;

	public UNCADBaseListener(UNCADParser parser,String name) {
		this.parser = parser;
		this.shapes = new ArrayList<CanvasShape>();
		this.frame = new JFrame();
		this.frame.setTitle(name);
	}
	
	@Override public void enterDoc(UNCADParser.DocContext ctx) {
	}
	
	public String getProps(){return "nul";};
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitDoc(UNCADParser.DocContext ctx) { 
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	
	@Override public void enterCanvas(UNCADParser.CanvasContext ctx) {
		System.out.println("canvas rule detected");
		String in = ctx.getText();
		boolean search_flag=true;
		int index;
		while(search_flag){
			index = in.indexOf("<canvas");
			if(index>=0){
				in = in.replaceFirst("<canvas","");
				index = in.indexOf("</canvas>");
				if(index>=0){
					in = in.replaceFirst("</canvas>","");
					if(in.indexOf("<canvas")>=0){
						System.out.println("More than one canvas definition found");
						error_flag = true;
					}
					if(in.indexOf("</canvas>")>=0){
						System.out.println("More than one canvas end-definition found");
						error_flag = true;
					}
					search_flag = false;
					
				}else{
					System.out.println("No canvas end-definition found");
					search_flag=false;
				}
			}else{
				System.out.println("No canvas definition found");
				search_flag=false;
			}
		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCanvas(UNCADParser.CanvasContext ctx) { 
		this.canvas = new ProcessingCanvas(this.shapes);		
		this.frame.add(this.canvas);
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterBody(UNCADParser.BodyContext ctx) { }
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
	@Override public void enterO_tag(UNCADParser.O_tagContext ctx) {
		System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitO_tag(UNCADParser.O_tagContext ctx) { 
		System.out.println("OBJECT EXIT para que ya se hallan verificado las propiedades"+ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProps(UNCADParser.PropsContext ctx) { }
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