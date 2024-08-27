package week5.longestincreasingsubsequence;

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
     * Complete the 'longestIncreasingSubsequence' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int longestIncreasingSubsequence(List<Integer> arr) {
        if (arr == null || arr.isEmpty()) {
            return 0;
        }

        ArrayList<Integer> lis = new ArrayList<>();
        for (int num : arr) {
            if (lis.isEmpty() || num > lis.get(lis.size() - 1)) {
                lis.add(num);
            } else {
                int index = binarySearch(lis, num);
                lis.set(index, num);
            }
        }

        return lis.size();
    }

    private static int binarySearch(ArrayList<Integer> lis, int num) {
        int low = 0, high = lis.size() - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;
            if (lis.get(mid) < num)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static int longestIncreasingSubsequence2(List<Integer> arr) {
        int maxSize = Integer.MIN_VALUE;
        List<List<Integer>> lis = new ArrayList<>(arr.size());
        for (int i = 0; i < arr.size(); i++)
            lis.add(new ArrayList<>());

        lis.get(0).add(arr.get(0));

        for (int i = 1; i < arr.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (arr.get(j) < arr.get(i) &&
                        lis.get(i).size() < lis.get(j).size() + 1) {

                    lis.set(i, new ArrayList<>(lis.get(j)));
                }
            }
            lis.get(i).add(arr.get(i));
            if (maxSize < lis.get(i).size())
                maxSize = lis.get(i).size();
        }

        return maxSize;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.longestIncreasingSubsequence(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
