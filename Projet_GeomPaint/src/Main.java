import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Main {
	public static void main(String[] args) {
		JFrame frame = new JFrame("GeomPaint");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Model m = new Model();
		VDrawingArea vda = new VDrawingArea(m);
		CDrawingArea cda = new CDrawingArea();
		ToolBar tb = new ToolBar(m);
		Organiser paintSoftware = new Organiser(vda,tb);
		vda.addMouseListener(cda);
		vda.addMouseMotionListener(cda);
		paintSoftware.setPreferredSize(new Dimension(600,600));
		frame.setContentPane(paintSoftware);
		frame.pack();
		frame.setVisible(true);
		frame.setResizable(false);
		paintSoftware.setFocusable(true);		  
	}
}
