package csc1060j.CourseScheduler;

public class Graph<Type> {
    private boolean[][] matrix;
    private Type[] values;
    private int size;

    public Graph(int size) {
        matrix = new boolean[size][size];
        this.size = size;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                matrix[i][j] = false;
            }
        }

        @SuppressWarnings("unchecked")
        Type[] tempvalues = (Type[]) new Object[size];
        this.values = tempvalues;
    }

    public int lookup(Type value) {
        for (int i = 0; i < size; i++) {
            if (values[i] != null && values[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    public void insertEdge(int from, int to) {
        matrix[from][to] = true;
    }

    public void insertEdge(Type from, Type to) {
        int fromIndex = lookup(from);
        int toIndex = lookup(to);
        insertEdge(fromIndex, toIndex);
    }

    public void removeEdge(int from, int to) {
        matrix[from][to] = false;
    }

    public boolean isEdge(int from, int to) {
        return matrix[from][to];
    }

    public void setValue(int node, Type value) {
        values[node] = value;
    }

    public int getSize() {
        return size;
    }

    public Type getValue(int index) {
        return values[index];
    }
}