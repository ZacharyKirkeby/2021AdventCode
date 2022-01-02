package days;

public class Day17{

	
	public static void main(String[]args) {
		String input = "target area: x=235..259, y=-118..-62";
		String[] x = input.substring(input.indexOf("x=") + 2, input.indexOf(",")).split("\\..");
		String[] y = input.substring(input.indexOf("y=") + 2).split("\\..");
		int xMin = Integer.parseInt(x[0]);
		int xMax = Integer.parseInt(x[1]);
		int yMin = Integer.parseInt(y[0]);
		int yMax = Integer.parseInt(y[1]);
		maxYPos(xMin,xMax,yMin,yMax);
	}

	public static void maxYPos(int xMin, int xMax, int yMin, int yMax) {
		int maxYPosition = (Math.abs(yMin) - 1) * (Math.abs(yMin)) / 2;
		System.out.println(maxYPosition);
	}

}