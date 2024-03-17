package week3.climbingleaderboard;

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
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY ranked
     * 2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {

        List<Integer> result = new ArrayList<>();

        // Convert ranked list to TreeSet to remove duplicates
        // and sort in ascending order
        Set<Integer> rankSet = new TreeSet<>(ranked);
        int highestRank = rankSet.size();

        // redefine ranked list with the sorted set
        ranked = new ArrayList<>(rankSet);

        for (Integer current : player) {
            // do a fast binary search in the ranked list to find
            // the insertion point of the currentplayer
            int index = Collections.binarySearch(ranked, current);

            // if the insertion point is found (aka positive index),
            // the ordinary position of the current player will
            // be located at the highestRank minus the insertion point
            int ord = highestRank - index;

            // if the insertion point is not found (aka negative index),
            // insertion point = -insertPoint - 1
            if (index < 0) {
                // the ordinary position of the current player
                // will be located at the highestRank minus the
                // the insertion point:
                // highestRank - (-insertPoint - 1) - 1
                ord = highestRank + index + 2;
            }

            result.add(ord);
        }

        return result;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
