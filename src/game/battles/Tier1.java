package game.battles;

import game.Player;
import game.input.Input;
import game.monsters.Monster;
import game.monsters.Skeleton;
import game.monsters.Zombie;
import game.zones.Level1;

import java.util.Scanner;

public class Tier1 {

    public static boolean fled;

    private static Scanner sc = new Scanner(System.in);
    private static Level1 monsterSpawn = new Level1();

    private static int zombiesKilled = 0;
    private static int skeletonsKilled = 0;

    public static void zombieSkeletonBattle(int amountOfZombies, int amountOfSkeletons, Player player) {

        Monster[] monsterArr = new Monster[amountOfZombies + amountOfSkeletons];

        if (amountOfZombies != 0) {
            // Adding zombies to the monster array
            for (int i = 0; i < amountOfZombies; i++) {
                monsterArr[i] = new Zombie("Zombie", 70, 15, 10, 3, 5, 1, 5);
            }
        }

        if (amountOfSkeletons != 0) {
            // Adding skeletons to the monster array starting at the first empty index
            for (int i = amountOfZombies; i < monsterArr.length; i++) {
                monsterArr[i] = new Skeleton("Skeleton", 50, 20, 5, 10, 3, 1, 7);
            }
        }
        System.out.println("Length of array: " + monsterArr.length);


        System.out.println("You have run into " + amountOfZombies + " zombies and " + amountOfSkeletons + " skeletons!");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Flee");

        // Get the user input
        int choice;
        choice = Input.getInteger(sc);

        // Interpret the user input
        switch (choice) {
            // If the user attacks
            case 1:
                // Count to keep track if the player has tried to flee
                boolean hasTriedToFlee = false;
                // Flags to keep track of the loot from each individual monster
                boolean hasReceivedZombieDrop = false;
                boolean hasReceivedSkeletonDrop = false;
                // Count to keep track of who to attack so the Player doesn't attack both enemies in one round
                int whoToAttack = 0;
                int i = 0, j = amountOfZombies;
                // Decide iterations of the for loop
                int iterations = Math.max(amountOfSkeletons, amountOfZombies); // Returns highest value

                for (int k = 0; k < iterations; k++) {
                    // While either monster AND the player is still alive, keep attacking
                    while ((monsterArr[i].getHp() > 0 || monsterArr[j].getHp() > 0) && player.getHp() > 0) {
                        // If the remainder is even, attack the zombie else the skeleton
                        if (whoToAttack % 2 == 0 && monsterArr[i].getHp() > 0) {
                            // Zombie attack here
                            player.attackMonster(monsterArr[i]);
                            monsterArr[i].attackPlayer(player);
                        } else { // Skeleton attack here
                            if (monsterArr[j].getHp() > 0)
                                player.attackMonster(monsterArr[j]);
                                monsterArr[j].attackPlayer(player);
                        }
                        whoToAttack++;
                        // When the monster dies, reward the player with the monsterDrop
                        if (monsterArr[i].getHp() <= 0) {
                            // TODO: SetEXP
                            // If the monster has already received this monsters drop, skip it
                            if (!hasReceivedZombieDrop && i < amountOfZombies) {
                                player.setMoney(player.getMoney() + monsterArr[i].getMonsterDrop().getSilver());
                                System.out.println(monsterArr[i].getSilverDrop());
                                hasReceivedZombieDrop = true;
                                zombiesKilled++;
                            }
                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        if (monsterArr[j].getHp() <= 0) {
                            if (!hasReceivedSkeletonDrop) {
                                player.setMoney(player.getMoney() + monsterArr[j].getMonsterDrop().getSilver());
                                System.out.println(monsterArr[j].getSilverDrop());
                                hasReceivedSkeletonDrop = true;
                                skeletonsKilled++;
                            }

                            try {
                                Thread.sleep(500);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    // Increment j when the skeleton dies and when we are not at the last index of the array
                    if (monsterArr[j].getHp() <= 0 && hasReceivedSkeletonDrop && j < monsterArr.length - 1) {
                        j++;
                        // Set to false to that the player will receive loot from the next skeleton kill
                        hasReceivedSkeletonDrop = false;
                    }
                    // Increment i so it stays below the start index of the skeletons
                    if (monsterArr[i].getHp() <= 0 && hasReceivedZombieDrop && i < amountOfZombies - 1) {
                        i++;
                        hasReceivedZombieDrop = false;
                    }

                    // if the players hp is less than 100, ask to flee or stay
                        if (player.getHp() < 100 && !hasTriedToFlee) {
                            // Check if the monsters are alive (Player can flee from a dead monster even if it's faster)
                            if (monsterArr[i].getHp() > 0 && monsterArr[j].getHp() > 0)
                                fled = Utility.fleeMidBattle(player, sc, monsterArr[i], monsterArr[j]);
                            else if (monsterArr[i].getHp() > 0 && monsterArr[j].getHp() <= 0)
                                fled = Utility.fleeMidBattle(player, sc, monsterArr[i]);
                            else
                                fled = Utility.fleeMidBattle(player, sc, monsterArr[j]);

                            hasTriedToFlee = true;
                            // if player successfully flees, break out of the switch statement
                            if (fled) {
                                break;
                            }
                        }
                }
                System.out.println("Zombies Killed: " + zombiesKilled);
                System.out.println("Skeletons killed: " + skeletonsKilled);
                int sum = zombiesKilled + skeletonsKilled;
                break;

            case 2:
//                fled = Utility.fleePreBattle(player, zombieArr[i]);
//                if (fled)
//                    break;
//                else
//                    oneZombie(player);
        }

    }

    public static void monsterBattle(String monsterType, int amountOfMonsters, Player player) {
        Monster[] monsterArr = new Monster[amountOfMonsters];

        // Populate the array with monsters
        for (int i = 0; i < monsterArr.length; i++) {
            if (monsterType.equalsIgnoreCase("zombie"))
                monsterArr[i] = new Zombie("Zombie", 70, 15, 10, 3, 5, 1, 5);
            else if (monsterType.equalsIgnoreCase("skeleton"))
                monsterArr[i] = new Skeleton("Skeleton", 50, 20, 5, 10, 3, 1, 7);
        }

        System.out.println("You have run into " + amountOfMonsters + " " + monsterType + "s");
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Flee");

        // Get the user input
        int choice;
        choice = Input.getInteger(sc);

        boolean hasTriedToFlee = false;

        // Interpret the user input
        switch (choice) {
            // If the user attacks
            case 1:
                // Count to keep track if the player has tried to flee

                for (int i = 0; i < monsterArr.length; i++) {
                    // While either monster AND the player is still alive, keep attacking
                    while (monsterArr[i].getHp() > 0 && player.getHp() > 0) {
                        player.attackMonster(monsterArr[i]);
                        monsterArr[i].attackPlayer(player);
                    }

                    // if the players hp is less than 100, ask to flee or stay
                    // Check if the monsters are alive (Player can flee from a dead monster even if it's faster)
                    if (player.getHp() < 100 && !hasTriedToFlee && monsterArr[i].getHp() > 0) {
                        fled = Utility.fleeMidBattle(player, sc, monsterArr[i]);
                        hasTriedToFlee = true;
                        // if player successfully flees, break out of the switch statement
                        if (fled) {
                            break;
                        }
                    }
                    // When the zombie AND skeleton is dead, provide the silver and exp dropped from them
                    if (monsterArr[i].getHp() <= 0) {
                        // TODO: SetEXP
                        player.setMoney(player.getMoney() + monsterArr[i].getMonsterDrop().getSilver());
                        System.out.println(monsterArr[i].getSilverDrop());
                    }
                }
                // break out of the switch statement after killing all monsters
                break;
            case 2:
                // TODO: Insert fleePreBattle here
                break;
        }
    }
}
