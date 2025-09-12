/*
Merge nums2 into nums1 (nums1 has extra space).
Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
Output: [1,2,2,3,5,6]
*/

public class SolutionSix
{
    public void merge(int[] nums1, int m, int[] nums2, int n)
	{
		int	i = 0;

		while (i < nums1.length)
		{
			if (nums1[i + 1] <= nums2[i] && nums1[i] >= nums2[i])
			{
				int	temp = nums1[i + 1];
				nums1[i+1] = nums2[i];
				nums1[m] = temp;
				i++;
			}
			i++;
			
		}
	}
}