/* Hadeem Secka
 * 
 */

import java.util.Scanner;

public class DateAndTimeTester {
    
 
    // This class is designed to validate date and time input from the user.

    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a date and time (MM/DD hh:mm) and I will determine if it is valid");
            String input = scanner.nextLine();
            if (isValid(input)) {
                System.out.println("The date and time is valid!");
            } else {
                System.out.println("The date and time is not valid");
            }

            System.out.println("Would you like to exit? Type \"quit\" to exit or press [ENTER] to continue");
            String decision = scanner.nextLine();
            if ("quit".equalsIgnoreCase(decision)) {
                System.out.println("Good bye");
                break;
            }
        }
    }

    private boolean isValid(String dateTime) {
        // Splits the dateTime string into date and time parts.
        String[] parts = dateTime.split(" ");
        if (parts.length != 2) return false;
        return isValidDate(parts[0]) && isValidTime(parts[1]);
    }

    private boolean isValidDate(String date) {
        // Validates the date part.
        int month = getMonth(date);
        int day = getDay(date);
        if (month < 1 || month > 12) return false;
        if (day < 1) return false;
        if (month == 2 && day > 28) return false;
        if (day > 31) return false;
        return true;
    }

    private boolean isValidTime(String time) {
        // Validates the time part.
        int hour = getHour(time);
        int minute = getMinute(time);
        if (hour < 1 || hour > 12) return false;
        if (minute < 0 || minute > 59) return false;
        return true;
    }

    private int getMonth(String date) {
        // Extracts the month from the date string.
        String[] parts = date.split("/");
        return Integer.parseInt(parts[0]);
    }

    private int getDay(String date) {
        // Extracts the day from the date string.
        String[] parts = date.split("/");
        return Integer.parseInt(parts[1]);
    }

    private int getHour(String time) {
        // Extracts the hour from the time string.
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]);
    }

    private int getMinute(String time) {
        // Extracts the minute from the time string.
        String[] parts = time.split(":");
        return Integer.parseInt(parts[1]);
    }

    // Main method only for testing purposes. Remove before submitting.
    public static void main(String[] args) {
        new DateAndTimeTester().run();
    }
}
