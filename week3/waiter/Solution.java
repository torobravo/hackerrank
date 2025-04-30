package week3.waiter;

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

    private static List<Integer> getPrimes(int q) {
        List<Integer> primes = new ArrayList<>();
        Integer ith = 2;
        while (primes.size() < q) {
            if (new BigInteger(ith.toString()).isProbablePrime(100)) {
                primes.add(ith++);
            }
        }

        return primes;
    }

    /*
     * Complete the 'waiter' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     * 1. INTEGER_ARRAY number
     * 2. INTEGER q
     */

    public static List<Integer> waiter(List<Integer> number, int q) {
        List<Integer> primes = getPrimes(q);
        List<Integer> answers = new ArrayList<>();

        Stack<Integer> a = new Stack<>();
        // Stack the plates in reverse order
        a.addAll(number);

        for (int i = 0; i < q; i++) {
            Stack<Integer> tempA = new Stack<>();
            Stack<Integer> tempB = new Stack<>();

            while (!a.isEmpty()) {
                int item = a.pop();
                // Check if divisible by ith-prime
                if (item % primes.get(i) == 0)
                    tempB.push(item);
                else
                    tempA.push(item);
            }

            // Move elements to answers
            while (!tempB.isEmpty()) {
                answers.add(tempB.pop());
            }

            a = tempA;
        }
        // Move remaining elements in A
        while (!a.isEmpty()) {
            answers.add(a.pop());
        }

        return answers;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        // BufferedWriter bufferedWriter = new BufferedWriter(new
        // FileWriter(System.getenv("OUTPUT_PATH")));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int q = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> number = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        List<Integer> result = Result.waiter(number, q);

        bufferedWriter.write(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
                        + "\n");

        bufferedReader.close();
        bufferedWriter.close();
    }
}
