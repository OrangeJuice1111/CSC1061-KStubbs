package edu.frcc.csc1060j.Exam2;

import java.io.File;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;

public class FileTree implements Iterable<FileNode> {

	private FileNode root;

	public FileTree(String path) {
		root = new FileNode(path);
		buildTree(root);
	}

	/**
	 * Return a depth first post-order traversal iterator
	 */
	@Override
	public Iterator<FileNode> iterator() {

		return new DepthFirstIterator();
	}

	/**
	 * TODO for Exam 2 Use recursion to build the tree from the directory structure.
	 * For each of node starting from the root node use listFiles() from File to get
	 * the list of files in that directory/folder. Create a node for each of the
	 * files and add it to a list of child nodes for the node Do this recursively
	 * for all the nodes.
	 * 
	 * @param fileNode
	 */
	private void buildTree(FileNode fileNode) {
		File file = fileNode.getFile();
		File[] files = file.listFiles();
				if (files != null) {
			for (File f : files) {
				FileNode childNode = new FileNode(f);
				fileNode.getChildNodes().add(childNode);
				buildTree(childNode);
			}
		}

	}

	/**
	 * TODO for Exam 2 Iterator that does a post order traversal of the tree. For
	 * post-order traversal use the 2 stack approach outlined here:
	 * https://www.geeksforgeeks.org/iterative-postorder-traversal/
	 * 
	 * @return
	 */
	private class DepthFirstIterator implements Iterator<FileNode> {
		private Deque<FileNode> stack = new ArrayDeque<>();
		private FileNode last = null;

		public DepthFirstIterator() {
				if (root != null) {
				stack.push(root);
			}
		}

		@Override
		public boolean hasNext() {
			return !stack.isEmpty();
		}

		@Override
		public FileNode next() {
			while (hasNext()) {
				FileNode current = stack.peek();

				ArrayList<FileNode> children = current.getChildNodes();

				if (children.isEmpty() || (last != null && children.contains(last))) {
					last = stack.pop();
					return last;
				} else {
						for (int i = children.size() - 1; i >= 0; i--) {
						stack.push(children.get(i));
					}
				}
			}
			return null;
		}
	}

	/**
	 * Returns an iterator that does a breadth first traversal of the tree using a
	 * queue.
	 * 
	 * @return
	 */
	public Iterator<FileNode> breadthFirstIterator() {

		return new BreadthFirstIterator();

	}

	/**
	 * TODO for Exam 2 Iterator that does a breadth first traversal of the tree
	 * using a queue.
	 * 
	 */
	private class BreadthFirstIterator implements Iterator<FileNode> {
		private Deque<FileNode> deque = new ArrayDeque<>();

		public BreadthFirstIterator() {
			if (root != null) {
				deque.offerLast(root);
			}
		}

		@Override
		public boolean hasNext() {
			return !deque.isEmpty();
		}

		@Override
		public FileNode next() {
			FileNode current = deque.pollFirst(); 

			for (FileNode child : current.getChildNodes()) {
				deque.offerLast(child); 
			}

			return current;
		}
	}
}
