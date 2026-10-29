package math;

import core.logger.Logger;

public class Cylinder
{
	public static String cylinderCalc(Double radius, Double height)
	{
		Logger.debug("cylinderCalc running...");
		String area = Double.toString(2 * Math.PI * radius * (radius + height));
		Logger.debug("cylinderCalc done.");
		return area;
	}
}
