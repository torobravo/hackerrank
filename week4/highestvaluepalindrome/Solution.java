package week4.highestvaluepalindrome;

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
     * Complete the 'highestValuePalindrome' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     * 1. STRING s
     * 2. INTEGER n
     * 3. INTEGER k
     */

    public static String highestValuePalindrome(String s, int n, int k) {
        StringBuilder sb = new StringBuilder(s);
        int mismatch = 0;

        // find all mismatch chars in string
        for (int i = 0; i < n / 2; i++) {
            if (sb.charAt(i) != sb.charAt(n - i - 1))
                mismatch++;
        }

        // more mismatches than allowed changes
        if (mismatch > k)
            return "-1";

        int remain = k - mismatch; // remaining extra changes

        for (int i = 0; i < n / 2; i++) {
            char left = sb.charAt(i);
            char right = sb.charAt(n - i - 1);

            if (left == right) {
                if (left != '9' && remain >= 2) {
                    sb.setCharAt(i, '9');
                    sb.setCharAt(n - i - 1, '9');
                    remain -= 2;
                }
            } else {
                if (left != '9' && right != '9' && remain > 0) {
                    sb.setCharAt(i, '9');
                    sb.setCharAt(n - i - 1, '9');
                    remain -= 1;
                } else {
                    if (left > right) {
                        sb.setCharAt(n - i - 1, left);
                    } else {
                        sb.setCharAt(i, right);
                    }
                }
            }
        }

        if (n % 2 == 1 && remain > 0) {
            sb.setCharAt(n / 2, '9');
        }

        return sb.toString();

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        // BufferedReader bufferedReader = new BufferedReader(new
        // FileReader("C:/temp/hackerrank_input.txt"));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        String s = bufferedReader.readLine();

        String result = Result.highestValuePalindrome(s, n, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
