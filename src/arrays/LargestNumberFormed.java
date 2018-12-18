//$Id$
package arrays;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


/**
 * Problem Statement:
 * Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. 
 * And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 * 
 * Reference:
 * https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
 * 
 * @author gokul-4406
 *
 */
public class LargestNumberFormed {
	/*
	 * Approach 1:
	 * We can have a customised comparator to compare the numbers in a way such that,
	 * given two numbers X and Y, we can form 2 numbers XY and YX and compare them.
	 * If XY is larger then X comes first, if YX is larger then Y comes first
	 * 
	 * Time Complexity:
	 * Space Complexity:
	 * 
	 * Approach 2:
	 * Get the length of the highest number.
	 * Convert all digits to n + 1 length by appending 0s
	 * Now sort, and select numbers based on non-increasing sorting order
	 * 
	 * Time complexity:
	 * Space Complexity:
	 * 
	 */
	public static void approach1(String[] arr){
		List<String> list = new ArrayList<String>();
		for(String a:arr){
			list.add(a);
		}
		Collections.sort(list, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return -Integer.compare(Integer.parseInt(o1+o2), Integer.parseInt(o2+o1));//- is added because an iterator iterates in a non-decreasing order.but we need non-increasing order
			}
		});
		Iterator<String> it = list.iterator(); 
	    while(it.hasNext()) {
	        System.out.print(it.next()); 
	    } 
	}
	public static void main(String[] args){
		String[] arr = {"3","30","34","5","9"};
		approach1(arr);
	}
}
