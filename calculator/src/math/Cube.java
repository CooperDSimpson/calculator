package math;

import core.logger.Logger;

public class Cube 
{
	public static String cubeCalc(Double len)
	{
		Logger.debug("cubeCalc running...");
		String area = Double.toString(len * len * 6);
		Logger.debug("cubeCalc done.");
		return area;
	}
}
