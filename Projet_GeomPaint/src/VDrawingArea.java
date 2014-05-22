import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;

public class VDrawingArea extends JPanel implements Observer, MouseListener {
	
	Model model;
	
	public VDrawingArea(){
		model = new Model();
	}
	
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	this.displayAll(g);
	}

	public void update(Observable o, Object arg1) {
		model = (Model) o;
		
		
	}
	
	public void createDrawing(GeomShape gs){
		int nbPoints = this.model.getFigureList().get(this.model.getFigureList().drawingSelected());
		
	}
	
	public void displayAll(Graphics g){
		GeomShape figure;
    	int nbPoints;
    	for(int i = 0 ; i < this.model.getFigureList().size() ; i++){
    		figure = this.model.getFigureList().get(i);
    		nbPoints = figure.getNumberPoints();
    		for (int j = 0 ; j < nbPoints-1 ; j++){
    			g.drawLine(figure.getPointsTab()[j].getX(), figure.getPointsTab()[j].getY(), figure.getPointsTab()[j+1].getX(), figure.getPointsTab()[j+1].getY());
    		}
    		g.drawLine(figure.getPointsTab()[nbPoints-1].getX(), figure.getPointsTab()[nbPoints-1].getY(), figure.getPointsTab()[0].getX(), figure.getPointsTab()[0].getY());
    	}
	}

	

}
