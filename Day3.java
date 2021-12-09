package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3 {

	public static void main(String[] args) {
		ArrayList<String> binary = importFile("inputDay3.txt");
		/*ArrayList<String> binary = new ArrayList<>();
		binary.add("00100");
		binary.add("11110");
		binary.add("10110");
		binary.add("10111");
		binary.add("10101");
		binary.add("01111");
		binary.add("00111");
		binary.add("11100");
		binary.add("10000");
		binary.add("11001");
		binary.add("00010");
		binary.add("01010");
	*/	System.out.println(findVal(binary));
		
		
	
		
		
		
		
	
	
		
		

	}
	
	
	public static int findVal(ArrayList<String> nums) {
		ArrayList<String> sequences = new ArrayList<>();
		String sequence = "";
		for(int i = 0; i < nums.get(0).length(); i++) {
			sequence = "";
			for(int k = 0; k < nums.size(); k++) {
			sequence += nums.get(k).charAt(i);
			}
			sequences.add(sequence);
			sequence = "";
		}
		String epi = "";
		String gamma = "";
		
		for(int n = 0; n < sequences.size(); n++) {
			if(mostCommon(sequences.get(n)).equals("1")) {
				gamma+= '1';
				epi += '0';
			}else if(mostCommon(sequences.get(n)).equals("0")) {
				gamma+= '0';
				epi += '1';
			}	
		}
		int epis =  Integer.parseInt(epi,2);
		int gammas = Integer.parseInt(gamma,2);
		return epis * gammas;
	}
	
	
	public static String mostCommon(String sequence) {
		int one = 0;
		int zero = 0;
		for(int i = 0; i < sequence.length(); i++ ) {
			if(sequence.charAt(i) == '0') {
				zero++;
			}else
				one++;
		}
		if(one > zero ) {
			return "1";
		}else
			return "0";
	}
	
	
	
	
	
	
	
	
	
	
	public static ArrayList<String> importFile(String fileName){
	    ArrayList<String> nums = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        nums.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return nums;
	  }
	}


