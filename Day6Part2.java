package days;


public class Day6Part2 {
	
	  public static void main(String[] args) {
	    int[] fish = new int[]{2,1,1,1,1,1,1,5,1,1,1,1,5,1,1,3,5,1,1,3,1,1,3,1,4,4,4,5,1,1,1,3,1,3,1,1,2,2,1,1,1,5,1,1,1,5,2,5,1,1,2,1,3,3,5,1,1,4,1,1,3,1,1,1,1,1,1,1,1,1,1,1,1,4,1,5,1,2,1,1,1,1,5,1,1,1,1,1,5,1,1,1,4,5,1,1,3,4,1,1,1,3,5,1,1,1,2,1,1,4,1,4,1,2,1,1,2,1,5,1,1,1,5,1,2,2,1,1,1,5,1,2,3,1,1,1,5,3,2,1,1,3,1,1,3,1,3,1,1,1,5,1,1,1,1,1,1,1,3,1,1,1,1,3,1,1,4,1,1,3,2,1,2,1,1,2,2,1,2,1,1,1,4,1,2,4,1,1,4,4,1,1,1,1,1,4,1,1,1,2,1,1,2,1,5,1,1,1,1,1,5,1,3,1,1,2,3,4,4,1,1,1,3,2,4,4,1,1,3,5,1,1,1,1,4,1,1,1,1,1,5,3,1,5,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,5,1,1,1,1,1,1,1,1,5,1,4,4,1,1,1,1,1,1,1,1,3,1,3,1,4,1,1,2,2,2,1,1,2,1,1};
	    long[] schoolOfFish = starterToFish(fish);
	    System.out.println(histogramOfFish(schoolOfFish)); 
	    
	  }
	  
	  public static long histogramOfFish(long[] fishgram) {
		  long[] fish = fishgram;
		  long total = 0;
		  
		  for(int time = 0; time < 256; time++) {
			  fish = day(fish);
		  }
		  for(int i = 0; i < fish.length; i++) {
			  total += fishgram[i];
		  }
		  return total;
	  }
	  
	  
	  
	  public static long[] starterToFish(int[] fish) {
		  long[] fishGram = new long[10];
		  for (int k = 0; k < fishGram.length; k++) {
			 for(int i = 0; i < fish.length; i++) {
				 if(fish[i] == k) {
					 fishGram[k] +=1;
				 }
			 }
		  }
		  return fishGram;
	  }
	  
	 
	public static long[] day(long[] fishgram){
	  for(int k = 0; k < fishgram.length; k++){
	      long count = fishgram[k];
	      if(k == 0) {
	    	  fishgram[7] += count;
	    	  fishgram[9] += count;
	    	  fishgram[k] = 0;
	      }else 
	    	fishgram[k-1] = fishgram[k];
	      	fishgram[k] = 0;
	      
	      
	  }
	  return fishgram;
	}
		  
		  
		  



	}