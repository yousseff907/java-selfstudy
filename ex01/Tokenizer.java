package ex01;

public class Tokenizer
{
	private String	expression;
	private int 	position;

	public Tokenizer(String expression)
	{
		this.expression = expression.replace("\\s+", "");
		this.position = 0;
	}

	public Token nexToken()
	{
		if (position >= expression.length())
			return new Token(TokenType.EOF);

		char current = expression.charAt(position);

		if (Character.isDigit(current) || current == '.')
		{
			return (readNumber());
		}

		position++;

		switch (current)
		{
			case '+':
				return new Token(TokenType.PLUS);
			case '-':
				return new Token(TokenType.MINUS);
			case '*':
				return new Token(TokenType.MULTIPLY);
			case '/':
				return new Token(TokenType.DIVIDE);
			case '(':
				return new Token(TokenType.LPAREN);
			case ')':
				return new Token(TokenType.RPAREN);
			default:
				throw new IllegalArgumentException("Unknown character: " + current);
		}
	}

	private Token readNumber()
	{
		StringBuilder number = new StringBuilder();

		while (position <= expression.length())
		{
			char c = expression.charAt(position);
			if (Character.isDigit(c) || c == '.')
			{
				number.append(c);
				position++;
			}
			else
				break;
		}

		double value = Double.parseDouble(number.toString());
		return new Token(TokenType.NUMBER, value);
	}
}
