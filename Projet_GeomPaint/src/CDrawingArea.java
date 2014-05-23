import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.SwingUtilities;


public class CDrawingArea implements MouseListener, MouseMotionListener {
	
	//ATTRIBUTES
	private Model model;
	private int x,  y, point;
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
					figure = this.model.getSelected();
			    	figure.translate(x, y);
			    		
				

				}
			
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		x = e.getX();
		y = e.getY();
		p = new Point(x, y);
		Point[] tabPoint;
		//recuperation points dessin de figure
		if(SwingUtilities.isLeftMouseButton(e) && (model.getMode()!='n')){
														
			
			int nbPointsRequired;
			if(this.model.getMode()=='r'){
				nbPointsRequired = 2;
				tabPoint = new Point[2];
			}
			if(this.model.getMode()=='t'){
				nbPointsRequired = 3;
				tabPoint = new Point[3];
			}
			if(this.model.getMode()=='p'){
				int n = model.getCounter();
				nbPointsRequired = n;
				tabPoint = new Point[n];
			}
			if(this.model.getMode()=='c'){
				nbPointsRequired = 2;
				tabPoint = new Point[2];
			}
			for(int i = 0; i<nbPointsRequired; i++){
				tabPoint[i] = p;
				
				
			}
			this.model.setMode('n');
		}
		
		
		//selection de figure
		if(SwingUtilities.isLeftMouseButton(e) && model.getFigureList().size() > 0 && model.getMode()=='n' ){
			
			
			for (int i =0; i<this.model.getFigureList().size(); i++){
				//si la figure sur laquel on clic n'est pas selectionée on change son état
				if(this.model.getFigureList().get(i).contains(p) && !this.model.getFigureList().get(i).isSelected()){
					this.model.getSelected().unselect();
					this.model.getFigureList().get(i).select();
				}
				//si on clic en dehors de la figure selectionée on deselctionne la figure qui etait selectionée 
				if(!this.model.getFigureList().get(i).contains(p) && this.model.getFigureList().get(i).isSelected()){
					this.model.getFigureList().get(i).unselect();
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
		Point closest = null;
		int res = 0;
		for(int i =0; i<this.model.getSelected().getNumberPoints(); i++){
			if(this.model.getSelected().getPointsTab()[i].distance(p)<res)
				closest = this.model.getSelected().getPointsTab()[i];
		}
		
		return closest;
		
	}

}
