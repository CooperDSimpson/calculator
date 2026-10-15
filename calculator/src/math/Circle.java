package math;


public class Circle 
{
	public static Double CircleCalc(String radius)
	{
		Double convertedRadius = Double.valueOf(radius);
		Double area =  Math.PI * (convertedRadius * convertedRadius);
		return area;
	}
}
