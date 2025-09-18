/*
Count how many candles are tallest on a birthday cake.
(Count occurrences of the maximum value)

Input: candles = [4,4,1,3]
Output: 2 (two candles have height 4, which is the maximum)
*/

public class BirthdayCakeCandles
{
    public static int birthdayCakeCandles(int[] candles)
	{
		int	Count = 1;
		int	maximum = candles[0];
		int	i = 1;

		while (i < candles.length)
		{
			if (candles[i] > maximum)
			{
				maximum = candles[i];
				Count = 1;
			}
			else if (candles[i] == maximum)
				Count++;
			i++;
		}

		return (Count);
    }

	public static void main(String[] args)
	{
		int[] candles1 = {4, 4, 1, 3};
		int result1 = birthdayCakeCandles(candles1);
		System.out.println("Test 1: [4,4,1,3] → " + result1 + " (Expected: 2)");

		int[] candles2 = {5, 5, 5, 5};
		int result2 = birthdayCakeCandles(candles2);
		System.out.println("Test 2: [5,5,5,5] → " + result2 + " (Expected: 4)");

		int[] candles3 = {1, 2, 3, 4, 5};
		int result3 = birthdayCakeCandles(candles3);
		System.out.println("Test 3: [1,2,3,4,5] → " + result3 + " (Expected: 1)");

		int[] candles4 = {10};
		int result4 = birthdayCakeCandles(candles4);
		System.out.println("Test 4: [10] → " + result4 + " (Expected: 1)");

		int[] candles5 = {3, 7, 2, 7, 1, 7};
		int result5 = birthdayCakeCandles(candles5);
		System.out.println("Test 5: [3,7,2,7,1,7] → " + result5 + " (Expected: 3)");
	}
}