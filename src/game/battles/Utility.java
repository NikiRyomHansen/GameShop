package game.battles;

import game.Player;
import game.input.Input;
import game.monsters.Monster;

import java.util.Scanner;

public class Utility {

    public static boolean fleeMidBattle(Player player, Scanner sc, Monster monster) {

        String continueFighting;

        System.out.println("You have less than 100 hp left, would you like to continue fighting? (Y/N)");
        continueFighting = Input.getString(sc);
        // If the player don't want to continue, try to flee by comparing the movement speed of the
        // player and the monster
        while (!continueFighting.equalsIgnoreCase("n") && !continueFighting.equalsIgnoreCase("y")) {
            System.out.println("Not equal 'y' or 'n'");
            continueFighting = Input.getString(sc);
        }
        if (continueFighting.equalsIgnoreCase("n")) {
            System.out.println("Attempting to flee the battle!");
            // if the movement speed of the player > monster then exit the fight, else keep fighting
            if (player.getMovementSpeed() > monster.getMovementSpeed()) {
                System.out.println("You have successfully fled the battle!");
                return true;
            } else {
                System.out.println(monster.getName() + " is faster than you and you cannot escape! You need " +
                        "to fight");
                return false;
            }
        }
        return false;
    }

    // Overloading fleeMidBattle to compare movement speed of 2 monsters
    public static boolean fleeMidBattle(Player player, Scanner sc, Monster monster1, Monster monster2) {

        String continueFighting;
        Monster monster;

        // Compare the movement speed of both monsters in the battle
        if (monster1.getMovementSpeed() > monster2.getMovementSpeed()) {
            monster = monster1;
        } else {
            monster = monster2;
        }

        System.out.println("You have less than 100 hp left, would you like to continue fighting? (Y/N)");
        continueFighting = Input.getString(sc);
        // If the player don't want to continue, try to flee by comparing the movement speed of the
        // player and the monster
        while (!continueFighting.equalsIgnoreCase("n") && !continueFighting.equalsIgnoreCase("y")) {
            System.out.println("Not equal 'y' or 'n'");
            continueFighting = Input.getString(sc);
        }
        if (continueFighting.equalsIgnoreCase("n")) {
            System.out.println("Attempting to flee the battle!");
            // if the movement speed of the player > monster then exit the fight, else keep fighting
            if (player.getMovementSpeed() > monster.getMovementSpeed()) {
                System.out.println("You have successfully fled the battle!");
                return true;
            } else {
                System.out.println(monster.getName() + " is faster than you and you cannot escape! You need " +
                        "to fight");
                return false;
            }
        }
        return false;
    }

    public static boolean fleePreBattle(Player player, Monster monster) {
        System.out.println("Attempting to flee the battle!");
        if (player.getMovementSpeed() > monster.getMovementSpeed()) {
            System.out.println("You have successfully fled the battle! \nCoward...");
            return true;
        } else {
            System.out.println(monster.getName() + " is faster than you and you cannot escape! You need " +
                    "to fight");
            return false;
        }
    }

    public static boolean fleePreBattle(Player player, Monster monster1, Monster monster2) {

        Monster monster;
        // Compare the movement speed of both monsters in the battle
        if (monster1.getMovementSpeed() > monster2.getMovementSpeed()) {
            monster = monster1;
        } else {
            monster = monster2;
        }

        System.out.println("Attempting to flee the battle!");
        if (player.getMovementSpeed() > monster.getMovementSpeed()) {
            System.out.println("You have successfully fled the battle! \nCoward...");
            return true;
        } else {
            System.out.println(monster.getName() + " is faster than you and you cannot escape! You need " +
                    "to fight");
            return false;
        }
    }


}
