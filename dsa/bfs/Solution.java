package dsa.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Solution {

    public static void bfs(int n, List<List<Integer>> edges, int start) {
        // create the graph
        Map<Integer, List<Integer>> graph = new HashMap<>(n);
        for (int i = 1; i <= n; i++) {
            graph.put(i, new LinkedList<>());
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u); // undirect graphs
        }

        Set<Integer> visited = new HashSet<>(n);
        Queue<Integer> queue = new LinkedList<>(); // uses a Queue

        queue.offer(start);
        visited.add(start);

        while (!queue.isEmpty()) {
            int v = queue.poll();
            System.out.print(v + " ");
            for (int neighbor : graph.get(v)) {
                if (!visited.contains(neighbor)) {
                    visited.add(neighbor);
                    queue.add(neighbor);
                }
            }
        }
    }

    public static void main(String[] args) {
        int nodes = 8;
        int start = 2;
        List<List<Integer>> edges = Arrays.asList(
                Arrays.asList(1, 7),
                Arrays.asList(1, 3),
                Arrays.asList(1, 2),
                Arrays.asList(2, 3),
                Arrays.asList(5, 6),
                Arrays.asList(6, 8));

        bfs(nodes, edges, start);
    }
}
