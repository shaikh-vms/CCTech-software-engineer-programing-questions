/**
 * By @author Vasim Shaikh
 * on
 * 16-Jun-2020 at 1:46:35 am
 */
package com.vms.cctech.problems;

import com.vms.cctech.problems.PointInPolygonCheckFunction.CreatedPoint;

public class PointInPolygonCheckDriver {

	private static CreatedPoint pointToCheck;
	private static PointInPolygonCheckFunction obj;

	public static void main(String[] args) {
		obj = new PointInPolygonCheckFunction();
		CreatedPoint polygon1[] = { new CreatedPoint(1, 0), new CreatedPoint(8, 3), new CreatedPoint(8, 8),
				new CreatedPoint(1, 5) };

		pointToCheck = new CreatedPoint(3, 5);
		System.out.println(obj.isInside(polygon1, pointToCheck));

		CreatedPoint polygon2[] = { new CreatedPoint(-3, 2), new CreatedPoint(-2, -0.8), new CreatedPoint(0, 1.2),
				new CreatedPoint(2.2, 0), new CreatedPoint(2, 4.5) };
		pointToCheck = new CreatedPoint(0, 0);
		System.out.println(obj.isInside(polygon2, pointToCheck));
	}

}
