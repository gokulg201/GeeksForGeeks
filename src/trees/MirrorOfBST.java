package trees;

/**
 * https://www.geeksforgeeks.org/write-an-efficient-c-function-to-convert-a-tree-into-its-mirror-tree/
 * @author gokul-4406
 *
 */
public class MirrorOfBST{
	class Node 
	{ 
	    int data; 
	    Node left, right; 
	  
	    public Node(int item) 
	    { 
	        data = item; 
	        left = right = null; 
	    } 
	} 
	public Node mirror(Node root){
		if(root == null){
			return root;	
		}
		Node left = mirror(root.left);
		Node right = mirror(root.right);

		root.left = right;
		root.right = left;
		return root;
	}
	public boolean areMirror(Node n1, Node n2){
		if(n1 == null && n2 == null){
			return true;
		}
		if(n1 == null || n2 == null){
			return false;
		}
		return n1.data == n2.data && areMirror(n1.left, n2.right) && areMirror(n1.right, n2.left);
	}
}