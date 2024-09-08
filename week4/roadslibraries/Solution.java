package week4.roadslibraries;

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
     * Complete the 'roadsAndLibraries' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER c_lib
     * 3. INTEGER c_road
     * 4. 2D_INTEGER_ARRAY cities
     */

    public static long roadsAndLibraries(int n, int c_lib, int c_road, List<List<Integer>> cities) {
        // If the cost of road is greater than a library
        // then it is better to build a library in each city
        if (c_road >= c_lib)
            return (long) n * c_lib;

        int roadCount = 0;
        UnionFind uf = new UnionFind(n);

        for (List<Integer> edge : cities) {
            int from = edge.get(0) - 1; // starts at index 0
            int to = edge.get(1) - 1; // starts at index 0

            if (!uf.isConnected(from, to)) {
                uf.union(from, to);
                roadCount++; // build a new road
            }
        }

        // count all disjoint sets
        int components = uf.getComponents();

        // build a library for each component and
        // add the cost of each road
        long result = (long) components * c_lib + (long) roadCount * c_road;

        return result;
    }

    static class UnionFind {
        int[] parent;
        int disjointSets;

        public UnionFind(int n) {
            parent = new int[n];
            disjointSets = n;
            // Initialize the parent array with each element
            // as its own representative
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        // Find the rep (root) of the set that includes element i
        public int find(int i) {
            // I am the parent
            if (parent[i] == i)
                return i;

            // Recursively find the rep of the parent until reaching the root
            parent[i] = find(parent[i]); // Path-compression
            return parent[i];
        }

        // Determines if element i and j are in the same set
        public boolean isConnected(int i, int j) {
            return find(i) == find(j);
        }

        public void union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            // if the same root, then they are in the same set
            if (rootI == rootJ)
                return;
            // Sets the parent to either set
            parent[rootI] = rootJ;

            // we have one less component or set
            disjointSets--;
        }

        public int getComponents() {
            return disjointSets;
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

                int c_lib = Integer.parseInt(firstMultipleInput[2]);

                int c_road = Integer.parseInt(firstMultipleInput[3]);

                List<List<Integer>> cities = new ArrayList<>();

                IntStream.range(0, m).forEach(i -> {
                    try {
                        cities.add(
                                Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                        .map(Integer::parseInt)
                                        .collect(toList()));
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                });

                long result = Result.roadsAndLibraries(n, c_lib, c_road, cities);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
