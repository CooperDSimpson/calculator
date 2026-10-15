package math;

public class Cylinder
{
	public static Double cylinderCalc(String radius, String height)
	{
		Double cRadius = Double.valueOf(radius);
		Double cHeight = Double.valueOf(height);
		
		Double area = 2 * Math.PI * cRadius * (cRadius + cHeight);
		return area;
	}
}
