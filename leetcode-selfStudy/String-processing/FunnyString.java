/*
A string is "funny" if for every index i, the absolute difference between 
ASCII values of characters at positions i and i+1 in the string is equal to 
the absolute difference between ASCII values at positions (n-1-i) and (n-i) 
where n is the length of the string.

Input: "acxz" 
- |a-c| = 2, |c-x| = 21, |x-z| = 2
- |z-x| = 2, |x-c| = 21, |c-a| = 2
Output: "Funny" (because 2==2, 21==21, 2==2)

Input: "bcxz"
Output: "Not Funny"
*/

public class FunnyString
{
	public static String funnyString(String s)
	{
		int	n = s.length();

		for(int i = 0; i < n - 1; i++)
		{
			int	rightWay = Math.abs(s.charAt(i) - Math.abs(s.charAt(i + 1)));
			int	leftWay = Math.abs(s.charAt(n - i - 1) - Math.abs(s.charAt(n - i - 2)));
			if (rightWay != leftWay)
				return ("Not Funny");
		}
		
		return ("Funny");
	}

	public static void main(String[] args)
	{
		System.out.println("\nQuick tests:");
		System.out.println("\"a\" → " + funnyString("a"));
		System.out.println("\"ab\" → " + funnyString("ab"));
		System.out.println("\"abcd\" → " + funnyString("abcd"));
		System.out.println(funnyString("bcxz"));
	}
}
