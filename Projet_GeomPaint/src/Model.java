import java.awt.Color;
import java.util.LinkedList;
import java.util.Observable;


public class Model extends Observable{
	
	// ATTRIBUTE
	/**
	 * LinkedList containing all the created figures.
	 */
	private LinkedList<GeomShape> figureList;
	
	/**
	 * Attribute corresponding to the mode the user is in.
	 * 'c' - Creation of a Circle 
	 * 'r' - Creation of a Rectangle
	 * 't' - Creation of a Triangle
	 * 'p' - Creation of a Polygon
	 * 'n' - Neutral - by default
	 */
	private char mode;
	
	// CONSTRUCTOR
	
	
	/**
	 * No-Arg constructor of the class Model
	 * initiates a new LinkedList.
	 */
	public Model() {
    	this.figureList = new LinkedList<GeomShape>();
    	this.mode = 'n';
    }
	
	// METHODS
	

	/**
	 * Method addFigure(GeomShape)
	 * adds a figure to the figureList attribute.
	 * @param f - figure to be added to the figureList.
	 */
	public void addFigure(GeomShape f) {
		if (figureList.isEmpty()){
			figureList.add(f);
			figureList.get(figureList.size() - 1).select();
		}
		else{
			this.unselectAll();
			figureList.add(f);
			figureList.get(figureList.size() - 1).select();
		}
	}
	
	
	/**
	 * Method unselectAll()
	 * Goes through the figureList and unselects all the figures.
	 */
	public void unselectAll(){
		for(int i=0 ; i < figureList.size() ; i++)
			this.figureList.get(i).unselect();		
	}
	
	/**
	 * Method deleteFigure()
	 * @param mod
	 */
	public void deleteFigure(Model mod){
					
	}
	
	
	//GETTER & SETTER
	
	public LinkedList<GeomShape> getFigureList() {
		return figureList;
	}
	
	public void setfigureList(LinkedList<GeomShape> figureList) {
		this.figureList = figureList;
	}

	// Getter and Setter 
	public boolean isDrawing() {
		return modeDrawing;
	}

	public void setDrawing(boolean modeDrawing) {
		this.modeDrawing = modeDrawing;
	}

	public boolean isHandling() {
		return modeHandling;
	}

	public void setHandling(boolean modeHandling) {
		this.modeHandling = modeHandling;
	}

	public void setFigureList(LinkedList<GeomShape> figureList) {
		this.figureList = figureList;
	}
	
	/**
	 * Method getSelected
	 * Return the figure selected
	 * @return sel 
	 */
	public GeomShape getSelected(){
		GeomShape sel = null;
		for (int i=0; i<this.getFigureList().size()-1; i++){
			if(this.getFigureList().get(i).isSelected())
				sel = this.getFigureList().get(i);
		}
		return sel;
		
	}
}
