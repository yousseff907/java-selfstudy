/*
Reverse a string in-place.
Input: ['h','e','l','l','o']
Output: ['o','l','l','e','h']
*/

import java.util.Arrays;

public class SolutionOne
{
    public static void reverseString(char[] s)
	{
        int	right = 0;
		int	left = s.length - 1;

		while (right < left)
		{
			char temp = s[left];
			s[left] = s[right];
			s[right] = temp;
			
			right++;
			left--;
		}
    }

	public static void main(String[] args)
	{
		char[] test = {'h', 'e', 'l', 'l', 'o'};

		System.out.println("Before: " + Arrays.toString(test));

		reverseString(test);
		
		System.out.println("After: " + Arrays.toString(test));
	}
}