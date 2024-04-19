package rec_graphs;

import java.util.*;

public class Graph {
    private int numVertices;
    private LinkedList<Integer>[] adjList;

    public Graph(int numVertices) {
        this.numVertices = numVertices;
        adjList = new LinkedList[numVertices];
        for (int i = 0; i < numVertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }

    void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src);  // Add this line to make the graph undirected
    }
    
    // DFS method
    public void DFS(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");

        Iterator<Integer> i = adjList[vertex].listIterator();
        while (i.hasNext()) {
            int adj = i.next();
            if (!visited[adj]) {
                DFS(adj, visited);
            }
        }
    }

    public void DFS(int startVertex) {
        boolean visited[] = new boolean[numVertices];
        DFS(startVertex, visited);
    }

    public void BFS(int startVertex) {
        boolean visited[] = new boolean[numVertices];
        LinkedList<Integer> queue = new LinkedList<>();

        visited[startVertex] = true;
        queue.add(startVertex);

        while (queue.size() != 0) {
            int s = queue.poll();
            System.out.print(s + " ");

            Iterator<Integer> i = adjList[s].listIterator();
            while (i.hasNext()) {
                int n = i.next();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}

// Main class to test the implementation
class Main {
    public static void main(String[] args) {
        Graph g = new Graph(11);

        g.addEdge(1, 2);
        g.addEdge(1, 4);
        g.addEdge(4, 3);
        g.addEdge(2, 3);
        g.addEdge(3, 10);
        g.addEdge(3, 9);
        g.addEdge(2, 5);
        g.addEdge(2, 8);
        g.addEdge(2, 7);
        g.addEdge(8, 7);
        g.addEdge(8, 5);
        g.addEdge(5, 6);

        System.out.println("DFS starting from vertex 2:");
        g.DFS(1);

        System.out.println("\nBFS starting from vertex 2:");
        g.BFS(1);
    }
}
