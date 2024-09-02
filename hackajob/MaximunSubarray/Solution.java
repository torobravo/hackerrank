package hackajob.MaximunSubarray;

public class Solution {

    public static int run(int[] a) {
        int maximum_sum = Integer.MIN_VALUE;
        int current = 0;
        for (int num : a) {
            current += num;
            if (current < num)
                current = num;

            if (maximum_sum < current)
                maximum_sum = current;
        }
        return maximum_sum;
    }

    public static void main(String[] args) {
        int[] a = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };

        int res = run(a);

        System.out.println("The maximun subarray is: " + res);
    }
}
