/*
Write a program that prints numbers 1 to n:
- For multiples of 3: print "Fizz"
- For multiples of 5: print "Buzz"  
- For multiples of both: print "FizzBuzz"
- Otherwise: print the number

Example: 1, 2, Fizz, 4, Buzz, Fizz, 7, 8, Fizz, Buzz, 11, Fizz, 13, 14, FizzBuzz
*/

public class FizzBuzz
{
	public static void FizzBuzz(int n)
	{
		for (int i = 1; i <= n; i++)
		{
			if (i % 3 == 0 && i % 5 == 0)
				System.out.println("FizzBuzz");
			else if (i % 3 == 0)
				System.out.println("Fizz");
			else if (i % 5 == 0)
				System.out.println("Buzz");
			else
				System.out.println(i);
		}
	}

	public static void main(String[] args)
	{
		if (args.length != 1)
			System.err.println("enter argument");
		else
		{
			int	n = Integer.parseInt(args[0]);
			FizzBuzz(n);
		}
	}
}
