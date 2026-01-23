/**
 * The WeeklyData class stores and analyzes a week's worth of numeric data.
 * This could represent steps taken, hours of sleep, money spent, screen time,
 * water consumption, or any other measurable daily value.
 * 
 * The class provides methods to calculate statistical measures including:
 * - Total sum of all values
 * - Average value across the week
 * - Maximum and minimum values
 * - Formatted string representation of daily data
 * 
 * Data is stored internally as a deep copy to prevent external modification.
 * 
 * Author: David H.
 * Course: AP Computer Science A (CSA)
 */
public class WeeklyData {

    // -------------------------------------------------------------
    // Instance Variables
    // -------------------------------------------------------------
    /** Private array to store 7 days of data */
    private double[] data;
    


    // -------------------------------------------------------------
    // Constructor
    // -------------------------------------------------------------
    /**
     * Constructs a WeeklyData object by taking in an array of values
     * and making a deep copy (element-by-element) into the internal array.
     *
     * @param input an array representing 7 days of data
     */
    public WeeklyData(double[] input) {
        // Create a new array with the same length as input
        if (input != null) {
            data = new double[input.length];
            // Copy each value from input into the internal data array
            for (int i = 0; i < input.length; i++) {
                data[i] = input[i];
            }
        } else {
            data = new double[0];
        }
    }

    // -------------------------------------------------------------
    // getTotal
    // -------------------------------------------------------------
    /**
     * Calculates and returns the total of all values in the week.
     *
     * @return the sum of all values in the data array
     */
    public double getTotal() {
        double total = 0.0;
        for (int i = 0; i < data.length; i++) {
            total += data[i];
        }
        return total;
    }


    // -------------------------------------------------------------
    // getAverage
    // -------------------------------------------------------------
    /**
     * Calculates and returns the average value for the week.
     *
     * @return the average of the values in the array,
     *         or 0.0 if the array is empty
     */
    public double getAverage() {
        if (data.length == 0) {
            return 0.0;
        }
        return getTotal() / data.length;
    }


    // -------------------------------------------------------------
    // getMax
    // -------------------------------------------------------------
    /**
     * Finds and returns the highest value in the data array.
     *
     * @return the maximum value
     */
    public double getMax() {
        if (data.length == 0) {
            return 0.0;
        }
        double max = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] > max) {
                max = data[i];
            }
        }
        return max;
    }


    // -------------------------------------------------------------
    // getMin
    // -------------------------------------------------------------
    /**
     * Finds and returns the lowest value in the data array.
     *
     * @return the minimum value
     */
    public double getMin() {
        if (data.length == 0) {
            return 0.0;
        }
        double min = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] < min) {
                min = data[i];
            }
        }
        return min;
    }


    // -------------------------------------------------------------
    // toString
    // -------------------------------------------------------------
    /**
     * Returns a formatted, multi-line String showing each day's data.
     *
     * Example:
     * Day 1: 4500
     * Day 2: 6200
     * Day 3: 5100
     *
     * @return a formatted String representing the week's data
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            sb.append(String.format("Day %d: %.1f%n", i + 1, data[i]));
        }
        return sb.toString();
    }
}
