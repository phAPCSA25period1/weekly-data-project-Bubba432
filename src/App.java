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
     * 
     * This method:
     * 1. Initializes a Scanner for user input
     * 2. Displays program information
     * 3. Collects daily water intake data with input validation
     * 4. Creates a WeeklyData object to analyze the data
     * 5. Displays statistical results (total, average, min, max)
     * 6. Provides personalized insights and recommendations
     * 
     * @param args Command-line arguments (not used in this application)
     */
    public static void main(String[] args) {

        // TODO 1: Create a Scanner for user input
        Scanner scanner = new Scanner(System.in);

        // TODO 2: Give information about your program
        //         Ask the user about their goals (if applicable)
        System.out.println("===========================================");
        System.out.println("    Water Intake Tracker for the Week       ");
        System.out.println("===========================================");
        System.out.println("Track your daily water consumption in cups.");
        System.out.println("Recommended daily intake: 8 cups");
        System.out.println();

        // TODO 3: Create an array to hold 7 days of data
        //         Use an appropriate data type (int or double)
        //         Name the array weekData
        double[] weekData = new double[7];

        // TODO 4: Use a for loop to collect data for each day of the week
        //         Prompt example:
        //         "Enter <data type> for day X: "
        //
        //         Include input validation:
        //         - Use a while loop to prevent negative values
        //         - Re-prompt if the value is invalid
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

        // TODO 5: Create a WeeklyData object
        //         Pass the weekData array into the constructor
        WeeklyData tracker = new WeeklyData(weekData);

        // TODO 6: Display the results of the analysis
        //         Call methods from WeeklyData to display:
        //         - Total
        //         - Average
        //         - Minimum
        //         - Maximum
        //
        //         Use clear labels and formatted output if needed
        System.out.println("===========================================");
        System.out.println("         Weekly Summary Report              ");
        System.out.println("===========================================");
        System.out.printf("Total Cups Consumed:  %.1f%n", tracker.getTotal());
        System.out.printf("Average Per Day:      %.2f cups%n", tracker.getAverage());
        System.out.printf("Highest Day:          %.1f cups%n", tracker.getMax());
        System.out.printf("Lowest Day:           %.1f cups%n", tracker.getMin());
        System.out.println();

        // TODO 7: Display the full week of data
        //         Use the toString() method from WeeklyData
        System.out.println("All Daily Values:");
        System.out.println(tracker.toString());

        // TODO 8: Give the user insights about their week
        //         --> "You need to drink more water next week!"
        //         --> "You were very hydrated this week!"
        //         --> etc.
        System.out.println("===========================================");
        System.out.println("           Weekly Insights                 ");
        System.out.println("===========================================");
        
        double average = tracker.getAverage();
        int daysMetGoal = 0;
        for (int i = 0; i < weekData.length; i++) {
            if (weekData[i] >= 8) {
                daysMetGoal++;
            }
        }
        
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
        
        scanner.close();
    }
}
