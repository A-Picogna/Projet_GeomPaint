import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.SwingUtilities;


public class CDrawingArea implements MouseListener, MouseMotionListener {
	
	//ATTRIBUTES
	private Model model;
	private int x, y, last_x, last_y, point;
	private Point p;
	private LinkedList<Point> data;

	
	public void mouseDragged(MouseEvent e) {
		
		if(SwingUtilities.isLeftMouseButton(e) && model.getFigureList().size() > 0 ){
			x = e.getX();
			y = e.getY();
			p = new Point(x, y);
			
				//modifier la figure

				if(this.getClosestPoint(p).isNearTo(p)){
					this.getClosestPoint(p).setX(x);
					this.getClosestPoint(p).setY(y);
				}
				
				//deplacer la figure

				if(this.model.getSelected().contains(p)){
					GeomShape figure = this.model.getSelected();
			    	figure.translate(x - last_x,y - last_y);
			    	last_x = x;
			    	last_y = y;
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
		
		//recuperation points dessin de figure
		if(SwingUtilities.isLeftMouseButton(e) && (model.getMode()!='n')){
														
			int nbPoints = model.getNbPointsRequired();
			if(nbPoints > 0){
				data.add(p);
				model.setNbPointsRequired(nbPoints -1);
				if(model.getNbPointsRequired()==0){
					
					switch(model.getMode()){
					case 'r':
						model.getFigureList().add(new Rectangle(data));
						break;
					case 't':
						model.getFigureList().add(new Triangle(data));
						break;
					case 'c':
						model.getFigureList().add(new Circle(data));
						break;
					/*case 'p':
					  model.getFigureList().add(new Polygon(data);
					  */
					}
				}
					
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
	 * Method getClosestPoint
	 * It returns the closest figure point to the mouse  
	 * @param p point which represents the position of the mouse
	 * @return closest, point closest to the mouse 
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
