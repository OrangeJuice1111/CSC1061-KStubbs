package edu.frcc.csc1060j.MyGraph;

import java.util.ArrayList;
import java.util.List;

public class Graph<K, E> {// K for key on vertex, E for weight on vertex

	private List<Vertex> vertices = new ArrayList<>();

	private class Vertex {
		protected K key;
		protected List<Edge> neighbors = new ArrayList<>();

		public Vertex(K key) {
			this.key = key;
		}

		@Override
		public String toString() {
			return key.toString();
		}

		@SuppressWarnings("unchecked")
		@Override
		public boolean equals(Object other) {
			if (other == null || !(other instanceof Graph.Vertex)) {
				return false;
			}
			if (key.equals(((Vertex) other).key)) {
				return true;
			}
			return false;
		}
	}

	private class Edge {
		protected E data;// the weight on the edge
		protected Vertex src;
		protected Vertex dst;

		@Override
		public boolean equals(Object other) {
			if (other == null || !(other instanceof Graph.Edge)) {
				return false;
			}
			Edge oEdge = (Edge) other;
			if (src.equals(oEdge.src) && dst.equals(oEdge.dst)) {
				return true;
			}
			return false;
		}
	}

	public boolean addVertex(K key) {
		Vertex newVertex = new Vertex(key);
		if (vertices.contains(newVertex)) {
			return false;
		}
		vertices.add(newVertex);
		return true;
	}

	public boolean addEdge(K src, K dst, E edgeData) {
		Edge newEdge = new Edge();
		newEdge.src = findVertex(src);
		newEdge.dst = findVertex(dst);
		newEdge.data = edgeData;
		if (newEdge.src.neighbors.contains(newEdge)) {
			return false;
		}
		newEdge.src.neighbors.add(newEdge);
		return true;
	}

	private Vertex findVertex(K key) {
		int indexOfVertex = vertices.indexOf(new Vertex(key));
		if (indexOfVertex < 0) {
			return null;
		}
		return vertices.get(indexOfVertex);
	}

	private Edge findEdge(K src, K dst) {
		Vertex srcVertex = findVertex(src);
		Vertex dstVertex = findVertex(dst);
		if (srcVertex == null || dstVertex == null) {
			return null;
		}
		Edge edge = new Edge();
		edge.src = srcVertex;
		edge.dst = dstVertex;
		int indexOfEdge = srcVertex.neighbors.indexOf(edge);
		if (indexOfEdge < 0) {
			return null;
		}
		return srcVertex.neighbors.get(indexOfEdge);
	}

	public void printGraph() {
		for (int i = 0; i < vertices.size(); i++) {
			Vertex curVertex = vertices.get(i);
			System.out.print("Vertex: " + curVertex + ":");
			List<Edge> neighbors = curVertex.neighbors;
			for (Edge edge : neighbors) {
				System.out.print("(" + edge.src + ", " + edge.dst + ", " + edge.data + ")");

			}
			System.out.println();
		}
	}

}
