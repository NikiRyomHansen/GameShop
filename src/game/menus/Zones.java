package game.menus;

import game.zones.MonsterPit;

import java.util.Scanner;

public class Zones {

    private static Scanner scanner = new Scanner(System.in);

    // TODO: Add Boss Pit
    public static void zones() {
        // 1. Monster Pit
        // 2. Arena (PvP)

        System.out.println("** Zone Menu **");
        System.out.println("1. Monster Pit");
        System.out.println("2. Arena (PvP)");
        System.out.println("9. Exit");

        // Get the user input
        int choice;
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("** You have entered the Monster Pit **");
                System.out.println("Be prepared, you can at any time run into one or several monsters!");
                MonsterPit monsterPit = new MonsterPit();
                System.out.println(monsterPit.skeletonArr[0].getAttackPoints());
                break;
            case 2:
                break;
            default:

        }

    }

}
