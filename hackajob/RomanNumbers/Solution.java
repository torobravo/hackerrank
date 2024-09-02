package hackajob.RomanNumbers;

public class Solution {

    public static String run(int n) {
        int[] values = { 1, 4, 5, 9, 10, 40, 50, 90, 100, 400, 500, 900, 1000 };
        String[] symbols = { "I", "IV", "V", "IX", "X", "XL", "L", "XC", "C", "CD", "D", "CM", "M" };

        String output = "";

        for (int i = values.length - 1; i >= 0; i--) {

            while (n >= values[i]) {
                output += symbols[i];
                n -= values[i];
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int n = 2016;

        System.out.println(run(n));
    }
}
