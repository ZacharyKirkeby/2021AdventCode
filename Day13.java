package days;

import java.util.ArrayList;

class Day13 {
  public static void main(String[] args) {
    ArrayList<String> str = new ArrayList<>();
    ArrayList<Day13Point> point = new ArrayList<>();
    str = DataImporting.importFile("inputDay13.txt");
    point = getPoints(str);
    int maxX = findMaxX(point);
    int maxY = findMaxY(point);
    point = foldX(point, 655, maxX);
    System.out.println(countDots(markMap(makeMap(), point)));
  }

  public static int findMaxY(ArrayList<Day13Point> point){
    int max = 0;
    for(int i = 0; i < point.size(); i++){
      max = Math.max(max, point.get(i).getY());
    }
    return max;
  }

  public static int findMaxX(ArrayList<Day13Point> point){
    int max = 0;
for(int i = 0; i < point.size(); i++){
      max = Math.max(max, point.get(i).getX());
    }
    return max;
  }
  public static int countDots(int[][] dots){
    int count = 0;
    for (int row = 0; row < dots.length; row++) {
      for (int col = 0; col < dots[0].length; col++) {
        if(dots[row][col] != 0){
          count++;
        }
      }
    }
    return count;
  }

  public static ArrayList<Day13Point> foldY(ArrayList<Day13Point> point, int a, int max){
    ArrayList<Day13Point> newPoints = new ArrayList<>();
    for(int i = 0; i < point.size(); i++){
      int y = point.get(i).getY();
      if(y >= a + 1){
        int x = point.get(i).getX();
        y = Math.abs(y - max);
        Day13Point p = new Day13Point(x, y);
        newPoints.add(p);
      } else {
        newPoints.add(point.get(i));
      }
    }
    return newPoints;
  }

  public static ArrayList<Day13Point> foldX(ArrayList<Day13Point> point, int b, int max){
ArrayList<Day13Point> newPoints = new ArrayList<>();
    for(int i = 0; i < point.size(); i++){
      int x = point.get(i).getX();
      if(x >= b + 1){
        int y = point.get(i).getY();
        x = Math.abs(x - max);
        Day13Point p = new Day13Point(x, y);
        newPoints.add(p);
      } else {
        newPoints.add(point.get(i));
      }
    }
    return newPoints;
  }

  public static ArrayList<Day13Point> getPoints(ArrayList<String> str){
    ArrayList<Day13Point> points = new ArrayList<>();
    for(int i = 0; i < str.size(); i++){
      String line = str.get(i);
      int a = line.indexOf(",");
      int x = Integer.parseInt(line.substring(0, a));
      int y = Integer.parseInt(line.substring(a + 1));
      //System.out.println(x + " " + y);
      Day13Point p = new Day13Point(x, y);
      points.add(p);
    }

    return points;
  }

  public static int folding(String fileName){
    
    return 0;
  }

  public static void printMe2d(int[][] list) {
    for (int row = 0; row < list.length; row++) {
      for (int col = 0; col < list[0].length; col++) {
        System.out.print(list[row][col]);
      }
      System.out.println();
    }
  }

  public static int[][] makeMap(){
    int[][] map = new int[1500][1500];
    for(int row = 0; row < map.length; row++){
    for(int col = 0; col < map[0].length; col++){
      map[row][col] = 0;
    }
  }
  return map;
  }

  public static int[][] markMap(int[][] map, ArrayList<Day13Point> points){
    for(int i = 0; i < points.size(); i++){
      int x = points.get(i).getX();
      int y = points.get(i).getY();
      map[y][x] += 1;
    }
    return map;
  }
}