package math;

public class Square 
{
	public static Double SquareCalc(String len)
	{
		Double convertedLen = Double.valueOf(len);
		Double area = (convertedLen * convertedLen);
		return area;
	}
}
