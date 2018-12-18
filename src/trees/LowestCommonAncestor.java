//$Id$
package trees;

/**
 * https://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * https://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
 * @author gokul-4406
 *
 */
public class LowestCommonAncestor {
	class Node{
	   int data;
	   Node left, right;
	   Node(int item){
        data = item;
        left = right = null;
	   }
	}
	Node lca(Node node, int a , int b){
		if(node == null) return null;
		if(node.data < a && node.data < b){
			//Go to right
			return lca(node.right, a, b);
		}else if(node.data > a && node.data > b){
			//Go to left
			return lca(node.left, a, b);
		}else{
			return node;
		}
	}
	static boolean _a = false;
	static boolean _b = false;
	/**
	 * Traverse from root to all nodes . If anyone of the node is found retyurn that node as lca.
	 * Now for a node get bot left and right lca and check if both are not null.Then the current node is the lca .
	 * Else one of the nodes is the lca.(based on assumption that both nodes are present in the tree). to ensure we are maintaining status for nodes found
	 * If at the end both nodes are found we can return the result else, one node is not found in tree, so return null
	 * @param node
	 * @param a
	 * @param b
	 * @return
	 */
	Node lca_1(Node node , int a , int b){
		Node lca = lowestCommonAncestor(node, a, b);
		if(_a && _b)
			return lca;
		return null;
	}
	Node lowestCommonAncestor(Node node, int a , int b){
		if(node == null){
			return null;
		}
		Node temp = null;
		//If we meet any one of the nodes then return it;
		if(node.data == a){
			_a = true;
			temp = node;
		}
		if(node.data == b){
			_b = true;
			temp = node;
		}
		Node left_Lca = lowestCommonAncestor(node.left, a, b);
		Node right_Lca = lowestCommonAncestor(node.right, a, b);
		//this is called here since the above 2 lines will be executed so all the nodes will be traversed.Now if both the nodes are found then,
		//bith the statuses will be set
		if(temp != null){
			return temp;
		}
		//If both lca's have not returned null then this node is the LCAs
		if(left_Lca !=  null && right_Lca != null){
			return node;
		}
		//If anyone of the lca's is null then both the nodes are in the same subtree. So the node that comes first forms the lca
		return left_Lca == null ? right_Lca : left_Lca; 
	}
}
