/**
 * Custom LinkedList Implementation
 * Difficulty: Medium 🟡
 * Topic: Data Structures
 */
public class LinkedList<T> {
    
    /**
     * Node class to represent individual elements
     */
    private class Node {
        T data;
        Node next;
        
        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
    
    private Node head;
    private int size;
    
    /**
     * Constructor to initialize empty list
     */
    public LinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Add element to the beginning of the list
     * @param data element to add
     */
    public void addFirst(T data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    /**
     * Add element to the end of the list
     * @param data element to add
     */
    public void addLast(T data) {
        Node newNode = new Node(data);
        
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    /**
     * Remove first element
     * @return removed element or null if list is empty
     */
    public T removeFirst() {
        if (head == null) {
            return null;
        }
        
        T data = head.data;
        head = head.next;
        size--;
        return data;
    }
    
    /**
     * Remove element by value
     * @param data element to remove
     * @return true if removed, false if not found
     */
    public boolean remove(T data) {
        if (head == null) {
            return false;
        }
        
        if (head.data.equals(data)) {
            head = head.next;
            size--;
            return true;
        }
        
        Node current = head;
        while (current.next != null) {
            if (current.next.data.equals(data)) {
                current.next = current.next.next;
                size--;
                return true;
            }
            current = current.next;
        }
        
        return false;
    }
    
    /**
     * Check if list contains element
     * @param data element to search
     * @return true if found, false otherwise
     */
    public boolean contains(T data) {
        Node current = head;
        while (current != null) {
            if (current.data.equals(data)) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    /**
     * Get size of the list
     * @return number of elements
     */
    public int size() {
        return size;
    }
    
    /**
     * Check if list is empty
     * @return true if empty, false otherwise
     */
    public boolean isEmpty() {
        return head == null;
    }
    
    /**
     * Display all elements
     */
    public void display() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        
        Node current = head;
        System.out.print("LinkedList: ");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(" -> ");
            }
            current = current.next;
        }
        System.out.println();
    }
    
    /**
     * Main method to test LinkedList implementation
     */
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        
        System.out.println("=== LinkedList Demo ===");
        
        // Add elements
        list.addFirst(10);
        list.addFirst(20);
        list.addLast(30);
        list.addLast(40);
        
        list.display(); // Should print: 20 -> 10 -> 30 -> 40
        System.out.println("Size: " + list.size());
        
        // Test contains
        System.out.println("Contains 30: " + list.contains(30));
        System.out.println("Contains 50: " + list.contains(50));
        
        // Remove elements
        System.out.println("Removed: " + list.removeFirst());
        list.display();
        
        list.remove(30);
        list.display();
        
        System.out.println("Final size: " + list.size());
    }
}
