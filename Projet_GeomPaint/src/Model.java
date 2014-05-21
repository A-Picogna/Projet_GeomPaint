import java.awt.Color;
import java.util.LinkedList;


public class Model {
	
	// ATTRIBUTE
	
	private LinkedList<GeomShape> figureList;
	
	// CONSTRUCTOR
	
	public Model() {
    	figureList = new LinkedList<Model>();   	
    }
	
	// METHODS
	
	public LinkedList<Model> getfigureList() {
		return figureList;
	}

	public void addFigure(Model m) {
		if (figureList.isEmpty()){
			figureList.add(m);
			figureList.get(figureList.size() - 1).select();
		}
		else{
			this.unSelectAll();
			figureList.add(m);
			figureList.get(figureList.size() - 1).select();
		}
	}
	
	public void unSelectAll(){
		for(int i=0 ; i < figureList.size() ; i++;)
			this.figureList.get(i).unSelect();		
	}
	
	public void deletefigure(Model mod){
					
	}
	
	
	//GETTER & SETTER
	
	public void setfigureList(LinkedList<Model> figureList) {
		this.figureList = figureList;
	}

	
	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		VDrawingArea.index = index;
	}
}
