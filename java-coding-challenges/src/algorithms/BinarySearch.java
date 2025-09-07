/**
 * Binary Search Algorithm Implementation
 * Difficulty: Medium 🟡
 * Topic: Algorithms, Searching
 */
import java.util.Arrays;

public class BinarySearch {
    
    /**
     * Iterative Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     * @param arr sorted array to search in
     * @param target value to find
     * @return index of target or -1 if not found
     */
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return -1; // Target not found
    }
    
    /**
     * Recursive Binary Search
     * Time Complexity: O(log n)
     * Space Complexity: O(log n)
     * @param arr sorted array to search in
     * @param target value to find
     * @param left starting index
     * @param right ending index
     * @return index of target or -1 if not found
     */
    public static int binarySearchRecursive(int[] arr, int target, int left, int right) {
        if (left > right) {
            return -1; // Base case: target not found
        }
        
        int mid = left + (right - left) / 2;
        
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] < target) {
            return binarySearchRecursive(arr, target, mid + 1, right);
        } else {
            return binarySearchRecursive(arr, target, left, mid - 1);
        }
    }
    
    /**
     * Find first occurrence of target
     * @param arr sorted array with possible duplicates
     * @param target value to find
     * @return index of first occurrence or -1 if not found
     */
    public static int findFirstOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1; // Continue searching left
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * Find last occurrence of target
     * @param arr sorted array with possible duplicates
     * @param target value to find
     * @return index of last occurrence or -1 if not found
     */
    public static int findLastOccurrence(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1; // Continue searching right
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return result;
    }
    
    /**
     * Find insertion point for target in sorted array
     * @param arr sorted array
     * @param target value to insert
     * @return index where target should be inserted
     */
    public static int findInsertionPoint(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return left;
    }
    
    /**
     * Search in rotated sorted array
     * @param arr rotated sorted array
     * @param target value to find
     * @return index of target or -1 if not found
     */
    public static int searchRotatedArray(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            
            // Check which half is sorted
            if (arr[left] <= arr[mid]) {
                // Left half is sorted
                if (target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // Right half is sorted
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    /**
     * Main method to demonstrate binary search implementations
     */
    public static void main(String[] args) {
        System.out.println("=== Binary Search Demo ===\n");
        
        // Standard binary search test
        int[] sortedArray = {1, 3, 5, 7, 9, 11, 13, 15, 17, 19};
        System.out.println("Sorted Array: " + Arrays.toString(sortedArray));
        
        int target = 7;
        System.out.println("\n1. Standard Binary Search for " + target + ":");
        
        int iterativeResult = binarySearchIterative(sortedArray, target);
        System.out.println("Iterative: Index " + iterativeResult);
        
        int recursiveResult = binarySearchRecursive(sortedArray, target, 0, sortedArray.length - 1);
        System.out.println("Recursive: Index " + recursiveResult);
        
        // Test with duplicates
        int[] arrayWithDuplicates = {1, 2, 2, 2, 3, 4, 4, 5, 6, 6, 6, 7};
        System.out.println("\n2. Array with Duplicates: " + Arrays.toString(arrayWithDuplicates));
        
        target = 2;
        System.out.println("Searching for " + target + ":");
        System.out.println("First occurrence: Index " + findFirstOccurrence(arrayWithDuplicates, target));
        System.out.println("Last occurrence: Index " + findLastOccurrence(arrayWithDuplicates, target));
        
        target = 6;
        System.out.println("Searching for " + target + ":");
        System.out.println("First occurrence: Index " + findFirstOccurrence(arrayWithDuplicates, target));
        System.out.println("Last occurrence: Index " + findLastOccurrence(arrayWithDuplicates, target));
        
        // Test insertion point
        System.out.println("\n3. Insertion Point:");
        int[] insertArray = {1, 3, 5, 7, 9};
        System.out.println("Array: " + Arrays.toString(insertArray));
        System.out.println("Insertion point for 4: Index " + findInsertionPoint(insertArray, 4));
        System.out.println("Insertion point for 8: Index " + findInsertionPoint(insertArray, 8));
        System.out.println("Insertion point for 0: Index " + findInsertionPoint(insertArray, 0));
        
        // Test rotated array
        System.out.println("\n4. Rotated Sorted Array:");
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Rotated Array: " + Arrays.toString(rotatedArray));
        target = 0;
        System.out.println("Searching for " + target + ": Index " + searchRotatedArray(rotatedArray, target));
        target = 3;
        System.out.println("Searching for " + target + ": Index " + searchRotatedArray(rotatedArray, target));
        
        // Performance comparison
        System.out.println("\n5. Performance Test:");
        int[] largeArray = new int[1000000];
        for (int i = 0; i < largeArray.length; i++) {
            largeArray[i] = i * 2;
        }
        
        target = 999998;
        long startTime = System.nanoTime();
        int result = binarySearchIterative(largeArray, target);
        long endTime = System.nanoTime();
        
        System.out.println("Array size: " + largeArray.length);
        System.out.println("Target " + target + " found at index: " + result);
        System.out.println("Time taken: " + (endTime - startTime) / 1000.0 + " microseconds");
        
        // Edge cases
        System.out.println("\n6. Edge Cases:");
        int[] emptyArray = {};
        System.out.println("Empty array search: " + binarySearchIterative(emptyArray, 5));
        
        int[] singleElement = {42};
        System.out.println("Single element array (searching 42): " + binarySearchIterative(singleElement, 42));
        System.out.println("Single element array (searching 10): " + binarySearchIterative(singleElement, 10));
    }
}
