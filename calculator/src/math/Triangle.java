package math;

public class Triangle
{
	public static Double TriangleCalc(String base, String height)
	{
		Double convertedBase = Double.valueOf(base);
		Double convertedHeight = Double.valueOf(height);
		
		Double area = 0.5 * convertedBase * convertedHeight;
		return area;
	}
}