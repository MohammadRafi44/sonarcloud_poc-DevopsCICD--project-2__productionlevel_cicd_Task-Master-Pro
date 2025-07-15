public class SonarViolationsExample {

    // Code Smell: unused field
    private String unusedField = "This is not used";

    // Code Smell: constant hardcoded directly
    private static final int MAGIC_NUMBER = 42;

    public static void main(String[] args) {
        // Bug: possible null dereference
        String message = null;
        if (message.equals("Hello")) {  // BUG
            System.out.println("Message matched");
        }

        // Code Smell: hardcoded strings
        System.out.println("Login with admin/admin"); // Hardcoded credentials
        System.out.println("Connecting to DB at 10.0.0.1"); // Hardcoded IP

        // Bug: empty catch block
        try {
            int result = 1 / 0;
        } catch (Exception e) {
            // silently swallowing exception
        }

        // Code Smell: very long method
        for (int i = 0; i < 10; i++) {
            System.out.println("Looping " + i);
        }
        for (int i = 0; i < 10; i++) {
            System.out.println("Looping again " + i);
        }

        // Duplicate Block 1
        int x = 5;
        int y = 10;
        int sum = x + y;
        System.out.println("Sum is: " + sum);

        // Duplicate Block 2
        int a = 5;
        int b = 10;
        int result = a + b;
        System.out.println("Sum is: " + result);

        // Duplicate Block 3
        int p = 5;
        int q = 10;
        int res = p + q;
        System.out.println("Sum is: " + res);

        // Duplicate Block 4
        int t = 5;
        int s = 10;
        int result1 = a + b;
        System.out.println("Sum is: " + result);

        // Bug: hardcoded conditional
        if (x == 5 && y == 10) {
            System.out.println("This block only works with hardcoded values.");
        }

        // Unreachable code
        if (true) return;
        System.out.println("This will never be executed");  // Code Smell
    }

    // Unused method
    public void doNothing() {  // Code Smell
    }

    // Untested business logic
    public int multiply(int a, int b) {
        return a * b;
    }

    // Another unused method
    private void helper() {
        System.out.println("This is a helper");
    }
}