package week3.simpletexteditor;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /*
         * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
         * class should be named Solution.
         */
        Stack<String> stack = new Stack<>();
        StringBuilder textEditor = new StringBuilder();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        while (q-- > 0) {
            String op = scanner.next();
            switch (op) {
                case "1":
                    stack.push(textEditor.toString());
                    textEditor.append(scanner.next());
                    break;
                case "2":
                    int k1 = scanner.nextInt();
                    stack.push(textEditor.toString());
                    textEditor.delete(textEditor.length() - k1, textEditor.length());
                    break;
                case "3":
                    int k2 = scanner.nextInt();
                    System.out.println(textEditor.charAt(k2 - 1));
                    break;
                case "4":
                    textEditor = new StringBuilder(stack.pop());
                    break;
                default:
                    break;
            }

        }
        scanner.close();
    }
}
