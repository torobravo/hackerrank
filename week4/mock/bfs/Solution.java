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
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new LinkedList<>());
        }

        for (List<Integer> edge : edges) {
            int src = edge.get(0) - 1; // index 0
            int dst = edge.get(1) - 1; // index 0
            graph.get(src).add(dst);
            graph.get(dst).add(src);
        }

        List<Integer> distance = new ArrayList<>(Collections.nCopies(n, Integer.MAX_VALUE));
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        queue.add(s - 1);
        distance.set(s - 1, 0);

        while (!queue.isEmpty()) {
            int u = queue.poll();
            for (Integer v : graph.get(u)) {
                if (distance.get(u) + 6 < distance.get(v)) {
                    distance.set(v, distance.get(u) + 6);
                    queue.add(v);
                }
            }
        }
        distance.replaceAll(ele -> ele == Integer.MAX_VALUE ? -1 : ele);
        distance.removeIf(ele -> ele == 0);
        return distance;
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
