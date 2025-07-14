package arithmaticOperation;

public class IncrementDecrementExample {
    public static void main(String[] args) {
        int x = 5;
        int y = 5;
        int result1;
        int result2;

        System.out.println("Initial value of x: " + x); // Output: Initial value of x: 5
        System.out.println("Initial value of y: " + y); // Output: Initial value of y: 5
        System.out.println("-------------------------");

        // --- Postfix Increment (x++) ---
        // 1. 'x's current value (5) is used for 'result1'.
        // 2. Then 'x' is incremented to 6.
        result1 = x++;
        System.out.println("After result1 = x++;");
        System.out.println("x (after postfix increment): " + x);       // Output: x (after postfix increment): 6
        System.out.println("result1: " + result1); // Output: result1: 5
        System.out.println("-------------------------");

        // Reset x for the next demonstration
        x = 5;
        System.out.println("Reset x to: " + x); // Output: Reset x to: 5

        // --- Prefix Increment (++x) ---
        // 1. 'x' is incremented to 6.
        // 2. Then the new value of 'x' (6) is used for 'result1'.
        result1 = ++x;
        System.out.println("After result1 = ++x;");
        System.out.println("x (after prefix increment): " + x);        // Output: x (after prefix increment): 6
        System.out.println("result1: " + result1);  // Output: result1: 6
        System.out.println("-------------------------");

        // --- Postfix Decrement (y--) ---
        // 1. 'y's current value (5) is used for 'result2'.
        // 2. Then 'y' is decremented to 4.
        result2 = y--;
        System.out.println("After result2 = y--;");
        System.out.println("y (after postfix decrement): " + y);       // Output: y (after postfix decrement): 4
        System.out.println("result2: " + result2); // Output: result2: 5
        System.out.println("-------------------------");

        // Reset y for the next demonstration
        y = 5;
        System.out.println("Reset y to: " + y); // Output: Reset y to: 5

        // --- Prefix Decrement (--y) ---
        // 1. 'y' is decremented to 4.
        // 2. Then the new value of 'y' (4) is used for 'result2'.
        result2 = --y;
        System.out.println("After result2 = --y;");
        System.out.println("y (after prefix decrement): " + y);        // Output: y (after prefix decrement): 4
        System.out.println("result2: " + result2);  // Output: result2: 4
    }
}
