package dsa.sorting;

public class QuickSort {
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end];   // choosing the last element as pivot
        int i = (start - 1);    // marking the index of smaller element

        // place smaller elements on the left
        for (int j = start; j < end; j++) {           
            if (arr[j] <= pivot) {
                i++;

                // swap
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        // place the pivot in the already partitioned list
        // swap arr[i+1] and arr[end] (or pivot)
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;

        return (i+1); // return the partition point
    }

    static void quickSort(int[] arr, int start, int end) {
        if (start < end) {
            int pivot_index = partition(arr, start, end);
            quickSort(arr, start, pivot_index - 1); // sort left
            quickSort(arr, pivot_index + 1, end); // sort right
        }

    }

    public static void main(String[] args) {
        int[] items = {7, 3, 2, 10, 9, 5, 6, 9, 2, 3};

        quickSort(items, 0, items.length -1);
        for (int item : items) {
            System.out.print(item + " ");
        }

    }
}
