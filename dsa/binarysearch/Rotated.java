package dsa.binarysearch;

public class Rotated {
    /*
     * Picture a scenario where you're sorting through a collection of books
     * arranged by publish date, and for some reason, they've gotten mixed up. You
     * now have a series where some books have been shifted from the beginning to
     * the end, and you must find the oldest book. This is the essence of a rotated
     * sorted array.
     */
    public static int findMin(int[] publishDates) {
        int left = 0;
        int right = publishDates.length - 1;
        while(left < right) {
            int mid = (left + right) / 2;
            if (publishDates[mid] > publishDates[right])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    public static void main(String[] args) {
        //int[] publishDates = new int[] {10, 20, 30, 40, 1, 2, 3, 4 };
        int[] publishDates = new int[] {5, 6, 7, 1, 2, 3, 4 };
        int minIndex = findMin(publishDates);
        System.out.println("Min index found at: " + minIndex + " with value of " + publishDates[minIndex]);
    }
}
