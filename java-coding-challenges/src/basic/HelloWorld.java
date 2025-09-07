/**
 * Basic Java Program - Hello World
 * Difficulty: Easy 🟢
 * Topic: Basic Programming
 */
public class HelloWorld {
    
    /**
     * Main method - entry point of the program
     * @param args command line arguments
     */
    public static void main(String[] args) {
        // Print Hello World message
        System.out.println("Hello, World!");
        System.out.println("Welcome to Java Coding Challenges!");
        
        // Print current date and time
        java.time.LocalDateTime now = java.time.LocalDateTime.now();
        System.out.println("Current Date and Time: " + now);
        
        // Print system information
        System.out.println("Java Version: " + System.getProperty("java.version"));
        System.out.println("Operating System: " + System.getProperty("os.name"));
    }
}
