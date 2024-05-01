package week4.maxsubarray;

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
     * Complete the 'maxSubarray' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static List<Integer> maxSubarray(List<Integer> arr) {
        int maxSubarray = Integer.MIN_VALUE;
        int maxSubseq = Integer.MIN_VALUE;
        int currentSum = 0, currentSumSubseq = 0;

        for (Integer num : arr) {
            // max subarray - Kadane's Algorithm
            currentSum += num;

            if (currentSum < num)
                currentSum = num;

            if (maxSubarray < currentSum)
                maxSubarray = currentSum;

            // max subseq
            if (num >= 0) { // only add if positive
                currentSumSubseq += num;
                maxSubseq = currentSumSubseq;
            }
            if (num > maxSubseq) // corner case all negatives
                maxSubseq = num;

            /*
             * if (num > 0 && currentSumSubseq >= 0) {
             * currentSumSubseq += num;
             * } else if (num > 0 && currentSumSubseq < 0) {
             * currentSumSubseq = Math.max(currentSumSubseq, num);
             * } else if (num < 0 && currentSumSubseq < 0) {
             * currentSumSubseq = Math.max(currentSumSubseq, num);
             * } else if (num < 0 && currentSumSubseq == 0) {
             * currentSumSubseq = num;
             * }
             */

        }

        return Arrays.asList(maxSubarray, maxSubseq);
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
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                List<Integer> result = Result.maxSubarray(arr);

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
