//$Id$
package SearchingAlgorithms;

/**
 * Given a sorted array with possible duplicate elements. Find number of occurrences of input ‘key’ in log N time.
 * 
 * @author gokul-4406
 *
 */
public class OccurencesOfElement {
	public static void solve(int[] arr,int key){
		int firstOuccurence = floor(arr, 0, arr.length-1, key), lastOccurence = ceil(arr, 0, arr.length - 1, key);
		if(arr[firstOuccurence] == key && arr[lastOccurence] == key){
			System.out.println(lastOccurence - firstOuccurence +1);
		}
		
	}
	public static int ceil(int[] arr, int l, int r,int key){
		int m;
		while(r - l >1){
			m = l + (r -l)/2;
			if(arr[m]>= key){
				r = m;
			}else{
				l = m;
			}
		}
		return r;
	}
	public static int floor(int[] arr, int l, int r,int key){
		int m;
		while(r - l >1){
			m = l + (r -l)/2;
			if(arr[m]<= key){
				l = m;
			}else{
				r = m;
			}
		}
		return l;
	}
}
