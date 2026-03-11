package edu.frcc.csc1060j.MyBookTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

public class MyBookTree implements Iterable<MyBookNode>{

	private MyBookNode root;
	
	public MyBookTree(String title) {
		root = new MyBookNode(title, 0, 0, 0);
	}
	
	//chapter node
	public boolean addBookNode(String title, int chapNum, int secNum, int subSecNum) {
		MyBookNode node = new MyBookNode(title, chapNum, secNum, subSecNum);
		
		if (secNum == 0) {
			root.getChildNodes().add(node);
			Collections.sort(root.getChildNodes());
			return true;
		}
		//sectio node
		if(subSecNum == 0) {
			for(MyBookNode chap : root.getChildNodes()) {
				if(chap.getChapNum() == chapNum) {
					chap.getChildNodes().add(node);
					Collections.sort(chap.getChildNodes());
					return true;
				}
			}
		}
		//subsection node
		for(MyBookNode chap : root.getChildNodes()) {
			if(chap.getChapNum() == chapNum) {
				for(MyBookNode sec : chap.getChildNodes()) {
					if(sec.getSecNum() == secNum) {
						sec.getChildNodes().add(node);
						Collections.sort(sec.getChildNodes());
						return true;
					}
				}
			}
		}
		return false;
	}

	@Override
	public Iterator<MyBookNode> iterator() {
		return new RecursiveIterator();
	}
	
	private class RecursiveIterator implements Iterator<MyBookNode>{
		Deque<MyBookNode> queue = new ArrayDeque<MyBookNode>();
		
		public RecursiveIterator() {
			preorder(root);
		}
		
		private void preorder(MyBookNode node) {
			queue.add(node);
			
			if(node.getChildNodes() == null || node.getChildNodes().isEmpty()) {
				return;
			}
			for(MyBookNode child : node.getChildNodes()) {
				preorder(child);
			}
		}

		@Override
		public boolean hasNext() {
			
			return !queue.isEmpty();
		}

		@Override
		public MyBookNode next() {
			// TODO Auto-generated method stub
			return queue.removeFirst();
		}
	}
	private class MyBookIterator implements Iterator<MyBookNode> {
		Deque<MyBookNode> stack;
		
		public MyBookIterator() {
			stack = new ArrayDeque<>();
			stack.push(root);
		}
		@Override
		public boolean hasNext() {
			if (!stack.isEmpty()) {
				return true;
			}
			return false;
		}

		@Override
		public MyBookNode next() {
			MyBookNode node = stack.pop();
			
			List<MyBookNode> children = node.getChildNodes();
			
			//we cant modify the original list so make a copy
			List<MyBookNode> copy = new ArrayList<>(children);
			
			//reverse the copy list
			Collections.reverse(copy);
			
			for(MyBookNode child : copy) {
				stack.push(child);
			}
			return node;
			
		}
		
	}
	
	
}
