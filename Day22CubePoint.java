package days;

import java.util.ArrayList;

public class Day22CubePoint {

	private int x1;
	private int x2;
	private int y1;
	private int y2;
	private int z1;
	private int z2;
	private boolean isOn;

	public Day22CubePoint(String in) {
		isOn = in.startsWith("on");
		String[] coords = in.substring(in.indexOf(" ") + 1).split(",");
		String[] xs = coords[0].replace("x=", "").split("\\..");
		String[] ys = coords[1].replace("y=", "").split("\\..");
		String[] zs = coords[2].replace("z=", "").split("\\..");
		x1 = toInt(xs[0]);
		x2 = toInt(xs[1]);
		y1 = toInt(ys[0]);
		y2 = toInt(ys[1]);
		z1 = toInt(zs[0]);
		z2 = toInt(zs[1]);
	}

	public Day22CubePoint(int x1, int x2, int y1, int y2, int z1, int z2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
		this.z1 = z1;
		this.z2 = z2;
		isOn = true;
	}

	public ArrayList<Day22CubePoint> findParts(Day22CubePoint c) {
		Day22CubePoint top = null, bottom = null, right = null, left = null, back = null, front = null;
		if (y2 > c.y2) {
			top = new Day22CubePoint(x1, x2, c.y2 + 1, y2, z1, z2);
		}
		if (y1 < c.y1) {
			bottom = new Day22CubePoint(x1, x2, y1, c.y1 - 1, z1, z2);
		}
		if (x2 > c.x2) {
			right = new Day22CubePoint(c.x2 + 1, x2, (bottom != null ? bottom.y2 + 1 : y1), (top != null ? top.y1 - 1 : y2), z1, z2);
		}
		if (x1 < c.x1) {
			left = new Day22CubePoint(x1, c.x1 - 1, (bottom != null ? bottom.y2 + 1 : y1), (top != null ? top.y1 - 1 : y2), z1, z2);
		}
		if (z2 > c.z2) {
			back = new Day22CubePoint((left != null ? left.x2 + 1 : x1), (right != null ? right.x1 - 1 : x2),
					(bottom != null ? bottom.y2 + 1 : y1), (top != null ? top.y1 - 1 : y2), c.z2 + 1, z2);
		}
		if (z1 < c.z1) {
			front = new Day22CubePoint((left != null ? left.x2 + 1 : x1), (right != null ? right.x1 - 1 : x2),
					(bottom != null ? bottom.y2 + 1 : y1), (top != null ? top.y1 - 1 : y2), z1, c.z1 - 1);
		}

		ArrayList<Day22CubePoint> parts = new ArrayList<Day22CubePoint>();
		if (top != null)
			parts.add(top);
		if (bottom != null)
			parts.add(bottom);
		if (right != null)
			parts.add(right);
		if (left != null)
			parts.add(left);
		if (back != null)
			parts.add(back);
		if (front != null)
			parts.add(front);
		return parts;
	}

	public ArrayList<Day22CubePoint> getParts(Day22CubePoint c) {
		ArrayList<Day22CubePoint> parts = new ArrayList<Day22CubePoint>();
		if (!overlap(c)) {
			parts.add(this);
			return parts;
		}
		parts.addAll(findParts(c));
		return parts;
	}

	public boolean overlap(Day22CubePoint c) {
		if (x1 > c.x2 || x2 < c.x1)
			return false;
		if (y1 > c.y2 || y2 < c.y1)
			return false;
		if (z1 > c.z2 || z2 < c.z1)
			return false;
		return true;
	}

	public long size() {
		return (x2 - x1 + 1L) * (y2 - y1 + 1L) * (z2 - z1 + 1L);
	}

	private int toInt(String s) {
		return Integer.parseInt(s);
	}

	public int getX1() {
		return x1;
	}

	public int getX2() {
		return x2;
	}

	public int getY1() {
		return y1;
	}

	public int getY2() {
		return y2;
	}

	public int getZ1() {
		return z1;
	}

	public int getZ2() {
		return z2;
	}

	public boolean isOn() {
		return isOn;
	}

	public boolean initCube() {
		return (x1 >= -50 && x2 <= 50 && y1 >= -50 && y2 <= 50 && z1 >= -50 && z2 <= 50);
	}
}
