/*
A password is strong if it has:
- At least 6 characters
- At least one digit
- At least one lowercase letter
- At least one uppercase letter
- At least one special character (!@#$%^&*()-+)

Return minimum characters needed to make it strong.
*/

public class Solution
{
    public static	int strongPasswordChecker(String password)
	{
		int	lowercase = 0;
		int	uppercase = 0;
		int	digit = 0;
		int	special = 0;
		int	i;
		int	count = 0;

        for (i = 0; i < password.length(); i++)
		{
			char c = password.charAt(i);

			if (Character.isUpperCase(c))
			{
				uppercase = 1;
			}

			if (Character.isLowerCase(c))
			{
				lowercase = 1;
			}

			if (Character.isDigit(c))
			{
				digit = 1;
			}

			if ("!@#$%^&*()-+".indexOf(c) != -1)
			{
				special = 1;
			}
		}

		if (uppercase == 0)
			count++;
		if (lowercase == 0)
			count++;
		if (special == 0)
			count++;
		if (digit == 0)
			count++;

		if (i < 6)
		{
			return (Math.max(6 - i, count));
		}

		else
			return(count);

    }

	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.err.println("enter argument");
			return;
		}

		System.out.println(strongPasswordChecker(args[0]));
	}
}