package ex01;

class AddNode extends BinaryOpNode
{
	public AddNode(ASTNode left, ASTNode right)
	{
		super(left, right);
	}

	@Override
	public double evaluate()
	{
		return (left.evaluate() + right.evaluate());
	}

	@Override
	public String toString()
	{
		return ("(" + left.toString() + " + " + right.toString() + ")");
	}
}

class SubtractNode extends BinaryOpNode
{
	public SubtractNode(ASTNode left, ASTNode right)
	{
		super(left, right);
	}

	@Override
	public double evaluate()
	{
		return (left.evaluate() - right.evaluate());
	}

	@Override
	public String toString()
	{
		return ("(" + left.toString() + " - " + right.toString() + ")");
	}
}


class MultiplyNode extends BinaryOpNode
{
	public MultiplyNode(ASTNode left, ASTNode right)
	{
		super(left, right);
	}

	@Override
	public double evaluate()
	{
		return (left.evaluate() * right.evaluate());
	}

	@Override
	public String toString()
	{
		return ("(" + left.toString() + " * " + right.toString() + ")");
	}
}

class DivideNode extends BinaryOpNode
{
	public DivideNode(ASTNode left, ASTNode right)
	{
		super(left, right);
	}

	@Override
	public double evaluate()
	{
		if (right.evaluate() == 0.0)
		{
			throw new ArithmeticException("Division by zero!");
		}
		return (left.evaluate() / right.evaluate());
	}

	@Override
	public String toString()
	{
		return ("(" + left.toString() + " / " + right.toString() + ")");
	}
}
