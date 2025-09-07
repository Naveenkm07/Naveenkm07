/**
 * Implementation of Common Sorting Algorithms
 * Difficulty: Medium 🟡
 * Topic: Algorithms, Sorting
 */
import java.util.Arrays;

public class SortingAlgorithms {
    
    /**
     * Bubble Sort Algorithm
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
            // If no swapping occurred, array is sorted
            if (!swapped) break;
        }
    }
    
    /**
     * Selection Sort Algorithm
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Swap minimum element with first element
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    /**
     * Insertion Sort Algorithm
     * Time Complexity: O(n²)
     * Space Complexity: O(1)
     */
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            
            // Move elements greater than key one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }
    
    /**
     * Merge Sort Algorithm (Recursive)
     * Time Complexity: O(n log n)
     * Space Complexity: O(n)
     */
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            
            merge(arr, left, mid, right);
        }
    }
    
    /**
     * Merge function for merge sort
     */
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }
    
    /**
     * Quick Sort Algorithm
     * Average Time Complexity: O(n log n)
     * Space Complexity: O(log n)
     */
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            
            quickSort(arr, low, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, high);
        }
    }
    
    /**
     * Partition function for quick sort
     */
    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        
        return i + 1;
    }
    
    /**
     * Utility method to print array
     */
    public static void printArray(int[] arr, String sortName) {
        System.out.println(sortName + ": " + Arrays.toString(arr));
    }
    
    /**
     * Main method to demonstrate all sorting algorithms
     */
    public static void main(String[] args) {
        int[] originalArray = {64, 34, 25, 12, 22, 11, 90, 88, 76, 50, 42};
        
        System.out.println("=== Sorting Algorithms Demo ===");
        System.out.println("Original Array: " + Arrays.toString(originalArray));
        System.out.println();
        
        // Test Bubble Sort
        int[] bubbleArray = originalArray.clone();
        long startTime = System.nanoTime();
        bubbleSort(bubbleArray);
        long endTime = System.nanoTime();
        printArray(bubbleArray, "Bubble Sort");
        System.out.println("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // Test Selection Sort
        int[] selectionArray = originalArray.clone();
        startTime = System.nanoTime();
        selectionSort(selectionArray);
        endTime = System.nanoTime();
        printArray(selectionArray, "Selection Sort");
        System.out.println("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // Test Insertion Sort
        int[] insertionArray = originalArray.clone();
        startTime = System.nanoTime();
        insertionSort(insertionArray);
        endTime = System.nanoTime();
        printArray(insertionArray, "Insertion Sort");
        System.out.println("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // Test Merge Sort
        int[] mergeArray = originalArray.clone();
        startTime = System.nanoTime();
        mergeSort(mergeArray, 0, mergeArray.length - 1);
        endTime = System.nanoTime();
        printArray(mergeArray, "Merge Sort");
        System.out.println("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n");
        
        // Test Quick Sort
        int[] quickArray = originalArray.clone();
        startTime = System.nanoTime();
        quickSort(quickArray, 0, quickArray.length - 1);
        endTime = System.nanoTime();
        printArray(quickArray, "Quick Sort");
        System.out.println("Time taken: " + (endTime - startTime) / 1000000.0 + " ms\n");
    }
}
