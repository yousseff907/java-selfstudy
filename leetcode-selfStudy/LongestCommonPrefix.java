/*
Write a function to find the longest common prefix string amongst an array of strings.
If there is no common prefix, return an empty string "".

Input: strs = ["flower","flow","flight"]
Output: "fl"

Input: strs = ["dog","racecar","car"]
Output: ""
*/

public class LongestCommonPrefix
{
	public static String longestCommonPrefix(String[] strs)
	{
		String	prefix = strs[0];

		if (strs == null || strs.length == 0)
			return ("");

		for (int i = 1; i < strs.length; i++)
		{
			while (strs[i].indexOf(prefix) != 0)
			{
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.equals(""))
					return ("");
			}
		}
		
		return (prefix);
	}

	public static void main(String[] args)
	{
		String[] test1 = {"flower", "flow", "flight"};
		System.out.println("Test: " + longestCommonPrefix(test1));

		String[] test2 = {"dog", "racecar", "car"};
		System.out.println("Test: " + longestCommonPrefix(test2));

		String[] test3 = {"hello"};
		System.out.println("Test: " + longestCommonPrefix(test3));
	}
}
