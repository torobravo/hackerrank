package dsa.sorting;

import java.util.Random;

public class BubbleSort {

    // imagine the collection is filled with water
    // heavy objects (rocks, sendiments) will sink to the bottom (the sorted
    // elements)
    // light objects (air, wood, bubbles) will flow to the top (the unsorted
    // elements)
    // .-- Place greatest element to end of the array --.
    // Quadratic time O(n^2)
    static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) { // recorre todo el arreglo hasta el penultimo elemento

            for (int j = 0; j < arr.length - 1 - i; j++) { // recorre todo el arreglo hasta el ultimo elemento
                                                           // ordenado
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] items = { 9, 3, 1, 6, 8, 2, 5, 4, 7 };

        bubbleSort(items);

        for (int songID : items) {
            System.out.print(songID + " "); // This will print "1 2 3 4 5 6 7 8 9"
        }
    }
}
