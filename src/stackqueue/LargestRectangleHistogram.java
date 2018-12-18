//$Id$
package stackqueue;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.
 * Problem : https://leetcode.com/problems/largest-rectangle-in-histogram/description/
 * 
 * Complexity Analysis:
 * Time Complexity O(2n)
 * Space Complexity O(n)
 * 
 * Reference:
 * https://www.youtube.com/watch?v=ZmnqCZp9bBs
 * https://www.youtube.com/watch?v=RVIh0snn4Qc
 * https://github.com/mission-peace/interview/blob/master/src/com/interview/stackqueue/MaximumHistogram.java
 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
 * @author gokul-4406
 *
 */
public class LargestRectangleHistogram {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int size = in.nextInt();
		int[] heights = new int[size];
		for(int i = 0; i < size ;i++){
			heights[i] = in.nextInt();
		}
		Solution s = new Solution();
		System.out.println(s.largestRectangleArea(heights));
	}
}
class Solution {
    public int largestRectangleArea(int[] heights) {
        int max = 0;
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0, top ,area ;
        while(i < heights.length){
            if(stack.isEmpty() || heights[stack.peek()] <= heights[i]){
            	stack.push(i++);
            }else{
            	top = stack.pop();
            	 //if stack is empty means everything till i has to be
                //greater or equal to input[top] so get area by
                //input[top] * i;
            	if(stack.isEmpty()){
            		area = heights[top] * i;
            	}
            	//if stack is not empty then everythin from i-1 to input.peek() + 1
                //has to be greater or equal to input[top]
                //so area = input[top]*(i - stack.peek() - 1);
            	else{
            		area = heights[top] * (i - 1 - stack.peek());
            	}
            	if(max < area){
        			max = area;
        		}
            }
        }
        //Get into this loop if i is already upyo end but stack has some elements left in it 
        while(!stack.isEmpty()){
        	top = stack.pop();
        	 //if stack is empty means everything till i has to be
            //greater or equal to input[top] so get area by
            //input[top] * i;
        	if(stack.isEmpty()){
        		area = heights[top] * i;
        	}
        	//if stack is not empty then everythin from i-1 to input.peek() + 1
            //has to be greater or equal to input[top]
            //so area = input[top]*(i - stack.peek() - 1);
        	else{
        		area = heights[top] * (i - 1 - stack.peek());
        	}
        	if(max < area){
    			max = area;
    		}
        }
        return max;
    }
}