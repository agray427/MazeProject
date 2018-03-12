package build_final;

public class Vector2
{
	public static final Vector2 UP = new Vector2(0, -1);
	public static final Vector2 DOWN = new Vector2(0, 1);
	public static final Vector2 LEFT = new Vector2(-1, 0);
	public static final Vector2 RIGHT = new Vector2(1, 0);
	
	public int x;
	public int y;
	
	public Vector2 ()
	{
		this(0, 0);
	}
	
	public Vector2 (int x, int y)
	{		
		this.x = x;
		this.y = y;
	}
	
	public Vector2 add(Vector2 addition)
	{
		return add(this, addition);
	}
	
	public boolean equals(Vector2 other)
	{
		return (this.x == other.x && this.y == other.y);
	}
	
	public String toString()
	{
		return "(" + x + ", " + y + ")";
	}
	
	public static Vector2 add(Vector2 origin, Vector2 other)
	{
		return new Vector2(origin.x + other.x, origin.y + other.y);
	}
}