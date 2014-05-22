/**
 * Class Circle
 * Describes a Circle.
 * A Circle is a sort of GeomShape.
 * @author VILAS
 *
 */
public class Circle extends GeomShape{
		
	
	public Circle (Point[]data)
	{
		this.setNumberPoints(2);
		this.setPointsTab(data);
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
