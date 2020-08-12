package game.menus;

import game.Player;
import game.battles.Tier1;
import game.input.Input;

import java.util.Scanner;

public class Level1 {

    public static void levelOne(Player player) {

        // TODO: If the player has completed the game before, they can choose a harder difficulty

        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to the main storyline!");
        System.out.println("In the game you will choose between different paths, choose wisely!");
        System.out.println("If you venture onto the wrong path you might find yourself fighting dangerous enemies.");
        System.out.println("However if you choose the right path you might even find bonus loot!");
        System.out.println("Can you reach the final level? Each difficulty will progressively become more challenging");
        System.out.println("Are you ready to start venturing into the maze? (Y/N)");

        String yesNo;
        yesNo = Input.getString(sc);

        if (!yesNo.equalsIgnoreCase("y")) {
            return;
        }

        System.out.println("You enter the maze!");

        int choice;
        do {
            System.out.println("You can continue straight or turn left");
            System.out.println("1. Continue straight");
            System.out.println("2. Turn left");
            choice = Input.getInteger(sc);

            switch (choice) {
                case 1: // Straight
                    // TODO: Change amount of zombies depending on difficulty
                    // Start a battle
                    Tier1.zombieSkeletonBattle(2, 1, player);

                    if (player.getHp() > 0) {
                        System.out.println("As you continue into the maze you see a new crossing");
                        System.out.println("1. Continue straight");
                        System.out.println("2. Turn right");

                        choice = Input.getInteger(sc);
                        switch (choice) {
                            case 1: // Straight/straight
                                Tier1.zombieSkeletonBattle(2, 1, player);

                                if (player.getHp() > 0) {
                                    // TODO: Add next pathway
                                }

                                break;
                            case 2: // Straight/right

                        }
                    }
                    break;
                case 2: // Left
                    System.out.println("You turn left and see a new crossing to go straight or turn right");
                    System.out.println("1. Continue Straight");
                    System.out.println("2. Turn right");
                    choice = Input.getInteger(sc);
                    switch (choice) {
                        case 1: // Straight
                            // TODO: t1 Battle here!
                            break;
                        case 2: // Right
                            System.out.println("You turn right and see a new crossing to go straight or turn left");
                            System.out.println("1. Continue straight");
                            System.out.println("2. Turn left");
                            choice = Input.getInteger(sc);
                            switch (choice) {
                                case 1: // Straight
                                    // TODO: t1 Maze guardian battle!
                                    break;
                                case 2: // Left
                                    // TODO: t1 Battle here!
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } while (player.getHp() > 0); // TODO: Include if player beats Maze Guardian set to false
    }

}
