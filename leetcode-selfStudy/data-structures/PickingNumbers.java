/*
Given an array of integers, find the longest subarray where the absolute 
difference between any two elements is at most 1.

Input: arr = [4,6,5,3,3,1]
Output: 3 (subarray [4,3,3] or [3,3] - but [3,3,3] would be length 3)

Actually: [3,3] has length 2, but we can pick [5,6] or [3,4] etc.
The longest valid subarray is of length 3: we can pick three 3's if they existed,
or pick 3,3,4 etc.
*/

import java.util.*;

public class PickingNumbers
{
    public int pickingNumbers(int[] a)
	{
		Map<Integer, Integer> map = new HashMap<>();

		for (int n : a)
		{
			map.put(n, map.getOrDefault(n, 0) + 1);
		}

		int maxLen = 0;

		for (int num : map.keySet())
		{
			int count = map.get(num);
			int	countPlusOne = map.getOrDefault(num + 1, 0);
			maxLen = Math.max(maxLen, count + countPlusOne);
		}

		return (maxLen);
    }
}