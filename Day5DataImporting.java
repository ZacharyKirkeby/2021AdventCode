package days;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;

public class Day5DataImporting{

public static ArrayList<String> importFile(String fileName){
  ArrayList<String> dataStrings = new ArrayList<>();
  try {
      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
       dataStrings.add(data);
    
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    return dataStrings;
  }



public static ArrayList<Day5HydroPoints> makeList(ArrayList<String> words){
ArrayList<Day5HydroPoints> onlyPoints = new ArrayList<>();
for(int i=0; i < words.size(); i++){
      String data = words.get(i); 
      int c = data.indexOf(",");
      String temp = data.substring(0,c);
      int x1 = Integer.parseInt(temp);
      data = data.substring(c+1);
      
      int s = data.indexOf(" ");
       temp = data.substring(0,s);
       int y1 = Integer.parseInt(temp);
       data = data.substring(s+1);
       
       s = data.indexOf(" ");
       temp = data.substring(s+1);
       c = temp.indexOf(",");
       data = temp;

      temp = data.substring(0,c);
       int x2 = Integer.parseInt(temp);
       data = data.substring(c+1);
       int y2 = Integer.parseInt(data);
       

       Day5HydroPoints point = new Day5HydroPoints(x1, y1, x2,y2);
        onlyPoints.add(point); 
}
return onlyPoints;       
}
}