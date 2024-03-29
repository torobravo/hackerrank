package week3.newyearchaos;

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
     * Complete the 'minimumBribes' function below.
     *
     * The function accepts INTEGER_ARRAY q as parameter.
     */

    public static void minimumBribes(List<Integer> q) {
        int swaps = 0;

        for (int index = q.size() - 1; index > 0; index--) {
            int rightValue = index + 1;
            if (q.get(index) != rightValue) {
                if (q.get(index - 1) == rightValue) {
                    q.set(index - 1, q.get(index));
                    q.set(index, rightValue);
                    swaps += 1;
                } else if (q.get(index - 2) == rightValue) {
                    q.set(index - 2, q.get(index - 1));
                    q.set(index - 1, q.get(index));
                    q.set(index, rightValue);
                    swaps += 2;
                } else {
                    System.out.println("Too chaotic");
                    return;
                }
            }
        }
        System.out.println(swaps);
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                int n = Integer.parseInt(bufferedReader.readLine().trim());

                List<Integer> q = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList());

                Result.minimumBribes(q);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
    }
}
