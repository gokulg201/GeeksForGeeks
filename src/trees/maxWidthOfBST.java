//$Id$
package trees;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://www.geeksforgeeks.org/maximum-width-of-a-binary-tree/
 * @author gokul-4406
 *
 */
public class maxWidthOfBST {
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
	int getWidth(Node root, int level){
		if(root == null){
			return 0;
		}else if(level == 1){
			return 1;
		}else{
			return getWidth(root.left, level - 1) + getWidth(root.right, level - 1);
		}
	}
	void getMaxWidth(Node root){
		int maxWidth = 0;
		int width = 0;
		int h = height(root);
		for (int i = 1; i <= h; i++)  
        { 
            width = getWidth(root, i); 
            if (width > maxWidth) 
                maxWidth = width; 
        } 
	}
	int height(Node node){
		if(node == null){
			return 0;
		}
		int lHeight = height(node.left);
		int rheight = height(node.right);
		return 1 + Math.max(lHeight, rheight);
	}
	//==============================Approach2==============================//
	/*
	 * Using a Queue to keep track of each level. Level Order traversal
	 */
	int maxWidth(Node root){
		if(root == null){
			return 0;
		}
		int maxCount = 0;
		Queue<Node> q = new LinkedList<maxWidthOfBST.Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			int count = q.size();
			if(maxCount < count){
				maxCount = count;
			}
			while(count-- > 0){
				Node temp = q.remove();
				if(temp.left != null){
					q.add(temp.left);
				}
				if(temp.right != null){
					q.add(temp.right);
				}
			}
			
		}
		return maxCount;
	}
}
