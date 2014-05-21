import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.LinkedList;

import javax.swing.JPanel;

public class VDrawingArea extends JPanel{
	
	/**
	 * Cette classe n'a vocation qu'a afficher les figures
	 * suivant les zones cliqu� et le bouton ou mode selectionn�
	 * on utilise une liste de figure issue de la classe Model
	 * et d'un indice statique qui repr�sente virtuellement la figure en cours
	 * de selection
	 */	
	private LinkedList<Model> figureList;
	private static int index;
	
	/**
	 * Constructeur qui cr� une liste de Modele et d�finie le fond en blanc
	 */	
	public VDrawingArea() {
    	figureList = new LinkedList<Model>();
    	this.setBackground(Color.white);    	
    }

	/**
	 * Getter - retourne la liste de figures
	 * @return
	 */	
	public LinkedList<Model> getfigureList() {
		return figureList;
	}

	/**
	 * Setter - modifie la liste de figure
	 * @param figureList
	 */
	public void setfigureList(LinkedList<Model> figureList) {
		this.figureList = figureList;
	}

	/**
	 * Getter - retourne l'indice actuel
	 * @return
	 */	
	public static int getIndex() {
		return index;
	}

	/**
	 * Setter - modifie l'indice
	 * @return
	 */	
	public static void setIndex(int index) {
		VDrawingArea.index = index;
	}

	/**
	 * fonction qui permet d'ajouter une figure en fin de liste
	 * et on incr�mente l'indice apr�s avoir d�selectionn� la figure en cours
	 * et selectionn� la figure qui vient d'�tre cr�er
	 * @param m
	 */
	public void addFigure(Model m) {
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
	
	/**
	 * on retire la figure de la liste correspondant � la valeur de l'indice
	 * ce qui revient a supprimer la figure
	 * @param mod
	 */
	public void deletefigure(Model mod){
		if(index>=0)  
			this.figureList.remove(index);
		if(index>=1)
			index--;
		if(index>=0 && this.figureList.size()!=0)
			this.figureList.get(index).Select();
		if(this.figureList.size()==0)
			this.index=-1;				
	}
	
	/**
	 * r�cupere la figure (l'objet) pr�sent a la position
	 * donn� par l'indice
	 * @return
	 */
	public Model getFigureSelection(){
		Model res;
		if(index>=0 && this.figureList.size()!=0)
			res = figureList.get(index);
		else
			res = null;
		return res;
	}
	
	/**
	 * on redessine toute la liste de figure
	 * ce qui revient a trac� des lignes entre les points
	 * de chaque figure
	 */
	public void paintComponent(Graphics g) {
    	super.paintComponent(g);
    	for(int i = 0; i< this.figureList.size() ; i++)
    		this.figureList.get(i).display(g);
    }
	
	

}
