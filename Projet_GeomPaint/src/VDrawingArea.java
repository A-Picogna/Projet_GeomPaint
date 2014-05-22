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


@SuppressWarnings("serial")
public class VDrawingArea extends JPanel implements Observer {

	/**
	 * This class is the view of our program
	 * her role is to drawing all the figure
	 * every time a change is detected
	 */
	
	private Model model;

	
	public VDrawingArea(Model m){
		super();
		this.model = m;
	}
	
	
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	this.displayAll(g);
	}


	/**
	 * every time a change is noticed, we check repaint everything
	 */
	public void update(Observable o, Object arg1) {
		this.model = (Model) o;
		repaint();		
	}
	
	/**
	 * this method is use to draw every single figure,
	 * for each figure we check if this is a polygon or a circle type
	 * in both case we also change the color and if the figure is 
	 * filled or not
	 */
	public void displayAll(Graphics g){
		GeomShape figure;
    	int nb_pts;
    	for(int i = 0 ; i < this.model.getFigureList().size() ; i++){
    		figure = this.model.getFigureList().get(i);
    		nb_pts = figure.getNumberPoints();
    		// check if it is a polygon or a circle type
    		if (figure instanceof Polygon){
    			int[] coordsX = new int[nb_pts];
        		int[] coordsY = new int[nb_pts];
        		// to draw a polygon, we need to create two tab, one with x coord and other with y coord
        		for (int j = 0 ; j < nb_pts-1 ; j++){
        			coordsX[j] = figure.getPointsTab()[j].getX();
        			coordsY[j] = figure.getPointsTab()[j].getY();
        		}
        		g.setColor(figure.getColour());
        		//check is we need to fill the figure or not
        		if (figure.isFilled())
        			g.fillPolygon(coordsX, coordsY, nb_pts);
        		else
        			g.drawPolygon(coordsX, coordsY, nb_pts);
    		}
    		if (figure instanceof Circle){
    			int radius = figure.getPointsTab()[0].distance(figure.getPointsTab()[1]);
    			g.setColor(figure.getColour());
    			//check is we need to fill the figure or not
    			if (figure.isFilled())
    				g.drawOval(figure.getPointsTab()[0].getX(), figure.getPointsTab()[0].getY(), radius, radius);
    			else
    				g.fillOval(figure.getPointsTab()[0].getX(), figure.getPointsTab()[0].getY(), radius, radius);
    		}
    	}
	}
}

	