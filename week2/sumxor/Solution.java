package week2.sumxor;

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
     * Complete the 'sumXor' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long sumXor(long n) {
        // Since (n + x) = (n OR X) = (n XOR x) except when both bits are 1
        // n x n|x n^x n&x
        // ----------------------
        // 0 0 0 0 0
        // 0 1 1 1 0
        // 1 0 1 1 0
        // 1 1 1 0 <--- 1
        //
        // The strategy is to only consider when (n OR x) = (n XOR x),
        // and that only occurs when (n AND 1) == 0
        // The way we do that is to loop through all bits and drop the right
        // bit (right shift) in very iteration (n>>1). We count how many times
        // the condition (n AND 1) == 0 is met.
        // Finally we rise the counter to power of 2 to obtain the result.
        // Why power of 2? Because we have 2 possible combination for very bit
        // of n.
        //

        int counter = 0;
        while (n > 0) {
            if ((n & 1) == 0) // count only when n|x == n^x
                counter++;
            n = n >> 1; // drop right-most digit (cut the number in half)
        }
        return 1l << counter; // a nice way to rise a number to power of 2

    }

    public static long sumXor2(long n) {
        // SOLUTION 2
        // Count how many zeros are in the binary representation of the input
        if (n == 0) {
            return 1;
        }
        String num = Long.toBinaryString(n);
        long counter = 0;
        char[] arr = num.toCharArray();
        for (char ar : arr) {
            if (ar == '0') {
                counter++;
            }
        }
        return (long) Math.pow(2, counter);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(bufferedReader.readLine().trim());

        long result = Result.sumXor(n);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
