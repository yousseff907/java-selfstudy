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
    
    public void printAST(String expression)
	{
		try
		{
			Parser parser = new Parser(expression);
			ASTNode ast = parser.parse();
			System.out.println("AST: " + ast.toString());
		}
		catch (Exception e)
		{
			System.err.println("Error parsing expression: " + e.getMessage());
		}
    }

	public static void main(String[] args)
	{
		Calculator calc = new Calculator();

		if (args.length == 0)
			System.out.println("Usage: java Calculator \"<expression>\"");
		
		for (int i = 0; i < args.length; i++)
		{
			String expression = args[i];
			System.out.println("Expression " + (i + 1) + ": " + expression);
			try
			{
				calc.printAST(expression);
				double result = calc.evaluate(expression);
				System.out.println("Result: " + result);
			}
			catch (Exception e)
			{
				System.err.println("Error: " + e.getMessage());
			}
		}
	}
}
