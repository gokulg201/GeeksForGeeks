package trees;

/**
* https://www.hackerrank.com/challenges/is-binary-search-tree/problem?utm_campaign=challenge-recommendation&utm_medium=email&utm_source=24-hour-campaign
* Reference : https://www.geeksforgeeks.org/a-program-to-check-if-a-binary-tree-is-bst-or-not/
**/
public class CheckForBST{
	public static void main(String[] args){
		CheckForBST tree = new CheckForBST();
		tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3);
        if(tree.checkBST_traversal(tree.root)){
        	System.out.println("Tree is BST");
        }else{
        	System.out.println("Tree is not a BST");
        }
	}
	static class Node {
        int data;
        Node left;
        Node right;
        public Node(int item) 
        { 
            data = item; 
            left = right = null; 
        } 
    }
	//Method 1
	//Correct but inefficient
    boolean checkBST(Node root) {
        //Base case check
        if(root == null){
        	return true;
        }
        return checkLeft(root.left, root.data) && checkRight(root.right, root.data);
    }
    boolean checkLeft(Node root, int data){
        if(root == null) return true;
        if(root.data >= data){
            return false;
        }
        return checkLeft(root.right,data) && checkLeft(root.left, root.data)  && checkRight(root.right, root.data);
    }
    boolean checkRight(Node root, int data){
        if(root == null) return true;
        if(root.data <= data){
            return false;
        }
        return checkRight(root.left, data) && checkLeft(root.left,root.data) && checkRight(root.right, root.data) ;
    }
    /* Method 2
     * Set a min and max value
     * If it is a left subtree every element in the left subtree should be less than the max element and greater than the min element
     */
    boolean checkBST(Node node ,int min,int max){
    	if(node == null) return true;
    	if(node.data > min || node.data < max){
    		return false;
    	}
    	return checkBST(node.left, min, node.data) && checkBST(node.right, node.data, max);
    }
    /* Method 3
     * Correct and efficient
     * Time Complexity : O(n)
     * Algo : 
     * Traverse the tree in inorder traversal and compare the current node with the previous node.
     * if(currentNode.data <= prevNode.data) return false; It is not a BST 
     * if(currentNode.data > prevNode.data) return false; It is a BST
     * Similar to something like checking if the numbers in an array are in ascending order sorted 
     */
    Node root;
    Node prev;
    boolean checkBST_traversal(Node node){
    	if(node == null)
    		return true;
    	if(!checkBST_traversal(node.left))
    		return false;
    	if(prev != null && node.data <= prev.data)
    		return false;
    	prev = node;
    	if(!checkBST_traversal(node.right))
    		return false;
    	return true;
    }
}