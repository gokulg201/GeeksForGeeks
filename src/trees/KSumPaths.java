//$Id$
package trees;

import java.util.LinkedList;
import java.util.Vector;

public class KSumPaths {
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
	public static void printKPathUtil(Node node,int k,Vector<Node> path){
		if(node == null){
			return ;
		}
		path.add(node);
		
		printKPathUtil(node.left, k, path);
		
		printKPathUtil(node.right, k, path);
		
		int sum = 0;
		for(int j = path.size()-1; j>=0;j--){
			sum = sum + path.get(j).data;
			if(sum == k){
				printPath(path,j);
			}
		}
		path.remove(node);
	}
	public static void printPath(Vector<Node> path, int j){
		int i = path.size() - 1;
		while(j <= i){
			System.out.print(path.get(j).data+" ");
			j++;
		}
		System.out.println();
	}
	public static void main(String[] args){
		Node root = new Node(1);
		root.left = new Node(3);
		root.left.left = new Node(2);
		root.left.right = new Node(1);
		root.left.right.left = new Node(1);
		root.right = new Node(-1);
		root.right.left = new Node(4);
		root.right.left.left = new Node(1);
		root.right.left.right = new Node(2);
		root.right.right = new Node(5);
		root.right.right.right = new Node(2);
		
		int k = 5;
		printKPathUtil(root, k, new Vector<KSumPaths.Node>());
	}
}
