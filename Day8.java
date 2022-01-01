package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day8 {

	public static void main(String[] args) {
		int total = 0;
		int c = 0;
		ArrayList<Day8Clock> input;
		try {
			input = new ArrayList<Day8Clock>();
			Scanner reader = new Scanner(new File("inputDay8.txt"));
			while (reader.hasNext()) {
				input.add(new Day8Clock(reader.nextLine()));
				total+= input.get(c).getCount();
				c++;
			}
			reader.close();
		} catch (Exception e) {
			System.out.println("file not found");
		}
		//Solution to part one 548
		System.out.println(total);
		
		
		
		
	}
	
	
	
	
	
	
}
