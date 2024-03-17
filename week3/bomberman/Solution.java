package week3.bomberman;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

class Result {

    /*
     * Complete the 'bomberMan' function below.
     *
     * The function is expected to return a STRING_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER n
     * 2. STRING_ARRAY grid
     */

    public static List<String> bomberMan(int n, List<String> grid) {
        char BOMB = 'O', DOT = '.';
        List<String> grid2 = new ArrayList<>();
        String filledBombs = new String("");
        for (int i = 0; i < grid.get(0).length(); i++) {
            filledBombs += BOMB;
        }

        List<String> filled = new ArrayList<>();
        for (int j = 0; j < grid.size(); j++) {
            filled.add(filledBombs);
        }

        /*
         * 4 possible states:
         * 
         * 1. Original grid (n = 1)
         * 2. Full of bombs (n = 2, 4, 6...)
         * 3. Detonate 1 time (n = 3, 7, 11...)
         * 4. Detonate 2 times (n = 5, 9, 13...)
         */

        if (n == 1)
            return grid;

        if ((n % 2) == 0)
            return filled;

        int maxFlips = 1;
        if (n % 4 == 1) // (n = 5, 9, 13...)
            maxFlips = 2;

        // original
        grid2.addAll(grid);

        while (maxFlips-- > 0) {
            grid.clear();
            grid.addAll(filled);
            for (int y = 0; y < grid.size(); y++) {
                for (int x = 0; x < grid.get(0).length(); x++) {
                    if (grid2.get(y).charAt(x) == BOMB) {

                        StringBuilder sb = new StringBuilder(grid.get(y));
                        sb.setCharAt(x, DOT);
                        grid.set(y, sb.toString());

                        // up
                        if (y > 0) {
                            sb = new StringBuilder(grid.get(y - 1));
                            sb.setCharAt(x, DOT);
                            grid.set(y - 1, sb.toString());
                        }
                        // down
                        if (y < grid2.size() - 1) {
                            sb = new StringBuilder(grid.get(y + 1));
                            sb.setCharAt(x, DOT);
                            grid.set(y + 1, sb.toString());
                        }
                        // left
                        if (x > 0) {
                            sb = new StringBuilder(grid.get(y));
                            sb.setCharAt(x - 1, DOT);
                            grid.set(y, sb.toString());
                        }
                        // right
                        if (x < grid.get(0).length() - 1) {
                            sb = new StringBuilder(grid.get(y));
                            sb.setCharAt(x + 1, DOT);
                            grid.set(y, sb.toString());
                        }
                    }

                }
            }
            grid2.clear();
            grid2.addAll(grid);
        }

        return grid2;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int r = Integer.parseInt(firstMultipleInput[0]);

        int c = Integer.parseInt(firstMultipleInput[1]);

        int n = Integer.parseInt(firstMultipleInput[2]);

        List<String> grid = new ArrayList<>();

        for (int i = 0; i < r; i++) {
            String gridItem = bufferedReader.readLine();
            grid.add(gridItem);
        }

        List<String> result = Result.bomberMan(n, grid);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(result.get(i));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
