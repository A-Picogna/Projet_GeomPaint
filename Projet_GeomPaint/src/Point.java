/**
 * Class Point
 * Describes the principal component of any geometric figure.
 * @author VILAS
 */
public class Point {
	/**
	 * Attributes x and y corresponding respectively to
	 * the abscissa and the ordinate of the Point.
	 */
	private int x,y;
	
	/**
	 * Constructor of the class Point 
	 * admitting two integers as arguments, 
	 * corresponding to the following:
	 * @param abs - abscissa value to be given to the created Point.
	 * @param ord - ordinate value to be given to the created Point.
	 */
	public Point(int abs, int ord)
	{
		if(abs >= 0 && ord >= 0)
		{
			this.x = abs;
			this.y = ord;
		}
	}
	
	
}
