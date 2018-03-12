package build_final;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class MazeSolver
{
	private Maze m_maze;
	private boolean m_isDone;
	private Queue<Vector2> m_queue;
	private Vector2[] m_path;
	
	private boolean[][] m_visited;
	private Vector2[][] m_previous;
	
	public MazeSolver(Maze maze)
	{
		m_maze = maze;
		m_isDone = false;
		m_queue = new LinkedList<Vector2>();
		m_path = null;
		
		int size = maze.getSideLength();
		m_visited = new boolean[size][size];
		m_previous = new Vector2[size][size];
	}

	public boolean getIsDone()
	{
		return m_isDone;
	}
	
    public void solve()
    {
    	if (m_maze != null && m_maze.canAttempt())
    	{
            solve(m_maze.getStartPosition());
    	}
    }
	
    private void solve(Vector2 position)
    {
    	if (Maze.validatePosition(m_maze, position))
    	{
    		m_queue.offer(position);
        	m_visited[position.x][position.y] = true;
    	}
    	
    	while (m_queue != null && !m_queue.isEmpty() && !m_isDone)
    	{
    		Vector2 current = m_queue.poll();    		
        	check(current.add(Vector2.RIGHT), current);
    		check(current.add(Vector2.DOWN), current);
    		check(current.add(Vector2.LEFT), current);
    		check(current.add(Vector2.UP), current);
    	}
    }
    
    private void check(Vector2 position, Vector2 previous)
    {
    	if (Maze.validatePosition(m_maze, position) && !m_visited[position.x][position.y])
    	{
        	m_visited[position.x][position.y] = true;
    		m_previous[position.x][position.y] = previous;
        	
        	if (m_maze.isEnd(position))
        	{
        		m_isDone = true;
        		m_path = generatePathFrom(position);
        	}
        	else if (m_maze.isOpen(position) && previous != null)
        	{
        		m_queue.offer(position);
        	}
    	}
    }
	
    private Vector2[] generatePathFrom(Vector2 position)
	{
		Stack<Vector2> pathStack = new Stack<Vector2>();
		
		while(position != null)
		{
			pathStack.push(position);
			position = m_previous[position.x][position.y];
		}
		
		Vector2[] path = new Vector2[pathStack.size()];
		
		for(int i = 0; !pathStack.isEmpty(); i++)
		{
			path[i] = pathStack.pop();
		}
		
		return path;
	}

    public void printPath()
    {
    	if (m_path != null && m_path.length > 0)
    	{
    		System.out.print(m_path[0].toString());
    		
    		for(int i = 1; i < m_path.length; i++)
    		{
    			System.out.print(" > " + m_path[i].toString());
    		}
    	}
    }
}