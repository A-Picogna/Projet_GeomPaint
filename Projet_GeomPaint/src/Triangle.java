import java.util.LinkedList;

/**
 * Class Triangle,
 * describes a triangular figure.
 * A Triangle is a kind of Polygon.
 * @author VILAS
 *
 */
public class Triangle extends Polygon {

	/**
	 * Constructor of the class Triangle
	 * admitting an array of 3 points as argument.
	 */
	public Triangle(LinkedList<Point> data)
	{
		super();
		this.setNumberPoints(data.size());
		for(int i = 0; i< data.size(); i++)
		{
			this.getPointsTab()[i] = data.get(i);	
		}
	}
	
	/**
	 * Copy-constructor of the class Triangle
	 * @param t - Triangle element to be duplicated.
	 */
	public Triangle(Triangle t)
	{
		super();
		this.setNumberPoints(t.getPointsTab().length);
		this.setPointsTab(t.getPointsTab());
	}

}
