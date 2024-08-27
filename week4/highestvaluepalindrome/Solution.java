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
        for (int start = 0, end = n - 1; start < n / 2; start++, end--) {
            char left = sb.charAt(start);
            char right = sb.charAt(end);
            if (left != right)
                mismatch += 1;
        }

        if (mismatch > k)
            return "-1"; // return early

        int remain = k - mismatch; // remaining extra changes
        for (int i = 0; i < n / 2; i++) {
            char left = sb.charAt(i);
            char right = sb.charAt(n - 1 - i);

            if (left != right) {
                if (left == '9') {
                    sb.setCharAt(n - 1 - i, left);
                } else if (right == '9') {
                    sb.setCharAt(i, right);
                } else {
                    if (remain > 0) {
                        if (left != '9') {
                            sb.setCharAt(i, '9');
                            remain -= 1;
                        }
                        if (right != '9') {
                            sb.setCharAt(n - 1 - i, '9');
                            remain -= 1;
                        }
                    } else {
                        if (left < right) {
                            sb.setCharAt(i, right);
                        } else {
                            sb.setCharAt(n - 1 - i, left);
                        }
                    }
                }
            } else if (remain >= 2) {
                if (left != '9') {
                    sb.setCharAt(i, '9');
                    remain -= 1;
                }
                if (right != '9') {
                    sb.setCharAt(n - 1 - i, '9');
                    remain -= 1;
                }
            }

        }

        if (n % 2 == 1 && remain > 0) {
            sb.setCharAt(n / 2, '9');
        }

        return sb.toString();
    }

    public static String highestValuePalindromehhh(String s, int n, int k) {
        StringBuilder input = new StringBuilder(s);
        int need = 0;
        int changes = 0;
        for (int i = 0; i < n / 2; i++) {
            char left = input.charAt(i);
            char right = input.charAt(n - 1 - i);
            if (left != right)
                need++;
        }
        if (need > k) {
            return "-1";
        } else {
            int free = k - need;
            for (int i = 0; i < n / 2; i++) {
                char left = input.charAt(i);
                char right = input.charAt(n - 1 - i);
                if (free >= 2) {
                    if (left != right)
                        free++;
                    if (left != '9') {
                        input.setCharAt(i, '9');
                        changes++;
                        free--;
                    }
                    if (right != '9') {
                        input.setCharAt(n - 1 - i, '9');
                        changes++;
                        free--;
                    }
                } else if (free == 1) {
                    if (left != right) {
                        if (left == '9' || right == '9')
                            free++;
                        if (left != '9') {
                            input.setCharAt(i, '9');
                            changes++;
                            free--;
                        }
                        if (right != '9') {
                            input.setCharAt(n - 1 - i, '9');
                            changes++;
                            free--;
                        }
                    }
                } else {
                    if (left != right) {
                        if (left > right) {
                            input.setCharAt(n - 1 - i, left);
                            changes++;
                        } else {
                            input.setCharAt(i, right);
                            changes++;
                        }
                    }
                }
            }
            if (n % 2 == 1 && free > 0)
                input.setCharAt(n / 2, '9');
            return input.toString();
        }

    }

    public static String highestValuePalindrome1(String s, int n, int k) {
        int mid = n / 2;
        String numStr = "987654321";
        StringBuilder str = new StringBuilder(s);
        for (int left = 0, right = n - 1; left < mid && right >= mid; left++, right--) {
            int i = 0, j = 0;

            while (str.charAt(left) != str.charAt(right) && k > 0 && i < numStr.length()) {
                if (numStr.charAt(i) > str.charAt(left)) {
                    str.replace(left, left + 1, String.valueOf(numStr.charAt(i)));
                    k--;
                    j = 0;
                }

                if (numStr.charAt(j % 8) > s.charAt(right)) {
                    str.replace(right, right + 1, String.valueOf(numStr.charAt(j % 8)));
                    k--;
                    j++;
                }

                if (j % 8 == 0)
                    i += 1;

            }

            if (str.charAt(left) != str.charAt(right))
                return "-1";
        }
        return str.toString();
    }

    public static String highestValuePalindrome4(String s, int n, int k) {
        if (n == 1)
            return "9";

        if (k == 0)
            return isPalindrome(s, 0, n - 1) ? s : "-1";

        StringBuilder sb = new StringBuilder(s);
        int mid = n / 2;
        int end = n - 1;
        int start = 0;
        for (; start <= mid; start++) {
            if (k == 1) {
                int i = minIndex(s, start, end - start);
                if (i > -1) {
                    sb.replace(i, i + 1, "9");
                    k -= 1;
                }
            } else if (k > 1) {
                if (sb.charAt(start) != '9') {
                    sb.replace(start, start + 1, "9");
                    k -= 1;
                }
                if (sb.charAt(end - start) != '9') {
                    sb.replace(end - start, end - start + 1, "9");
                    k -= 1;
                }

            } else {
                break;
            }
        }

        return isPalindrome(sb.toString(), start, end - start) ? sb.toString() : "-1";

    }

    private static int minIndex(String s, int start, int end) {
        int index = -1;
        do {
            if (s.charAt(start) > s.charAt(end)) {
                index = end;
                break;
            } else if (s.charAt(start) < s.charAt(end)) {
                index = start;
                break;
            } else {
                index = start;
            }
        } while (start++ < end--);
        return index;
    }

    private static boolean isPalindrome(String s, int start, int end) {
        do {
            if (s.charAt(start) != s.charAt(end))
                return false;

        } while (start++ < end--);

        return true;
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
