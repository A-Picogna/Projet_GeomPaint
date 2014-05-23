/**
 * Class Circle
 * Describes a Circle.
 * A Circle is a sort of GeomShape.
 * @author VILAS
 *
 */
public class Circle extends GeomShape{
		
	/**
	 * Constructor of the class Circle
	 * admitting an array of 2 points as arguments
	 * @param data - array of two points corresponding to the centre 
	 * and to a point on the circle's border
	 */
	public Circle (Point[]data)
	{
		if (data.length == 2){
			this.setNumberPoints(2);
			this.setPointsTab(data);			
		}
	}
	
	/**
	 * Copy-constructor of the class Circle
	 * @param c - Circle element to be duplicated.
	 */
	public Circle(Circle c)
	{
		this.setPointsTab(c.getPointsTab());
		this.setNumberPoints(c.getPointsTab().length);
	}
	
    /**
     * Return true if the given point is contained inside the calling Circle.
     * @param test - The point to check
     * @return true if the point is inside the boundary, false otherwise
     *
     */
	public boolean contains(Point test)
	{
		Point centre = this.getPointsTab()[0];
		Point edge = this.getPointsTab()[1];
		boolean result = false;
		
		if (centre.distance(test) <= centre.distance(edge))
			result = true;
		return result;
	}

}
