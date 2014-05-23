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
	 * initiates a new LinkedList and sets the mode to neutral.
	 */
	public Model() {
    	this.figureList = new LinkedList<GeomShape>();
    	this.mode = 'n';
    }
	
	// METHODS
	

	/**
	 * Method addShape(GeomShape)
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
	 * @param index - index of the figure to be deleted.
	 */
	public void delFigure(int index){
		// 	GeomShape deleted = this.figureList.get(index);
		this.figureList.remove(index);
		/*
		 * This section prepares for an eventual array that would contain all deleted figures
		 * in case the user would need to retrieve them afterwards.
		 * It would require adding another attribute :
		 * LinkedList<GeomShape> figureDeleted
		 * */
		/*
		 * this.figureDeleted.add(deleted);
		 */
	}
	

	
	
	//GETTER & SETTER
	
	public LinkedList<GeomShape> getFigureList() {
		return figureList;
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
	
	/**
	 * Method indicating whether the user is in a Rectangle creation mode.
	 * @return true if the user is in a Rectangle creation mode.
	 */
	public boolean isRectangleDrawing()
	{
		return this.mode == 'r';
	}
	
	/**
	 * Method indicating whether the user is in a Triangle creation mode.
	 * @return true if the user is in a Triangle creation mode.
	 */
	public boolean isTriangleDrawing()
	{
		return this.mode == 't';
	}
	
	/**
	 * Method indicating whether the user is in a Circle creation mode.
	 * @return true if the user is in a Circle creation mode.
	 */
	public boolean isCircleDrawing()
	{
		return this.mode == 'c';
	}
	
	/**
	 * Method indicating whether the user is in a Polygon creation mode.
	 * @return true if the user is in a Polygon creation mode.
	 */
	public boolean isPolygonDrawing()
	{
		return this.mode == 'p';
	}

	/**
	 * Method indicating whether the mode the model is in.
	 * @return the mode the model is in.
	 */
	public char getMode()
	{
		return this.mode;
	}
	
	/**
	 * Method to change the mode of the model
	 * @param mode - mode to set the model to	 
	 */
	public void setMode(char mode)
	{
		switch (mode){
			case 'r' : this.mode = 'r';
			case 't' : this.mode = 't';
			case 'c' : this.mode = 'c';
			case 'f' : this.mode = 'f';
			case 'n' : this.mode = 'n';	
		}
	}
}
