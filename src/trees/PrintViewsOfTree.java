//$Id$
package trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Vector;

import trees.PrintViewsOfTree.Node;

public class PrintViewsOfTree {
	public static class Node{
		int data;
		Node left;
		Node right;
		public Node(int data){
			this.data = data;
			left = null;
			right= null;
		}
	}
	Node root;
	static int max_level = 0;
    void rightView(Node node) {
        rightView(node,1);
    }
    void rightView(Node node, int currLvl){
        if(node == null){
            return;
        }
        if(currLvl > max_level){
            System.out.print(node.data+" ");
            max_level = currLvl;
        }
        rightView(node.right,currLvl + 1);
        rightView(node.left,currLvl + 1);
    }
    void leftView(Node node){
    	leftView(node, 1);
    }
    void leftView(Node node , int currLvl){
    	if(node == null){
    		return;
    	}
    	if(max_level < currLvl){
    		System.out.print(node.data+" ");
    		max_level = currLvl;
    	}
    	leftView(node.left, currLvl + 1);
    	leftView(node.right, currLvl + 1);
    }
    void printTopView(Node node){
    	class QueueObj{
    		Node node;
    		int hd;
    		public QueueObj(Node node, int hd) {
    			this.node = node;
    			this.hd = hd;
			}
    	}
    	Queue<QueueObj> queue = new LinkedList<QueueObj>();
    	Map<Integer, Node> hdMap = new HashMap<Integer, PrintViewsOfTree.Node>();
    	if(node != null){
    		queue.add(new QueueObj(node,0));
    	}else{
    		return;
    	}
    	while(!queue.isEmpty()){
    		QueueObj q = queue.poll();
    		Node temp = q.node;
    		int d = q.hd;
    		if(!hdMap.containsKey(d)){
    			hdMap.put(d, temp);
    		}
    		if(temp.left != null){
    			queue.add(new QueueObj(temp.left, d - 1));
    		}
    		if(temp.right != null){
    			queue.add(new QueueObj(temp.right, d + 1));
    		}
    	}
    	for(int i = 0; i < hdMap.size();i++){
    		System.out.println(hdMap.get(i).data);
    	}
    }
    /**
     * It is an alteration of top view code
     * @param node
     */
    void printVerticalOrder(Node node){
    	class QueueObj{
    		Node node;
    		int hd;
    		public QueueObj(Node node, int hd) {
    			this.node = node;
    			this.hd = hd;
			}
    	}
    	Queue<QueueObj> queue = new LinkedList<QueueObj>();
    	Map<Integer, Vector<Node>> hdMap = new TreeMap<Integer, Vector<Node>>();
    	if(node != null){
    		queue.add(new QueueObj(node,0));
    	}else{
    		return;
    	}
    	while(!queue.isEmpty()){
    		QueueObj q = queue.poll();
    		Node temp = q.node;
    		int d = q.hd;
    		if(!hdMap.containsKey(d)){
    			Vector<Node> v = new Vector<Node>();
    			v.add(temp);    			
    			hdMap.put(d, v);
    		}else{
    			Vector<Node> v = new Vector<Node>();
    			v.addAll(hdMap.get(d));
    			v.add(temp);
    			hdMap.put(d, v);
    		}
    		if(temp.left != null){
    			queue.add(new QueueObj(temp.left, d - 1));
    		}
    		if(temp.right != null){
    			queue.add(new QueueObj(temp.right, d + 1));
    		}
    	}
    }
    static void verticalOrder(Node node){
    	int hd = 0;
    	Map<Integer, Vector<Node>> hdMap = new TreeMap<Integer, Vector<Node>>();
    	verticalOrderUtil(node, 0, hdMap);
    }
    static void verticalOrderUtil(Node node, int hd, Map<Integer, Vector<Node>> hdMap){
    	Vector<Node> v = hdMap.get(hd);
    	if(v == null){
    		v = new Vector<Node>();
    		v.add(node);
    	}else{
    		v.add(node);
    	}
    	hdMap.put(hd, v);
    	verticalOrderUtil(node.left, hd - 1, hdMap);
    	verticalOrderUtil(node.right, hd + 1, hdMap);
    }
//    public static void main(String args[]) { 
//    	PrintViewsOfTree tree = new PrintViewsOfTree(); 
//        tree.root = new Node(1); 
//        tree.root.left = new Node(2); 
//        tree.root.right = new Node(3); 
//        tree.root.left.left = new Node(4); 
//        tree.root.left.right = new Node(5); 
//        tree.root.right.left = new Node(6); 
//        tree.root.right.right = new Node(7); 
//        tree.root.right.left.right = new Node(8); 
//          
//        tree.rightView(tree.root); 
//  
//        }
    public static void main(String[] args)
    {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0)
		{	int n=Integer.parseInt(sc.next());
		Node root=null;
			if(n==1)
			{
				int a=sc.nextInt();
				System.out.println(a);
				continue;
			}
			else
			{	
		while(n-->0){
				int n1=Integer.parseInt(sc.next());
				int n2=Integer.parseInt(sc.next());
				char lr=sc.next().charAt(0);
				if(root==null)
				{
					root=new Node(n1);
					switch(lr)
					{
						case 'L':
						root.left=new Node(n2);
						break;
						case 'R':
						root.right=new Node(n2);
						break;
					}
				}
				else{
					RightViewBT.insert(root,n1,n2,lr);
				}
			}
			}
			PrintViewsOfTree tree = new PrintViewsOfTree();
			tree.printTopView(root);
			System.out.println();
		}
	}
}
class RightViewBT{
	public static void insert(Node root,int n1,int n2,char lr){
		if(root==null)
			return;
		if(root.data==n1){
		switch(lr)
					{
						case 'L':
						root.left=new Node(n2);
						break;
						case 'R':
						root.right=new Node(n2);
						break;
					}
		}
		else{
			insert(root.left,n1,n2,lr);
			insert(root.right,n1,n2,lr);
		}
	}
	}
