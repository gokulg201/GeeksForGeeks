//$Id$
package graphs;

import java.util.Stack;

/**
 * https://www.geeksforgeeks.org/floyd-warshall-algorithm-dp-16/
 * https://www.youtube.com/watch?v=LwJdNfdLF9s
 * @author gokul-4406
 * This algorithm is used to find the shortest distance between vertice pairs in a weighted graph(directed/undirected).
 * This algorithm also used to detect negative weighted cycle in a graph(Bellman-Ford algorithm also used for the same purpose)
 * Time Complexity is O(n^3) n-> No of vertices
 */
public class FloydWarshall {
	static final int INF = 100000;
	static int[][] floydWarshall(int[][] graph){
		int[][] distance = new int[graph.length][graph.length];
		int[][] path = new int[graph.length][graph.length];
		//Populating distance and path arrays
		for(int i = 0;i < graph.length;i++){
			for(int j = 0 ;j < graph.length;j++){
				distance[i][j] = graph[i][j];
				if(distance[i][j] != INF && i!=j){
					path[i][j] = i;
				}else{
					path[i][j] = -1;
				}
			}
		}
		for(int k = 0 ; k < graph.length;k++){
			for(int i = 0;i < graph.length;i++){
				for(int j = 0 ;j < graph.length;j++){
					if(distance[i][k] == INF || distance[k][j] == INF)
						continue;
					if(distance[i][j] > distance[i][k] + distance[k][j]){
						distance[i][j] = distance[i][k] + distance[k][j];
						path[i][j] = path[k][j];
					}
				}
			}	
		}
		path(path, 1, 2);
		//look for negative weight cycle in the graph
        //if values on diagonal of distance matrix is negative
        //then there is negative weight cycle in the graph.
        for(int i = 0; i < distance.length; i++) {
            if(distance[i][i] < 0) {
//                throw new NegativeWeightCycleException();
            	//This shows that there is negative weight cycle
            }
        }

		return distance;
	}
	static void path(int[][] path, int _v1, int _v2){
		if(_v1 == 0 || _v2 ==0 || _v1 >= path.length || _v2 >= path.length){
			return ;
		}
		Stack<Integer> traversed = new Stack<Integer>();
		traversed.add(_v2);
		while(true){
			_v2 = path[_v1][_v2];
			//This means no path
			if(_v2 == -1){
				return;
			}
			traversed.add(_v2);
			//Reached the start vertex
			if(_v2 == _v1){
				break;
			}
		}
		while(!traversed.isEmpty()){
			System.out.println(traversed.pop()+" ");
		}
	}
	static void minimumDistance(int _v1, int _v2,int[][] graph){
		int[][] distance = floydWarshall(graph);
		System.out.println("Minimum path between "+_v1+" and "+_v2+" is "+distance[_v1][_v2]);
	}
	public static void main(String[] args){
		int[][] graph = {
                {0,   3,   6,   15},
                {INF, 0,  -2,   INF},
                {INF, INF, 0,   2},
                {1,   INF, INF, 0}
        };
		minimumDistance(1, 2, graph);
	}
}
