package week4.castlegrid;

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
     * Complete the 'minimumMoves' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     * 1. STRING_ARRAY grid
     * 2. INTEGER startX
     * 3. INTEGER startY
     * 4. INTEGER goalX
     * 5. INTEGER goalY
     */

    public static int minimumMoves(List<String> grid, int startX, int startY, int goalX, int goalY) {

        int[][] neighbours = { { 0, -1 }, { 0, 1 }, { 1, 0 }, { -1, 0 } };
        int rows = grid.size();
        int cols = grid.get(0).length();

        boolean[][] visited = new boolean[rows][cols];
        Node[][] previous = new Node[rows][cols];
        Queue<Node> q = new LinkedList<>();

        visited[startX][startY] = true;
        q.offer(new Node(startX, startY));

        while (!q.isEmpty()) {
            Node current = q.poll();

            for (int[] neighbour : neighbours) {
                int nextX = current.x;
                int nextY = current.y;

                while (true) {
                    nextX += neighbour[0];
                    nextY += neighbour[1];

                    // guard out of bounds
                    if ((nextX < 0 || nextX >= rows) || nextY < 0 || nextY >= cols)
                        break;

                    // if blocked, stop and continue next direction
                    boolean isBlocked = grid.get(nextX).charAt(nextY) == 'X';
                    if (isBlocked)
                        break;

                    // if not visited
                    if (!visited[nextX][nextY]) {
                        Node newNode = new Node(nextX, nextY);
                        visited[nextX][nextY] = true;
                        previous[nextX][nextY] = current;
                        q.offer(newNode);
                    }

                    // if found, count previous nodes and exits
                    if (nextX == goalX && nextY == goalY) {
                        int counter = 0;
                        Node node = previous[goalX][goalY];
                        while (node != null) {
                            node = previous[node.x][node.y];
                            counter++;
                        }

                        return counter;
                    }
                }
            }
        }

        return -1;

    }

    static class Node {
        int x;
        int y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> grid = IntStream.range(0, n).mapToObj(i -> {
            try {
                return bufferedReader.readLine();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
                .collect(toList());

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int startX = Integer.parseInt(firstMultipleInput[0]);

        int startY = Integer.parseInt(firstMultipleInput[1]);

        int goalX = Integer.parseInt(firstMultipleInput[2]);

        int goalY = Integer.parseInt(firstMultipleInput[3]);

        int result = Result.minimumMoves(grid, startX, startY, goalX, goalY);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
