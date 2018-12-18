package SearchingAlgorithms;

import java.util.Scanner;

/**
* Given a sorted array of distinct elements, and the array is rotated at an unknown position. Find minimum element in the array.
**/
public class LowestElementInRotatedArray{
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
	    int t = in.nextInt();
	    while(t-- > 0){
	        int n = in.nextInt();
	        int[] arr = new int[n];
	        for(int i = 0;i < n;i++){
	            arr[i] = in.nextInt();
	        }
	        int i = findMin(arr,0, n - 1);
	        if(i != -1){
	        	System.out.println(arr[i]);
	        }
	    }
	}
	public static int findMin(int[] arr,int l, int r){
		//Can solve using binary search
		int m;
		while(r >= l){
			//When r and l are equal, then we have probably found the element
			if( l == r )
            	return l;
			m = l + (r-l)/2;
			if(arr[m] > arr[r]){
				//It falls in the first quad
				l = m + 1;
			}else{
				//It falls in the second quad
				r = m;
			}
		}
		return -1;
	}
}