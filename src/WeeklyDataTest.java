/**
 * AP CSA - Weekly Data Analyzer (Arrays & OOP Assessment)
 * Manual tests for WeeklyData.java
 * 
 * This test class provides comprehensive validation of the WeeklyData class
 * through a series of 12 unit tests that verify proper functionality of all
 * methods and ensure data integrity.
 *
 * Tests validate:
 *  - Constructor deep copy (internal array must NOT alias the input)
 *  - getTotal(): sum of values across the week
 *  - getAverage(): arithmetic mean of all values
 *  - getMax(): maximum value in the dataset
 *  - getMin(): minimum value in the dataset
 *  - toString(): formatted daily output with day labels and values
 * 
 * Each test includes:
 *  - Test setup with sample data
 *  - Method invocation
 *  - Result validation with tolerance for floating-point comparisons
 *  - Clear pass/fail output with checkmarks or X marks
 * 
 * Author: David H.
 * Course: AP Computer Science A (CSA)
 */
public class WeeklyDataTest {

    /**
     * Main method that executes all unit tests for the WeeklyData class.
     * 
     * This method:
     * 1. Initializes test counters for pass tracking
     * 2. Runs 12 comprehensive tests covering all methods
     * 3. Handles exceptions gracefully with try-catch blocks
     * 4. Outputs test results with visual indicators (checkmarks/X marks)
     * 5. Displays a final summary showing total passes and failures
     * 
     * Test coverage includes edge cases such as:
     * - Constructor deep copy validation
     * - Small arrays with 3 elements
     * - Large arrays with 7 elements
     * - Decimal values
     * - Values at array boundaries (first and last positions)
     * 
     * @param args Command-line arguments (not used in this test class)
     */
    public static void main(String[] args) {
        int passCount = 0;
        int totalTests = 0;

        // Test 1: Constructor deep copy
        totalTests++;
        try {
            double[] input = {10.0, 20.0, 30.0};
            WeeklyData wd = new WeeklyData(input);
            double originalTotal = wd.getTotal();
            input[0] = 9999.0;
            if (Math.abs(originalTotal - wd.getTotal()) < 1e-9) {
                System.out.println("✓ Test 1 passed: Deep copy works");
                passCount++;
            } else {
                System.out.println("✗ Test 1 failed: Deep copy not working");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 1 failed with exception: " + e.getMessage());
        }

        // Test 2: Copy all elements
        totalTests++;
        try {
            double[] input = {5.5, 10.0, 20.25};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(35.75 - wd.getTotal()) < 1e-9) {
                System.out.println("✓ Test 2 passed: All elements copied");
                passCount++;
            } else {
                System.out.println("✗ Test 2 failed: Incorrect total");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 2 failed with exception: " + e.getMessage());
        }

        // Test 3: Large array
        totalTests++;
        try {
            double[] input = {100.0, 100.0, 100.0, 100.0, 100.0, 100.0, 100.0};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(700.0 - wd.getTotal()) < 1e-9) {
                System.out.println("✓ Test 3 passed: Large array total");
                passCount++;
            } else {
                System.out.println("✗ Test 3 failed: Incorrect total for large array");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 3 failed with exception: " + e.getMessage());
        }

        // Test 4: Decimal values
        totalTests++;
        try {
            double[] input = {6.0, 6.0, 6.0, 6.0, 6.0, 6.0, 6.0};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(42.0 - wd.getTotal()) < 1e-9) {
                System.out.println("✓ Test 4 passed: Decimal values total");
                passCount++;
            } else {
                System.out.println("✗ Test 4 failed: Incorrect total for decimal values");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 4 failed with exception: " + e.getMessage());
        }

        // Test 5: Get average
        totalTests++;
        try {
            double[] input = {5.0, 5.0, 5.0, 5.0, 5.0, 5.0, 5.0};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(5.0 - wd.getAverage()) < 1e-9) {
                System.out.println("✓ Test 5 passed: Average calculation");
                passCount++;
            } else {
                System.out.println("✗ Test 5 failed: Incorrect average");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 5 failed with exception: " + e.getMessage());
        }

        // Test 6: Get average with different values
        totalTests++;
        try {
            double[] input = {0.0, 2.0, 2.0, 2.0, 2.0, 2.0, 2.0};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(12.0 / 7.0 - wd.getAverage()) < 1e-9) {
                System.out.println("✓ Test 6 passed: Average with mixed values");
                passCount++;
            } else {
                System.out.println("✗ Test 6 failed: Incorrect average");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 6 failed with exception: " + e.getMessage());
        }

        // Test 7: Get max
        totalTests++;
        try {
            double[] input = {10.0, 20.0, 75.0, 5.0, 15.0, 30.0, 12.0};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(75.0 - wd.getMax()) < 1e-9) {
                System.out.println("✓ Test 7 passed: Max value");
                passCount++;
            } else {
                System.out.println("✗ Test 7 failed: Incorrect max");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 7 failed with exception: " + e.getMessage());
        }

        // Test 8: Get max at start
        totalTests++;
        try {
            double[] input = {100.0, 20.0, 75.0, 5.0, 15.0, 30.0, 12.0};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(100.0 - wd.getMax()) < 1e-9) {
                System.out.println("✓ Test 8 passed: Max at start");
                passCount++;
            } else {
                System.out.println("✗ Test 8 failed: Incorrect max");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 8 failed with exception: " + e.getMessage());
        }

        // Test 9: Get min
        totalTests++;
        try {
            double[] input = {50.0, 20.0, 75.0, 10.0, 15.0, 30.0, 12.0};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(10.0 - wd.getMin()) < 1e-9) {
                System.out.println("✓ Test 9 passed: Min value");
                passCount++;
            } else {
                System.out.println("✗ Test 9 failed: Incorrect min");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 9 failed with exception: " + e.getMessage());
        }

        // Test 10: Get min at start
        totalTests++;
        try {
            double[] input = {5.0, 20.0, 75.0, 10.0, 15.0, 30.0, 25.0};
            WeeklyData wd = new WeeklyData(input);
            if (Math.abs(5.0 - wd.getMin()) < 1e-9) {
                System.out.println("✓ Test 10 passed: Min at start");
                passCount++;
            } else {
                System.out.println("✗ Test 10 failed: Incorrect min");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 10 failed with exception: " + e.getMessage());
        }

        // Test 11: toString contains days
        totalTests++;
        try {
            double[] input = {5.0, 10.0, 15.0, 20.0, 25.0, 30.0, 35.0};
            WeeklyData wd = new WeeklyData(input);
            String result = wd.toString();
            if (result.contains("Day 1") && result.contains("Day 2") && result.contains("Day 3")) {
                System.out.println("✓ Test 11 passed: toString contains day labels");
                passCount++;
            } else {
                System.out.println("✗ Test 11 failed: toString missing day labels");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 11 failed with exception: " + e.getMessage());
        }

        // Test 12: toString contains values
        totalTests++;
        try {
            double[] input = {5.0, 10.0, 15.0, 20.0, 25.0, 30.0, 35.0};
            WeeklyData wd = new WeeklyData(input);
            String result = wd.toString();
            if (result.contains("5") && result.contains("10")) {
                System.out.println("✓ Test 12 passed: toString contains values");
                passCount++;
            } else {
                System.out.println("✗ Test 12 failed: toString missing values");
            }
        } catch (Exception e) {
            System.out.println("✗ Test 12 failed with exception: " + e.getMessage());
        }

        // Summary
        System.out.println("\n" + "=".repeat(50));
        System.out.println("Test Results: " + passCount + "/" + totalTests + " passed");
        System.out.println("=".repeat(50));
    }
}
