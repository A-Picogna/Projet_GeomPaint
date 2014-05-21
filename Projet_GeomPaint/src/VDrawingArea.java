import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

public class VDrawingArea extends JPanel{
	
	Model drawingList;
	
	public VDrawingArea(){
		drawingList = new Model();
	}
	
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	GeomShape figure;
    	int nbPoints;
    	for(int i = 0 ; i < this.drawingList.getfigureList().size() ; i++){
    		figure = this.drawingList.getfigureList().get(i);
    		nbPoints = figure.getNumberPoints();
    		for (int j = 0 ; j < nbPoints-1 ; j++){
    			g.drawLine(figure.getPointsTab[j].getX(), figure.getPointsTab[j].getY(), figure.getPointsTab[j+1].getX(), figure.getPointsTab[j+1].getY());
    		}
    		g.drawLine(figure.getPointsTab[nbPoints-1].getX(), figure.getPointsTab[nbPoints-1].getY(), figure.getPointsTab[0].getX(), figure.getPointsTab[0].getY());
    	}
	}
	
	

}
