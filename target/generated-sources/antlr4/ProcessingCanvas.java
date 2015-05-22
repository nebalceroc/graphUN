import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;

import java.util.ArrayList;

public class ProcessingCanvas extends JPanel{
	
	ArrayList<CanvasShape> shapes;
	
	public ProcessingCanvas(ArrayList<CanvasShape> shapes){
		this.shapes = shapes;
	}
	
	private void doDrawing(Graphics g) {

        Graphics2D g2d = (Graphics2D) g;
        g2d.fillOval(270, 130, 50, 50);;
    }
	
	private void drawOval(int a, int b, int c, int d, Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		g2d.draw(new Ellipse2D.Double(a, b, c, d));
		
	}
	
	private void drawCircle(int a, int b, Graphics g){
		drawOval(a,a,b,b,g);
	}

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        
    }
}