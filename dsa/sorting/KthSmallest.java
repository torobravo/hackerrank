package dsa.sorting;

public class KthSmallest {
    static int partition(int[] arr, int start, int end) {
        int pivot = arr[start];
        int i = start;
    
        for(int j = start + 1; j <= end; j++) {
            if(arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    
        int temp = arr[i];
        arr[i] = arr[start];
        arr[start] = temp;
    
        return i;
    }

    public static int findKthSmallest(int[] numbers, int k) {
        if(numbers == null || numbers.length < k)
            return Integer.MIN_VALUE;
        return kthSmallest(numbers, 0, numbers.length - 1, k);
    }

    static int kthSmallest(int[] arr, int start, int end, int k) {
        if (k > 0 && k <= end - start + 1) {
            int pos = partition(arr, start, end);

            if (pos - start == k - 1) {
                return arr[pos];
            }

            if (pos - start > k - 1) {
                return kthSmallest(arr, start, pos - 1, k);
            }

            return kthSmallest(arr, pos + 1, end, k - pos + start - 1);
        }

        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 7, 2, 4, 2, 1, 6};
        System.out.println(findKthSmallest(numbers, 5));  // It should print 4
    }
}
