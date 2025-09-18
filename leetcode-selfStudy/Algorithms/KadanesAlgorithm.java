/*
Find contiguous subarray with largest sum (Kadane's Algorithm).
Input: [-2,1,-3,4,-1,2,1,-5,4]
Output: 6 (subarray [4,-1,2,1] has sum 6)
*/

public class KadanesAlgorithm
{
    public static int maxSubArray(int[] nums)
	{
		int	currentSum = 0;
		int	maxSum = nums[0];

		for (int i = 0; i < nums.length; i++)
		{
			currentSum = Math.max(nums[i], currentSum + nums[i]);
			if (currentSum >= maxSum)
				maxSum = currentSum;
		}
		return (maxSum);
    }

	public static void main(String[] args)
	{
		int[] nums = {-2,1,-3,4,-1,2,1,-5,4};

		System.out.println(maxSubArray(nums));

		int[] numsOne = {1, 2, 3, 4, 5};

		System.out.println(maxSubArray(numsOne));
	}
}