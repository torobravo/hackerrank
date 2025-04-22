package leetcode.closetozero;

public class Solution {

    static int findClosestNumber(int[] nums) {
        int maxNeg = Integer.MIN_VALUE;
        int minPos = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < 0) {
                if (maxNeg < num)
                    maxNeg = num;
            } else if (num > 0) {
                if (minPos > num)
                    minPos = num;
            } else {
                return 0;
            }
        }

        if (maxNeg == Integer.MIN_VALUE)
            return minPos;

        if (minPos == Integer.MAX_VALUE)
            return maxNeg;

        if (-maxNeg >= minPos)
            return minPos;
        else
            return maxNeg;
    }

    public static void main(String[] args) {

        int[] nums = { -10, -12, -54, -12, -544, -10000 };
        System.out.println(findClosestNumber(nums));
    }
}
