package hackajob.FizzBuzz;

import java.io.*;
import java.util.*;

public class Solution {
    public static void printFizzBuzz(int N, int M) {
        String sequence = "";
        for (int i = N; i <= M; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                sequence += "FizzBuzz";
            else if (i % 3 == 0)
                sequence += "Fizz";
            else if (i % 5 == 0)
                sequence += "Buzz";
            else
                sequence += Integer.toString(i);

            sequence += ",";
        }

        System.out.println(
                sequence.substring(0, sequence.length() - 1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();

        printFizzBuzz(N, M);
    }
}