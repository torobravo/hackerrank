package week3.queuetwostacks;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < q; i++) {
            String line = scanner.nextLine();
            String[] cmd = line.split("\\s");

            switch (cmd[0]) {
                case "1":
                    s1.push(cmd[1]);
                    break;
                case "2":
                    if (s2.isEmpty()) {
                        while (!s1.isEmpty()) {
                            s2.push(s1.pop());
                        }
                    }
                    s2.pop();
                    break;
                case "3":
                    if (s2.isEmpty()) {
                        while (!s1.isEmpty()) {
                            s2.push(s1.pop());
                        }
                    }
                    System.out.println(s2.peek());
                    break;
                default:
                    break;
            }
        }

        scanner.close();

    }
}
