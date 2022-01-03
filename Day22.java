package days;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;

public class Day22{

	public static void main(String[]args) {
		ArrayList<Day22CubePoint> input;
		Scanner reader = null;
		try {
			reader = new Scanner(new File("inputDay22.txt"));
		} catch (Exception e) {
			System.out.println("file not found");
		}

		input = new ArrayList<Day22CubePoint>();
		while (reader.hasNext()) {
			input.add(new Day22CubePoint(reader.nextLine()));
		}
		reader.close();
		
		howManyOn(input);
	}

	public static void howManyOn(ArrayList<Day22CubePoint> input) {
		long on = runInst(true, input);
		System.out.println(on); //part 1
		on = runInst(false, input);
		System.out.println(on); //part 2
	}

	public static long runInst(boolean init, ArrayList<Day22CubePoint> input) {
		ArrayList<Day22CubePoint> lit = new ArrayList<Day22CubePoint>();
		lit.add(input.get(0));
		for (int r = 1; r < input.size(); r++) {
			Day22CubePoint instruction = input.get(r);
			if (init && !instruction.initCube()) {
				continue;
			}
			ArrayList<Day22CubePoint> newLit = new ArrayList<Day22CubePoint>();
			for (int i = 0; i < lit.size(); i++) {
				ArrayList<Day22CubePoint> parts = lit.get(i).getParts(instruction);
				newLit.addAll(parts);
			}
			if (instruction.isOn()) {
				newLit.add(instruction);
			}
			lit = newLit;
		}
		long ans = 0;
		for (Day22CubePoint cuboid : lit) {
			ans += cuboid.size();
		}
		return ans;
	}

}