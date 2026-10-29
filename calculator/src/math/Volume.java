package math;

import java.util.Map;

import core.logger.Logger;

public class Volume 
{
	private static final Map<String, Double> LITER_FACTORS = Map.of(
		"Liters", 1.0,
		"Gallons", 3.78541,
		"Pints", 2.11338
		);
			
	public static Double volumeCalc(String inputSelection, String inputVal, String outputSelection)
	{
		Logger.debug("volumeCalc running...");
		Double amount = Double.valueOf(inputVal);
		Double inputFactor = LITER_FACTORS.get(inputSelection);
		Double outputFactor = LITER_FACTORS.get(outputSelection);
		
		Double converted = amount * inputFactor / outputFactor;
		Logger.debug("volumeCalc done.");
		return converted;
	
	}
}
