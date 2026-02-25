package edu.frcc.csc1061j.PlaylistManager;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyDoubleLinkedList<E> implements List<E> {

	private Node head = null;
	private Node tail = null;
	private int size = 0;

	private class Node {
		public E data;
		public Node next;
		public Node prev;

		public Node(E data) {
			this.data = data;
			this.next = next;
			this.prev = prev;
		}
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
		if(indexOf(o) >= 0) {
			return true;
		}
		return false;
	}

	@Override
	public Iterator<E> iterator() {

		
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<E>{
		private Node curNode = head;
		
		@Override
		public boolean hasNext() {
			if(curNode != null) {
				return true;
			}
			
			return false;
		}

		@Override
		public E next() {
			if(curNode != null) {
				E data = curNode.data;
				curNode = curNode.next;
				return data;
			}
			return null;
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
	public boolean add(E e) {
		Node newNode = new Node(e);

		if (head == null) {
			head = newNode;
			tail = newNode;
		} else {
			Node node = null;
			for (node = head; node.next != null; node = node.next) {
			}
			tail.next = newNode;
			newNode.prev = tail;
		}
		tail = newNode;

		size++;

		return true;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if (index < 0) {
			return false;
		}
		remove(index);
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
	public boolean addAll(int index, Collection<? extends E> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		head = null;
		tail = null;
		size = 0;
	}

	private Node getNode(int index) {
		if (index < 0 || index >= size) {
			throw new IndexOutOfBoundsException("Bad index into list");
		}
		Node node = head;
		for (int i = 0; i < index; i++) {
			node = node.next;
		}
		return node;
	}

	@Override
	public E get(int index) {
		Node node = getNode(index);
		return node.data;
	}

	@Override
	public E set(int index, E element) {
		Node node = getNode(index);
		E old = node.data;
		node.data = element;
		return old;
	}

	@Override
	public void add(int index, E element) {

		Node newNode = new Node(element);

		if (index == 0) {
			newNode.next = head;
			head.prev = newNode;
			if (tail == null) {
				tail = newNode;
			}
			head = newNode;
		} else {
			Node prevNode = getNode(index - 1);
			newNode.next = prevNode.next;
			newNode.prev = prevNode;
			prevNode.next = newNode;
			if (newNode.next != null) {
				newNode.next.prev = newNode;
			}
			if (prevNode == tail) {
				tail = newNode;
			}

		}
		size++;
	}

	@Override
	public E remove(int index) {
		E data = get(index);
		
		if(index == 0) {
			if(head == tail) {
				tail = null;
			}
			head = head.next;
			if(head != null) {
				head.prev = null;
			}
		}
		else {
			Node prevNode = getNode(index -1);
			prevNode.next = prevNode.next.next;
			if (prevNode.next != null) {
				prevNode.next.prev = prevNode;
			}
			else {
				tail = prevNode;
			}
		}
		size ++;
		return data;
	}

	@Override
	public int indexOf(Object o) {
		Node node = head;
		for(int i = 0; i < size; i++) {
			if(((E)o).equals(node.data)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Node node = tail;
		for(int i = size - 1; i >= 0; i--) {
			if(((E)o).equals(node.data)){
				return i;
			}
		}
		return -1;
	}

	@Override
	public ListIterator<E> listIterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ListIterator<E> listIterator(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> subList(int fromIndex, int toIndex) {
		// TODO Auto-generated method stub
		return null;
	}

}
