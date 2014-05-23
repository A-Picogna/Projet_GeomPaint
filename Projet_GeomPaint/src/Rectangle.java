/**
 * Class Rectangle,
 * describes a rectangular figure.
 * A Rectangle is a kind of Polygon.
 * @author VILAS
 *
 */
public class Rectangle extends Polygon{
	
	/**
	 * Constructor of the class Polygon
	 * admitting 2 points as arguments.
	 * @param a - point constituting the top left corner of the Rectangle.
	 * @param c - point constituting the bottom right corner of the Rectangle.
	 */
	public Rectangle(Point a, Point c)
	{
		super();
		int xa = a.getX();
		int ya = a.getY();
		int xc = c.getX();
		int yc = c.getY();
		// Creation of an array of points corresponding to the coordinates of the rectangle's angles
		// from the top left corner to the bottom left corner, clockwise.
		Point[]data= {new Point(xa,ya), new Point(xc,yc), new Point(xc,yc), new Point(xa,yc)};
		
		this.setNumberPoints(data.length);
		this.setPointsTab(data);
	}
	
	/**
	 * Copy-constructor of the class Rectangle
	 * @param r - Rectangle element to be duplicated.
	 */
	public Rectangle(Rectangle r)
	{
		super();
		this.setNumberPoints(r.getPointsTab().length);
		this.setPointsTab(r.getPointsTab());
	}

}
