/**
 * Palindrome Checker - String Manipulation
 * Difficulty: Easy 🟢
 * Topic: Basic Programming, Strings
 */
public class PalindromeChecker {
    
    /**
     * Check if string is palindrome (case-sensitive)
     * Time Complexity: O(n)
     * Space Complexity: O(1)
     * @param str input string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindrome(String str) {
        if (str == null) return false;
        
        int left = 0;
        int right = str.length() - 1;
        
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    /**
     * Check if string is palindrome (case-insensitive, ignores spaces)
     * @param str input string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeIgnoreCase(String str) {
        if (str == null) return false;
        
        String cleaned = str.toLowerCase().replaceAll("\\s", "");
        return isPalindrome(cleaned);
    }
    
    /**
     * Check if string is palindrome (ignores all non-alphanumeric)
     * @param str input string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeAlphanumeric(String str) {
        if (str == null) return false;
        
        String cleaned = str.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isPalindrome(cleaned);
    }
    
    /**
     * Check using StringBuilder reverse
     * @param str input string
     * @return true if palindrome, false otherwise
     */
    public static boolean isPalindromeReverse(String str) {
        if (str == null) return false;
        
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
    
    /**
     * Find longest palindromic substring
     * @param str input string
     * @return longest palindromic substring
     */
    public static String longestPalindrome(String str) {
        if (str == null || str.length() == 0) return "";
        
        String longest = "";
        
        for (int i = 0; i < str.length(); i++) {
            // Check for odd length palindromes
            String palindrome1 = expandAroundCenter(str, i, i);
            // Check for even length palindromes
            String palindrome2 = expandAroundCenter(str, i, i + 1);
            
            if (palindrome1.length() > longest.length()) {
                longest = palindrome1;
            }
            if (palindrome2.length() > longest.length()) {
                longest = palindrome2;
            }
        }
        
        return longest;
    }
    
    /**
     * Helper method to expand around center
     */
    private static String expandAroundCenter(String str, int left, int right) {
        while (left >= 0 && right < str.length() && str.charAt(left) == str.charAt(right)) {
            left--;
            right++;
        }
        return str.substring(left + 1, right);
    }
    
    /**
     * Main method to demonstrate palindrome checking
     */
    public static void main(String[] args) {
        System.out.println("=== Palindrome Checker Demo ===\n");
        
        // Test cases
        String[] testStrings = {
            "racecar",
            "A man a plan a canal Panama",
            "race a car",
            "hello",
            "Madam",
            "Was it a car or a cat I saw?",
            "12321",
            "12345",
            "",
            "a"
        };
        
        System.out.println("1. Basic Palindrome Check (Case-Sensitive):");
        for (String test : testStrings) {
            System.out.printf("'%s' -> %s%n", test, isPalindrome(test));
        }
        
        System.out.println("\n2. Case-Insensitive (Ignores Spaces):");
        for (String test : testStrings) {
            System.out.printf("'%s' -> %s%n", test, isPalindromeIgnoreCase(test));
        }
        
        System.out.println("\n3. Alphanumeric Only:");
        for (String test : testStrings) {
            System.out.printf("'%s' -> %s%n", test, isPalindromeAlphanumeric(test));
        }
        
        System.out.println("\n4. Using StringBuilder Reverse:");
        String[] simpleTests = {"racecar", "hello", "level"};
        for (String test : simpleTests) {
            System.out.printf("'%s' -> %s%n", test, isPalindromeReverse(test));
        }
        
        System.out.println("\n5. Longest Palindromic Substring:");
        String[] substringTests = {
            "babad",
            "cbbd",
            "racecar",
            "abcdef",
            "abacabad"
        };
        
        for (String test : substringTests) {
            System.out.printf("'%s' -> '%s'%n", test, longestPalindrome(test));
        }
        
        // Performance comparison
        System.out.println("\n6. Performance Comparison:");
        String longString = "racecar".repeat(1000);
        
        long startTime = System.nanoTime();
        boolean result1 = isPalindrome(longString);
        long endTime = System.nanoTime();
        System.out.println("Two-pointer approach: " + (endTime - startTime) / 1000.0 + " microseconds");
        
        startTime = System.nanoTime();
        boolean result2 = isPalindromeReverse(longString);
        endTime = System.nanoTime();
        System.out.println("StringBuilder reverse: " + (endTime - startTime) / 1000.0 + " microseconds");
        
        System.out.println("Both results match: " + (result1 == result2));
    }
}
