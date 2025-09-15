package ex01;

class NumberNode extends ASTNode
{
	private double	Value;

	public	NumberNode(double Value)
	{
		this.Value = Value;
	}

	@Override
	public double evaluate()
	{
		return (Value);
	}

	@Override
	public String toString()
	{
		return (String.valueOf(Value));
	}
}
