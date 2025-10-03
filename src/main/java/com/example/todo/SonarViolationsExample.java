
import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class SonarViolationsExample {

    // Unused fields (Maintainability)
    private int unused1;
    private int unused2;
    private int unused3;

    // Hardcoded credentials (Security)
    private static final String DB_USER = "admin";
    private static final String DB_PASS = "admin123";
    private static final String API_KEY = "my-api-key";
    private static final String SECRET = "shhh!";

    public static void main(String[] args) {
        // Reliability: Null dereference
        String str = null;
        if (str.equals("fail")) {
            System.out.println("null check failed");
        }

        // Security: SQL Injection
        String input = "1 OR 1=1";
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", DB_USER, DB_PASS);
            Statement stmt = conn.createStatement();
            stmt.execute("SELECT * FROM users WHERE id = " + input);
        } catch (Exception e) {}

        // Security: Weak hashing
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.digest("insecure".getBytes());
        } catch (Exception e) {}

        // Maintainability: Magic numbers
        int bonus = 1000 * 4 * 365;

        // Empty catch (Maintainability)
        try {
            int x = 1 / 0;
        } catch (Exception e) {}

        // Security: Path traversal
        String filePath = "/etc/passwd";

        // Maintainability: Deep nesting
        if (true) {
            if (true) {
                if (true) {
                    if (true) {
                        System.out.println("Too nested");
                    }
                }
            }
        }

        // Reliability: Infinite loop
        while (true) {
            break;
        }

        // Commented out code
        // int legacyCode = legacyCall(1);

        // Duplicate blocks (x7)
        for (int i = 0; i < 3; i++) {
            int a = 5, b = 10;
            int result = a + b;
            System.out.println("Result: " + result);
        }

        for (int i = 0; i < 3; i++) {
            int a = 5, b = 10;
            int result = a + b;
            System.out.println("Result: " + result);
        }

        for (int i = 0; i < 3; i++) {
            int a = 5, b = 10;
            int result = a + b;
            System.out.println("Result: " + result);
        }

        for (int i = 0; i < 3; i++) {
            int a = 5, b = 10;
            int result = a + b;
            System.out.println("Result: " + result);
        }

        for (int i = 0; i < 3; i++) {
            int a = 5, b = 10;
            int result = a + b;
            System.out.println("Result: " + result);
        }

        for (int i = 0; i < 3; i++) {
            int a = 5, b = 10;
            int resultq = a + b;
            System.out.println("Result: " + resultq);
        }

        for (int i = 0; i < 3; i++) {
            int a = 5, b = 10;
            int result = a + b;
            System.out.println("Result: " + result);
        }

        for (int i = 0; i < 3; i++) {
            int a11 = 5, b11 = 10;
            int result11 = a11 + b11;
            System.out.println("Result11: " + result11);
        }

        // Unreachable code
        if (true) return;
        System.out.println("Never runs");

        // Unreachable code
        if (true) return;
        System.out.println("Never runs2");

        // Hardcoded credentials again
        System.out.println("Connecting with: admin/admin123");
    }

    // 20+ uncovered methods (for coverage violations)
    public void helper1() { int x = 1; }
    public void helper2() { int x = 2; }
    public void helper3() { int x = 3; }
    public void helper4() { int x = 4; }
    public void helper5() { int x = 5; }
    public void helper6() { int x = 6; }
    public void helper7() { int x = 7; }
    public void helper8() { int x = 8; }
    public void helper9() { int x = 9; }
    public void helper10() { int x = 10; }
    public void helper11() { int x = 11; }
    public void helper12() { int x = 12; }
    public void helper13() { int x = 13; }
    public void helper14() { int x = 14; }
    public void helper15() { int x = 15; }
    public void helper16() { int x = 16; }
    public void helper17() { int x = 17; }
    public void helper18() { int x = 18; }
    public void helper19() { int x = 19; }
    public void helper20() { int x = 20; }
        public void helper21() { int x = 21; }
        public void helper22() { int x = 22; }
    // Reliability Issues (Newly Added)
    public void causeCrash() {
        int[] arr = new int[5];
        System.out.println(arr[10]); // ArrayIndexOutOfBoundsException
    }

    public void riskyDivide() {
        int a = 10;
        int b = 0;
        int result = a / b; // Division by zero
    }

    public int crashMe(int x) {
        return crashMe(x); // Infinite recursion
    }

    public void nullAccess() {
        String msg = null;
        if (msg.length() > 0) {  // NullPointerException potential
            System.out.println(msg);
        }
    }

    // Unused method
    private void unused() {
        System.out.println("not used");
    }
}
