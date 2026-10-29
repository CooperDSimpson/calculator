package math;

import core.logger.Logger;

public class Cube 
{
	public static Double cubeCalc(String len)
	{
		Logger.debug("cubeCalc running...");
		Double convertedLen = Double.valueOf(len);
		Double area = Math.pow(convertedLen, 6);
		Logger.debug("cubeCalc done.");
		return area;
	}
}
