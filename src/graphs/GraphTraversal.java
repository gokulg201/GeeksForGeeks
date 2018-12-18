//$Id$
package graphs;

import graphs.Graph.Vertex;

import java.util.HashSet;
import java.util.LinkedList;

/**
 * https://www.youtube.com/watch?v=zaBhtODEL0w&t=541s
 * @author gokul-4406
 *
 */
public class GraphTraversal {
	/**
	 * Complexity Analysis:
	 * Time Complexity O(n) - as it has to traverse atmost all the vertices once
	 * @param source
	 * @param destination
	 * @param visited
	 * @return
	 */
	public boolean hasPathDFS(Vertex<Integer> source, Vertex<Integer> destination, HashSet<Vertex<Integer>> visited){
		if(visited.contains(source))
			return false;
		visited.add(source);
		if(source.equals(destination))
			return true;
		for(Vertex<Integer> adjacent : source.adjacentVertices){
			if(hasPathDFS(adjacent, destination, visited)){
				return true;
			}
		}
		return false;
	}
	/**
	 * Complexity Analysis:
	 * Time Complexity O(n) - as it has to traverse atmost all the vertices once
	 * @param source
	 * @param destination
	 * @return
	 */
	public boolean hasPathBFS(Vertex<Integer> source, Vertex<Integer> destination){
		HashSet<Vertex<Integer>> visited = new HashSet<Graph.Vertex<Integer>>();
		LinkedList<Vertex<Integer>> nextToVisit = new LinkedList<Graph.Vertex<Integer>>();
		nextToVisit.add(source);
		while(!nextToVisit.isEmpty()){
			if(visited.contains(source))
				continue;
			visited.add(source);
			if(source.equals(destination))
				return true;
			for(Vertex<Integer> adjacent : source.adjacentVertices){
				nextToVisit.add(adjacent);
			}
		}
		return false;
	}
}
