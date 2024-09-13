package week4.mock.bfs;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'bfs' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER m
     * 3. 2D_INTEGER_ARRAY edges
     * 4. INTEGER s
     */

    public static List<Integer> bfs(int n, int m, List<List<Integer>> edges, int s) {
        Graph graph = new Graph(n);

        for (List<Integer> edge : edges) {
            int src = edge.get(0) - 1;
            int dest = edge.get(1) - 1;

            graph.addEdge(src, dest, 6);
        }

        return graph.dijkstra(s - 1);
    }

    static class Graph {
        private int v;
        private LinkedList<Node>[] adjList;

        static class Node implements Comparable<Node> {
            int vertex;
            int weight;

            public Node(int v, int w) {
                vertex = v;
                weight = w;
            }

            @Override
            public int compareTo(Node o) {
                return this.weight - o.weight;
            }

        }

        public Graph(int v) {
            this.v = v;
            this.adjList = new LinkedList[v];
            for (int i = 0; i < v; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest, int weight) {
            adjList[src].add(new Node(dest, weight));
            adjList[dest].add(new Node(src, weight));
        }

        public List<Integer> dijkstra(int src) {
            PriorityQueue<Node> pq = new PriorityQueue<>();
            int[] dist = new int[v];
            Arrays.fill(dist, Integer.MAX_VALUE);
            dist[src] = 0;

            pq.add(new Node(src, 6));

            while (!pq.isEmpty()) {
                Node currentNode = pq.poll();
                int u = currentNode.vertex;

                for (Node neighbor : adjList[u]) {
                    int v = neighbor.vertex;
                    int weight = neighbor.weight;

                    if (dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                        pq.add(new Node(v, dist[v]));
                    }
                }
            }
            List<Integer> result = new ArrayList<>();
            for (int i = 1; i < dist.length; i++) {
                if (dist[i] < Integer.MAX_VALUE)
                    result.add(dist[i]);
                else
                    result.add(-1);
            }

            return result;
        }

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                List<List<Integer>> edges = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        edges.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                int s = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> result = Result.bfs(n, m, edges, s);

                bufferedWriter.write(
                        result.stream()
                                .map(Object::toString)
                                .collect(joining(" "))
                                + "\n");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
