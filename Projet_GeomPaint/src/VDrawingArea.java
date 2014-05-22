import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class VDrawingArea extends JPanel implements Observer, MouseListener, MouseMotionListener {
	
	private Model model;
	private static boolean drawingInProgress = false;
	private static int numberClicRequired = 0;
	private static ArrayList<Point> pointsToDraw;
	
	public VDrawingArea(){
		model = new Model();
	}
	
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	this.displayAll(g);
	}

	public void update(Observable o, Object arg1) {
		this.model = (Model) o;
		if (this.model.isRectangle())
			this.createDrawing("rectangle");
		if (this.model.isTriangle())
			this.createDrawing("triangle");
		if (this.model.isCercle())
			this.createDrawing("circle");
		if (this.model.isPolygon())
			this.createDrawing("polygon");		
		
	}
	
	@Override
	public void mouseReleased(MouseEvent e) {
		if (SwingUtilities.isLeftMouseButton(e)){
			pointsToDraw.add(new Point(e.getX(), e.getY()));
			Graphics tmp = null;
			tmp.fillRect (e.getX(), e.getY(), 5, 5);
			tmp.setColor(Color.black);
			numberClicRequired--;
		}
	}
	
	public void createDrawing(String s){
		this.addMouseListener(this);
		this.addMouseMotionListener(this);
		drawingInProgress = true;
		
		switch(s){
		case (s = "rectangle"):
			numberClicRequired = 2;
			while (numberClicRequired > 0){				
			}
			//points number 1 and 3 are known, we need to calculate 2 and 4
			pointsToDraw.add(new Point( pointsToDraw.get(1).getX() - pointsToDraw.get(0).getX() + pointsToDraw.get(0).getX() ,
										pointsToDraw.get(0).getY() ));
			pointsToDraw.add(new Point( pointsToDraw.get(0).getX() ,
										pointsToDraw.get(1).getY() - pointsToDraw.get(0).getY() + pointsToDraw.get(0).getY() ));
			/*
			 * so we need to instance a rectangle with all points in our arrayList
			 * ATTENTION points sequence a,b,c,d in the list is 0,2,1,3
			 */
			this.model.addFigure(new Rectangle(pointsToDraw.get(0), pointsToDraw.get(2), pointsToDraw.get(1), pointsToDraw.get(3)));
			pointsToDraw.clear();			
			break;
		case (s = "triangle"):
			numberClicRequired = 3;
			while (numberClicRequired > 0){				
			}
			this.model.addFigure(new Triangle(pointsToDraw.get(0), pointsToDraw.get(1), pointsToDraw.get(2)));
			pointsToDraw.clear();	
			break;
		case (s = "circle"):
			numberClicRequired = 3;
			while (numberClicRequired > 0){				
			}
			this.model.addFigure(new circle(pointsToDraw.get(0), pointsToDraw.get(1)));
			pointsToDraw.clear();	
			break;
		case (s = "polygon"):
			numberClicRequired = //LE NOMBRE DE POINTS SAISI PAR L'UTILISATEUR;
			while (numberClicRequired > 0){				
			}
			this.model.addFigure(new Polygon());
			pointsToDraw.clear();	
			break;
		}
		this.removeMouseListener(this);
		this.removeMouseMotionListener(this);
		drawingInProgress = false;	
		repaint();
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

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	

}
