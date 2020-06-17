/**
 * By @author Vasim Shaikh
 * on
 * 16-Jun-2020 at 1:42:58 pm
 */
package com.vms.cctech.problems.second;

import java.util.ArrayList;

import com.vms.cctech.problems.second.CalculateLengthFunction.CreatedPoint;

public class CalculateLengthDriver {
	
	private static CalculateLengthFunction obj;

	public static void main(String[] args) {

		ArrayList<CreatedPoint[]> Buildings = new ArrayList<CreatedPoint[]>();
		CreatedPoint building1[]= { new CreatedPoint(4,0), new CreatedPoint(4, -5), new CreatedPoint(7,-5),
				new CreatedPoint(7,0) };
		
		Buildings.add(building1);
		CreatedPoint lightSource = new CreatedPoint(1, 1);
		obj = new CalculateLengthFunction();
		int length = obj.totalExposedToLight(Buildings,lightSource);
	}

}
