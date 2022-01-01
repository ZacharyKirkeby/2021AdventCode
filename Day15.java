package days;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day15 {

	public static void main(String[] args) {
		int[][] riskMap;
		Scanner reader = null;
		try {
			reader = new Scanner(new File("inputDay15.txt"));
		} catch (Exception e) {
			System.out.println("file not found");
		}
		ArrayList<String> input = new ArrayList<String>();
		while (reader.hasNext()) {
			input.add(reader.nextLine());
		}
		reader.close();

		riskMap = new int[input.size()][input.get(0).length()];
		for (int row = 0; row < riskMap.length; row++) {
			for (int col = 0; col < riskMap[0].length; col++) {
				riskMap[row][col] = Integer.parseInt(input.get(row).substring(col, col + 1));
			}
		}
		lowestRisk(riskMap);
	}

	public static void lowestRisk(int[][] map) {
		int risk = risk(map);
		System.out.println(risk);
	}

	public static int risk(int[][] riskMap) {
		int[][] sums = new int[riskMap.length][riskMap[0].length];
		for (int r = 0; r < sums.length; r++) {
			for (int c = 0; c < sums[0].length; c++) {
				sums[r][c] = 1000;
			}
		}
		sums[sums.length - 1][sums[0].length - 1] = 0;
		boolean change = true;
		while (change == true) {
			change = false;
			for (int r = sums.length - 1; r >= 0; r--) {
				for (int c = sums[0].length - 1; c >= 0; c--) {
					int min = Integer.MAX_VALUE;
					if (r - 1 >= 0)
						min = Math.min(min, riskMap[r - 1][c] + sums[r - 1][c]);
					if (r + 1 < sums.length)
						min = Math.min(min, riskMap[r + 1][c] + sums[r + 1][c]);
					if (c - 1 >= 0)
						min = Math.min(min, riskMap[r][c - 1] + sums[r][c - 1]);
					if (c + 1 < sums[0].length)
						min = Math.min(min, riskMap[r][c + 1] + sums[r][c + 1]);

					int oldRisk = sums[r][c];
					sums[r][c] = Math.min(sums[r][c], min);
					if (sums[r][c] != oldRisk)
						change = true;
				}
			}
		}
		return (sums[0][0]);
	}
}