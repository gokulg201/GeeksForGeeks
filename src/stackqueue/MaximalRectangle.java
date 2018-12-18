//$Id$
package stackqueue;

import java.util.Stack;

public class MaximalRectangle {
	private static int maxRectangleArea(int[][] matrix){
		int row = matrix.length;
		int col = matrix[0].length;
		//Need to create a matrix representing heights like in a histogram at each level(row)
		int area ;
		area = maxArea(matrix[0], col);
		for(int i = 1 ;i < row;i++){
			for(int j = 0 ;j < col;j++){
				//If the base is 1 then we have to sum up the height of the bar
				if(matrix[i][j] ==  1){
					matrix[i][j] = matrix[i][j] + matrix[i - 1][j];
				}
			}
			int currentArea = maxArea(matrix[i],col);
			if(currentArea > area){
				area = currentArea;
			}
		}
		return area;
	}
	/*
	* Same as largest rectangle in a histogram
	*/
	private static int maxArea(int[] hist, int n){
		int index_Top , max_area = Integer.MIN_VALUE , currentArea = 0;
		Stack<Integer> s = new Stack<Integer>();
		int i = 0;
		while(i < n){
			if(s.isEmpty() || hist[i] > hist[s.peek()]){
				s.push(i++);
			}else{
				index_Top = s.pop();
				currentArea = hist[index_Top] * (s.isEmpty() ? i : (i - s.peek() -1));
			}
			if(max_area < currentArea){
				max_area = currentArea;
			}
		}
		while(!s.isEmpty()){
			index_Top = s.pop();
			currentArea = hist[index_Top] * (s.isEmpty() ? i : (i - s.peek() -1));
			if(max_area < currentArea){
				max_area = currentArea;
			}
		}
		return max_area;
	}
}
