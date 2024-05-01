package week4.legoblocks;

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
     * Complete the 'legoBlocks' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. INTEGER m
     */

    /**
     * Raise a num to an exponent and mod the result
     * NOTE: don't use Math.pow() since it will give
     * incorrect results since it does not mod the
     * intermediate results
     */
    private static long pow(long num, int exp, long mod) {
        long res = num;
        while (exp-- > 1) {
            res = (res * num) % mod;
        }

        return res;
    }

    /**
     * Strategy using Dynamic Programming:
     * 1. Create an array where each index represents the width
     * and store the number of permuations for a single row.
     * 
     * 2. Create an array where each index represents the width
     * and store the number of valid and invalid permutations for
     * the total number of rows (height)
     * 
     * 3. Create an array where each index represents the width
     * and store the number of invalid permuations of each
     * total number of rows.
     * 
     * 4. The final result will be the substracion of (2) - (3):
     * result = (valid + invalid) - (invalid)
     * 
     */
    public static int legoBlocks(int h, int w) {
        long divisor = 1000000007; // every calculation must be mod by this number

        // STEP 1:
        // Permutations for a single row is:
        // when width=0; 0 valid permutation
        // when width=1; 1 valid permutation
        // when width=2; 2 valid permutations
        // when width=3; 4 valid permutations
        // when width=4; 8 valid permutations
        // when widht=N; the sum of the previous 4 widths: (N-1) + (N-2) + (N-3) + (N-4)
        List<Long> singleRow = new ArrayList<>(Arrays.asList(0L, 1L, 2L, 4L, 8L));

        // STEP 2:
        // Total permutations for all rows:
        // when width=0; singleRow[0]^h valid permutations (always 0)
        // when width=1; singleRow[1]^h valid permutations (always 1)
        // when width=2; singleRow[2]^h valid permutations
        // when width=3; singleRow[3]^h valid permutations
        // when width=4; singleRow[4]^h valid permutations
        // when width=N; singleRow[N]^h valid permutations
        List<Long> total = new ArrayList<>(
                Arrays.asList(0L, 1L,
                        pow(2, h, divisor),
                        pow(4, h, divisor),
                        pow(8, h, divisor)));

        // Completes the singleRow and total arrays dynamically from
        // the previous values according to the above rules
        for (int i = 5; i <= w; i++) {
            long val = (singleRow.get(i - 1) + singleRow.get(i - 2) +
                    singleRow.get(i - 3) + singleRow.get(i - 4)) % divisor;
            singleRow.add(val);

            total.add(pow(val, h, divisor));
        }

        // STEP 3 Invalid permutations:
        // Perform a vertical cut across all rows of bricks
        // when width=0; 0 invalid permutations
        // when width=1; 0 invalid permutations
        List<Long> invalid = new ArrayList<>(Arrays.asList(0L, 0L));

        // This is the tricky part:
        // Starting with a 2-width cut up to the width
        // For each cut, walk 1-width at a time up to the cut
        // and add the result of the left * right (invalid permutations)
        // the left part are the valid permutations
        // the right part are all possible permutations (valid and invalid)
        for (int cut = 2; cut <= w; cut++) {
            long anum = 0;
            for (int i = 1; i < cut; i++) {
                long l = total.get(i) - invalid.get(i);
                long r = total.get(cut - i);
                anum += ((l * r) % divisor);
            }
            invalid.add(anum % divisor);
        }

        // STEP 4
        // We have finally calculated all the valid and invalid permuations
        // we only substract the invalid permutations from the total permuations
        long r = (total.get(w) - invalid.get(w)) % divisor;

        // In case the substraction is negative
        // add the divisor(mod) to the result to find out the real value
        while (r < 0)
            r += divisor;

        return (int) r;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedReader bufferedReader = new BufferedReader(new
        // FileReader("c:\\temp\\hackerrank_input.txt"));

        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, t).forEach(tItr -> {
            try {
                String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

                int n = Integer.parseInt(firstMultipleInput[0]);

                int m = Integer.parseInt(firstMultipleInput[1]);

                int result = Result.legoBlocks(n, m);

                bufferedWriter.write(String.valueOf(result));
                bufferedWriter.newLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        bufferedReader.close();
        bufferedWriter.close();
    }
}
