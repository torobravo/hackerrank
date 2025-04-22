package dsa.sorting;

public class InsertionSort {

    // after comparing element to the left
    // shift elements to the right to make room to insert a value
    // Quadratic time O(n^2)
    public static void sort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;

            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = tmp;
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
