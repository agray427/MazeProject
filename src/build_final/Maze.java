package build_final;

import java.util.ArrayList;

public class Maze
{
	public static final int SIZE_MIN = 3;
	
	private Square[][] m_grid;
	private Vector2 m_startPosition;
	private ArrayList<Vector2> m_endPositions;
	
	public Maze(int size)
	{
		m_grid = new Square[size][size];
		m_startPosition = null;
		m_endPositions = null;
	}
	
	public boolean canAttempt()
	{
		return m_startPosition != null && m_endPositions != null && m_endPositions.size() > 0;
	}
	
	public int getSideLength()
	{
		return m_grid.length;
	}
	
	public void setSquare(int x, int y, Square value)
	{
		setSquare(new Vector2(x, y), value);
	}
	
	public void setSquare(Vector2 position, Square value)
	{
		if (position != null)
		{
			if (validatePosition(this, position))
			{
				char code = value.getCode();
				
				if (code == Square.CODE_START)
				{
					if (m_startPosition == null)
					{
						m_startPosition = position;
					}
					else
					{
						value = Square.fromCode(Square.CODE_WALL);
					}
				}
				else if (code == Square.CODE_END)
				{
					if (m_endPositions == null)
					{
						m_endPositions = new ArrayList<Vector2>();
					}
					
					m_endPositions.add(position);
				}
				
				m_grid[position.x][position.y] = value;
			}
		}
	}

	public Square getSquare(int x, int y)
	{
		return getSquare(new Vector2(x, y));
	}
	
	public Square getSquare(Vector2 position)
	{
		if (m_grid != null)
		{
			return m_grid[position.x][position.y];
		}
		
		return null;
	}
	
	public Vector2 getStartPosition()
	{
		return m_startPosition;
	}

	public boolean isEnd(Vector2 position)
	{
		return isCode(position, Square.CODE_END);
	}
	
	public boolean isOpen(Vector2 position)
	{
		return isCode(position, Square.CODE_OPEN);
	}
	
	private boolean isCode(Vector2 position, char code)
	{
		if (m_grid != null && validatePosition(this, position))
		{
			return (m_grid[position.x][position.y]).getCode() == code;
		}
		
		return false;
	}
	
	@Override
	public String toString()
	{
		int sideLength = getSideLength();
		StringBuilder sb = new StringBuilder();
		
		for(int y = 0; y < sideLength; y++)
		{
			for(int x = 0; x < sideLength; x++)
			{
				sb.append(getSquare(x, y).toString());
			}
			
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	public static boolean validatePosition(Maze maze, Vector2 position)
	{
		return validatePosition(maze, position.x, position.y);
	}
	
	public static boolean validatePosition(Maze maze, int x, int y)
	{
		int sideLength = maze.getSideLength();
		return (sideLength >= SIZE_MIN && (x >= 0 && x < sideLength) && (y >= 0 && y < sideLength));
	}
}