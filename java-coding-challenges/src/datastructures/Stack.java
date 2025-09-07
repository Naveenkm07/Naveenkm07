/**
 * Custom Stack Implementation
 * Difficulty: Medium 🟡
 * Topic: Data Structures
 */
import java.util.EmptyStackException;

public class Stack<T> {
    
    /**
     * Array-based Stack Implementation
     */
    public static class ArrayStack<T> {
        private Object[] stack;
        private int top;
        private int capacity;
        
        public ArrayStack(int capacity) {
            this.capacity = capacity;
            this.stack = new Object[capacity];
            this.top = -1;
        }
        
        public ArrayStack() {
            this(10); // Default capacity
        }
        
        public void push(T item) {
            if (isFull()) {
                resize();
            }
            stack[++top] = item;
        }
        
        @SuppressWarnings("unchecked")
        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            T item = (T) stack[top];
            stack[top--] = null; // Help GC
            return item;
        }
        
        @SuppressWarnings("unchecked")
        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return (T) stack[top];
        }
        
        public boolean isEmpty() {
            return top == -1;
        }
        
        public boolean isFull() {
            return top == capacity - 1;
        }
        
        public int size() {
            return top + 1;
        }
        
        private void resize() {
            capacity *= 2;
            Object[] newStack = new Object[capacity];
            System.arraycopy(stack, 0, newStack, 0, top + 1);
            stack = newStack;
        }
    }
    
    /**
     * LinkedList-based Stack Implementation
     */
    public static class LinkedStack<T> {
        private Node<T> top;
        private int size;
        
        private static class Node<T> {
            T data;
            Node<T> next;
            
            Node(T data) {
                this.data = data;
            }
        }
        
        public void push(T item) {
            Node<T> newNode = new Node<>(item);
            newNode.next = top;
            top = newNode;
            size++;
        }
        
        public T pop() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            T data = top.data;
            top = top.next;
            size--;
            return data;
        }
        
        public T peek() {
            if (isEmpty()) {
                throw new EmptyStackException();
            }
            return top.data;
        }
        
        public boolean isEmpty() {
            return top == null;
        }
        
        public int size() {
            return size;
        }
    }
    
    /**
     * Main method to demonstrate stack implementations
     */
    public static void main(String[] args) {
        System.out.println("=== Stack Implementation Demo ===\n");
        
        // Test Array Stack
        System.out.println("1. Array-based Stack:");
        ArrayStack<Integer> arrayStack = new ArrayStack<>(3);
        
        System.out.println("Pushing 1, 2, 3, 4, 5...");
        for (int i = 1; i <= 5; i++) {
            arrayStack.push(i);
            System.out.println("Pushed: " + i + ", Size: " + arrayStack.size());
        }
        
        System.out.println("Peek: " + arrayStack.peek());
        
        System.out.println("Popping all elements:");
        while (!arrayStack.isEmpty()) {
            System.out.println("Popped: " + arrayStack.pop() + ", Size: " + arrayStack.size());
        }
        
        // Test LinkedList Stack
        System.out.println("\n2. LinkedList-based Stack:");
        LinkedStack<String> linkedStack = new LinkedStack<>();
        
        String[] words = {"Hello", "World", "Java", "Stack"};
        System.out.println("Pushing words...");
        for (String word : words) {
            linkedStack.push(word);
            System.out.println("Pushed: " + word + ", Size: " + linkedStack.size());
        }
        
        System.out.println("Peek: " + linkedStack.peek());
        
        System.out.println("Popping all elements:");
        while (!linkedStack.isEmpty()) {
            System.out.println("Popped: " + linkedStack.pop() + ", Size: " + linkedStack.size());
        }
        
        // Performance comparison
        System.out.println("\n3. Performance Comparison:");
        int operations = 100000;
        
        // Array Stack performance
        ArrayStack<Integer> perfArrayStack = new ArrayStack<>();
        long startTime = System.nanoTime();
        for (int i = 0; i < operations; i++) {
            perfArrayStack.push(i);
        }
        for (int i = 0; i < operations; i++) {
            perfArrayStack.pop();
        }
        long endTime = System.nanoTime();
        System.out.println("Array Stack (" + operations + " push+pop): " + 
                          (endTime - startTime) / 1000000.0 + " ms");
        
        // LinkedList Stack performance
        LinkedStack<Integer> perfLinkedStack = new LinkedStack<>();
        startTime = System.nanoTime();
        for (int i = 0; i < operations; i++) {
            perfLinkedStack.push(i);
        }
        for (int i = 0; i < operations; i++) {
            perfLinkedStack.pop();
        }
        endTime = System.nanoTime();
        System.out.println("LinkedList Stack (" + operations + " push+pop): " + 
                          (endTime - startTime) / 1000000.0 + " ms");
        
        // Edge case testing
        System.out.println("\n4. Edge Case Testing:");
        ArrayStack<String> emptyStack = new ArrayStack<>();
        
        try {
            emptyStack.pop();
        } catch (EmptyStackException e) {
            System.out.println("✓ EmptyStackException caught on pop()");
        }
        
        try {
            emptyStack.peek();
        } catch (EmptyStackException e) {
            System.out.println("✓ EmptyStackException caught on peek()");
        }
        
        System.out.println("Empty stack size: " + emptyStack.size());
        System.out.println("Is empty: " + emptyStack.isEmpty());
    }
}
