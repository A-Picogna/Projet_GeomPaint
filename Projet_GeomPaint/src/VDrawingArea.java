import java.awt.Color;
import java.util.LinkedList;

import javax.swing.JPanel;


public class VDrawingArea extends JPanel{
	
	private LinkedList<Model> figureList;
	private static int index;
	
	public VDrawingArea() {
    	figureList= new LinkedList<Model>();
    	index = -1;	
    	this.setBackground(Color.white);    	
    }

	public LinkedList<Model> getfigureList() {
		return figureList;
	}

	public void setfigureList(LinkedList<Model> figureList) {
		this.figureList = figureList;
	}

	public static int getIndex() {
		return index;
	}

	public static void setIndex(int index) {
		VDrawingArea.index = index;
	}

	public void addFigure(Model m,Color c) {
		figureList.add(m);
		if(index==-1){
			index++;
		}else{
			if(index>=1){
				figureList.get(index).unSelect();
				index++;
			}else{
				index++;
			}
		figureList.get(index).Select();
		}
	}
	
	public void deletefigure(Model mod){
		if(index>=0)  
			this.figureList.remove(index);
		if(index>=1)
			index--;
		if(index>=0 && this.figureList.size()!=0)
			this.figureList.get(index).select();
		if(this.figureList.size()==0)
			this.index=-1;				
	}

}