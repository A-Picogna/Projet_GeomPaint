import java.awt.*;

import javax.swing.*;

import java.awt.event.*;


public class Main {
	public static void main(String[] args) {
		// Definition of the Frame
		JFrame window = new JFrame("GeomPaint");
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Generation of the different elements constituting the application :
			// Model.
		Model m = new Model();
			// View for the drawing part of the model.
		VDrawingArea vda = new VDrawingArea(m);
			// View for the ToolBar part of the model.
		ToolBar tb = new ToolBar(m);
			// View assembling together the VDrawingArea and the ToolBar views.
		Organiser paintSoftware = new Organiser(vda,tb);
		
		// Implementation of the Model's Observer.
		m.addObserver(vda);
		
		// Definition of the size and specifications for the window.
		paintSoftware.setPreferredSize(new Dimension(600,600));
		window.setContentPane(paintSoftware);
		window.pack();
		window.setVisible(true);
		window.setResizable(false);
		paintSoftware.setFocusable(true);		  
	}
}
