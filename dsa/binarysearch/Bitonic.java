package dsa.binarysearch;

public class Bitonic {
    /*
     * Consider a scenario where you're dealing with a dataset akin to a roller
     * coaster ride — you start with a steady climb (ascending values), reach the
     * summit (the peak value), and then take a thrilling dive (descending values).
     * This is precisely what a bitonic array resembles
     */
    public static int findPeak(int[] temperatures) {
        int low = 0;
        int high = temperatures.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;
            if (temperatures[mid] > temperatures[mid + 1])
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    public static int binarysearch(int[] temperatures, int low, int high, int target, boolean ascending) {
        while(low <= high) {
            int mid = (low + high) / 2;

            if (temperatures[mid] == target)
                return mid;

            if (ascending ? temperatures[mid] < target : temperatures[mid] > target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] temperatures = new int[]{ 10, 20, 30, 40, 50, 60, 40, 35, 10};
        int target = 35;

        int peakIndex = findPeak(temperatures);
        System.out.println("Peak index = " + peakIndex + " value = " + temperatures[peakIndex] );

        int searchResult = binarysearch(temperatures, 0, peakIndex, target, true);
        if (searchResult == -1)
            searchResult = binarysearch(temperatures, peakIndex + 1, temperatures.length - 1, target, false);

        System.out.println("Target value of " + target + " found at index: " + searchResult);

    }
}
