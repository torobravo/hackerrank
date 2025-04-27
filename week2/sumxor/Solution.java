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
        /*
         * The equation n + x = n XOR X holds true when there are
         * no carry-overs in the binary addition of n and x. This
         * happens when n and x have not set bits in the same position.
         * 
         * 1. Identify Unset bits in n:
         * * For each bit position in n, if the bit is 0, then
         * * the corresponding bit in x can be 0 or 1.
         * 
         * 2. Count the number of Unset bits
         * * The number of valid x is determined by the number of
         * * unset (0) bits in n. If there are k unset bits, there are
         * * 2^k possible values of x.
         */

        int counter = 0;
        while (n > 0) {
            if ((n & 1) == 0) // counts the number of unset bits (0)
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
