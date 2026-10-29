package math;

import core.logger.Logger;

public class Cylinder
{
	public static Double cylinderCalc(String radius, String height)
	{
		Logger.debug("cylinderCalc running...");
		Double cRadius = Double.valueOf(radius);
		Double cHeight = Double.valueOf(height);
		
		Double area = 2 * Math.PI * cRadius * (cRadius + cHeight);
		Logger.debug("cylinderCalc done.");
		return area;
	}
}
