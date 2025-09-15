package ex01;

abstract class BinaryOpNode extends ASTNode
{
	protected ASTNode left;
	protected ASTNode right;

	public BinaryOpNode(ASTNode left, ASTNode right)
	{
		this.left = left;
		this.right = right;
	}
}
