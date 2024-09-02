package hackajob.FindTheSingleton;

public class Solution {
    public static int run(int[] student_list) {
        int res = 0;
        for (int num : student_list) {
            res ^= num;
        }

        return res;
    }

    public static void main(String[] args) {
        int[] s = { 5, 3, 2, 2, 3, 5, 4, 6, 9, 6, 4, 12, 8, 9, 12 };

        System.out.println(run(s));
    }
}
