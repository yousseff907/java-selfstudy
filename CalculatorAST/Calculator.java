package ex01;

public class Calculator
{
		public double evaluate(String expression)
		{
			try
			{
				Parser parser = new Parser(expression);
				ASTNode ast = parser.parse();
				return ast.evaluate();
			}
			catch (Exception e)
			{
				System.err.println("Error evaluating expression: " + e.getMessage());
				throw e;
			}
		}

	public static void main(String[] args)
	{
		Calculator calc = new Calculator();

		if (args.length != 1)
			System.out.println("Usage: java Calculator \"<expression>\"");

		String expression = args[0];
		try
		{
			double result = calc.evaluate(expression);
			System.out.println("Result: " + result);
		}
		catch (Exception e)
		{
			System.err.println("Error: " + e.getMessage());
		}
	}
}
