package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4{
	
		public static void main(String[] args) throws FileNotFoundException{
		int[] input = new int[] {92,12,94,64,14,4,99,71,47,59,37,73,29,7,16,32,40,53,30,76,74,39,70,88,55,45,17,0,24,65,35,20,63,68,89,84,33,66,18,50,38,10,83,75,67,42,3,56,82,34,90,46,87,52,49,2,21,62,93,86,25,78,19,57,77,26,81,15,23,31,54,48,98,11,91,85,60,72,8,69,6,22,97,96,80,95,58,36,44,1,51,43,9,61,41,79,5,27,28,13};
		int[][][] cards = importFile("inputDay4.txt");
		System.out.println(bingo(input,cards));
		
	}
	
	public static int bingo(int[] nums, int[][][] cards) {
		int win = -1;
		int called = -1;
		int i = 0; 
		boolean done = false; 
		while (!done) {
			called = nums[i];
			for (int card = 0; card < cards.length; card++) {
				for (int row = 0; row < 5; row++) {
				for (int col = 0; col < 5; col++) {
					if (cards[card][row][col] == called) {
					cards[card][row][col] = -1;
						if (cards[card][0][col] + cards[card][1][col] + cards[card][2][col] + cards[card][3][col]+ cards[card][4][col] == -5) {
							called = card;
							done = true;
					} else if (cards[card][row][0] + cards[card][row][1] + cards[card][row][2]+ cards[card][row][3] + cards[card][row][4] == -5) {
						called = card;
						done = true;
					}
					}
					}
			}
		}
			i++;
		}
		int answer = 0;
		for (int row = 0; row < 5; row++) {
			for (int col = 0; col < 5; col++) {
				if (cards[called][col][row] > 0) {
				answer += cards[called][col][row];
				}
		}
		}
		answer *= called;
		return answer;
	}
	
	public static int[][][] importFile(String fileName) throws FileNotFoundException{
	 File myObj = new File(fileName);
     Scanner myReader = new Scanner(myObj);
	int row = 0;
	int col = 0;
	int card = 0;
	int[][][]cards = new int[100][5][5];
	while (myReader.hasNext()) {
		cards[card][row][col] = myReader.nextInt();
		col++;
		if (col == 5) {
			col = 0;
			row++;
		}
		if (row == 5) {
			row = 0;
			card++;
		}
	}

	myReader.close();
	return cards;
}
	
}	