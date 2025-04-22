package dsa.sorting;

public class SelectionSort {

    // search through an array and keep track of the min value during
    // each iteration. At the end of each iteration, we swap variables.
    // Quadratic time O(n^2)
    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            // Start assumming this is the index of the min value
            int min = i;

            // Find the index of the min value
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }

            // Swap in-place
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public static void main(String[] args) {
        int[] items = { 9, 3, 1, 6, 8, 2, 5, 4, 7 };

        sort(items);

        for (int songID : items) {
            System.out.print(songID + " "); // This will print "1 2 3 4 5 6 7 8 9"
        }
    }
}
