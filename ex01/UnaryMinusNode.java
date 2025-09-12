package ex01;

class UnaryMinusNode extends ASTNode
{
	private ASTNode operand;
	
	public UnaryMinusNode(ASTNode operand)
	{
		this.operand = operand;
	}

	@Override
	public double evaluate()
	{
		return ((operand.evaluate() * -1));
	}

	@Override
	public String toString()
	{
		return ("(-" + operand.toString() + ")");
	}
}
