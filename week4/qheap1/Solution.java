package week4.qheap1;

import java.io.*;
import java.util.*;

public class Solution {

    static class MyHeap {
        private long[] items;
        private int capacity = 10;
        private int size;

        private int leftIndex(int index) {
            return index * 2 + 1;
        }

        private int rightIndex(int index) {
            return index * 2 + 2;
        }

        private int parentIndex(int index) {
            return (index - 1) / 2;
        }

        private long getLeftNode(int index) {
            return items[leftIndex(index)];
        }

        private long getRightNode(int index) {
            return items[rightIndex(index)];
        }

        private long getParentNode(int index) {
            return items[parentIndex(index)];
        }

        private boolean hasLeftNode(int index) {
            return leftIndex(index) < size;
        }

        private boolean hasRightNode(int index) {
            return rightIndex(index) < size;
        }

        private boolean hasParentNode(int index) {
            return parentIndex(index) >= 0;
        }

        public MyHeap() {
            this.size = 0;
            this.items = new long[capacity];
        }

        public void add(int item) {
            checkCapacity();
            this.items[size] = item;
            this.size += 1;
            heapifyUp();
        }

        public long poll() {
            long head = items[0];
            swap(0, size - 1);
            size -= 1;
            heapifyDown();

            return head;
        }

        public long peek() {
            long item = items[0];
            return item;
        }

        public void remove(int item) {
            int index = search(item);
            swap(index, size - 1);
            size -= 1;
            heapifyDown(index);
        }

        public int search(int item) {
            for (int i = 0; i < size; i++) {
                if (item == items[i])
                    return i;
            }

            return -1;
        }

        private void checkCapacity() {
            if (size >= capacity) { // grow
                this.capacity *= 2;
                long[] newItems = new long[capacity];
                for (int i = 0; i < size; i++) {
                    newItems[i] = items[i];
                }
                this.items = newItems;
            }
        }

        private void swap(int indexOne, int indexTwo) {
            long tmp = this.items[indexOne];
            this.items[indexOne] = this.items[indexTwo];
            this.items[indexTwo] = tmp;
        }

        private void heapifyUp() {
            int index = size - 1;
            while (hasParentNode(index) && getParentNode(index) > items[index]) {
                swap(parentIndex(index), index);
                index = parentIndex(index);
            }
        }

        private void heapifyDown() {
            heapifyDown(0);
        }

        private void heapifyDown(int currentIndex) {

            while (hasLeftNode(currentIndex)) {
                int smallerChildIndex = leftIndex(currentIndex);
                if (hasRightNode(currentIndex) && getRightNode(currentIndex) < getLeftNode(currentIndex)) {
                    smallerChildIndex = rightIndex(currentIndex);
                }

                if (items[smallerChildIndex] < items[currentIndex]) {
                    swap(currentIndex, smallerChildIndex);
                }

                currentIndex = smallerChildIndex;
            }
        }

    }

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);

        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        Solution.MyHeap pq = new Solution.MyHeap();
        int Q = scanner.nextInt();
        while (Q-- > 0) {
            int op = scanner.nextInt();
            switch (op) {
                case 1: // add
                    pq.add(scanner.nextInt());
                    break;
                case 2: // delete
                    pq.remove(scanner.nextInt());
                    break;
                default: // print

                    System.out.println(pq.peek());

            }
        }

        scanner.close();
    }
}
