package week4.arraymanipulation;

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
     * Complete the 'arrayManipulation' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. 2D_INTEGER_ARRAY queries
     */
/*
|             |      optimal approach       |       |
| array index | [1,5,3] | [4,8,7] | [6,9,1] | Total |
|    1        |    3    |         |         |   3   |
|    2        |         |         |         |       |
|    3        |         |         |         |       |
|    4        |         |    7    |         |   7   |
|    5        |   -3    |         |         |  -3   |
|    6        |         |         |    1    |   1   |
|    7        |         |         |         |       |
|    8        |         |         |         |       |
|    9        |         |   -7    |         |  -7   |
|    10       |         |         |         |       |
|    10+1     |         |         |   -1    |  -1   |
 */

    public static long arrayManipulation(int n, List<List<Integer>> queries) {
        Map<Integer, Long> sum = new TreeMap<>(); // order by key
        for (List<Integer> list : queries) {
            int a = list.get(0);
            int b = list.get(1);
            long k = list.get(2);
            sum.put(a, sum.getOrDefault(a, 0L) + k);
            sum.put(b + 1, sum.getOrDefault(b + 1, 0L) - k);
        }

        long max = 0L;
        long current = 0L;
        for (long value : sum.values()) {
            current += value;
            max = Math.max(max, current);
        }
        return max;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int m = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> queries = new ArrayList<>();

        IntStream.range(0, m).forEach(i -> {
            try {
                queries.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList()));
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = Result.arrayManipulation(n, queries);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
