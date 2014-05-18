import java.awt.Color;
import java.util.LinkedList;


public class VDrawingArea extends JPanel{
	
	private LinkedList<Model> dessin;
	private static int index;
	
	public VDrawingArea() {
    	dessin= new LinkedList<Model>();
    	index = -1;	
    	this.setBackground(Color.white);    	
    }

	public LinkedList<Model> getDessin() {
		return dessin;
	}

	public void setDessin(LinkedList<Model> dessin) {
		this.dessin = dessin;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		VDrawingArea.index = index;
	}



}
