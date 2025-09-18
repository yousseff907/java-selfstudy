/*
Given array of integers and target, return indices of two numbers that add up to target.
Input: nums = [2,7,11,15], target = 9
Output: [0,1] (because nums[0] + nums[1] = 9)
*/

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum
{
    public static int[] twoSum(int[] nums, int target)
	{
		int	i = 0;
		HashMap<Integer, Integer> map = new HashMap<>();

		while (i < nums.length)
		{
			int	remaining = target - nums[i];
			if (map.containsKey(remaining))
				return (new int[]{map.get(remaining), i});
			map.put(nums[i], i);
			i++;
		}
		return (null);
	}

	public static void main(String[] args)
	{
		int[] nums = {1, 2, 4, 99, 100, 0};
		int target = 100;

		System.out.println(Arrays.toString(twoSum(nums, target)));
	}
}
