package edu.frcc.csc1060j.MyTreeSet;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class MyTreeSet<E extends Comparable<E>> implements Set<E> {
	private Node root = null;
	private int size = 0;
	private List<Node> path = new ArrayList<>();

	private class Node {
		protected E data;
		protected Node lChild;
		protected Node rChild;
		protected int height;

		public Node(E data) {
			this.data = data;

		}
	}

	public int getTreeHeight() {
		return root.height;
	}

	@Override
	public int size() {

		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<E> iterator() {
		
		return new InOrderRecursive();
	}
	
	private class InOrderRecursive implements Iterator<E>{
		private Queue<E> queue = new ArrayDeque<E>();
		
		public InOrderRecursive() {
			inorder(root);
		}
		
		private void inorder(Node node) {
			if(node == null) {
				return;
			}
			
			inorder(node.lChild);
			queue.add(node.data);
			inorder(node.rChild);
		}

		@Override
		public boolean hasNext() {
			return !queue.isEmpty();
		}

		@Override
		public E next() {
			return queue.remove();
		}
		
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean add(E data) {
		if (root == null) {
			root = new Node(data);
			size++;
			path.clear();
			return true;
		}

		Node current = root;
		Node parent = null;
		while (current != null) {
			path.add(current);
			if (data.compareTo(current.data) < 0) {
				parent = current;
				current = current.lChild;

			} else if (data.compareTo(current.data) > 0) {
				parent = current;
				current = current.rChild;
			} else {
				return false;
			}
		}

		Node newNode = new Node(data);
		if (data.compareTo(parent.data) < 0) {
			parent.lChild = newNode;
		} else {
			parent.rChild = newNode;
		}

		size++;

		balancePath();

		return true;
	}

	private void updateHeight(Node node) {
		// leaf node
		if (node.lChild == null && node.rChild == null) {
			node.height = 0;
		} else if (node.lChild == null) {
			node.height = node.rChild.height + 1;
		} else if (node.rChild == null) {
			node.height = node.lChild.height + 1;
		} else {
			node.height = Math.max(node.lChild.height, node.rChild.height) + 1;
		}
	}

	private int balanceFactor(Node node) {
		int balanceFactor = 0;
		if(node.rChild == null && node.lChild == null) {
			return 0;
		}
		if(node.rChild == null) {
			balanceFactor = (-1) - node.lChild.height;
		}
		else if(node.lChild == null) {
			balanceFactor = node.rChild.height - (-1);
		}
		else {
			balanceFactor = node.rChild.height - node.lChild.height;
		}
		return balanceFactor;
	}
	private void balancePath() {
		for (int i = path.size() - 1; i >= 0; i--) {
			Node current = path.get(i);
			updateHeight(current);

			Node parent = null;
			if (i > 0) {
				parent = path.get(i - 1);
			}
			
			int balanceFactor = balanceFactor(current);
			switch(balanceFactor) {
				case -2:
					if(balanceFactor(current.lChild) <= 0) {
					//Left Left Imbalance
						balanceLL(current, parent);
					}
					else {
						//Left Right Imbalance
						balanceLR(current, parent);
					}
					break;
				case 2:
					if(balanceFactor(current.rChild) >= 0) {
						balanceRR(current, parent);
						//Right Right Imbalance
					}
					else {
						balanceRL(current, parent);
						//Right Left Imbalance
					}
					break;
			}
		
		}
	}

	private void balanceRL(Node node, Node parent) {
		// TODO Auto-generated method stub
		
	}

	private void balanceRR(Node node, Node parent) {
		// TODO Auto-generated method stub
		
	}

	private void balanceLL(Node node, Node parent) {
		Node ggp = parent;
		Node gp = node;
		Node par = node.lChild; 
	
		if(gp == root) {
			root = par;
			
		}else {
			if(ggp.lChild == gp) {
				ggp.lChild = par;
			}
			else {
				ggp.rChild = par;
			}
		}
		gp.lChild = par.rChild;
		par.rChild = gp;
		
		updateHeight(par.lChild);
		updateHeight(gp);
		updateHeight(par);
		
	}
	
	private void balanceLR(Node node, Node parent) {
		Node ggp = parent;
		Node gp = node;
		Node par = node.lChild;
		Node ch = par.rChild;
		
		if(gp == root) {
			root = ch;
		}
		else {
			if(ggp.lChild == gp) {
				ggp.lChild = ch;
			}
			else {
				ggp.rChild = ch;
			}
		}
		par.rChild = ch.lChild;
		gp.lChild = ch.rChild;
		
		ch.lChild = par;
		ch.rChild = gp;
		
		updateHeight(gp);
		updateHeight(par);
		updateHeight(ch);
	}
	
	
	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub

	}

}
