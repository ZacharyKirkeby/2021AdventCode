package days;
import java.util.ArrayList;
public class Day6 {
	
	  public static void main(String[] args) {
	    int[] fish = new int[]{2,1,1,1,1,1,1,5,1,1,1,1,5,1,1,3,5,1,1,3,1,1,3,1,4,4,4,5,1,1,1,3,1,3,1,1,2,2,1,1,1,5,1,1,1,5,2,5,1,1,2,1,3,3,5,1,1,4,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,4,1,5,1,2,1,1,1,1,5,1,1,1,1,1,5,1,1,1,4,5,1,1,3,4,1,1,1,3,5,1,1,1,2,1,1,4,1,4,1,2,1,1,2,1,5,1,1,1,5,1,2,2,1,1,1,5,1,2,3,1,1,1,5,3,2,1,1,3,1,1,3,1,3,1,1,1,5,1,1,1,1,1,1,1,3,1,1,1,1,3,1,1,4,1,1,3,2,1,2,1,1,2,2,1,2,1,1,1,4,1,2,4,1,1,4,4,1,1,1,1,1,4,1,1,1,2,1,1,2,1,5,1,1,1,1,1,5,1,3,1,1,2,3,4,4,1,1,1,3,2,4,4,1,1,3,5,1,1,1,1,4,1,1,1,1,1,5,3,1,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1,1,5,1,4,4,1,1,1,1,1,1,1,1,3,1,3,1,4,1,1,2,2,2,1,1,2,1,1};
	    ArrayList<Integer>  schoolOfFish = arrayToList(fish);
	    System.out.println(schoolOfFish.size());
	    
	    System.out.print(fishDay(schoolOfFish));
	    
	    
	  }


	  public static ArrayList<Integer> arrayToList (int[] fish){
	  ArrayList<Integer> lantern = new ArrayList<Integer>();
	  for(int i = 0; i < fish.length; i++){
	    lantern.add(fish[i]);
	  }
	  return lantern;
	}




	public static int fishDay(ArrayList<Integer> lantern){
	  for(int i = 0; i < 80; i++){
	    lantern = day(lantern);
	  }
	  return lantern.size();
	}


	public static ArrayList<Integer> day(ArrayList<Integer> lantern){
	  for(int k = 0; k < lantern.size(); k++){
	      if(lantern.get(k) == 0){
	        lantern.add(9);
	        lantern.set(k,6);
	      }else
	        lantern.set(k, lantern.get(k)-1);
	      
	  }
	  return lantern;
	}




	}

