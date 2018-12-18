//$Id$
package trees;

/**
 * https://www.geeksforgeeks.org/find-distance-between-two-nodes-of-a-binary-tree/
 * https://www.geeksforgeeks.org/shortest-distance-between-two-nodes-in-bst/
 * @author gokul-4406
 *
 */
public class DistanceBetweenNodes {
	class Node{
	   int data;
	   Node left, right;
	   Node(int item){
        data = item;
        left = right = null;
	   }
	}
	static int d1 = -1 , d2 = -1 , dist = 0;
	static int level(Node root, int n, int lvl){
		if(root == null) return -1;
		if(root.data == n) return lvl;
		int l = level(root.left, n, lvl + 1);
		return (l == -1) ? level(root.right, n, lvl + 1) : l;
	}
	static Node findLCA(Node node, int n1, int n2, int level){
		if(node == null) return null;
		//The node n1 is found. So return the node
		if(node.data == n1){
			d1 = level;
			return node;
		}
		//The node n1 is found. So return the node
		if(node.data == n2){
			d2 = level;
			return node;
		}
		//Node is not found. So, search for them in left and right trees
		Node left_lca = findLCA(node.left, n1, n2, level + 1);
		Node right_lca = findLCA(node.right, n1, n2, level +1);
		
		if(left_lca != null && right_lca != null){
			//It has found both nodes in left and right subtrees
			//So both d1 & d2 would have been found
			//This indicates that the current node is the lca
			dist = d1 + d2 - 2 * level;
			return node;
		}
		return (left_lca != null) ? left_lca : right_lca;
	}
	static int distance(Node node, int n1, int n2){
		d1 = -1 ;
		d2 = -1 ;
		dist = 0;
		Node lca = findLCA(node, n1, n2, 0);
		if(d1 != -1 && d2 != -1){
			//Which implies that we have found the lcs and also he respective distances from root
			return dist;
		}
		//Found Members at the root itself
		if(d1 != -1){
			//d2 is -1 here. Which implies that d2 has not been calculated
			dist = level(lca, n2, 0);
			return dist;
		}
		if(d2 != -1){
			dist = level(lca, n1, 0);
			return dist;
		}
		return -1;
	}
}
