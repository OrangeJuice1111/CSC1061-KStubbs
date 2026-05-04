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
            this.height = 0;
        }
    }

    
    public int getTreeHeight() {
        return root == null ? -1 : root.height;
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
        if (o == null) return false;
        try {
            @SuppressWarnings("unchecked")
            E data = (E) o;
            return contains(root, data);
        } catch (ClassCastException e) {
            return false;
        }
    }

    private boolean contains(Node node, E data) {
        if (node == null) return false;
        int cmp = data.compareTo(node.data);
        if (cmp == 0) return true;
        else if (cmp < 0) return contains(node.lChild, data);
        else return contains(node.rChild, data);
    }

    @Override
    public Iterator<E> iterator() {
        return new InOrderRecursive();
    }

    private class InOrderRecursive implements Iterator<E> {
        private Queue<E> queue = new ArrayDeque<>();

        public InOrderRecursive() {
            inorder(root);
        }

        private void inorder(Node node) {
	            if (node == null) return;
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
        ArrayList<E> list = new ArrayList<>();
        for (E e : this) {
            list.add(e);
        }
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
	        ArrayList<E> list = new ArrayList<>();
	        for (E e : this) {
	            list.add(e);
	        }
	        return list.toArray(a);
    }

   
    @Override
    public boolean add(E data) {
        if (data == null) throw new NullPointerException("Null elements not allowed");
        if (root == null) {
            root = new Node(data);
            size++;
            path.clear();
            return true;
        }

        Node current = root;
        Node parent = null;
        path.clear();

        while (current != null) {
            path.add(current);
            int cmp = data.compareTo(current.data);
            if (cmp < 0) {
                parent = current;
                current = current.lChild;
            } else if (cmp > 0) {
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
        if (node == null) return;
        int leftHeight = (node.lChild == null) ? -1 : node.lChild.height;
        int rightHeight = (node.rChild == null) ? -1 : node.rChild.height;
        node.height = 1 + Math.max(leftHeight, rightHeight);
    }

    private int balanceFactor(Node node) {
        if (node == null) return 0;
        int leftHeight = (node.lChild == null) ? -1 : node.lChild.height;
        int rightHeight = (node.rChild == null) ? -1 : node.rChild.height;
        return rightHeight - leftHeight;
    }

    private void balancePath() {
        for (int i = path.size() - 1; i >= 0; i--) {
            Node current = path.get(i);
            updateHeight(current);

            Node parent = (i > 0) ? path.get(i - 1) : null;

            int bf = balanceFactor(current);
            if (bf == -2) {
                if (balanceFactor(current.lChild) <= 0) {
                    balanceLL(current, parent);
                } else {
                    balanceLR(current, parent);
                }
            } else if (bf == 2) {
                if (balanceFactor(current.rChild) >= 0) {
                    balanceRR(current, parent);
                } else {
                    balanceRL(current, parent);
                }
            }
        }
    }

    private void balanceLL(Node node, Node parent) {
        Node gp = node;
        Node par = node.lChild;

        if (gp == root) {
            root = par;
        } else {
            if (parent.lChild == gp) {
                parent.lChild = par;
            } else {
                parent.rChild = par;
            }
        }

        gp.lChild = par.rChild;
        par.rChild = gp;

        updateHeight(gp);
        updateHeight(par);
    }

    private void balanceLR(Node node, Node parent) {
        Node gp = node;
        Node par = node.lChild;
        Node ch = par.rChild;

        if (gp == root) {
            root = ch;
        } else {
            if (parent.lChild == gp) {
                parent.lChild = ch;
            } else {
                parent.rChild = ch;
            }
        }

        par.rChild = ch.lChild;
        gp.lChild = ch.rChild;

        ch.lChild = par;
        ch.rChild = gp;

        updateHeight(par);
        updateHeight(gp);
        updateHeight(ch);
    }

    private void balanceRR(Node node, Node parent) {
        Node gp = node;
        Node par = node.rChild;

        if (gp == root) {
            root = par;
        } else {
            if (parent.lChild == gp) {
                parent.lChild = par;
            } else {
                parent.rChild = par;
            }
        }

        gp.rChild = par.lChild;
        par.lChild = gp;

        updateHeight(gp);
        updateHeight(par);
    }

    private void balanceRL(Node node, Node parent) {
        Node gp = node;
        Node par = node.rChild;
        Node ch = par.lChild;

        if (gp == root) {
            root = ch;
        } else {
            if (parent.lChild == gp) {
                parent.lChild = ch;
            } else {
                parent.rChild = ch;
            }
        }

        par.lChild = ch.rChild;
        gp.rChild = ch.lChild;

        ch.rChild = par;
        ch.lChild = gp;

        updateHeight(par);
        updateHeight(gp);
        updateHeight(ch);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object e : c) {
            if (!contains(e)) return false;
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        boolean changed = false;
        for (E e : c) {
            if (add(e)) changed = true;
        }
        return changed;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        root = null;
        size = 0;
        path.clear();
    }
}