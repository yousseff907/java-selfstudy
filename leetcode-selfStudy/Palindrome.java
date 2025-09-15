/*
Check if a string is a palindrome (reads same forwards and backwards).
Ignore case and non-alphanumeric characters.

Example: "A man, a plan, a canal: Panama" → true
*/

public class Palindrome
{
    public static boolean isPalindrome(String s)
	{
		s = s.toLowerCase();
		s = s.replaceAll("[^a-zA-Z0-9]", "");

		if (s.equals(new StringBuilder(s).reverse().toString()))
		{
			return (true);
		}

		return (false);

    }

	public static void main(String[] args)
	{
		String str = "A man, a plan, a canal: Panama";
		System.out.println(isPalindrome(str));
	}
}
