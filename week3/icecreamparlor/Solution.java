package week3.icecreamparlor;

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
     * Complete the 'icecreamParlor' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER m
     * 2. INTEGER_ARRAY arr
     */

    public static List<Integer> icecreamParlor(int m, List<Integer> arr) {

        for (int f1 : arr) {
            int index1 = arr.indexOf(f1);
            int index2 = arr.lastIndexOf(m - f1);
            if (index1 != index2 && index2 >= 0)
                return Arrays.asList(index1 + 1, index2 + 1);
        }

        return new ArrayList<>();
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int m = Integer.parseInt(bufferedReader.readLine().trim());

                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.icecreamParlor(m, arr);

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
