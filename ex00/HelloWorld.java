package ex00;

import java.util.Scanner;

public class HelloWorld
{
	public static void main(String[] args)
	{
		String str = "";

		try (Scanner scanner = new Scanner(System.in))
		{
			System.out.println("Whats your name?");
			try
			{
			    str = scanner.nextLine();
			}
			catch (Exception e)
			{
			    System.err.println("wrong type");
			}
			if (str.compareTo("CREED") == 0)
			{
			    System.out.println("correct!");
			}
			System.out.println("hello world!");
		}
	}
}
