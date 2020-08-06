package game.menus;

import game.Player;
import game.input.Input;
import game.zones.MonsterPit;

import java.util.Scanner;

public class MonsterPitZone {

    private static Scanner sc = new Scanner(System.in);

    public static void monsterPit(Player player) {
        MonsterPit monsterPit = new MonsterPit();
        System.out.println("** You have entered the Monster Pit **");
        System.out.println("Your first battle is against a Zombie");
        monsterPit.zombieArr[0].getStats();
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Flee");

        int choice;
        choice = Input.getInteger(sc);

        switch (choice) {
            case 1:
                // Count to keep track if the player has tried to flee
                int count = 0;
                while (monsterPit.zombieArr[0].getHp() > 0) {
                    player.attackMonster(monsterPit.zombieArr[0]);
                    monsterPit.zombieArr[0].attackPlayer(player);

                    // TODO: Move this to another class
                    // If the players hp is less than 100, ask if the player wants to continue fighting
                    if (player.getHp() < 100 && count == 0) {
                        count++;
                        String continueFighting;
                        System.out.println("You have less than 100 hp left, would you like to continue fighting? (Y/N)");
                        continueFighting = Input.getString(sc);
                        // If the player don't want to continue, try to flee by comparing the movement speed of the
                        // player and the monster
                        if (continueFighting.equalsIgnoreCase("no")) {
                            System.out.println("Attempting to flee the battle!");
                            // if the movement speed of the player > monster then exit the fight, else keep fighting
                            if (player.getMovementSpeed() > monsterPit.zombieArr[0].getMovementSpeed()) {
                                System.out.println("You have successfully fled the battle!");
                                break;
                            }
                            System.out.println(monsterPit.zombieArr[0].getName() + " is faster than you, you will " +
                                    "have to fight");
                        }
                    }
                }
                // TODO: Attack the zombie
        }

    }

}
