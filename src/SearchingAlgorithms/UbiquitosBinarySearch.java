package SearchingAlgorithms;

/**
 * https://www.geeksforgeeks.org/the-ubiquitous-binary-search-set-1/
 * This algorihtm is an optimised version of Binary Search thereby reducing the no of comparions required 
 * in binary search
 * @author gokul-4406
 *
 */
class UbiquitosBinarySearch{
	/**
	* This is normal Binary Search algorithm
	* Time Complexity O(log N)
	**/
	int binarySearch(int[] arr, int l, int r,int key){
		int m;
		while(l <= r){
			m = l +(r-l)/2;
			if(arr[m] == key)
				return m;
			if(key < arr[m]){ // If key is in the left tree
				r = m - 1;
			}else{//If key is in the right tree
				l = m + 1;
			}
		}
		return -1;
	}
	

}