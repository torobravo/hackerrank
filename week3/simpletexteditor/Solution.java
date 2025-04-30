package week3.simpletexteditor;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<String> history = new Stack<>();
        StringBuilder S = new StringBuilder();

        int q = scanner.nextInt();

        while (q-- > 0) {

            switch (scanner.nextInt()) {
                case 1: // Append(W)
                    history.push(S.toString());
                    S.append(scanner.next());
                    break;
                case 2: // Delete(k)
                    history.push(S.toString());
                    S.delete(S.length() - scanner.nextInt(), S.length());
                    break;
                case 3: // Print(k)
                    System.out.println(S.charAt(scanner.nextInt() - 1));
                    break;
                case 4: // Undo()
                    S = new StringBuilder(history.pop());
                    break;
                default:
            }

        }

        scanner.close();
    }
}
