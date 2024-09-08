package week4.lilyshomework;

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
     * Complete the 'lilysHomework' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts INTEGER_ARRAY arr as parameter.
     */

    public static int lilysHomework(List<Integer> arr) {
        int swaps_asc = 0;
        int swaps_desc = 0;

        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();

        for (int i = 0; i < arr.size(); i++) {
            map1.put(arr.get(i), i);
            map2.put(arr.get(i), i);
        }

        List<Integer> arr2 = new ArrayList<>(arr);

        List<Integer> list_asc = new ArrayList<>(arr);
        Collections.sort(list_asc);

        int n = arr.size();

        for (int i = 0; i < arr.size(); i++) {
            if (list_asc.get(i) != arr.get(i)) {
                int index = map1.get(list_asc.get(i));

                map1.put(arr.get(i), index);
                map1.put(list_asc.get(i), i);

                arr.set(index, arr.get(i));
                arr.set(i, list_asc.get(i));

                swaps_asc++;
            }

            if (list_asc.get(n - i - 1) != arr2.get(i)) {
                int index = map2.get(list_asc.get(n - i - 1));

                map2.put(arr2.get(i), index);
                map2.put(list_asc.get(n - i - 1), i);

                arr2.set(index, arr2.get(i));
                arr2.set(i, list_asc.get(n - i - 1));

                swaps_desc++;
            }
        }

        return Math.min(swaps_asc, swaps_desc);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> arr = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.lilysHomework(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
