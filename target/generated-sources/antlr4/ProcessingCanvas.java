import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

import java.util.ArrayList;
import javax.swing.JFrame;
import java.util.ArrayDeque;
import java.awt.Color;
import java.awt.Dimension;
import java.util.*;


public class ProcessingCanvas extends JPanel{
	
	ArrayDeque<CanvasShape> shapes;
	JFrame frame;
	int size_x;
	int size_y;
	
	public ProcessingCanvas(ArrayDeque<CanvasShape> shapes, int size_x, int size_y){
		this.shapes = shapes;
		this.size_x = size_x;
		this.size_y = size_y;
		this.setPreferredSize(new Dimension(size_x,size_y));
		this.setMinimumSize(new Dimension(size_x,size_y));
		this.setMaximumSize(new Dimension(size_x,size_y));
	}
	
	private void init_draw(Graphics g){
		Iterator<CanvasShape> it = shapes.iterator();
		while (it.hasNext()){
			CanvasShape shape = it.next();
			String type=shape.getType();
			//System.out.println("shape: "+type);
			switch(type){
				case "circle":
					//System.out.println("Drawing circle");
					drawCircle(shape.getCx(),shape.getCy(),shape.getP1(),shape.getColor(),shape.getFill(),shape.getBorder(),shape.getRotation(),g);
					break;
				case "square":
					//System.out.println("Drawing square");
					drawSquare(shape.getCx(),shape.getCy(),shape.getP1(),shape.getColor(),shape.getFill(),shape.getBorder(),shape.getRotation(),g);
					break;
				case "rectangle": 
					drawRectangle(shape.getCx(),shape.getCy(),shape.getP1(),shape.getP2(),shape.getColor(),shape.getFill(),shape.getBorder(),shape.getRotation(),g);
					break;
				case "triangle":
					drawTriangle(shape.getCx(),shape.getCy(),shape.getP1(),shape.getP2(),shape.getP3(),shape.getP4(),shape.getColor(),shape.getFill(),shape.getBorder(),shape.getRotation(),g);
					break;
				case "ellipse":
					//System.out.println("Drawing ellipse");
					drawOval(shape.getCx(),shape.getCy(),shape.getP1(),shape.getP2(),shape.getColor(),shape.getFill(),shape.getBorder(),shape.getRotation(),g);
					break;
				case "line":
					drawLine(shape.getCx(),shape.getCy(),shape.getP1(),shape.getP2(),shape.getP3(),shape.getP4(),shape.getColor(),shape.getBorder(),shape.getRotation(),g);
					break;
				case "point":
					drawCircle(shape.getCx(),shape.getCy(),5,shape.getColor(),shape.getFill(),shape.getBorder(),shape.getRotation(),g);
					break;
			}
		}
	}
	
	private void drawTriangle(float x, float y, float p1, float p2, float p3, float p4, String color,String fill, String border, float rotation, Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        int[] vx = new int[]{(int) x, (int) p1, (int) p3};
        int[] vy = new int[]{(int) y, (int) p2, (int) p4};
        g2d.rotate((double) rotation);
        if(color.equals("no_color")){
			g2d.setColor(getColor(fill));
			g2d.fillPolygon(vx,vy,3);
			g2d.setColor(getColor(border));
			g2d.drawPolygon(vx,vy,3);
		}else{
			g2d.setColor(getColor(color));
			g2d.drawPolygon(vx,vy,3);
			g2d.fillPolygon(vx,vy,3);
		}	
    }
	
	private void drawLine(float x, float y, float p1, float p2, float p3, float p4, String color, String border, float rotation, Graphics g){
		Graphics2D g2d = (Graphics2D) g;
        int[] vx = new int[]{(int) x, (int) p1, (int) p3};
        int[] vy = new int[]{(int) y, (int) p2, (int) p4};
        g2d.rotate((double) rotation);
        if(color.equals("no_color")){
			g2d.setColor(getColor(border));
			g2d.drawPolyline(vx,vy,3);
		}else{
			g2d.setColor(getColor(color));
			g2d.drawPolyline(vx,vy,3);
		}
	}
	
	private void drawSquare(float x, float y, float d, String color,String fill, String border, float rotation, Graphics g){
		drawRectangle(x,y,d,d,color,fill,border,rotation,g);		
	}
	
	private void drawRectangle(float x, float y, float h, float w, String color,String fill, String border, float rotation, Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate((double) rotation);
		if(color.equals("no_color")){
			g2d.setColor(getColor(fill));
			g2d.fillRect((int) x,(int) y, (int) h, (int) w);
			g2d.setColor(getColor(border));
			g2d.drawRect((int) x,(int) y, (int) h, (int) w);
		}else{
			g2d.setColor(getColor(color));
			g2d.drawRect((int) x,(int) y, (int) h, (int) w);
			g2d.fillRect((int) x,(int) y, (int) h, (int) w);
		}		
	}
	
	private void drawOval(float x, float y, float a, float b, String color, String fill, String border, float rotation, Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.rotate((double) rotation);
		if(color.equals("no_color")){
			g2d.setColor(getColor(fill));
			g2d.fillOval((int) x,(int) y, (int) a, (int) b);
			g2d.setColor(getColor(border));
			g2d.drawOval((int) x,(int) y, (int) a, (int) b);
		}else{
			g2d.setColor(getColor(color));
			g2d.drawOval((int) x, (int) y, (int) a,(int)  b);
			g2d.fillOval((int) x, (int) y, (int) a,(int)  b);
		}
		
	}
	
	private void drawCircle(float x, float y, float r, String color,String fill, String border, float rotation, Graphics g){
		drawOval(x,y,r,r,color,fill,border,rotation,g);
	}
	
	private Color getColor(String color){
		Color c;
		switch(color){
			case "green":
				c = Color.green;
				break;
			case "red":
				c = Color.red;
				break;
			case "blue":
				c = Color.blue;
				break;
			case "yellow":
				c = Color.yellow;
				break;
			case "black":
				c = Color.black;
				break;
			case "white":
				c = Color.white;
				break;
			default:
				c = Color.black;
				break;
		}
		return c;
	}
	
	private Color getFillColor(String color){
		Color c;
		switch(color){
			case "green":
				c = Color.green;
				break;
			case "red":
				c = Color.red;
				break;
			case "blue":
				c = Color.blue;
				break;
			case "yellow":
				c = Color.yellow;
				break;
			case "black":
				c = Color.black;
				break;
			case "white":
				c = Color.white;
				break;
			default:
				c = Color.white;
				break;
		}
		return c;
	}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        init_draw(g);        
    }
    
    public void paint(Graphics g) {
    	init_draw(g); 
    }
}