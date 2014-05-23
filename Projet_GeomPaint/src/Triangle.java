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
	public Triangle(Point[]data)
	{
		super();
		this.setNumberPoints(data.length);
		this.setPointsTab(data);
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
