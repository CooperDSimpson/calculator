package math;

import core.logger.Logger;

public class Circle 
{
	public static Double CircleCalc(String radius)
	{
		Logger.debug("CircleCalc running...");
		Double convertedRadius = Double.valueOf(radius);
		Double area =  Math.PI * (convertedRadius * convertedRadius);
		Logger.debug("CircleCalc done.");
		return area;
	}
}
