package math;

import java.util.Map;

import core.logger.Logger;

public class Currency 
{
	private static final Map<String, Double> DOLLAR_FACTORS = Map.of(
			"Dollars", 1.0,
			"Canadian Dollar", 0.8,
			"Euro", 1.10);
		
	public static Double CurrencyCalc(String inputSelection, String inputVal, String outputSelection)
	{
		Logger.debug("CurrencyCalc running...");
		Double amount = Double.valueOf(inputVal);
		Double inputFactor = DOLLAR_FACTORS.get(inputSelection);
		Double outputFactor = DOLLAR_FACTORS.get(outputSelection);
		
		Double converted = (amount * inputFactor) / outputFactor;
		Logger.debug("CurrencyCalc done.");
		return converted;
	}
}
