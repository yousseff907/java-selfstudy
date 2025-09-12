package ex01;

public class Parser
{
	private Tokenizer	tokenizer;
	private Token		currentToken;

	public Parser(String expression)
	{
		this.tokenizer = new Tokenizer(expression);
		this.currentToken = tokenizer.nextToken();
	}

	public ASTNode parse()
	{
		ASTNode result = parseExpression();
		if (currentToken.type != TokenType.EOF)
		{
			throw new IllegalArgumentException("Unexpected token: " + currentToken);
		}
		return (result);
	}

	private ASTNode parseExpression()
	{
		ASTNode left = parseTerm();

		while (currentToken.type == TokenType.PLUS || currentToken.type == TokenType.MINUS)
		{
			TokenType operator = currentToken.type;
			consume(operator);
			ASTNode right = parseTerm();
			if (operator == TokenType.PLUS)
				left = new AddNode(left, right);
			else
				left = new SubtractNode(left, right);
		}

		return (left);
	}

	private ASTNode	parseTerm()
	{
		ASTNode	left = parseFactor();

		while (currentToken.type == TokenType.MULTIPLY || currentToken.type == TokenType.DIVIDE)
		{
			TokenType operator = currentToken.type;
			consume(operator);
			ASTNode right = parseTerm();
			if (operator == TokenType.MULTIPLY)
				left = new MultiplyNode(left, right);
			else
				left = new DivideNode(left, right);
		}

		return (left);
	}

	private ASTNode parseFactor()
	{
		if (currentToken.type == TokenType.MINUS) 
		{
			consume(TokenType.MINUS);
			ASTNode operand = parseFactor();
			return new UnaryMinusNode(operand);
		}

		if (currentToken.type == TokenType.NUMBER)
		{
			double value;

			value = currentToken.TokenValue;
			consume(TokenType.NUMBER);
			return (new NumberNode(value));
		}

		if (currentToken.type == TokenType.LPAREN)
		{
			ASTNode node;

			consume(TokenType.LPAREN);
			node = parseExpression();
			consume(TokenType.RPAREN);
			return (node);
		}
		else
			throw new IllegalArgumentException("Expected number or '(', got: " + currentToken);
	}

	private void consume(TokenType expectedType)
	{
		if (currentToken.type == expectedType)
			currentToken = tokenizer.nextToken();
		else
			throw new IllegalArgumentException("Expected " + expectedType + ", got: " + currentToken);
	}
}
