//$Id$
package trees;

import java.util.Vector;


public class PathFromRootOfSpecifiedSum {
	static class Node {
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data = data;
			left = null;
			right = null;
		}
	}
	public static void printPath(Vector<Node> path){
		int i = path.size() - 1;
		while(i >= 0){
			System.out.print(path.get(i).data+" ");
			i--;
		}
		System.out.println();
	}
	public static void printKPathUtil(Node node,int k,int sumSoFar,Vector<Node> path){
		if(node == null){
			return;
		}
		sumSoFar += node.data;
		path.add(node);
		
		if(sumSoFar == k){
			printPath(path);
		}else if(sumSoFar > k){
			path.remove(node);
			return;
		}
		printKPathUtil(node.left, k, sumSoFar, path);
		
		printKPathUtil(node.right, k, sumSoFar, path);
		
		path.remove(node);
	}
	public static void printKDistant(Node root, int k){
		if(root == null){
			return ;
		}
		if(k == 0){
			System.out.print(root.data + " ");
			return;
		}
		printKDistant(root.left, k-1);
		printKDistant(root.right, k-1);
	}
	public static void main(String[] args){
		Node root  = new Node(10); 
	    root.left  = new Node(28); 
	    root.right = new Node(13); 
	  
	    root.right.left   = new Node(14); 
	    root.right.right  = new Node(15); 
	  
	    root.right.left.left   = new Node(21); 
	    root.right.left.right  = new Node(22); 
	    root.right.right.left  = new Node(23); 
	    root.right.right.right = new Node(24); 
	    
	    int sum = 38;
	    printKPathUtil(root, sum, 0, new Vector<PathFromRootOfSpecifiedSum.Node>());
	}
}
