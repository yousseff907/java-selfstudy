/*
Find any peak element (element greater than its neighbors).
Array may contain multiple peaks, return index of any peak.

Input: [1,2,3,1] → index 2 (element 3 is peak)
*/

public class binarySearch
{
    public static int findPeakElement(int[] nums)
	{
        int	right = nums.length - 1;
		int	left = 0;

		while (left < right)
		{
			int	m = left + (right - left) / 2;

			if (nums[m] > nums[m + 1])
				right = m;
			else
				left = m + 1;
		}

		return (left);
	}

	public static void main(String[] args)
	{
		int[] arr = {1, 5, 0, 1, 0};

		int index = findPeakElement(arr);

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
