package days;
import java.io.File; 
import java.io.FileNotFoundException; 
import java.util.Scanner; 
import java.util.ArrayList;
public class Day1Part2 {

	public static void main(String[] args) {
		ArrayList<Integer> depths = importFile("inputday1.txt");
		System.out.println(depths.size());
		System.out.println(isSetIncrease(depths));
	}
	
	public static int isSetIncrease(ArrayList<Integer> nums) {
		
		int count = 0;
		int sum = 0;
		int sum2 = 0;
		sum2+=nums.get(0);
		sum2+=nums.get(1);
		sum2+=nums.get(2);
		for(int i = 2; i < nums.size()-1; i++) {
			sum = sum2;
			sum2 = 0;
			sum2+=nums.get(i);
			sum2+=nums.get(i+1);
			sum2+=nums.get(i-1);
			if(sum < sum2) {
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