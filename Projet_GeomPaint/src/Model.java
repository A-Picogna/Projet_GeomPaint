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
	 * Attribute corresponding to the .
	 */
	private char mode;
	
	// CONSTRUCTOR
	
	
	/**
	 * No-Arg constructor of the class Model
	 * initiates a new LinkedList.
	 */
	public Model() {
    	figureList = new LinkedList<GeomShape>();   	
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


}
