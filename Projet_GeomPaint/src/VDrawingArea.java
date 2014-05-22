import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
<<<<<<< HEAD
=======
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
>>>>>>> branch 'master' of git@github.com:APicogna/Projet_GeomPaint.git
import java.util.LinkedList;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


public class VDrawingArea extends JPanel implements Observer {

	
	private Model model;

	
	public VDrawingArea(Model m){
		super();
		this.model = m;
	}
	
	
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	this.displayAll(g);
	}


	public void update(Observable o, Object arg1) {
		this.model = (Model) o;
		repaint();		
	}
	
	
	public void displayAll(Graphics g){
		GeomShape figure;
    	int nbPoints;
    	for(int i = 0 ; i < this.model.getfigureList().size() ; i++){
    		figure = this.model.getFigureList().get(i);
    		nbPoints = figure.getNumberPoints();
    		for (int j = 0 ; j < nbPoints-1 ; j++){
    			g.drawLine(figure.getPointsTab[j].getX(), figure.getPointsTab[j].getY(), figure.getPointsTab[j+1].getX(), figure.getPointsTab[j+1].getY());
    		}
    		g.drawLine(figure.getPointsTab[nbPoints-1].getX(), figure.getPointsTab[nbPoints-1].getY(), figure.getPointsTab[0].getX(), figure.getPointsTab[0].getY());
    	}
	}

	