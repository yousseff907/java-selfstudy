/*
Perform left rotations on an array. Each rotation moves elements one position left.
Elements that go past the leftmost position wrap around to the right.

Input: arr = [1,2,3,4,5], d = 2
Output: [3,4,5,1,2]

Perform d left rotations on the array.
*/

import java.util.Arrays;

public class RotateLeft
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

	public static int[] rotLeft(int[] a, int d)
	{
		int	n = a.length;
		d = d % n;

		reverse(a, 0, d -1);
		reverse(a, d, n - 1);
		reverse(a, 0, n - 1);

		return (a);
	}

	public static void main(String[] args)
	{
		int[] Input = {1,2,3,4,5,6,7};

		rotLeft(Input, 3);

		System.out.println(Arrays.toString(Input));
	}
}
