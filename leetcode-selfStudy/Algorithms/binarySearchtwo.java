/*
Implement binary search on sorted array.
Return index of target, or -1 if not found.

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
*/

public class binarySearchtwo
{
    public static int search(int[] nums, int target)
	{
		int	right = nums.length - 1;
		int	left = 0;

		while (left <= right)
		{
			int	m = left + (right - left) / 2;
			if (nums[m] == target)
				return (m);
			else if (nums[m] < target)
				left = m + 1;
			else if (nums[m] > target)
				right = m - 1;
		}

		return (-1);
	}

	public static void main(String[] args)
	{
		int[] arr = {0, 1, 2, 3, 4, 99, 975};

		int index = search(arr, 99);

		if (index != -1)
		{
			System.out.println("Found at index: " + index);
		}
		else
		{
			System.out.println("Not found");
		}
	}
}