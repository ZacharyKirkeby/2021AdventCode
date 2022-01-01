package days;
import java.io.File;
import java.util.Scanner;
public class Day11 {
	private static int flash;
	
	public static void main(String[] args) {	
		Scanner reader = null;
		int[][] grid = new int[10][10];
		try {
			reader = new Scanner(new File("inputDay11.txt"));
		} catch (Exception e) {
			System.out.println("file not found");
		}
		
		int row = 0;
		while (reader.hasNext()) {
			String line = reader.nextLine();
			for (int col = 0; col < line.length(); col++) {
				grid[row][col] = Integer.parseInt(line.substring(col, col + 1));
			}
			row++;
		}
		reader.close();

		int[][] grid2 = grid;
		for (int i = 0; i < 100; i++) {
		 updateGrid(grid2);
		}
		System.out.println(flash);
	}
	
	
/*
	public void part2() {
		int[][] grid = copy();
		int step = 0;
		// update the grid until every single element equals 0.
		while (!allZeros(grid)) {
			updateGrid(grid);
			step++;
		}
		System.out.println(step);
	}
*/
	
	public static void updateGrid(int[][] grid) {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				grid[r][c]++;
			}
		}
		tens(grid);
	}
		
		
	public static void tens (int[][] grid) {
		
		boolean flasH = false;
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] >= 10) {
					grid[r][c] = 0;
					flash++;
					flasH = true;
					allFlash(grid, r, c);
					}
				}
			}
			if (flasH == true) {
				tens(grid);
			}
		
		}
		
	
	public static void allFlash(int[][] grid, int r, int c) {
		int[] d = new int[] { -1, 0, 1 };
		for (int i = 0; i < d.length; i++) {
			for (int j = 0; j < d.length; j++) {
				if (!(i == 1 && j == 1)) {
					if (canFlash(grid, r + d[i], c + d[j]) == true) {
						grid[r + d[i]][c + d[j]]++;
					}	
				}
			}
		}
	}


	public static boolean canFlash(int[][] grid, int r, int c) {
		return (r >= 0 && c >= 0 && r < grid.length && c < grid[0].length && grid[r][c] != 0);
	}

	
	public static boolean allZeros(int[][] grid) {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] != 0)
					return false;
			}
		}
		return true;
	}
	

}


// part 2: 403