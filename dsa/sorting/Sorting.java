package dsa.sorting;

import java.util.Arrays;
import java.util.Date;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        int max = 100000;
        int[] items = new int[max];

        for (int i = 0; i < max; i++)
            items[i] = new Random().nextInt(max);

        int[] bItems = Arrays.copyOf(items, max);
        long start = new Date().getTime();
        BubbleSort.bubbleSort(bItems);
        long end = new Date().getTime();
        System.out.println("BubbleSort: " + (end - start) + " ms.");

        int[] sItems = Arrays.copyOf(items, max);
        start = new Date().getTime();
        SelectionSort.sort(sItems);
        end = new Date().getTime();
        System.out.println("SelectionSort: " + (end - start) + " ms.");

        int[] iItems = Arrays.copyOf(items, max);
        start = new Date().getTime();
        InsertionSort.sort(iItems);
        end = new Date().getTime();
        System.out.println("InsertionSort: " + (end - start) + " ms.");

        int[] qItems = Arrays.copyOf(items, max);
        start = new Date().getTime();
        QuickSort.quickSort(qItems, 0, qItems.length - 1);
        end = new Date().getTime();
        System.out.println("QuickSort: " + (end - start) + " ms.");

        int[] mItems = Arrays.copyOf(items, max);
        start = new Date().getTime();
        MergeSort.mergeSort(mItems, 0, mItems.length - 1);
        end = new Date().getTime();
        System.out.println("MergeSort: " + (end - start) + " ms.");
    }
}
