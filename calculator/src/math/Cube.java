package math;

public class Cube 
{
	public static Double cubeCalc(String len)
	{
		Double convertedLen = Double.valueOf(len);
		Double area = Math.pow(convertedLen, 6);
		return area;
	}
}
