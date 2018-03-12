package build_final;

public class Square
{
	public static final char CODE_START = 'o';
	public static final char CODE_END = '*';
	public static final char CODE_OPEN = '.';
	public static final char CODE_WALL = '#';
	
	private char m_typeCode;
	
	public Square(char typeCode)
	{
		m_typeCode = typeCode;
	}
	
	public char getCode()
	{
		return m_typeCode;
	}
	
	@Override
	public String toString()
	{
		return String.valueOf(getCode());
	}
	
	public static Square fromCode(char code)
	{
		switch(code)
		{
		case CODE_START:
		case CODE_END:
		case CODE_OPEN:
			return new Square(code);
		default:
			return new Square(CODE_WALL);
		}
	}
}