package math;

import core.logger.Logger;

public class Triangle
{
	public static Double TriangleCalc(String base, String height)
	{
		Logger.debug("TriangleCalc running...");
		Double convertedBase = Double.valueOf(base);
		Double convertedHeight = Double.valueOf(height);
		
		Double area = 0.5 * convertedBase * convertedHeight;
		Logger.debug("TriangleCalc done.");
		return area;
	}
}