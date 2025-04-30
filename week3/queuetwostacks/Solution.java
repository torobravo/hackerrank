package week3.queuetwostacks;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        int q = scanner.nextInt();

        while (q-- > 0) {
            switch (scanner.nextInt()) {
                case 1:
                    s1.push(scanner.nextInt());
                    break;
                case 2:
                    if (s2.isEmpty()) {
                        while (!s1.empty()) {
                            s2.push(s1.pop());
                        }
                    }
                    s2.pop();
                    break;
                case 3:
                    if (s2.isEmpty()) {
                        while (!s1.empty()) {
                            s2.push(s1.pop());
                        }
                    }
                    System.out.println(s2.peek());
                    break;
                default:
            }
        }

        scanner.close();
    }
}
