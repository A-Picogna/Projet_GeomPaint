import java.awt.Color;

/**
 * Describes Geometric Figures.
 * @author VILAS
 *
 */
public class GeomShape {

////////////////////
//   ATTRIBUTES   //
////////////////////

	/**
	 * Array of points describing the figure.
	 */
	private Point[] pointsTab;
	
	/**
	 * Colour of the figure.
	 */
	private Color colour;
	
	/**
	* Attribute set to True if the figure is selected,
	* and to false otherwise.
	*/
	private boolean selected;
	
	/**
	 * Number of points of the figure.
	 */
	private int numberPoints;
	
	
////////////////////
//    METHODS     //
////////////////////

	
	

///////////////////////
//GETTERS & SETTERS //
///////////////////////

	/**
	 * Method getPointsTab()
	 * @return the array of Points constituting the figure.
	 */
	public Point[] getPointsTab() {
		return pointsTab;
	}

	/**
	 * Method getColour()
	 * @return the colour of the calling figure.
	 */
	public Color getColour() {
		return colour;
	}

	/**
	 * Method setColour(Color)
	 * @param colour - coour to be given to the calling figure.
	 */
	public void setColour(Color colour) {
		this.colour = colour;
	}

	/**
	 * Method isSelected()
	 * @return true if the calling figure is selected, false otherwise.
	 */
	public boolean isSelected() {
		return selected;
	}

	/**
	 * Method select()
	 * Sets the selected attribute of the calling figure to true.
	 */
	public void select() {
		this.selected = true;
	}
	
	/**
	 * Method unselect()
	 * Sets the selected attribute of the calling figure to false.
	 */
	public void unselect() {
		this.selected = false;
	}

	/**
	 * Method getNumberPoints()
	 * @return the number of points constituting the figure.
	 */
	public int getNumberPoints()
	{
		return this.numberPoints;
	}
	
	/**
	 * Method setNumberPoints(int)
	 * @param numberPoints - the number of points constituting the figure.
	 */
	public void setNumberPoints(int numberPoints) {
		this.numberPoints = numberPoints;
	}
}
