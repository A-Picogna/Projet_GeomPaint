import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.SwingUtilities;


public class CDrawingArea implements MouseListener, MouseMotionListener {
	
	//ATTRIBUTES
	private Model model;
	private int x, lastx, y, lasty, point;
	private Point p;

	
	public void mouseDragged(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e) && model.getFigureList().size() > 0 ){
			x = e.getX();
			y = e.getY();
			p = new Point(x, y);
			
			if(this.model.getFigureList().size() != 0){
				//modifier la figure

				if( this.getClosestPoint(p).isNearTo(p)){

					this.getClosestPoint(p).translate(x, y);
				}
				
				//deplacer la figure

				if(this.model.getSelected().contains(p)){
					GeomShape figure;
					int nbPoints;
					figure = this.model.getSelected();
			    		nbPoints = figure.getNumberPoints();
			    		for (int j = 0 ; j < nbPoints-1 ; j++){
			    			figure.getPointsTab()[j].translate(x, y);
			    		}
				

				}
			lastx = e.getX();
			lasty = e.getY();
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e) && model.getFigureList().size() > 0 ){
			x = e.getX();
			y = e.getY();
			p = new Point(x, y);
			
			for (int i =0; i<this.model.getFigureList().size()-1; i++){
				//si la figure sur laquel on clic n'est pas selectionée on change son état
				if(this.model.getFigureList().get(i).contains(p) && !this.model.getFigureList().get(i).isSelected()){
					this.model.getFigureList().get(i).select();
				}
			}
		}
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * Methode qui renvoie le point plus proche a la souris
	 * @param p point qui represente la position de la souris
	 * @return closest point plus proche a la souris
	 */
	public Point getClosestPoint(Point p){
		Point closest;
		int res = 0;
		for(int i =0; i<this.model.getSelected().getNumberPoints(); i++){
			if(this.model.getSelected().getPointsTab()[i].distance(p)<res)
				closest = this.model.getSelected().getPointsTab()[i];
		}
		
		return closest;
		
	}

}
