//$Id$
package trees;


/**
 * https://www.geeksforgeeks.org/root-to-leaf-path-sum-equal-to-a-given-number/
 * @author gokul-4406
 *
 */
public class HasPathSum {
	static class Node  
	{ 
	    int data; 
	    Node left, right; 
	   
	    Node(int item)  
	    { 
	        data = item; 
	        left = right = null; 
	    } 
	} 
	boolean hasPathSum(Node root, int k){
		if(root == null){
			return false;
		}
		boolean ans = false;
		k = k - root.data;
		if(k == 0 && root.left == null && root.right == null){
			return true;
		}
		if(root.left != null){
			ans = ans || hasPathSum(root.left, k);
		}
		if(root.right != null){
			ans = ans || hasPathSum(root.right, k);
		}
		return ans;
	}
}
