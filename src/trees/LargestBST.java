//$Id$
package trees;

/**
 * Problem Statement:
 * Given a Binary Tree, write a function that returns the size of the largest subtree which is also a Binary Search Tree (BST). If the complete Binary Tree is BST, then return the size of whole tree.
 * Examples:
 * Input: 
	      5
	    /  \
	   2    4
	 /  \
	1    3

 * Output: 3 
 * The following subtree is the maximum size BST subtree 
	   2  
	 /  \
	1    3

 * Input: 
	       50
	     /    \
	  30       60
	 /  \     /  \ 
	5   20   45    70
	              /  \
	            65    80
 * Output: 5
 * The following subtree is the maximum size BST subtree 
	      60
	     /  \ 
	   45    70
	        /  \
	      65    80
 * @author gokul-4406
 */
public class LargestBST {
	Node root;
	static class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	static class Value{
		int size = 0;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		boolean isBST = false;
	}
	public Value largestBSTUtil(Node root,Value val){
		if(root == null){
			val.isBST = true;
			return val;
		}
		Value leftSubtree = largestBSTUtil(root.left, new Value());
		Value rightSubtree = largestBSTUtil(root.right, new Value());

		//Checking for positive case. i.e., Both left & rigth subtrees are BSTs and are not null
		if(leftSubtree.isBST && rightSubtree.isBST && leftSubtree.max < root.data && rightSubtree.min > root.data){
			val.isBST = true;
			//Including the current node(root)
			val.size = leftSubtree.size + rightSubtree.size + 1; 
			/*Note: If it is the leaf node, then the size will be 1 since both left & right size will be 0*/
			if(root.left != null && root.right != null){
				val.min = leftSubtree.min;
				val.max = rightSubtree.max;
			}else{
				//If both are left and right are null, then it is a leaf node.
				//So min and max will be the node itself

				//If left is null, then min is the node itself
				if(root.left == null){
					val.min = root.data;
				}else{
					val.min = leftSubtree.min;
				}
				if(root.right == null){
					val.max = root.data;
				}else{
					val.max = rightSubtree.max;
				}
			}
			return val;
		}else{
			//Negative case. i.e., either of the left or right subtree is not a BST
			val.isBST = false;
			val.size = Math.max(leftSubtree.size,rightSubtree.size);
			return val;
		}
	}
	public int largestBST(Node root){
		Value value = new Value();
		largestBSTUtil(root, value);
		return value.size;
	}
	public static void main(String[] args){
		LargestBST tree = new LargestBST();
		tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
//        tree.root = new Node(50); 
//        tree.root.left = new Node(10); 
//        tree.root.right = new Node(60); 
//        tree.root.left.left = new Node(5); 
//        tree.root.left.right = new Node(20); 
//        tree.root.right.left = new Node(55); 
//        tree.root.right.left.left = new Node(45); 
//        tree.root.right.right = new Node(70); 
//        tree.root.right.right.left = new Node(65); 
//        tree.root.right.right.right = new Node(80); 
        System.out.println("Size of largest BST is " + tree.largestBST(tree.root)); 
	}
}
