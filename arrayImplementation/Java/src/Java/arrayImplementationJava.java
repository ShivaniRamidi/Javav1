package Java;
/**
 * A custom implementation of a dynamic array (similar to ArrayList) for integers.
 * This class manages its own capacity and length, and handles resizing automatically.
 * It does not use any of Java's built-in collection classes.
 */
public class arrayImplementationJava {

    private int[] array;    // The underlying array to store elements.
    private int length;     // The number of elements currently in the array.
    private int capacity;   // The total number of elements the array can currently hold.

    /**
     * Default constructor.
     * Initializes the array with a default capacity of 2.
     */
    public arrayImplementationJava() {
        this.capacity = 2; // Start with a small initial capacity.
        this.length = 0;
        this.array = new int[this.capacity];
    }

    /**
     * Constructor with a specified initial capacity.
     * @param initialCapacity The initial size of the internal array.
     */
    public arrayImplementationJava(int initialCapacity) {
        if (initialCapacity < 1) {
            // Ensure capacity is at least 1.
            this.capacity = 1;
        } else {
            this.capacity = initialCapacity;
        }
        this.length = 0;
        this.array = new int[this.capacity];
    }

    /**
     * Returns the number of elements in the array.
     * @return The current length.
     */
    public int size() {
        return this.length;
    }

    /**
     * Returns the current total storage size of the array.
     * @return The current capacity.
     */
    public int getCapacity() {
        return this.capacity;
    }

    /**
     * Checks if the array is empty.
     * @return true if length is 0, false otherwise.
     */
    public boolean isEmpty() {
        return this.length == 0;
    }

    /**
     * Retrieves the element at a specific index.
     * @param index The index of the element to retrieve.
     * @return The element at the specified index.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public int get(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.length);
        }
        return this.array[index];
    }

    /**
     * Updates the element at a specific index.
     * @param index The index of the element to update.
     * @param value The new value.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void set(int index, int value) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.length);
        }
        this.array[index] = value;
    }

    /**
     * Adds an element to the end of the array.
     * If the array is full, it will be resized.
     * @param element The element to add.
     */
    public void add(int element) {
        // Check if we need to resize before adding the new element.
        if (this.length == this.capacity) {
            resize();
        }
        // Add the element at the end and increment the length.
        this.array[this.length] = element;
        this.length++;
    }

    /**
     * Inserts an element at a specific index.
     * Elements from the index onwards are shifted to the right.
     * @param index The index at which to insert the new element.
     * @param element The element to insert.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public void insert(int index, int element) {
        if (index < 0 || index > this.length) { // Allow insertion at the very end (index == length)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.length);
        }

        // Resize if necessary.
        if (this.length == this.capacity) {
            resize();
        }

        // Shift elements to the right to make space for the new element.
        // We loop backwards from the end to avoid overwriting elements.
        for (int i = this.length; i > index; i--) {
            this.array[i] = this.array[i - 1];
        }

        // Insert the new element and increment length.
        this.array[index] = element;
        this.length++;
    }

    /**
     * Removes the element at a specific index.
     * Subsequent elements are shifted to the left.
     * @param index The index of the element to remove.
     * @return The element that was removed.
     * @throws IndexOutOfBoundsException if the index is out of bounds.
     */
    public int removeAt(int index) {
        if (index < 0 || index >= this.length) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + this.length);
        }

        int removedElement = this.array[index];

        // Shift elements to the left to fill the gap.
        for (int i = index; i < this.length - 1; i++) {
            this.array[i] = this.array[i + 1];
        }

        // Decrement the length. The last element is now considered garbage.
        this.length--;

        return removedElement;
    }

    /**
     * Private helper method to increase the capacity of the array.
     * It creates a new array with double the capacity and copies elements over.
     */
    private void resize() {
        // Double the capacity.
        this.capacity = this.capacity * 2;
        // Create a new, larger array.
        int[] newArray = new int[this.capacity];

        // Copy all elements from the old array to the new one.
        for (int i = 0; i < this.length; i++) {
            newArray[i] = this.array[i];
        }

        // Replace the old array with the new one.
        this.array = newArray;
    }

    /**
     * Provides a string representation of the array's contents.
     * @return A string like "[1, 2, 3]".
     */
    @Override
    public String toString() {
        if (this.length == 0) {
            return "[]";
        }

        // Use a StringBuilder for efficient string concatenation.
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.length; i++) {
            sb.append(this.array[i]);
            if (i < this.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Main method to demonstrate the functionality of the DynamicArray.
     */
    public static void main(String[] args) {
        System.out.println("--- Initializing Dynamic Array ---");
        arrayImplementationJava arr = new arrayImplementationJava();
        System.out.println("Initial Array: " + arr);
        System.out.println("Initial Length: " + arr.size());
        System.out.println("Initial Capacity: " + arr.getCapacity());
        System.out.println("Is Empty? " + arr.isEmpty());

        System.out.println("\n--- Adding elements (triggers resize) ---");
        arr.add(10);
        System.out.println("Array: " + arr + ", Length: " + arr.size() + ", Capacity: " + arr.getCapacity());
        arr.add(20);
        System.out.println("Array: " + arr + ", Length: " + arr.size() + ", Capacity: " + arr.getCapacity());
        arr.add(30); // This will trigger a resize from 2 to 4
        System.out.println("Array: " + arr + ", Length: " + arr.size() + ", Capacity: " + arr.getCapacity());
        arr.add(40);
        System.out.println("Array: " + arr + ", Length: " + arr.size() + ", Capacity: " + arr.getCapacity());
        arr.add(50); // This will trigger a resize from 4 to 8
        System.out.println("Array: " + arr + ", Length: " + arr.size() + ", Capacity: " + arr.getCapacity());

        System.out.println("\n--- Accessing and Modifying Elements ---");
        System.out.println("Element at index 2: " + arr.get(2));
        arr.set(2, 35);
        System.out.println("Set element at index 2 to 35. New array: " + arr);

        System.out.println("\n--- Inserting an Element ---");
        arr.insert(1, 15); // Insert 15 at index 1
        System.out.println("After inserting 15 at index 1: " + arr);
        System.out.println("New Length: " + arr.size() + ", New Capacity: " + arr.getCapacity());

        System.out.println("\n--- Removing an Element ---");
        int removedValue = arr.removeAt(3); // Remove element at index 3 (which is 35)
        System.out.println("Removed element at index 3. Value was: " + removedValue);
        System.out.println("Array after removal: " + arr);
        System.out.println("New Length: " + arr.size() + ", New Capacity: " + arr.getCapacity());

        System.out.println("\n--- Testing Edge Cases ---");
        try {
            arr.get(10);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Successfully caught error for out-of-bounds get: " + e.getMessage());
        }
    }
}
