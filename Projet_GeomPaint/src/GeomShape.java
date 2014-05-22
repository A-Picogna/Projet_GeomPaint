import java.awt.Color;

/**
 * Describes Geometric Figures.
 * @author VILAS
 *
 */
public abstract class GeomShape {

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
	* Attribute set to True if the figure is filled,
	* and to false if it is empty.
	*/
	private boolean filled;
	
	/**
	 * Number of points of the figure.
	 */
	private int numberPoints;
	
	
////////////////////
//    METHODS     //
////////////////////


	public void translate(int dx, int dy)
	{
		for(int i =0; i < this.numberPoints; i++)
		{
			
		}
	}

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
	 * @param colour - colour to be given to the calling figure.
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
	 * Method setFilled(boolean)
	 * Sets the filled attribute of the calling figure as per the value given as parameter.
	 * @param fill - value to be given to the calling figure's attribute filled.
	 */
	public void setFilled(boolean fill){
		this.filled = fill;
	}
	
	/**
	 * Method isFilled()
	 * @return true if the calling figure is filled or false if it is empty.
	 */
	public boolean isFilled(){
		return this.filled;
	}
	
	/**
	 * Method setNumberPoints(int)
	 * @param numberPoints - the number of points constituting the figure.
	 */
	public void setNumberPoints(int numberPoints) {
		this.numberPoints = numberPoints;
	}
}
