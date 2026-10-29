package math;
import core.logger.Logger;
public class RectPrism
{
	public static Double prismCalc(String len, String width, String height)
	{
		Logger.debug("prismCalc running...");
		Double cLen = Double.valueOf(len);
		Double cWidth = Double.valueOf(width);
		Double cHeight = Double.valueOf(height);
		
		Double area = 2 * ((cLen * cWidth) + (cHeight * cLen) + (cHeight * cWidth));
		Logger.debug("prismCalc done.");
		return area;
	}
}
