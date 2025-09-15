
import java.util.Arrays;



/*
Rotate array to right by k steps in-place.
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
*/

public class SolutionSixteen
{
	private static void reverse(int[] nums, int start, int end)
	{
		while (start < end)
		{
			int temp = nums[end];
			nums[end] = nums[start];
			nums[start] = temp;
			start++;
			end--;
		}
	}

    public static void rotate(int[] nums, int k)
	{
		int	n = nums.length;
		k = k % n;

		reverse(nums, 0, n - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, n - 1);
	}

	public static void main(String[] args)
	{
		int[] Input = {1,2,3,4,5,6,7};

		rotate(Input, 3);

		System.out.println(Arrays.toString(Input));
	}
}