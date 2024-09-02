package hackajob.MovieCollection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    public static int[] run(int n, int m, int[] movies) {
        int[] result = new int[m];
        int resultIndex = 0;

        int[] tower = new int[n];

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            tower[i] = i + 1;
        }

        for (int movie : movies) {
            int towerIndex = 0;
            int top = tower[towerIndex++];
            int cntr = 0;
            int tempIndex = 0;
            while (movie != top) {
                temp[tempIndex++] = top;
                top = tower[towerIndex++];
                cntr++;
            }

            result[resultIndex++] = cntr;

            for (int i = tempIndex - 1; i >= 0; i--) {
                tower[--towerIndex] = temp[i];
            }

            tower[0] = top;
        }

        return result;
    }

    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int[] movies = { 4, 4, 5 };

        Stack<Integer> tower = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        List<Integer> result = new ArrayList<>();

        for (int i = n; i > 0; i--) {
            tower.push(i);
        }

        for (int movie : movies) {

            int top = tower.pop();
            int cntr = 0;
            while (movie != top) {
                temp.push(top);
                top = tower.pop();
                cntr++;
            }

            result.add(cntr);

            while (!temp.empty())
                tower.push(temp.pop());

            tower.push(top);
        }

        for (int num : result)
            System.out.print(num + " ");

        int[] res = run(n, m, movies);

        for (int i : res) {
            System.out.print(i + " ");
        }

    }
}
