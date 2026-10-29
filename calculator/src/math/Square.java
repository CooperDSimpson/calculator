package math;

import core.logger.Logger;

public class Square 
{
	public static Double SquareCalc(String len)
	{
		Logger.debug("SquareCalc running...");
		Double convertedLen = Double.valueOf(len);
		Double area = (convertedLen * convertedLen);
		Logger.debug("SquareCalc done.");
		return area;
	}
}
