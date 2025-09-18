import java.util.*;

/*
Check if string has valid parentheses: (), [], {}
Input: "()[]{}" → true
Input: "([)]" → false
*/

public class validParenth
{
    public static boolean isValid(String s)
	{
		Stack<Character> stack = new Stack<>();

		for(char c : s.toCharArray())
		{
			if (c == '(')
				stack.push(')');
			else if (c == '[')
				stack.push(']');
			else if (c == '{')
				stack.push('}');
			else
			{
				if (stack.isEmpty() || stack.pop() != c)
					return (false);
			}
		}
		return (stack.isEmpty());
	}

	public static void main(String[] args)
	{
		String s = "[{()}]";
		String b = "[{]}";
		String a = "()[]{}";

		System.out.println(isValid(s));
		System.out.println(isValid(b));
		System.out.println(isValid(a));
	}
}
