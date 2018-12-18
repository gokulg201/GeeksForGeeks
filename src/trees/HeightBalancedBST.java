//$Id$
package trees;


public class HeightBalancedBST {
	class Node  
	{ 
	    int data; 
	    Node left, right; 
	   
	    Node(int item)  
	    { 
	        data = item; 
	        left = right = null; 
	    } 
	} 
	/**
	 * https://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
	 * @return
	 */
	boolean isBalanced(Node root){
		if(root == null){
			return true;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		if(Math.abs(lh - rh) <= 1 && isBalanced(root.left) && isBalanced(root.right)){
			return true;
		}
		return false;
	}
	int height(Node root){
		if(root == null){
			return 0;
		}
		int lh = height(root.left);
		int rh = height(root.right);
		return 1 + Math.max(lh,rh);
	}
	//=========Approach 2=================//
	class Height{
		int height;
	}
	boolean isBalanced(Node root, Height height){
		if(root == null){
			height.height = 0;
			return true;
		}
		Height lheight = new Height();
		Height rheight = new Height();
		boolean l = isBalanced(root.left, lheight );
		boolean r = isBalanced(root.right, rheight );
		int lh = lheight.height;
		int rh = rheight.height;
		height.height = 1 + Math.max(lh, rh);
		
		if(l && r && Math.abs(lh - rh) <= 1){
			return true;
		}
		return false;
	}
}
