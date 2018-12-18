//$Id$
package string;

import java.util.Arrays;

public class ZigZagConcatentation {
	static String printZigZagConcatenation(String str,int n){
		if(n == 1){
			return str;
		}
		String[] arr = new String[n];
		Arrays.fill(arr, "");
		int row = 0;
		boolean down = true;
		for(int i = 0;i < str.length();i++){
			arr[row] += str.charAt(i);
			if(row == n-1){
				down = false;
			}
			if(row == 0){
				down = true;
			}
			if(down){
				row++;
			}else{
				row--;
			}
		}
		String result ="";
		for(String s : arr){
			result+=s;
		}
		return result;
	}
	public static void main(String[] args){
		System.out.println(printZigZagConcatenation("GEEKSFORGEEKS", 3));
	}
}
