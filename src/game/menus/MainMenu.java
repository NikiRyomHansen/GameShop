package game.menus;

import java.util.InputMismatchException;
import java.util.Scanner;

/* The initial start menu for the player */
public class MainMenu {

    Scanner scanner = new Scanner(System.in);

    public void startMenu() {

        int choice;

        // 1. Choose zone
        // 2. Enter the GameShop

        do {
            System.out.println("** Game Menu **");
            System.out.println("1. Choose zone");
            System.out.println("2. Enter Game shop");
            System.out.println("9. Exit");
            System.out.println();
            try {
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter 1-9");
                // Clear the Scanner input
                scanner.next();
                continue;
            }

            switch (choice) {
                case 1:

            }

        } while(true);

    }

}
