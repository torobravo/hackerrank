package week4.mock.componentsingraph;

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
     * Complete the 'componentsInGraph' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts 2D_INTEGER_ARRAY gb as parameter.
     */

    public static List<Integer> componentsInGraph(List<List<Integer>> gb) {

        int maxNodes = Integer.MIN_VALUE;

        for (List<Integer> edge : gb) {
            maxNodes = Math.max(maxNodes, edge.get(1));
        }

        UnionFind uf = new UnionFind(maxNodes);

        for (List<Integer> edge : gb) {
            int left = edge.get(0) - 1;
            int right = edge.get(1) - 1;
            uf.union(left, right);
        }

        System.out.println("components " + uf.disjointSets);

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (Integer i : uf.size) {
            System.out.print(i + " ");
            if (i <= 1)
                continue;
            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return Arrays.asList(min, max);
    }

    static class UnionFind {
        int[] parents;
        int disjointSets;
        int[] size;

        public UnionFind(int n) {
            disjointSets = n;
            parents = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parents[i] = i;
                size[i] = 1;
            }

        }

        public int find(int i) {
            if (parents[i] != i) {
                // Path compression: Make the parent of i the
                // root of the set
                parents[i] = find(parents[i]);
            }
            return parents[i];
        }

        public void union(int i, int j) {
            int irep = find(i);
            int jrep = find(j);

            if (irep == jrep)
                return;

            int isize = size[irep];
            int jsize = size[jrep];

            if (isize < jsize) {
                parents[irep] = jrep;
                size[jrep] += size[irep];
                size[irep] = 1;
            } else {
                parents[jrep] = irep;
                size[irep] += size[jrep];
                size[jrep] = 1;
            }

            disjointSets--;

            return;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> gb = new ArrayList<>();

        IntStream.range(0, n).forEach(i -> {
            try {
                gb.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        List<Integer> result = Result.componentsInGraph(gb);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining(" "))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
