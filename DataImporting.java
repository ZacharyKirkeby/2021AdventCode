package days;

import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.ArrayList;
public class DataImporting{

 public static ArrayList<String> importFile(String fileName){
    ArrayList<String> instructions = new ArrayList<>();
    ArrayList<String> words = new ArrayList<>();
    try {

      File myObj = new File(fileName);
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        if(data.length() != 0){
        words.add(data);
        } else {
          instructions.add(data);
        }
      }
        
      myReader.close();
    } 
    catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
    directions(instructions);
    return words;
  }

  public static ArrayList<String> directions(ArrayList<String> instruction){
    return instruction;
  }

}