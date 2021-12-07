package days;
import java.io.File;  
import java.io.FileNotFoundException;  
import java.util.Scanner;
import java.util.ArrayList;

public class Day2 {

	public static void main(String[] args) {
		ArrayList<String> navigate = importFile("inputDay2.txt");
		System.out.println(navigate.size());
		System.out.print(location(navigate));
	}

	
	public static int location(ArrayList<String> nav) {
		int depth = 0;
		int horiz = 0;
		
		for(int i = 0; i < nav.size(); i++) {
			if(nav.get(i).indexOf("forward") > -1) {
				int num = Integer.parseInt(nav.get(i).substring(nav.get(i).length()-1,nav.get(i).length()));
				horiz += num;
			}else if(nav.get(i).indexOf("down") > -1){
				int num = Integer.parseInt(nav.get(i).substring(nav.get(i).length()-1,nav.get(i).length()));
				depth += num;
			}else if(nav.get(i).indexOf("up") > -1){
				int num = Integer.parseInt(nav.get(i).substring(nav.get(i).length()-1,nav.get(i).length()));
				depth -= num;
				
			}
			
			}
			
			int location = depth * horiz;
			return location;
	}
	
	
	
	
	
	
	
	
	
	
	
	


	public static ArrayList<String> importFile(String fileName){
	    ArrayList<String> words = new ArrayList<>();
	    try {
	      File myObj = new File(fileName);
	      Scanner myReader = new Scanner(myObj);
	      while (myReader.hasNextLine()) {
	        String data = myReader.nextLine();
	        words.add(data);
	      }
	      myReader.close();
	    } catch (FileNotFoundException e) {
	      System.out.println("An error occurred.");
	      e.printStackTrace();
	    }
	    return words;
	  }
	
}
