/*
Remove all instances of val from array in-place. Return new length.
Input: nums = [3,2,2,3], val = 3
Output: 2, nums = [2,2,_,_]
*/

import java.util.Arrays;

public class SolutionFour
{
    public static int removeElement(int[] nums, int val)
	{
		int	j = 0;

		for (int i = 0; i < nums.length; i++)
		{
			if (nums[i] != val)
			{
				nums[j] = nums[i];
				j++;
			}
		}
		return (j);
    }

	public static void main(String[] args)
	{
		int[] nums = {1, 5, 88, 9, 9, 0, 7, 2, 1, 8686};
		int	new_length = removeElement(nums, 2);
		System.out.println(Arrays.toString(nums) + "\n" + new_length);
	}
}