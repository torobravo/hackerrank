package dsa.sorting;

import java.util.Date;
import java.util.Random;

public class Sorting {
    public static void main(String[] args) {
        int max = 100000;
        int[] items = new int[max];

        for(int i = 0; i < max; i++)
            items[i] = new Random().nextInt();        
        long start = new Date().getTime();
        BubbleSort.bubbleSort(items);
        long end = new Date().getTime();
        System.out.println("BubbleSort: " + (end - start) + " ms.");

        for(int i = 0; i < max; i++)
            items[i] = new Random().nextInt();
        start = new Date().getTime();
        QuickSort.quickSort(items, 0, items.length - 1);
        end = new Date().getTime();
        System.out.println("QuickSort: " + (end - start) + " ms.");

        for(int i = 0; i < max; i++)
            items[i] = new Random().nextInt();
        start = new Date().getTime();
        MergeSort.mergeSort(items, 0, items.length - 1);
        end = new Date().getTime();
        System.out.println("MergeSort: " + (end - start) + " ms.");
    }
}
