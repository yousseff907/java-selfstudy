/*
Determine if an integer is a palindrome WITHOUT converting to string.
Negative numbers are not palindromes.

Input: x = 121
Output: true

Input: x = -121  
Output: false

Input: x = 10
Output: false
*/

public class integerPalindrome
{
    public static boolean isPalindrome(int x)
	{
		int	newnumb = 0;

		if (x < 0)
			return (false);
		
		int	original = x;

		while (x != 0)
		{
			newnumb = newnumb * 10 + (x % 10);
			x = x / 10;
		}

		return (newnumb == original);
    }

	public static void main(String[] args)
	{
		System.out.println(isPalindrome(121));   // true
		System.out.println(isPalindrome(-121));  // false
		System.out.println(isPalindrome(10));    // false
		System.out.println(isPalindrome(12321)); // true
		System.out.println(isPalindrome(0));     // true
	}
}