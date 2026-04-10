package edu.frcc.csc1060j.MyGraph;

public class GraphTest {

	public static void main(String[] args) {

		Graph<Integer, Integer> graph = new Graph<>();
		
		graph.addVertex(Integer.valueOf(0));
		graph.addVertex(1);
		graph.addVertex(2);
		graph.addVertex(3);
		graph.addVertex(4);
		graph.addVertex(5);
		
		Integer[][] edges = {
				{0, 1, 5}, {0, 2, 6},
				{1, 0, 5}, {1,2,2},{1,5,3},
				{2,0,6},{2,1,2},{2,5,4},{2,3,10},
				{3,2,10},{3,5,9},{3,4,7},
				{4,3,7},{4,5,8},
				{5,1,3},{5,2,4},{5,3,9},{5,4,8}
		};
		
		for(Integer[] edge : edges) {
			graph.addEdge(edge[0],edge[1],edge[2]);
		}
		graph.printGraph();
	}

}
