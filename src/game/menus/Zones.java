package game.menus;

import game.Player;

import java.util.Scanner;

public class Zones {

    private static Scanner scanner = new Scanner(System.in);

    // TODO: Add Boss Pit
    public static void zones(Player player) {
        // 1. Monster Pit
        // 2. Arena (PvP)

        System.out.println("** Zone Menu **");
        System.out.println("1. Main Story");
        System.out.println("2. Monster Pit");
        System.out.println("3. Arena (PvP)");
        System.out.println("9. Exit");

        // Get the user input
        int choice;
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                Level1.levelOne(player);
                break;
            case 2:
                break;
            default:

        }

    }

}
