package week4.queriesfixedlength;

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
     * Complete the 'solve' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY arr
     * 2. INTEGER_ARRAY queries
     */

    public static List<Integer> solve(List<Integer> arr, List<Integer> queries) {
        List<Integer> result = new ArrayList<>();
        // List<Integer> maxs = new ArrayList<>();

        // for (int q = 0; q < arr.size(); q++) {
        // maxs.add(arr.get(q));
        // }

        // for (int q = 0; q < queries.size(); q++) {
        // int d = queries.get(q);
        // int min = Integer.MAX_VALUE;
        // for (int i = 0; i <= arr.size() - d; i++) {
        // maxs.set(i, maxs.get(i) < arr.get(i + d - 1) ? arr.get(i + d - 1) :
        // maxs.get(i));
        // if (min > maxs.get(i))
        // min = maxs.get(i);
        // }
        // result.add(min);
        // }

        for (int q = 0; q < queries.size(); q++) {
            int d = queries.get(q);
            int min = Integer.MAX_VALUE;
            int last = arr.get(0);
            for (int i = 0; i <= arr.size() - d; i++) {
                int max = Integer.MIN_VALUE;
                last = arr.get(i);
                if (last < min) {
                    for (int j = i; j < i + d; j++) {

                        if (max < arr.get(j))
                            max = arr.get(j);
                    }
                }
                if (min > max) {
                    min = max;
                }
            }
            result.add(min);
        }

        return result;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        // BufferedReader bufferedReader = new BufferedReader(new
        // InputStreamReader(System.in));
        BufferedReader bufferedReader = new BufferedReader(new FileReader("c:\\temp\\hackerrank_input.txt"));

        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> queries = IntStream.range(0, q).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.solve(arr, queries);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
