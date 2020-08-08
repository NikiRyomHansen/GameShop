package game.menus;

import game.GameShop;
import game.Player;

import java.util.InputMismatchException;
import java.util.Scanner;

/* The initial start menu for the player */
public class MainMenu {

    static Scanner scanner = new Scanner(System.in);

    // Create a Player
    public static Player createPlayer() {
        // Prompting the user for the Player's name
        System.out.println("Please enter Player name: ");
        String playerName = scanner.nextLine();
        // Instantiating a Player
        return new Player(playerName, 45);
    }

    public static void startMenu() {

        int choice;

        // Create a player
        Player player = createPlayer();

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
                    Zones.zones(player);
                    break;
                case 2:
                    GameShop.menu(player);
                    break;
            }

        } while(true);

    }

}
