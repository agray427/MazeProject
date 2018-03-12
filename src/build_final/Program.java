package build_final;

import java.io.File;

public class Program
{
	public static void main(String[] args)
	{
		File file = new File("Maze.txt");
		Maze maze = MazeReader.generateMaze(file);
		MazeSolver solver = new MazeSolver(maze);
		System.out.println(maze.toString());
		solver.solve();
		
		if (solver.getIsDone())
		{
			solver.printPath();
		}
		else
		{
			System.out.println("Couldn't find a path...");
		}
	}
}