/*
Merge nums2 into nums1 (nums1 has extra space).
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
*/

import java.util.Arrays;

public class SolutionSix
{
    public static void merge(int[] nums1, int m, int[] nums2, int n)
	{
		int	i = m -1;
		int	j = n - 1;
		int	k = m + n - 1;

		while (i >= 0 && j >= 0)
		{
			if (nums1[i] > nums2[j])
				nums1[k--] = nums1[i--];
			else
				nums1[k--] = nums2[j--];
		}

		while (j >= 0)
		{
			nums1[k--] = nums2[j--];
		}
	}

	public static void main(String[] args)
	{
		int[] nums1 = {1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = {2, 5, 6};
        int n = 3;

		merge(nums1, m, nums2, n);

        System.out.println("Merged array: " + Arrays.toString(nums1));
	}
}