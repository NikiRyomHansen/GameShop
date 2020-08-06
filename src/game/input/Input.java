package game.input;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {

    // Get an integer and display a message
    public static int getInteger(Scanner sc, String message) {
        System.out.print(message);
        // while the input is not an int, keep looping
        while (!sc.hasNextInt()) {
            // try-catch if the user inputs anything other than integers
            try {
                sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("No characters allowed");
                // clear Scanner input
                sc.next();
            }
            System.out.print(message);
        }
        return sc.nextInt();
    }

    // Overloading getInteger to not display a message
    public static int getInteger(Scanner sc) {
        // while the input is not an int, keep looping
        while (!sc.hasNextInt()) {
            // try-catch if the user inputs anything other than integers
            try {
                sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("No characters allowed");
                // clear Scanner input
                sc.next();
            }
        }
        return sc.nextInt();
    }

    public static String getString(Scanner sc, String message) {
        System.out.println(message);
        // while the input is not a String, keep looping
        while (!sc.hasNext()) {
            System.out.println("The input cannot be empty");
            // clear Scanner input
            sc.next();
            System.out.print(message);
        }
        return sc.next();
    }

    public static String getString(Scanner sc) {
        // while the input is not a String, keep looping
        while (!sc.hasNext()) {
            System.out.println("The input cannot be empty");
            // clear Scanner input
            sc.next();
        }
        return sc.next();
    }
}
