import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.LinkedList;

import javax.swing.SwingUtilities;


public class CDrawingArea implements MouseListener, MouseMotionListener {
	
	//ATTRIBUTES
	private Model model;
	private int index;
	private int x, lastx, y, lasty, point;
	private boolean inside;
	private Point p;

	
	public void mouseDragged(MouseEvent e) {
		if(SwingUtilities.isLeftMouseButton(e) && model.getFigureList().size() > 0 ){
			x = e.getX();
			y = e.getY();
			p = new Point(x, y);
			
			if(this.model.getFigureList().size() != 0){
				//modifier la figure
				if(this.model.getFigureList.get(index).isSelected() && this.getClosestPoint(p).isNearTo(p)){
					this.getClosestPoint(p).translate(x, y);
				}
				
				//deplacer la figure
				if(model.getFigureList().get(index).isSelected()/* && souris dans la figure*/){
					
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
		if(SwingUtilities.isLeftMouseButton(e) && model.getFigureListe().size() > 0 ){
			if(this.model.getfigureList())
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
	
	public Point getClosestPoint(Point p){
		Point closest;
		int res = 0;
		for(int i =0; i<this.model.getFigureList().getSelected().getNumberPoints(); i++){
			if(this.model.getFigureList().getSelected().getPointsTab()[i].distance(p)<res)
				closest = this.model.getFigureList().getSelected().getPointsTab()[i];
		}
		
		return closest;
		
	}

}
