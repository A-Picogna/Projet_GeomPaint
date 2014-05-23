/**
 * Class Polygon,
 * describes a polygon figure.
 * A Polygon is a kind of GeomShape
 * @author VILAS
 *
 */
public class Polygon extends GeomShape {
	
	/**
	 * No-arg constructor of the class Polygon
	 * crates a default Polygon.
	 */
	public Polygon()
	{
		super();
	}
	
	/**
	 * Constructor of the class Polygon
	 * admitting an array of points as argument.
	 * @param data - array of points constituting the Polygon.
	 */
	public Polygon(Point[]data)
	{
		super();
		this.setNumberPoints(data.length);
		this.setPointsTab(data);
	}
	
    /**
     * Return true if the given point is contained inside the boundary.
     * @param test The point to check
     * @return true if the point is inside the boundary, false otherwise
     *
     */
    public boolean contains(Point test) {
    	int i, j;
    	
    	Point[] points = this.getPointsTab();
    	boolean result = false;
    	for (i = 0, j = this.getNumberPoints() - 1; i < this.getNumberPoints(); j = i++) {
    		if ((points[i].getY() > test.getY()) != (points[j].getY() > test.getY()) &&
    				(test.getX() < (points[j].getX() - points[i].getX()) * (test.getY() - points[i].getY()) / (points[j].getY()-points[i].getY()) + points[i].getX())) {
    			result = !result;
    		}
    	}
      return result;
    }

}
