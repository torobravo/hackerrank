package week1.flippingbits;

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
     * Complete the 'flippingBits' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts LONG_INTEGER n as parameter.
     */

    public static long flippingBits(long n) {
        /*
         * 32-bit number can store 2^32 different values = 4,294,967,296
         * **Signed 32-bit integer limit = -2,147,483,648 To 2,147,483,647
         * **Unsigned 32-bit integer limit = 0 To 4,294,967,295
         * 
         * 0 in 32-bit integer binary form is: (0000 0000 0000 0000 0000 0000 0000 0000)
         * 1 in 32-bit integer binary form is: (0000 0000 0000 0000 0000 0000 0000 0001)
         * 4294967295 in 32-bit binary form is:(1111 1111 1111 1111 1111 1111 1111 1111)
         * 
         * (VAL) 0000 0000 0000 0000 0000 0000 0000 0000 0001 (1)
         * (XOR) 1111 1111 1111 1111 1111 1111 1111 1111 1111 (4,294,967,295)
         * ====================================================
         * (RES) 1111 1111 1111 1111 1111 1111 1111 1111 1110 (4,294,967,294)
         */

        // return ~n & 0xffffffffL;
        // return ~n & (1L << 32) - 1;
        // return n ^ (1L << 32) - 1;
        return n ^ 0xffffffffL;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        int q = Integer.parseInt(bufferedReader.readLine().trim());

        IntStream.range(0, q).forEach(qItr -> {
            try {
                long n = Long.parseLong(bufferedReader.readLine().trim());

                long result = Result.flippingBits(n);

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
