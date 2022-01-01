package days;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9 {

	public static void main(String[]args) {
		
		ArrayList<String> input = new ArrayList<String>();
		int[][] heightMap;
		
		Scanner reader = null;
		try {
			reader = new Scanner(new File("inputDay9.txt"));
			while (reader.hasNext()) {
				input.add(reader.nextLine());
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("file not found");
		}
		heightMap = new int[input.size()][input.get(0).length()];
		for (int row = 0; row < input.size(); row++) {
			for (int col = 0; col < input.get(0).length(); col++) {
				heightMap[row][col] = Integer.parseInt(input.get(row).substring(col, col + 1));
			}
		}
		height(input,heightMap);
	}

	public static void height(ArrayList<String> input, int[][] map) {
		int riskSum = 0;
		for (int r = 0; r < map.length; r++) {
			for (int c = 0; c < map[0].length; c++) {
				if (isLow(r, c, map)) {
					riskSum += 1 + map[r][c];
				}
			}
		}
		System.out.println(riskSum);
	}
	public static boolean isLow(int r, int c, int[][] map) {
		int height = map[r][c];
		int up;
		int down;
		int left;
		int right;
		
		if(r>0) {
			up = map[r - 1][c];
		}else
			up = 9;
		if(r<= map.length-2) {
			down = map[r + 1][c];
		}else 
			down = 9;
		if(c > 0) {
			left = map[r][c - 1];
		}else
			left = 9;
		if(c <= map[0].length - 2) {
			right = map[r][c + 1];
		}else
			right = 9;
		
		return (height < up && height < down && height < left && height < right);
	}
}
