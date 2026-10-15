package math;

public class RectPrism
{
	public static Double prismCalc(String len, String width, String height)
	{
		Double cLen = Double.valueOf(len);
		Double cWidth = Double.valueOf(width);
		Double cHeight = Double.valueOf(height);
		
		Double area = 2 * ((cLen * cWidth) + (cHeight * cLen) + (cHeight * cWidth));
		return area;
	}
}
