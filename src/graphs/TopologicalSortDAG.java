//$Id$
package graphs;

import graphs.Graph.Vertex;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * This algortihm sorts the vertices based on the no of incoming edges in a Directed Acyclic Graph(DAG)
 * Given a directed acyclic graph, do a topological sort on this graph.
 *
 * Do DFS by keeping visited. Put the vertex which are completely explored into a stack.
 * Pop from stack to get sorted order.
 *
 * Space and time complexity is O(n).
 * @author gokul-4406
 *
 */
public class TopologicalSortDAG<T> {
	public Stack<Vertex<T>> topologicalSort(Graph<T> graph){
		Set<Vertex<T>> visited = new HashSet<Graph.Vertex<T>>();
		Stack<Vertex<T>> sortedVertices = new Stack<Graph.Vertex<T>>();
		for(Vertex<T> vertex:graph.getAllVertex()){
			if(visited.contains(vertex)){
				continue;
			}
			topologicalSortUtil(vertex, visited, sortedVertices);
		}
		return sortedVertices;
	}
	private void topologicalSortUtil(Vertex<T> vertex, Set<Vertex<T>> visited, Stack<Vertex<T>> sortedVertices){
		if(visited.contains(vertex))
			return;
		visited.add(vertex);
		for(Vertex<T> adjacent:vertex.getAdjacentVertices()){
			topologicalSortUtil(adjacent, visited, sortedVertices);
		}
		sortedVertices.add(vertex);
	}
	public static void main(String args[]){
        Graph<Integer> graph = new Graph<>(true);
        graph.addEdge(1, 3);
        graph.addEdge(1, 2);
        graph.addEdge(3, 4);
        graph.addEdge(5, 6);
        graph.addEdge(6, 3);
        graph.addEdge(3, 8);
        graph.addEdge(8, 11);
        
        TopologicalSortDAG<Integer> sort = new TopologicalSortDAG<Integer>();
        Stack<Vertex<Integer>> result = sort.topologicalSort(graph);
        while(!result.isEmpty()){
            System.out.println(result.pop().id);
        }
    }
}
