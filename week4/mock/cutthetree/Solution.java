package week4.mock.cutthetree;

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
     * Complete the 'cutTheTree' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY data
     * 2. 2D_INTEGER_ARRAY edges
     */

    public static int cutTheTree(List<Integer> data, List<List<Integer>> edges) {
        int totalSum = 0;
        int diff = Integer.MAX_VALUE;
        // Create Graph
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < data.size(); i++) {
            graph.put(i + 1, new ArrayList<>());
            totalSum += data.get(i);
        }
        for (List<Integer> edge : edges) {
            int u = edge.get(0);
            int v = edge.get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        // DFS
        Set<Integer> visited = new HashSet<>();
        Stack<Integer> stack = new Stack<>();
        Map<Integer, Integer> cum_weight = new HashMap<>();
        Map<Integer, Integer> child_parent = new HashMap<>();

        // visited.add(1);
        stack.add(1);

        while (!stack.isEmpty()) {
            int vertex = stack.peek();

            if (visited.contains(vertex)) {
                cum_weight.put(vertex, data.get(vertex - 1));
                for (Integer c : graph.get(vertex)) {
                    if (child_parent.getOrDefault(c, -1) == vertex)
                        cum_weight.put(vertex, cum_weight.get(vertex) + cum_weight.get(c));
                }
                diff = Math.min(diff, Math.abs(totalSum - 2 * cum_weight.get(vertex)));
                stack.pop();
                continue;
            }

            visited.add(vertex);
            for (Integer neighbor : graph.get(vertex)) {
                if (!visited.contains(neighbor)) {
                    child_parent.put(neighbor, vertex);
                    stack.add(neighbor);
                }
            }
        }
        return diff;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> data = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<List<Integer>> edges = new ArrayList<>();

        IntStream.range(0, n - 1).forEach(i -> {
            try {
                edges.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int result = Result.cutTheTree(data, edges);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
