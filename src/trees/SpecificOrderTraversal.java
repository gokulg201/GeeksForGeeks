//$Id$
package trees;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class SpecificOrderTraversal {
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
	 * https://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal/
	 */
	void topDownTraversal(Node root){
		if(root == null){
			return;
		}
		System.out.print(root.data+" ");
		if(root.left != null){
			System.out.print(root.left.data+" "+root.right.data+" ");
		}
		if(root.left.left == null){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root.left);
		q.add(root.right);
		Node first = null;
	    Node second = null;
		while(!q.isEmpty()){
			first = q.remove();
			second = q.remove();
			System.out.print(first.left.data+" "+second.right.data+" ");
			System.out.print(first.right.data+" "+second.left.data+" ");
			if(first.left.left != null){
				q.add(first.left);
				q.add(second.right);
				q.add(first.right);
				q.add(second.left);
			}
		}
	}
	/**
	 * https://www.geeksforgeeks.org/perfect-binary-tree-specific-level-order-traversal-set-2/
	 */
	void bottomUpApproach(Node root){

		if(root == null){
			return;
		}
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(root.data);
		if(root.left != null){
			stack.push(root.left.data);
			stack.push(root.right.data);
		}
		if(root.left.left == null){
			return;
		}
		Queue<Node> q = new LinkedList<Node>();
		q.add(root.left);
		q.add(root.right);
		Node first = null;
	    Node second = null;
		while(!q.isEmpty()){
			first = q.remove();
			second = q.remove();
			stack.push(first.left.data);
			stack.push(second.right.data);
			stack.push(first.right.data);
			stack.push(second.left.data);
			if(first.left.left != null){
				q.add(first.left);
				q.add(second.right);
				q.add(first.right);
				q.add(second.left);
			}
		}
		for(Integer d : stack){
			System.out.print(d+" ");
		}
	}
}
