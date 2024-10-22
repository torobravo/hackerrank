package dsa.sorting;

public class MergeSort {

    static void merge(int[] arr, int start, int mid, int end) {
        int lf = mid - start + 1;
        int rt = end - mid;
        
        int[] left = new int[lf];
        int[] right = new int[rt];

        for(int i = 0; i < lf; i++)
            left[i] = arr[start + i];
        for(int j = 0; j < rt; j++)
            right[j] = arr[mid + j + 1];
        
        int i = 0, j = 0;
        int k = start;
        while(i < lf && j < rt) {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
                arr[k++] = right[j++];
        }

        while(i < lf)
            arr[k++] = left[i++];
        while(j < rt)
            arr[k++] = right[j++];
    }


    static void mergeSort(int[] items, int start, int end) {
        if (start >= end)
            return;

        int mid = (start + end) / 2;
        mergeSort(items, start, mid);
        mergeSort(items, mid + 1, end);
        merge(items, start, mid, end);
    }

    public static void main(String[] args) {
        int[] items = {9, 3, 1, 6, 8, 2, 5, 4, 7};
        mergeSort(items, 0, items.length - 1);

        for (int songID : items) {
            System.out.print(songID + " "); // This will print "1 2 3 4 5 6 7 8 9"
        }
    }
}
