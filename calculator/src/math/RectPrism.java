package math;
import core.logger.Logger;
public class RectPrism
{
	public static String prismCalc(Double len, Double width, Double height)
	{
		Logger.debug("prismCalc running...");

		String area = Double.toString(2 * ((len * width) + (height * len) + (height * width)));
		Logger.debug("prismCalc done.");
		return area;
	}
}
