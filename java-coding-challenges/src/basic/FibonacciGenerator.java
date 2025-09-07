/**
 * Fibonacci Sequence Generator
 * Difficulty: Easy 🟢
 * Topic: Basic Programming, Recursion
 */
public class FibonacciGenerator {
    
    /**
     * Generate Fibonacci sequence iteratively
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param n number of terms to generate
     */
    public static void generateIterative(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number");
            return;
        }
        
        if (n == 1) {
            System.out.println("Fibonacci Series: 0");
            return;
        }
        
        long first = 0, second = 1;
        System.out.print("Fibonacci Series: " + first + ", " + second);
        
        for (int i = 2; i < n; i++) {
            long next = first + second;
            System.out.print(", " + next);
            first = second;
            second = next;
        }
        System.out.println();
    }
    
    /**
     * Generate nth Fibonacci number recursively
     * Time Complexity: O(2^n) - Inefficient for large n
     * Space Complexity: O(n)
     * @param n position in sequence
     * @return nth Fibonacci number
     */
    public static long fibonacciRecursive(int n) {
        if (n <= 1) return n;
        return fibonacciRecursive(n - 1) + fibonacciRecursive(n - 2);
    }
    
    /**
     * Generate nth Fibonacci number with memoization
     * Time Complexity: O(n)
     * Space Complexity: O(n)
     * @param n position in sequence
     * @param memo memoization array
     * @return nth Fibonacci number
     */
    public static long fibonacciMemo(int n, long[] memo) {
        if (n <= 1) return n;
        if (memo[n] != 0) return memo[n];
        
        memo[n] = fibonacciMemo(n - 1, memo) + fibonacciMemo(n - 2, memo);
        return memo[n];
    }
    
    /**
     * Generate Fibonacci series using array
     * @param n number of terms
     * @return array containing Fibonacci sequence
     */
    public static long[] generateArray(int n) {
        if (n <= 0) return new long[0];
        
        long[] fib = new long[n];
        if (n >= 1) fib[0] = 0;
        if (n >= 2) fib[1] = 1;
        
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        
        return fib;
    }
    
    /**
     * Check if a number is a Fibonacci number
     * @param num number to check
     * @return true if Fibonacci number, false otherwise
     */
    public static boolean isFibonacci(long num) {
        if (num < 0) return false;
        
        long a = 0, b = 1;
        if (num == a || num == b) return true;
        
        long c = a + b;
        while (c <= num) {
            if (c == num) return true;
            a = b;
            b = c;
            c = a + b;
        }
        return false;
    }
    
    /**
     * Main method to demonstrate all Fibonacci implementations
     */
    public static void main(String[] args) {
        System.out.println("=== Fibonacci Generator Demo ===\n");
        
        int n = 15;
        
        // Test iterative approach
        System.out.println("1. Iterative Approach:");
        generateIterative(n);
        
        // Test recursive approach (only for small numbers due to inefficiency)
        System.out.println("\n2. Recursive Approach (first 10 numbers):");
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacciRecursive(i));
            if (i < 9) System.out.print(", ");
        }
        System.out.println();
        
        // Test memoized approach
        System.out.println("\n3. Memoized Approach:");
        long[] memo = new long[n];
        System.out.print("Fibonacci Series: ");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacciMemo(i, memo));
            if (i < n - 1) System.out.print(", ");
        }
        System.out.println();
        
        // Test array generation
        System.out.println("\n4. Array Generation:");
        long[] fibArray = generateArray(n);
        System.out.print("Fibonacci Array: ");
        for (int i = 0; i < fibArray.length; i++) {
            System.out.print(fibArray[i]);
            if (i < fibArray.length - 1) System.out.print(", ");
        }
        System.out.println();
        
        // Test Fibonacci number checking
        System.out.println("\n5. Fibonacci Number Checker:");
        long[] testNumbers = {0, 1, 2, 3, 5, 8, 13, 21, 22, 34, 55};
        for (long num : testNumbers) {
            System.out.println(num + " is Fibonacci: " + isFibonacci(num));
        }
        
        // Performance comparison
        System.out.println("\n6. Performance Comparison:");
        int testN = 30;
        
        // Iterative timing
        long startTime = System.nanoTime();
        generateArray(testN);
        long endTime = System.nanoTime();
        System.out.println("Iterative (30 terms): " + (endTime - startTime) / 1000000.0 + " ms");
        
        // Memoized timing
        startTime = System.nanoTime();
        long[] memoArray = new long[testN];
        fibonacciMemo(testN - 1, memoArray);
        endTime = System.nanoTime();
        System.out.println("Memoized (30th term): " + (endTime - startTime) / 1000000.0 + " ms");
    }
}
