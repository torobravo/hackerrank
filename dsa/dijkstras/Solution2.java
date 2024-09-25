package dsa.dijkstras;

import java.util.*;

public class Solution2 {
    public static List<Integer> shortestPaths(int n, List<List<Integer>> edges, int start, int end) {
        Map<Integer, Integer> distances = new HashMap<>(n);
        // create the graph
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            graph.put(i, new HashMap<>());
            distances.put(i, Integer.MAX_VALUE);
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            graph.get(u).put(v, w);
            graph.get(v).put(u, w); // undirect graphs
        }

        PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<Map.Entry<Integer, Integer>>(
                (a, b) -> a.getValue() - b.getValue()); // uses a PriorityQueue

        queue.offer(new AbstractMap.SimpleEntry<Integer, Integer>(start, 0));
        distances.put(start, 0);

        while (!queue.isEmpty()) {
            Map.Entry<Integer, Integer> v = queue.poll();
            for (Map.Entry<Integer, Integer> neighbor : graph.get(v.getKey()).entrySet()) {
                int u = neighbor.getKey();
                int newWeight = distances.get(v.getKey()) + neighbor.getValue();

                if (distances.get(u) > newWeight) {
                    distances.put(u, newWeight);
                    queue.offer(new AbstractMap.SimpleEntry<Integer, Integer>(u, newWeight));
                }
            }
        }

        return new ArrayList<Integer>(distances.values());
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

        List<Integer> result = shortestPaths(nodes, edges, start, end);
        for (int res : result) {
            System.out.print(res + " ");
        }
    }
}
