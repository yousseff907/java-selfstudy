/*
Create a compound interest calculator for financial applications.
Given principal amount, annual interest rate, time period, compounding frequency.

Formula: A = P(1 + r/n)^(nt)
Where: P=principal, r=annual rate, n=compounds per year, t=time in years
*/

public class FinancialCalculator
{
	public double compoundInterest(double principal, double annualRate, int timeYears, int compoundingFrequency)
	{
		double rate = annualRate > 1 ? annualRate / 100 : annualRate;
		double compoundInterest = 0;

		if (principal <= 0 || annualRate <= 0 || timeYears <= 0 || compoundingFrequency <= 0)
			throw new IllegalArgumentException("All values should be positive non zero");

		compoundInterest = principal * Math.pow(1 + rate/compoundingFrequency, compoundingFrequency * timeYears);

		return(compoundInterest);
	}

	public static void main(String[] args)
	{
		FinancialCalculator calc = new FinancialCalculator();

		double result1 = calc.compoundInterest(1000, 5, 2, 12);
		System.out.println("$1000 at 5% for 2 years (monthly): $" + String.format("%.2f", result1));

		double result2 = calc.compoundInterest(1000, 0.05, 2, 12);
		System.out.println("Same with decimal rate: $" + String.format("%.2f", result2));

		try
		{
			calc.compoundInterest(-1000, 5, 2, 12);
		}
		catch (IllegalArgumentException e)
		{
			System.out.println("Caught error: " + e.getMessage());
		}
	}
}