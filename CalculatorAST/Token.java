package ex01;

enum TokenType
{
	NUMBER,
	PLUS,
	MINUS,
	MULTIPLY,
	DIVIDE,
	LPAREN,
	RPAREN,
	EOF
}

class Token
{
	public TokenType type;
	public double TokenValue;

	public Token(TokenType type)
	{
		this.TokenValue = 0;
		this.type = type;
	}

	public Token(TokenType type, double TokenValue)
	{
		this.TokenValue = TokenValue;
		this.type = type;
	}

	@Override
	public String toString()
	{
		if (type == TokenType.NUMBER)
		{
			return ("NUMBER(" + TokenValue + ")");
		}
		else
			return (type.toString());
	}
}