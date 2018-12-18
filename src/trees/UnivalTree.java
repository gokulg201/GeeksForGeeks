//$Id$
package trees;

/**
 * Problem Statement:
 * Given a binary tree, write a program to count the number of Single Valued Subtrees. 
 * A Single Valued Subtree is one in which all the nodes have same value. Expected time complexity is O(n).
 * 
 * Example:
 * Input: root of below tree
              5
             / \
            1   5
           / \   \
          5   5   5
 * Output: 4
 * There are 4 subtrees with single values. 
 * Input: root of below tree 
	              5
	             / \
	            4   5
	           / \   \
	          4   4   5                
 * Output: 5
 * There are five subtrees with single values.
 * 
 * Reference:
 * https://www.geeksforgeeks.org/find-count-of-singly-subtrees/
 * @author gokul-4406
 *
 */
public class UnivalTree {
	/*
	 * A unival tree is a tree in which all of its elements are same. An empty tree also forms an unival tree
	 */
	class Node{
		int data;
		Node left;
		Node right;
		Node(int data){
			this.data = data;
		}
	}
	class Count{
		int count = 0;
	}
	Node root;
	Count ct = new Count();
	public boolean count(Node root,Count c){
		//If we have reached a null node then it is a unival tree by definition
		if(root == null){
			return true;
		}
		//Check if left subtree is unival tree and also get the count
		boolean leftTree_isUnival = count(root.left, c); 
		//Check if right subtree is unival tree and also get the count
		boolean rightTree_isUnival = count(root.right, c);
		//If its subtrees are not unival then tree with root cannot also be unival
		if(leftTree_isUnival == false || rightTree_isUnival ==  false){
			return false;
		}
		//Check for left and right child of root 
		if(root.left != null && root.left.data != root.data){
			return false;
		}
		if(root.right != null && root.right.data != root.data){
			return false;
		}
		//Increment the count by one since the tree with root is a unival tree, so including the root i.e., count + 1
		c.count++;
		return true;
	}
	public static void main(String[] args){
		UnivalTree tree = new UnivalTree(); 
        tree.root = tree.new Node(5); 
        tree.root.left = tree.new Node(4); 
        tree.root.right = tree.new Node(5); 
        tree.root.left.left = tree.new Node(4); 
        tree.root.left.right = tree.new Node(4); 
        tree.root.right.right = tree.new Node(5); 
	}
}
