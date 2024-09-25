package dsa.unionfind;

public class Solution {
    static class UnionFind {
        int[] parent;
        int[] rank;
        int[] size;
        int disjointSets;

        public UnionFind(int n) {
            parent = new int[n];
            rank = new int[n];
            size = new int[n];
            disjointSets = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 0;
                size[i] = 1;
            }
        }

        public int find(int x) {
            if (parent[x] == x)
                return x;

            parent[x] = find(parent[x]); // path-compression
            return parent[x];
        }

        public void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            parent[py] = px;
            disjointSets--;
        }

        public void unionByRank(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            int rankX = rank[x];
            int rankY = rank[y];

            if (rankX < rankY) {
                parent[px] = py;
            } else if (rankX > rankY) {
                parent[py] = px;
            } else {
                parent[px] = py;
                rank[py]++;
            }

            disjointSets--;
        }

        public void unionBySize(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py)
                return;

            int sizeX = size[x];
            int sizeY = size[y];

            if (sizeX < sizeY) {
                parent[px] = py;
                size[py] += size[px];
                size[px] = 0;
            } else {
                parent[py] = px;
                size[px] += size[py];
                size[py] = 0;
            }

            disjointSets--;
        }

    }

    public static void main(String[] args) {
        int n = 5;
        UnionFind uf = new UnionFind(n);
        uf.unionBySize(0, 1);
        uf.unionBySize(2, 3);
        uf.unionBySize(0, 4);
        for (int i = 0; i < n; i++) {
            System.out.println("Element " + i 
                                + ": Parent = "
                                + uf.find(i)
                                + ": Size = "
                                + uf.size[i]);
        }
    }
}
