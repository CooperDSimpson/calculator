package math;

import core.logger.Logger;

public class Square 
{
	public static String SquareCalc(Double len)
	{
		Logger.debug("SquareCalc running...");
		String area = Double.toString(len * len);
		Logger.debug("SquareCalc done.");
		return area;
	}
}
