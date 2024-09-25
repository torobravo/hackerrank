package dsa.kruskal;

import java.util.*;

public class Solution {
    static class UnionFind {
        int[] parent;
        int[] rank;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
            }
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;
            parent[x] = find(parent[x]);
            return parent[x];
        }

        public void unionByRank(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            if (rank[px] < rank[py]) {
                parent[px] = py;
            } else if (rank[x] > rank[y]) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }
        }

        public boolean isConnected(int x, int y) {
            return find(x) == find(y);
        }
    }

    static class Edge {
        int u;
        int v;
        int w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    public static int kruskal(int n, List<List<Integer>> edges) {
        // create the graph
        List<Edge> graph = new ArrayList<>(n);
        for (List<Integer> edge : edges) {
            graph.add(new Edge(edge.get(0), edge.get(1), edge.get(2)));
        }
        graph.sort(new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w - o2.w;  // sort by weight
            }
        });

        Edge[] results = new Edge[n];
        UnionFind uf = new UnionFind(n);

        int j = 0;
        int noOfEdges = 0;

        while (noOfEdges < n - 1) {
            Edge nextEdge = graph.get(j++);
            if (!uf.isConnected(nextEdge.u, nextEdge.v)) {
                results[noOfEdges++] = nextEdge;
                uf.unionByRank(nextEdge.u, nextEdge.v);
            }
        }

        int minCost = 0;
        for (int i = 0; i < noOfEdges; i++) {
            System.out.println(results[i].u + " -- "
                    + results[i].v + " == "
                    + results[i].w);
            minCost += results[i].w;
        }

        return minCost;
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
        int n = 9;
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

        System.out.println("Min Total Weight: " + kruskal(n, edges));
    }
}
