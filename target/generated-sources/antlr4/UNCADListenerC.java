import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.NotNull;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.awt.Dimension;
import java.awt.BorderLayout;

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
	ArrayDeque<CanvasShape> shape_predeclaration_stack;
	ArrayDeque<CanvasShape> shape_declaration_stack;
	ArrayDeque<String> prop_declaration_stack;
	ArrayList<String> ids;
	JFrame frame;
	JPanel panel;
	ProcessingCanvas canvas;
	boolean obj_props = false;
	boolean error_flag = false;
	boolean canvas_flag = false;
	boolean prop_tag_open=false;
	int canvas_x = 500;
	int canvas_y = 500;
	
	ArrayList<String> shape_words;
	
	public UNCADBaseListener(UNCADParser parser) {
		this.parser = parser;
		this.shape_words = new ArrayList<String>();
		this.ids = new ArrayList<String>();
		shape_words.add("circle");
		shape_words.add("ellipse");
		shape_words.add("square");
		shape_words.add("rectangle");
		shape_words.add("triangle");
		shape_words.add("point");
		shape_words.add("line");
		this.shape_predeclaration_stack = new ArrayDeque<CanvasShape>();
		this.shape_declaration_stack = new ArrayDeque<CanvasShape>();
		this.prop_declaration_stack = new ArrayDeque<String>();
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
	@Override public void exitCanvas(UNCADParser.CanvasContext ctx) { 
		this.frame = new JFrame();
		this.frame.setPreferredSize(new Dimension(this.canvas_x,this.canvas_y));
		this.frame.setMaximumSize(new Dimension(this.canvas_x,this.canvas_y));
		this.frame.setMinimumSize(new Dimension(this.canvas_x,this.canvas_y));
		//this.frame.setResizable(false);
		int size = shape_declaration_stack.size();
		canvas = new ProcessingCanvas(shape_declaration_stack,this.canvas_x,this.canvas_y);
		this.frame.add(canvas);
		this.frame.setVisible(true);
		this.canvas.setVisible(true);
		this.frame.setTitle("UnCad v0.0");
		/*
		for(int x=0;x<size;x++){	
			CanvasShape shape = shape_declaration_stack.pop(); 
			System.out.println("Type: "+shape.getType()+" id: "+shape.getId()+" cx: "+shape.getCx()+" cy: "+shape.getCy()+" p1: "+shape.getP1()+" p2: "+shape.getP2()+" color: "+shape.getColor()+" border: "+shape.getBorder()+" fill: "+shape.getFill()+" rotation: "+shape.getRotation());
		}*/
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas_init(UNCADParser.Canvas_initContext ctx) { 
		//System.out.println("canvas init tag detected");
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
		//System.out.println("canvas init tag end \n props suposed to be verified");
		//System.out.println(ctx.getText());
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas_end(UNCADParser.Canvas_endContext ctx) {
		//System.out.println("canvas end tag detected");
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
	@Override public void enterCanvas_scalex(UNCADParser.Canvas_scalexContext ctx) {
		String in = ctx.getText();
		String[] in_data = in.split("=");
		if(in_data.length==2){
			this.canvas_x = (int) Float.parseFloat(in_data[1]);
		}else{
			System.out.println("Error(Line:"+ctx.getStart().getLine()+") Error declaring canvas x dimension.");

		}
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitCanvas_scalex(UNCADParser.Canvas_scalexContext ctx) {	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterCanvas_scaley(UNCADParser.Canvas_scaleyContext ctx) {
		String in = ctx.getText();
		String[] in_data = in.split("=");
		if(in_data.length==2){
			this.canvas_y = (int) Float.parseFloat(in_data[1]);
		}else{
			System.out.println("Error(Line:"+ctx.getStart().getLine()+") Error declaring canvas y dimension.");

		}
	}
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
	@Override public void enterP_tag_init(UNCADParser.P_tag_initContext ctx) { 
		prop_tag_open=true;
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void exitP_tag_init(UNCADParser.P_tag_initContext ctx) { 
		prop_tag_open=false;
	}
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
	@Override public void exitP_tag_end(UNCADParser.P_tag_endContext ctx) { 
		String propr_deleted = prop_declaration_stack.pop();
	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterO_tag(UNCADParser.O_tagContext ctx) { 
		//System.out.println("Object tag pair detected(sin match)");
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
		//System.out.println("Object declaration init tag detected");
		String in = ctx.getText();
		in = in.replace("<","");
		in = in.replace(">","");
		String[] split_in = in.split(",");
		String shape_type = split_in[0];
		if(shape_words.contains(shape_type)){
			CanvasShape shape = new CanvasShape(shape_type);
			//System.out.println("Shape predeclaration: "+shape_type);
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
		//System.out.println("Object declaration end tag detected");
		String in = ctx.getText();
		in = in.replace("</","");
		in = in.replace(">","");
		String[] split_in = in.split(",");
		String shape_type = split_in[0];
		//System.out.println(in);
		CanvasShape shape = shape_predeclaration_stack.peekFirst();
		if(shape_type.equals(shape.getType())){
			shape = shape_predeclaration_stack.pop();
			if(prop_declaration_stack.size()>0){
				String in2 = prop_declaration_stack.peekFirst();
				String[] split_in2 = in2.split(",");
				String shape_type2 = split_in2[0];
				for(int x=0;x<split_in2.length;x++){
					String[] data_in = split_in2[x].split("=");
					String prop = data_in[0];
					String data = data_in[1];
					switch(prop){
						case "id":
							shape.setId(data);
							break;
						case "cx":
							shape.setCx(Float.parseFloat(data));
							break;
						case "cy":
							shape.setCy(Float.parseFloat(data));
							break;
						case "p1":
							shape.setP1(Float.parseFloat(data));
							break;
						case "p2":
							shape.setP2(Float.parseFloat(data));
							break;
						case "p3":
							shape.setP3(Float.parseFloat(data));
							break;
						case "p4":
							shape.setP4(Float.parseFloat(data));
							break;
						case "color":
							shape.setColor(data);
							break;
						case "border":
							shape.setBorder(data);
							break;
						case "fill":
							shape.setFill(data);
							break;
						case "rotation":
							shape.setRotation(Float.parseFloat(data));
							break;			
					}
				}
				
				
				
			}		
			if(shape_predeclaration_stack.size()>0){
				CanvasShape shape_parent = shape_predeclaration_stack.peekFirst();
				shape.setCx(shape.getCx()+shape_parent.getCx());
				shape.setCy(shape.getCy()+shape_parent.getCy());
				shape.setRotation(shape.getRotation()+shape_parent.getRotation());
			}
			if(ids.contains(shape.getId()) && !shape.getId().equals("no_id")){
				System.out.println("Error(Line:"+ctx.getStart().getLine()+") Dublicated id detected.");
			}else{
				ids.add(shape.getId());
			}
			shape_declaration_stack.push(shape);
		}
 	}
	/**
	 * {@inheritDoc}
	 *
	 * <p>The default implementation does nothing.</p>
	 */
	@Override public void enterProps(UNCADParser.PropsContext ctx) {
		//System.out.println("Object props detected :");
		//System.out.println(shape_predeclaration_stack.peekFirst().getType());
		if(!prop_tag_open){
			String in = ctx.getText();
			String[] split_in = in.split(",");
			String shape_type = split_in[0];
			CanvasShape shape = shape_predeclaration_stack.peekFirst();
			for(int x=0;x<split_in.length;x++){
				String[] data_in = split_in[x].split("=");
				String prop = data_in[0];
				String data = data_in[1];
				switch(prop){
					case "id":
						shape.setId(data);
						break;
					case "cx":
						shape.setCx(Float.parseFloat(data));
						break;
					case "cy":
						shape.setCy(Float.parseFloat(data));
						break;
					case "p1":
						shape.setP1(Float.parseFloat(data));
						break;
					case "p2":
						shape.setP2(Float.parseFloat(data));
						break;
					case "p3":
						shape.setP3(Float.parseFloat(data));
						break;
					case "p4":
						shape.setP4(Float.parseFloat(data));
						break;
					case "color":
						shape.setColor(data);
						break;
					case "border":
						shape.setBorder(data);
						break;
					case "fill":
						shape.setFill(data);
						break;
					case "rotation":
						shape.setRotation(Float.parseFloat(data));
						break;			
				}
			}
			if(shape_predeclaration_stack.size()>1){
				shape = shape_predeclaration_stack.pop();
				CanvasShape shape_parent = shape_predeclaration_stack.peekFirst();
				shape.setCx(shape_parent.getCx());
				shape.setCy(shape_parent.getCy());
				if(shape.getType().equals("triangle") || shape.getType().equals("line")){
					shape.setP1(shape.getP1()+shape_parent.getCx());
					shape.setP2(shape.getP2()+shape_parent.getCy());
					shape.setP3(shape.getP3()+shape_parent.getCx());
					shape.setP4(shape.getP4()+shape_parent.getCy());					
				}
				shape_predeclaration_stack.push(shape);
			}
			if(ids.contains(shape.getId()) && !shape.getId().equals("no_id")){
				System.out.println("Error(Line:"+ctx.getStart().getLine()+") Duplicated id detected.");
			}else{
				ids.add(shape.getId());
			}
			//System.out.println("Type: "+shape.getType()+" id: "+shape.getId()+" cx: "+shape.getCx()+" cy: "+shape.getCy()+" p1: "+shape.getP1()+" p2: "+shape.getP2()+" p3: "+shape.getP3()+" p4: "+shape.getP4()+" color: "+shape.getColor()+" border: "+shape.getBorder()+" fill: "+shape.getFill()+" rotation: "+shape.getRotation());
		}else{
			prop_declaration_stack.push(ctx.getText());
		}
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