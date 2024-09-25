package dsa.dijkstras;

import java.util.*;

public class Solution {

    static class Node {
        int u;
        int w;
        public Node(int u, int w) {
            this.u = u;
            this.w = w;
        }
    }
    
    public static List<Integer> shortestPaths(int n, List<List<Integer>> edges, int start) {
        // Create Graph
        List<Integer> distances = new ArrayList<>(n);
        List<List<Node>> graph = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
            distances.add(Integer.MAX_VALUE);
        }
        for(List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            graph.get(u).add(new Node(v, w));
            graph.get(v).add(new Node(u, w));
        }

        PriorityQueue<Node> pq = new PriorityQueue<Node>(Comparator.comparingInt(o -> o.w));
        pq.offer(new Node(start, 0));
        distances.set(start, 0);

        while(!pq.isEmpty()) {
            Node current = pq.poll();
            for(Node neighbor : graph.get(current.u)) {
                int newWeight = distances.get(current.u) + neighbor.w;
                if (distances.get(neighbor.u) > newWeight) {
                    distances.set(neighbor.u, newWeight);
                    pq.offer(new Node(neighbor.u, newWeight));
                }
            }
        }

        return distances;

    }


    //
    //       1 --- 2 ----- 3
    //    /  |     | \     | \
    //   /   |     |  \    |  \
    //  0    |     8   \   |   4
    //   \   |   / |    \  |  /
    //    \  |  /  |     \ | /
    //       7 --- 6 ----- 5
    //
    public static void main(String[] args) {
        int nodes = 9;
        int start = 1;
        int end = 7;
        List<List<Integer>> edges = Arrays.asList(
            Arrays.asList(0, 1, 4),
            Arrays.asList(0, 7, 8),
            Arrays.asList(1, 2, 8),
            Arrays.asList(7, 1, 11),
            Arrays.asList(7, 8, 7),
            Arrays.asList(7, 6, 1),
            Arrays.asList(2, 3, 7),
            Arrays.asList(2, 5, 4),
            Arrays.asList(2, 8, 2),
            Arrays.asList(8, 6, 6),
            Arrays.asList(6, 5, 2),
            Arrays.asList(3, 4, 9),
            Arrays.asList(5, 3, 14),
            Arrays.asList(5, 4, 10));

        List<Integer> result = shortestPaths(nodes, edges, start);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
