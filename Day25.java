package days;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;


public class Day25{
	
	public static void main(String[] args) {
		Scanner reader = null;
		try {
			reader = new Scanner(new File("inputDay25.txt"));
		} catch (Exception e) {
			System.out.println("file not found");
		}

		ArrayList<String> input = new ArrayList<String>();
		while (reader.hasNext()) {
			input.add(reader.nextLine());
		}
		reader.close();

		char[][] grid = new char[input.size()][input.get(0).length()];
		int r = 0;
		for (String line : input) {
			grid[r] = line.toCharArray();
			r++;
		}
		char East = '>';
		char South = 'v';
		char blank = '.';
		part1(grid, East, South, blank);
	}

	public static void part1(char[][] grid, char east, char south, char blank) {

		int steps = 0;
		boolean movedEast = true;
		boolean movedSouth = true;

		while (movedEast || movedSouth) {
			steps++;
			movedEast = moveEast(grid, east, south, blank);
			movedSouth = moveSouth(grid, east, south, blank);
		}

		System.out.println(steps);

	}

	private static boolean moveEast(char[][] grid, char East, char South, char blank) {
		boolean moved = false;
		for (int r = 0; r < grid.length; r++) {
			boolean moveOG = false;
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == East) {
					if (c <= grid[0].length - 2 && grid[r][c + 1] == blank) {
						moved = true;
						if (c == 0)
							moveOG = true;
						grid[r][c] = blank;
						grid[r][c + 1] = East;
						c++;
					} else if (c == grid[0].length - 1 && grid[r][0] == blank && !moveOG) {
						moved = true;
						grid[r][c] = blank;
						grid[r][0] = East;
					}
				}
			}
		}
		return moved;
	}

	private static boolean moveSouth(char[][] grid,char East, char South, char blank) {
		boolean moved = false;
		for (int c = 0; c < grid[0].length; c++) {
			boolean moveOG = false;
			for (int r = 0; r < grid.length; r++) {
				if (grid[r][c] == South) {
					if (r <= grid.length - 2 && grid[r + 1][c] == blank) {
						moved = true;
						if (r == 0)
							moveOG = true;
						grid[r][c] = blank;
						grid[r + 1][c] = South;
						r++;
					} else if (r == grid.length - 1 && grid[0][c] == blank && !moveOG) {
						moved = true;
						grid[r][c] = blank;
						grid[0][c] = South;
					}
				}
			}
		}
		return moved;
	}

}