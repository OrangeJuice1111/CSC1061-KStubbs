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
            this.next = null;
            this.prev = null;
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
        return indexOf(o) >= 0;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator();
    }

    private class MyIterator implements Iterator<E> {
        private Node curNode = head;

        @Override
        public boolean hasNext() {
            return curNode != null;
        }

        @Override
        public E next() {
            if (curNode != null) {
                E data = curNode.data;
                curNode = curNode.next;
                return data;
            }
            return null;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] array = new Object[size];
        Node node = head;
        for (int i = 0; i < size; i++) {
            array[i] = node.data;
            node = node.next;
        }
        return array;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) java.lang.reflect.Array.newInstance(a.getClass().getComponentType(), size);
            a = newArray;
        }
        Node node = head;
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            T element = (T) node.data;
            a[i] = element;
            node = node.next;
        }
        if (a.length > size) {
            a[size] = null;
        }
        return a;
    }

    @Override
    public boolean add(E e) {
        Node newNode = new Node(e);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
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
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object obj : c) {
            if (!contains(obj)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (add(e)) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {
        boolean changed = false;
        int currentIndex = index;
        for (E e : c) {
            add(currentIndex++, e);
            changed = true;
        }
        return changed;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean changed = false;
        for (Object obj : c) {
            while (remove(obj)) {
                changed = true;
            }
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean changed = false;
        Node node = head;
        int index = 0;
        while (node != null) {
            if (!c.contains(node.data)) {
                remove(index);
                changed = true;
                node = (index == 0) ? head : getNode(index);
            } else {
                node = node.next;
                index++;
            }
        }
        return changed;
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
        Node node;
        if (index < size / 2) {
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        } else {
            node = tail;
            for (int i = size - 1; i > index; i--) {
                node = node.prev;
            }
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
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Bad index into list");
        }

        Node newNode = new Node(element);

        if (index == 0) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
        } else if (index == size) {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        } else {
            Node nextNode = getNode(index);
            Node prevNode = nextNode.prev;

            prevNode.next = newNode;
            newNode.prev = prevNode;

            newNode.next = nextNode;
            nextNode.prev = newNode;
        }
        size++;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Bad index into list");
        }

        Node nodeToRemove = getNode(index);
        E data = nodeToRemove.data;

        if (nodeToRemove.prev != null) {
            nodeToRemove.prev.next = nodeToRemove.next;
        } else {
            head = nodeToRemove.next;
        }

        if (nodeToRemove.next != null) {
            nodeToRemove.next.prev = nodeToRemove.prev;
        } else {
            tail = nodeToRemove.prev;
        }

        size--;
        return data;
    }

    @Override
    public int indexOf(Object o) {
        Node node = head;
        for (int i = 0; i < size; i++) {
            if (o == null ? node.data == null : o.equals(node.data)) {
                return i;
            }
            node = node.next;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        Node node = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (o == null ? node.data == null : o.equals(node.data)) {
                return i;
            }
            node = node.prev;
        }
        return -1;
    }

    @Override
    public ListIterator<E> listIterator() {
        
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        
        return null;
    }

    public void reverse() {
        Node current = head;
        Node temp = null;

        
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }

        
        if (temp != null) {
            head = temp.prev;
            tail = head;
            while (tail.next != null) {
                tail = tail.next;
            }
        }
    }
}