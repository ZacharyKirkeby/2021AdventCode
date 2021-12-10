package days;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day3Part2 {

	public static void main(String[] args) {
		ArrayList<String> binary = importFile("inputDay3.txt");
		System.out.println(diagnostic(binary));
		
	}
	
	
	 public static int diagnostic(ArrayList<String> input) {
	        ArrayList<String> gamma = input;
	        ArrayList<String> eps = input;
	        int gammaIndex = 0;
	        int epsIndex=0;
	        while (gamma.size() > 1) {
	            ArrayList<String> zero = new ArrayList<>();
	            ArrayList<String> one = new ArrayList<>();
	            int count = 0;
	            for (String line : gamma) {
	                if (line.charAt(gammaIndex) == '1') {
	                    count++;
	                    one.add(line);
	                }
	                else zero.add(line);
	            }
	            if (count >=gamma.size() - count) gamma = one;
	            else gamma = zero;
	            gammaIndex++;
	        }

	        while (eps.size() > 1) {
	            ArrayList<String> zeroL = new ArrayList<>();
	           ArrayList<String> oneL = new ArrayList<>();
	            int c = 0;
	            for (String line : eps) {
	                if (line.charAt(epsIndex) == '1') {
	                    c++;
	                    oneL.add(line);
	                }
	                else zeroL.add(line);
	            }
	            if (c >= eps.size() - c) eps = zeroL;
	            else eps = oneL;
	            epsIndex++;
	            
	        }
	        return Integer.parseInt(gamma.get(0), 2) * Integer.parseInt(eps.get(0),2);
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


