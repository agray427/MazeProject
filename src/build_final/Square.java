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
	
	public static Square fromChar(char ch)
	{
		if (ch == CODE_START || ch == CODE_END || ch == CODE_OPEN || ch == CODE_WALL)
		{
			return new Square(ch);
		}
		else
		{
			throw new IllegalArgumentException("Character must be one of the following: o * . #");
		}
	}
}
