//$Id$
package graphs;

import graphs.Graph.Edge;
import graphs.Graph.Vertex;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.geeksforgeeks.org/detect-negative-cycle-graph-bellman-ford/
 * https://www.geeksforgeeks.org/bellman-ford-algorithm-dp-23/
 * Algorithm to determine if a graph(wieghted/directed) has negative weight cycle
 * Complexity Analysis
 * Time Complexity O(VE)
 * Space Complexity O(V)
 * @author gokul-4406
 *
 */
public class BellmanFord<T> {
	private static final int INF = Integer.MAX_VALUE; 
	public Map<Vertex<T>, Integer> singleSourceShortestPath(Graph<T> graph, Vertex<T> source){
		Map<Vertex<T>, Vertex<T>> parentMap = new HashMap<Graph.Vertex<T>, Graph.Vertex<T>>();
		Map<Vertex<T>, Integer> distance = new HashMap<Graph.Vertex<T>, Integer>();
		for(Vertex<T> vertex:graph.getAllVertex()){
			distance.put(vertex, INF);
			parentMap.put(vertex, null);
		}
		distance.put(source, 0);
		
		for(int i = 0 ;i < graph.getAllVertex().size() - 1; i++){
			for(Edge<T> edge:graph.getAllEdges()){
				Vertex<T> from = edge.getVertex1();
				Vertex<T> to = edge.getVertex2();
				if(distance.get(to) > (distance.get(from) + edge.getWeight())){
					distance.put(to, distance.get(from) + edge.getWeight());
					parentMap.put(to, from);
				}
			}
		}
		//Finding negative cycle
		//If the value of the distance reduces after V-1 iterations then there tends to exist a negative weighted cyce in the graph
		for(Edge<T> edge:graph.getAllEdges()){
			Vertex<T> from = edge.getVertex1();
			Vertex<T> to = edge.getVertex2();
			if(distance.get(to) > (distance.get(from) + edge.getWeight())){
				throw new NegativeWeightException();
			}
		}
		return distance;
	}
	public static void main(String[] args){
		Graph<Integer> graph = new Graph<>(false);
        graph.addEdge(0, 3, 8);
        graph.addEdge(0, 1, 4);
        graph.addEdge(0, 2, 5);
        graph.addEdge(1, 2, -3);
        graph.addEdge(2, 4, 4);
        graph.addEdge(3, 4, 2);
        graph.addEdge(4, 3, 1);

        BellmanFord<Integer> shortestPath = new BellmanFord<Integer>();
        Vertex<Integer> startVertex = graph.getAllVertex().iterator().next();
        Map<Vertex<Integer>,Integer> distance = shortestPath.singleSourceShortestPath(graph, startVertex);
        System.out.println(distance);
	}
}
class NegativeWeightException extends RuntimeException{
	
}