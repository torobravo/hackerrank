package dsa.binarysearch;

public class Solution {

    public static int search(int[] items, int num) {
        int left = 0;
        int right = items.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (items[mid] == num) {
                return mid;
            }

            if (items[mid] < num) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] items = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 }; // Must be sorted!!
        int minIndex = search(items, 11);
        if (minIndex > -1) {
            System.out.println("Min index found at: " + minIndex + " with value of " + items[minIndex]);
        } else {
            System.out.println("Not found");
        }
    }

}
