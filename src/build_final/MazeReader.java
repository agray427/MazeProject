package build_final;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MazeReader
{
	public static Maze generateMaze(File file)
	{
		try
		{
			Scanner scanner = new Scanner(file);
			StringBuilder sb = new StringBuilder();
			
			while (scanner.hasNextLine())
			{
				sb.append(scanner.nextLine());
			}
			
			scanner.close();
			return generateMaze(sb.toString());
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		
		return null;
	}
	
	public static Maze generateMaze(String input)
	{
		int size = (int)Math.sqrt(input.length());
		
		if (size >= Maze.SIZE_MIN)
		{
			Maze maze = new Maze(size);
			
			for(int y = 0; y < size; y++)
			{
				for(int x = 0; x < size; x++)
				{
					int index = y * size + x;
					char code = input.charAt(index);
					Square square = Square.fromCode(code);
										
					if (square != null)
					{
						maze.setSquare(x, y, square);
					}
				}
			}
			
			return maze;
		}
		
		return null;
	}
}