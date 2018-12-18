//$Id$
package trees;


/**
 * https://www.geeksforgeeks.org/add-greater-values-every-node-given-bst/
 * @author gokul-4406
 *
 */
public class ModifyBST {
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
	static int sum = 0;
	void modifyBSTUtil(Node node){
		if(node == null){
			return;
		}
		modifyBSTUtil(node.right);
		
		sum = sum + node.data;
		node.data = sum;
		
		modifyBSTUtil(node.left);
	}
}
