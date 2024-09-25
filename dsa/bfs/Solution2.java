package dsa.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution2 {

    static class Graph {
        int vertices; // Number of vertices in the graph
        LinkedList<Integer>[] adjList; // Adjency list representation of the graph

        public Graph(int v) {
            this.vertices = v;
            this.adjList = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                this.adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dst) {
            this.adjList[src].add(dst); // Directed graph: add an edge from src to dst
            // this.adjList[dst].add(src); // For undirected graph, add an edge grom dst to
            // src as well
        }

        public void bfs(int start) {
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();

            visited[start] = true;
            queue.add(start);

            while (!queue.isEmpty()) {
                int vertex = queue.poll();
                System.out.print(vertex + " ");

                for (int neighbor : adjList[vertex]) {
                    if (!visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.add(neighbor);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int n = 8;
        int start = 1;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(0, 1),
                Arrays.asList(0, 2),
                Arrays.asList(1, 2),
                Arrays.asList(1, 3),
                Arrays.asList(1, 4),
                Arrays.asList(2, 1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 3));

        Graph graph = new Graph(n);

        for (List<Integer> edge : edges) {
            graph.addEdge(edge.get(0), edge.get(1));
        }

        graph.bfs(start);
    }
}
