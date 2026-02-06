import java.util.Scanner;

/**
 * Water Intake Tracker Application for the Weekly Data Project
 * 
 * This App class collects daily water intake data from the user and uses
 * the WeeklyData class to analyze and display statistics for the week.
 * The program prompts the user for water consumption (in cups) for each
 * day of the week, validates input, and provides insights about hydration habits.
 * 
 * Author: David H.
 * Collaborators: ChatGPT and Claude
 * Course: AP Computer Science A (CSA)
 * 
 * Instructions:
 * - Complete the WeeklyData.java class first.
 * - Use this App class to collect user input and test your WeeklyData methods.
 * - Follow all TODOs carefully.
 * - Do NOT hard-code values — use loops and method calls.
 */
public class App {

    /**
     * Main method that runs the Water Intake Tracker application.
     * Demonstrates method encapsulation by delegating tasks to helper methods.
     * 
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Delegate to helper methods for clean, readable code
        displayProgramInfo();
        double[] weekData = collectWeeklyData(scanner);
        WeeklyData tracker = new WeeklyData(weekData);
        displayResults(tracker);
        displayInsights(tracker, weekData);
        
        scanner.close();
    }

    /**
     * Displays the program header and introductory information.
     * This method encapsulates the program display logic.
     */
    private static void displayProgramInfo() {
        System.out.println("===========================================");
        System.out.println("    Water Intake Tracker for the Week       ");
        System.out.println("===========================================");
        System.out.println("Track your daily water consumption in cups.");
        System.out.println("Recommended daily intake: 8 cups");
        System.out.println();
    }

    /**
     * Collects daily water intake data from the user with input validation.
     * This method encapsulates all data collection and validation logic.
     * 
     * @param scanner The Scanner object for reading user input
     * @return An array of 7 double values representing water intake for each day
     */
    private static double[] collectWeeklyData(Scanner scanner) {
        double[] weekData = new double[7];
        
        for (int i = 0; i < weekData.length; i++) {
            boolean validInput = false;
            while (!validInput) {
                System.out.print("Enter cups of water for day " + (i + 1) + ": ");
                if (scanner.hasNextDouble()) {
                    double value = scanner.nextDouble();
                    if (value >= 0) {
                        weekData[i] = value;
                        validInput = true;
                    } else {
                        System.out.println("Please enter a non-negative value.");
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number.");
                    scanner.nextLine(); // Clear invalid input
                }
            }
        }
        scanner.nextLine(); // Clear newline from last input
        System.out.println();
        
        return weekData;
    }

    /**
     * Displays the weekly statistical summary of water intake.
     * This method encapsulates the results display logic.
     * 
     * @param tracker The WeeklyData object containing the analysis
     */
    private static void displayResults(WeeklyData tracker) {
        System.out.println("===========================================");
        System.out.println("         Weekly Summary Report              ");
        System.out.println("===========================================");
        System.out.printf("Total Cups Consumed:  %.1f%n", tracker.getTotal());
        System.out.printf("Average Per Day:      %.2f cups%n", tracker.getAverage());
        System.out.printf("Highest Day:          %.1f cups%n", tracker.getMax());
        System.out.printf("Lowest Day:           %.1f cups%n", tracker.getMin());
        System.out.println();
        
        System.out.println("All Daily Values:");
        System.out.println(tracker.toString());
    }

    /**
     * Displays personalized insights and recommendations based on weekly data.
     * This method encapsulates all insight logic and analysis.
     * 
     * @param tracker The WeeklyData object containing the analysis
     * @param weekData The array of daily water intake values
     */
    private static void displayInsights(WeeklyData tracker, double[] weekData) {
        System.out.println("===========================================");
        System.out.println("           Weekly Insights                 ");
        System.out.println("===========================================");
        
        double average = tracker.getAverage();
        int daysMetGoal = countDaysMetGoal(weekData);
        
        System.out.println("Days you met the 8-cup goal: " + daysMetGoal + "/7");
        
        if (average >= 8) {
            System.out.println("Great job! You stayed well hydrated this week!");
            System.out.println("Keep up the excellent hydration habits!");
        } else if (average >= 6) {
            System.out.println("Good effort! You're close to the daily goal.");
            System.out.println("Try to drink more water next week.");
        } else {
            System.out.println("You need to drink more water next week!");
            System.out.println("Aim for at least 8 cups per day for better health.");
        }
        
        if (daysMetGoal == 7) {
            System.out.println("Excellent! You achieved perfect hydration all week!");
        } else if (daysMetGoal >= 5) {
            System.out.println("You had a great week! Focus on the remaining days.");
        }
    }

    /**
     * Helper method to count how many days met the 8-cup hydration goal.
     * This method encapsulates a specific calculation.
     * 
     * @param weekData The array of daily water intake values
     * @return The number of days where intake was 8 cups or more
     */
    private static int countDaysMetGoal(double[] weekData) {
        int daysMetGoal = 0;
        for (int i = 0; i < weekData.length; i++) {
            if (weekData[i] >= 8) {
                daysMetGoal++;
            }
        }
        return daysMetGoal;
    }
}
