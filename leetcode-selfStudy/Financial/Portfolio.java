/*
Calculate total portfolio value and individual position values.
Given holdings (symbol -> quantity) and current market prices.
*/

import java.util.HashMap;
import java.util.Map;

public class Portfolio
{
	public double calculateTotalValue(Map<String, Integer> holdings, Map<String, Double> currentPrices)
	{
		double finalVal = 0.0;

        for(String type : holdings.keySet())
		{
			if (currentPrices.containsKey(type))
			{
				finalVal += holdings.get(type) * currentPrices.get(type);
			}
		}
		return (finalVal);
	}
    
	public Map<String, Double> calculatePositionValues(Map<String, Integer> holdings, Map<String, Double> currentPrices)
	{
		HashMap<String, Double> map = new HashMap<>();

        for (String type : holdings.keySet())
		{
			if (currentPrices.containsKey(type))
			{
				map.put(type, currentPrices.get(type) * holdings.get(type));
			}
		}

		return (map);
	}
}