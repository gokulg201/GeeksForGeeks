//$Id$
package trees;

import java.util.LinkedList;
import java.util.Queue;

import trees.maxWidthOfBST.Node;

public class LevelOrderTraversal {
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
	//==============================Approach1==============================//
	int height(Node node){
		if(node == null){
			return 0;
		}
		int lHeight = height(node.left);
		int rheight = height(node.right);
		return 1 + Math.max(lHeight, rheight);
	}
	void printLevelOrderTraversal(Node root){
		 int h = height(root); 
         int i; 
         for (i=1; i<=h; i++) 
        	 printLevel(root, i); 
	}
	void printLevel(Node node, int level){
		if(node == null){
			return;
		}
		if(level == 1){
			System.out.print(node.data+ " ");
		}else if(level > 1){
			printLevel(node.left, level-1);
			printLevel(node.right, level-1);
		}
	}
	//==============================Approach2==============================//
	/*
	 * Using queue 
	 */
	void printLevelOrder_1(Node root){
		if(root == null){
			return;
		}
		Queue<Node> q = new LinkedList<LevelOrderTraversal.Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			Node temp = q.remove();
			System.out.print(temp.data + " ");
			if(temp.left != null){
				q.add(temp.left);
			}
			if(temp.right != null){
				q.add(temp.right);
			}
		}
	}
}
