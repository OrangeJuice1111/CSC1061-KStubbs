package csc1060j.CourseScheduler;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseScheduler {
    private Graph<String> graph;
    private int numCourses;

    public CourseScheduler(int numCourses) {
        this.numCourses = numCourses;
        graph = new Graph<>(numCourses);
    }

    public void buildGraphFromLines(List<String> lines) {
        try {
            if (lines.isEmpty()) {
                System.out.println("Input file is empty.");
                System.exit(1);
            }

             this.numCourses = Integer.parseInt(lines.get(0)); // no trim()

            this.graph = new Graph<>(numCourses);

             for (int i = 1; i <= numCourses; i++) {
                String[] parts = lines.get(i).split(" ");
                graph.setValue(i - 1, parts[0]);
            }

             for (int i = 1; i <= numCourses; i++) {
                String[] parts = lines.get(i).split(" ");
                String course = parts[0];
                int prereqCount = Integer.parseInt(parts[1]);
                for (int j = 0; j < prereqCount; j++) {
                    String prereq = parts[2 + j];
                    graph.insertEdge(prereq, course);
                }
            }
        } catch (Exception e) {
            System.out.println("Error processing input lines: " + e.getMessage());
            System.exit(1);
        }
    }

    public List<String> topologicalSort() {
        int size = graph.getSize();
        int[] inDegree = new int[size];

        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (graph.isEdge(i, j)) {
                    inDegree[j]++;
                }
            }
        }

        java.util.Queue<Integer> queue = new java.util.LinkedList<>();
        for (int i = 0; i < size; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        List<String> ordering = new ArrayList<>();
        int count = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            ordering.add(graph.getValue(node));
            count++;

            for (int neighbor = 0; neighbor < size; neighbor++) {
                if (graph.isEdge(node, neighbor)) {
                    graph.removeEdge(node, neighbor); 
                    inDegree[neighbor]--;
                    if (inDegree[neighbor] == 0) {
                        queue.add(neighbor);
                    }
                }
            }
        }

        if (count != size) {
            return null;
        }

        return ordering;
    }

    public static void main(String[] args) {
        Scanner inputScanner = new Scanner(System.in);

        System.out.println("Which input file do you want to run?");
        System.out.println("1 - cpsc.txt");
        System.out.println("2 - cybr.txt");
        System.out.println("3 - impossible.txt");
       
        String choice = inputScanner.nextLine().trim();
        String resourceName;

        switch (choice) {
            case "1":
                resourceName = "cpsc.txt";
                break;
            case "2":
                resourceName = "cybr.txt";
                break;
            case "3":
                resourceName = "impossible.txt";
                break;
            default:
                System.out.println("Invalid choice");
               return;
        }

        inputScanner.close();

        InputStream inputStream = CourseScheduler.class.getClassLoader().getResourceAsStream(resourceName);
        if (inputStream == null) {
            System.out.println("Resource file not found: " + resourceName);
            System.exit(1);
        }

        List<String> lines = new ArrayList<>();
        try (Scanner fileScanner = new Scanner(inputStream)) {
            while (fileScanner.hasNextLine()) {
                lines.add(fileScanner.nextLine());
            }
        }

        CourseScheduler scheduler = new CourseScheduler(0);
        scheduler.buildGraphFromLines(lines);

        List<String> order = scheduler.topologicalSort();

        if (order == null) {
            System.out.println("Impossible to complete courses");
        } else {
            for (String course : order) {
                System.out.println(course);
            }
        }
    }
}