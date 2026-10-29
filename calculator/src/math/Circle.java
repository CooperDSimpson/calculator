package math;

import core.logger.Logger;

public class Circle 
{
	public static String CircleCalc(Double radius)
	{
		Logger.debug("CircleCalc running...");
		String area =  Double.toString(Math.PI * (radius * radius));
		Logger.debug("CircleCalc done.");
		return area;
	}
}
