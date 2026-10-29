package math;

import core.logger.Logger;

public class Triangle
{
	public static String TriangleCalc(Double base, Double height)
	{
		Logger.debug("TriangleCalc running...");
		
		String area = Double.toString(0.5 * base * height);
		Logger.debug("TriangleCalc done.");
		return area;
	}
}