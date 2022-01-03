package days;

public class Day17Part2 {
	
	public static void main(String[] args) {
		String input = "target area: x=235..259, y=-118..-62";
		String[] x = input.substring(input.indexOf("x=") + 2, input.indexOf(",")).split("\\..");
		String[] y = input.substring(input.indexOf("y=") + 2).split("\\..");
		int xMin = Integer.parseInt(x[0]);
		int xMax = Integer.parseInt(x[1]);
		int yMin = Integer.parseInt(y[0]);
		int yMax = Integer.parseInt(y[1]);
		findVal(xMin, xMax, yMin, yMax);
	}
	
	
	public static void findVal(int xMin, int yMin, int xMax, int yMax) {
		int maxXV = yMin; 
		int minYV = xMax;						
		int minXV = (int) Math.ceil((-1 + Math.sqrt(1 + 8 * xMin)) / 2);
		//this is some weird equation that I found called Gauss sum formula, which according to wikipedia is used for predicting trajectories									
		int maxYV = (Math.abs(yMin) - 1);
		int count = 0;
		for (int x = minXV; x <= maxXV; x++) {
			for (int y = minYV; y <= maxYV; y++) {
				if (launch(x, y, xMin, xMax, yMin, yMax) == true) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

	public static boolean launch(int x, int y, int xMin, int yMin, int xMax, int yMax) {
		int x2 = 0;
		int y2 = 0;
		while ((x2 <= xMax) && (y2 >= yMin)) {
			x2 += x;
			y2 += y;
			if (x > 0) {
				x--;
			}
			y--;
			if (x2 >= xMin && x2 <= xMax && y2 >= yMin && y2 <= yMax) {
				return true;
			}
		}
		return false;
}
}
