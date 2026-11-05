package math;

import core.logger.Logger;

public class Temperature 
{
	public static Double TemperatureCalc(Double input, String fromUnit, String toUnit)
	{
		Double celsius;
		
		if("celsius".equals(fromUnit))
		{
			celsius = input;
		}
		else if("Fahrenheit".equals(fromUnit)) 
		{
            celsius = (input - 32) * 5 / 9;
		}	
		else if("Kelvin".equals(fromUnit))
		{
			celsius = input - 273.15;
		}
		else
		{
			return input;
		}
		
		
		if ("Celsius".equals(toUnit))
		{
            return celsius;
        }
		else if ("Fahrenheit".equals(toUnit))
		{
            return (celsius * 9 / 5) + 32;
        }
		else if ("Kelvin".equals(toUnit))
		{
            return celsius + 273.15;
        }

        return celsius;
	}
}
