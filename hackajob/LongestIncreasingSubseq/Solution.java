package hackajob.LongestIncreasingSubseq;

public class Solution {

    public static int LIS(int[] sequence) {
        int n = sequence.length;
        int[] dp = new int[n];

        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (sequence[i] > sequence[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int length : dp)
            maxLength = Math.max(maxLength, length);

        return maxLength;
    }

    public static void main(String[] args) {
        // int[] sequence = { 15, 27, 14, 38, 26, 55, 46, 65, 85 };
        int[] sequence = { 5, 2, 8, 6, 3, 6, 9, 7 };

        int result = LIS(sequence);

        System.out.println(result);
    }
}
