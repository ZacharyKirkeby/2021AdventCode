package Day5;
import java.util.ArrayList;
class Main {
  public static void main(String[] args) {
    int result = Main.dangerSpots("testData.txt");
    System.out.println(result);
    

  }
  
public static int dangerSpots(String name){
  ArrayList<String> everything =  DataImporting.importFile("inputDay5.txt");
    System.out.println(everything);
    ArrayList<HydroPoints> onlyPoints =  DataImporting.makeList(everything);
    int[][] maps = makeGrid();
    return updateMap(onlyPoints, maps);
}

public static int[][] makeGrid(){
  int[][] map = new int[1000][1000];
  for(int row = 0; row < map.length; row++){
    for(int col = 0; col < map[0].length; col++){
      map[row][col] = 0;
    }
  }
  return map;
}

public static int updateMap(ArrayList<HydroPoints> points, int[][] map){
int count = 0;
for(int i = 0; i < points.size(); i++){

  int maxY = Math.max(points.get(i).getY1(),points.get(i).getY2());
  int minY = Math.min(points.get(i).getY1(),points.get(i).getY2());
  int maX = Math.max(points.get(i).getX1(),points.get(i).getX2());
  int minX = Math.min(points.get(i).getX1(),points.get(i).getX2());


  if(points.get(i).getX1() == points.get(i).getX2()){
 
    for(int k = minY; k <= maxY; k++){
      int x = points.get(i).getX1();
      int y = k;
     // System.out.println(x + ", " + y);
      map[x][y] += 1;
      
    }
  }else if(points.get(i).getY1() == points.get(i).getY2()){
    for(int m = minX; m <= maX; m++){
      int x = m;
      int y = points.get(i).getY1();
      //System.out.println(x + ", " + y);
      map[x][y] += 1;
    }
}
}

   //testing to see why the count isnt working, need count backward and forward not just forward

for(int l = 0; l < map.length; l++){
  for(int coll = 0; coll < map[0].length; coll++){
    if(map[l][coll] >= 2){
      count++;
    }
  }
}
return count;
}
}

