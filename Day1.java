package days;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList;
import java.util.Collection;
public class Day1 {

	public static void main(String[] args) {
		ArrayList<Integer> depths = importFile("inputday1.txt");
		System.out.println(depths.size());
		System.out.println(isIncreasing(depths));
	}
	
	public static int isIncreasing(ArrayList<Integer> nums) {
		int count = 0;
		for(int i = 0; i < nums.size()-1; i++) {
			if(nums.get(i) < nums.get(i+1)) {
				count++;
			}
		}
		return count;
	}
	
	public static ArrayList<Integer> importFile(String fileName){
	    ArrayList<Integer> nums = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        int data = Integer.parseInt( myReader.nextLine());
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
	
	
	

