import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import java.util.Arrays;
import java.util.Comparator;

//An immutable data type representing a 3D point.
public class Point3D implements Comparable<Point3D> {
	private final double x; // x coordinate
	private final double y; // y coordinate
	private final double z; // z coordinate

	// Construct a point in 3D given its coordinates.
	public Point3D(double x, double y, double z) {
		this.x = x;
		this.y = y;
		this.z = z;
	}

	// The Euclidean distance between this point and that.
	public double distance(Point3D that) {
		double dist = 0;
		dist = Math.sqrt(((this.x - that.x) * (this.x - that.x))
				+ ((this.y - that.y) * (this.y - that.y))
				+ ((this.z - that.z) * (this.z - that.z)));
		return dist;
	}

	// -1, 0, or 1 depending on this point's Euclidean distance
	// to the origin is less than, equal to, or greater than that point's
	// Euclidean distance to the origin, where the origin is (0, 0, 0).
	public int compareTo(Point3D that) {
		Point3D origin = new Point3D(0, 0, 0);
		if (this.distance(origin) > that.distance(origin)) {
			return 1;
		}
		if (this.distance(origin) < that.distance(origin)) {
			return -1;
		}
		return 0;
	}

	// Compare points based on their x-coordinates.
	public static class xOrder implements Comparator<Point3D> {
		// -1, 0, or 1 depending on whether p1's x-coordinate
		// is less than, equal to, or greater than p2's x-coordinate.
		public int compare(Point3D p1, Point3D p2) {
			if (p1.x < p2.x) {
				return -1;
			}
			if (p1.x > p2.x) {
				return 1;
			}
			return 0;
		}
	}

	// Compare points based on their y-coordinates.
	public static class yOrder implements Comparator<Point3D> {
		// -1, 0, or 1 depending on whether p1's y-coordinate
		// is less than, equal to, or greater than p2's y-coordinate.
		public int compare(Point3D p1, Point3D p2) {
			if (p1.y < p2.y) {
				return -1;
			}
			if (p1.y > p2.y) {
				return 1;
			}
			return 0;
		}
	}

	// Compare points based on their z-coordinates.
	public static class zOrder implements Comparator<Point3D> {
		// -1, 0, or 1 depending on whether p1's z-coordinate
		// is less than, equal to, or greater than p2's z-coordinate.
		public int compare(Point3D p1, Point3D p2) {
			if (p1.z < p2.z) {
				return -1;
			}
			if (p1.z > p2.z) {
				return 1;
			}
			return 0;
		}
	}

	// A string representation of the point, as "(x, y, z)".
	public String toString() {
		return "(" + x + ", " + y + ", " + z + ")";
	}
    
    // Test client. [DO NOT EDIT]
    public static void main(String[] args) {
        int n = StdIn.readInt();
        Point3D[] points = new Point3D[n];
        for (int i = 0; i < n; i++) {
            double x = StdIn.readDouble();
            double y = StdIn.readDouble();
            double z = StdIn.readDouble();
            points[i] = new Point3D(x, y, z);
        }
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points);
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, new Point3D.xOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, new Point3D.yOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
        Arrays.sort(points, new Point3D.zOrder());
        for (Point3D point : points) {
            StdOut.println(point);
        }
    }
}
