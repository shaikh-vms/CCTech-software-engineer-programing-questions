/**
 * By @author Vasim Shaikh
 * on
 * 16-Jun-2020 at 12:49:24 am
 */
package com.vms.cctech.problems;

public class PointInPolygonCheckFunction {
	static int EXTREME_RIGHT = Integer.MAX_VALUE;
	static class CreatedPoint{
		double x;
		double y;

		public CreatedPoint(double x, double y) {
			this.x = x;
			this.y = y;
		}
	}

	boolean isInside(CreatedPoint polygon[], int n, CreatedPoint pointToCheck) {
		if (n < 3) {
			return false;
		}
		CreatedPoint extreme = new CreatedPoint(EXTREME_RIGHT, pointToCheck.y);
		// Count intersections of the above line with sides of polygon
		int count = 0, i = 0;

		do {
			int next = (i + 1) % n;

			// Check if the line segment from point to its extreme intersects with the line
			if (isIntersects(polygon[i], polygon[next], pointToCheck, extreme)) {

				// cheking for point on any edge of polygon
				if (orientation(polygon[i], pointToCheck, polygon[next]) == 0) {
					return isOnSegment(polygon[i], pointToCheck, polygon[next]);
				}

				count++;
			}
			i = next;
		} while (i != 0);

		return (count % 2 == 1);
	}

	/* function to check if given point m lies between point l and point r */
	boolean isOnSegment(CreatedPoint l, CreatedPoint m, CreatedPoint r) {
		double max_x = (l.x > r.x) ? l.x : r.x;
		double min_x = (l.x < r.x) ? l.x : r.x;
		double max_y = (l.y > r.y) ? l.y : r.y;
		double min_y = (l.y < r.y) ? l.y : r.y;
		
		//can be done using Math.max and Math.min but instructions are of NO USE OF BUILT-IN FUNCTION

		if (m.x <= max_x && m.x >= min_x && m.y <= max_y && m.y >= min_y) {
			return true;
		}
		return false;
	}

	// --------------------------------ORIENTATION
	/*
	 * Checking for orientation of given points as argument and co-linearity The
	 * function returns: 0 if given points are colinear 1 for Clockwise 2 for
	 * Counterclockwise
	 * 
	 * formula derived using slope concept of line which at end gives sign which can
	 * be used to determine orientation
	 */
	static int orientation(CreatedPoint p, CreatedPoint q, CreatedPoint r) {
		int result = (int) ((q.y - p.y) * (r.x - q.x) - (q.x - p.x) * (r.y - q.y));

		if (result == 0) {// co-linear
			return 0;
		}
		return (result > 0) ? 1 : 2; // clock/counterclock wise
	}

	// -------------------------------check for intersection
	boolean isIntersects(CreatedPoint p1, CreatedPoint p2, CreatedPoint p3, CreatedPoint p4) {

		int o1 = orientation(p1, p2, p3);
		int o2 = orientation(p1, p2, p4);
		int o3 = orientation(p3, p4, p1);
		int o4 = orientation(p3, p4, p2);

		/*
		 * General case i.e. if (p1p2p3) and (p1p2p4) have different orientation and
		 * (p3p4p1),(p3p4p2) have diffrent orientation
		 */
		if (o1 != o2 && o3 != o4) {
			return true;
		}

		// Special Cases
		// p1, p3 and p2 are colinear and
		// p2 lies on segment p1p2
		if (o1 == 0 && isOnSegment(p1, p3, p2)) {
			return true;
		}
		

		// p1, p4 and p2 are colinear and
		// p4 lies on segment p1p2
		if (o2 == 0 && isOnSegment(p1, p4, p2)) {
			return true;
		}

		// p3, p1 and p4 are colinear and
		// p1 lies on segment p3p4
		if (o3 == 0 && isOnSegment(p3, p1, p4)) {
			return true;
		}
		// p3, p2 and p4 are colinear and
		// p2 lies on segment p3p4
		if (o4 == 0 && isOnSegment(p3, p2, p4)) {
			return true;
		}

		return false;
	}

}
