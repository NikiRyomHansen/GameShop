package game.battles;

import game.Player;
import game.input.Input;
import game.monsters.Skeleton;
import game.monsters.Zombie;
import game.zones.Level1;

import java.util.Scanner;

public class Tier1 {

    public static boolean fled;

    private static Scanner sc = new Scanner(System.in);
    private static Level1 monsterSpawn = new Level1();

    public static void oneZombie(Player player) {
        Zombie zombie = monsterSpawn.zombieArr[0];
        System.out.println("You have run into a crazed zombie!");
        // Display the stats of the enemy to the Player
        System.out.println(zombie.getStats());
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
                int count = 0;
                // While the zombie is still alive, keep attacking
                while (zombie.getHp() > 0 && player.getHp() > 0) {
                    player.attackMonster(zombie);
                    zombie.attackPlayer(player);
                    // if the players hp is less than 100, ask to flee or stay
                    if (player.getHp() < 100 && count == 0) {
                        fled = Utility.fleeMidBattle(player, sc, zombie);
                        count++;
                        // if player successfully flees, break out of the switch statement and continue
                        if (fled) {
                            break;
                        }
                    }
                }
                // When the zombie is dead, provide the silver and exp dropped from the zombie
                if (zombie.getHp() <= 0) {
                    // TODO: SetEXP
                    player.setMoney(player.getMoney() + zombie.getZombieDrop().getSilver());
                }
                break;
            case 2:
                fled = Utility.fleePreBattle(player, zombie);
                if (fled)
                    break;
                else
                    oneZombie(player);
        }
    }

    public static void oneZombieOneSkeleton(Player player) {

        Zombie zombie = monsterSpawn.zombieArr[1];
        Skeleton skeleton = monsterSpawn.skeletonArr[0];
        System.out.println("You have run into a skeleton and a zombie!");
        // Display the stats of the enemy to the Player
        System.out.println(zombie.getStats());
        System.out.println(skeleton.getStats());
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
                int count = 0;
                // Count to keep track of who to attack so the Player doesn't attack both enemies in one round
                int oddEvenWhoToAttack = 0;

                // While either monster AND the player is still alive, keep attacking
                while ((zombie.getHp() > 0 || skeleton.getHp() > 0) && player.getHp() > 0) {
                    // If the remainder is even, attack the skeleton else the zombie
                    if (oddEvenWhoToAttack % 2 == 0 || zombie.getHp() <= 0) {
                        if (skeleton.getHp() > 0) {
                            player.attackMonster(skeleton);
                            skeleton.attackPlayer(player);
                        }
                    } else {
                        if (zombie.getHp() > 0 || skeleton.getHp() <= 0) {
                            player.attackMonster(zombie);
                            zombie.attackPlayer(player);
                        }
                    }
                    oddEvenWhoToAttack++;

                    // if the players hp is less than 100, ask to flee or stay
                    if (player.getHp() < 100 && count == 0) {
                        fled = Utility.fleeMidBattle(player, sc, zombie, skeleton);
                        count++;
                        // if player successfully flees, break out of the switch statement and continue
                        if (fled) {
                            break;
                        }
                    }

                }
                // When the zombie AND skeleton is dead, provide the silver and exp dropped from them
                if (zombie.getHp() <= 0 && skeleton.getHp() <= 0) {
                    // TODO: SetEXP
                    player.setMoney(player.getMoney() + zombie.getZombieDrop().getSilver());
                    System.out.println(zombie.silverDrop());
                    player.setMoney(player.getMoney() + skeleton.getSkeletonDrop().getSilver());
                    System.out.println(skeleton.silverDrop());
                }
                break;
            case 2:
                fled = Utility.fleePreBattle(player, zombie);
                if (fled)
                    break;
                else
                    oneZombie(player);
        }
    }

    public static void zombieSkeletonBattle(int amountOfZombies, int amountOfSkeletons, Player player) {
        Zombie[] zombieArr = new Zombie[amountOfZombies];
        Skeleton[] skeletonArr = new Skeleton[amountOfSkeletons];

        for (int i = 0; i < zombieArr.length; i++) {
            zombieArr[i] = new Zombie("Zombie", 70, 15, 10, 3, 5, 1, 5);
        }

        for (int i = 0; i < skeletonArr.length; i++) {
            skeletonArr[i] = new Skeleton("Skeleton", 50, 20, 5, 10, 3, 1, 7);
        }


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
                int count = 0;
                // Count to keep track of who to attack so the Player doesn't attack both enemies in one round
                int whoToAttack = 0;

                for (int i = 0, j = 0; i < zombieArr.length || j < skeletonArr.length;) {
                    // While either monster AND the player is still alive, keep attacking
                    while ((zombieArr[i].getHp() > 0 || skeletonArr[j].getHp() > 0) && player.getHp() > 0) {
                        // If the remainder is even, attack the skeleton else the zombie
                        if ((whoToAttack % 2 == 0 || zombieArr[i].getHp() <= 0)) {
                            if (skeletonArr[j].getHp() > 0) {
                                player.attackMonster(skeletonArr[j]);
                                skeletonArr[j].attackPlayer(player);
                            }
                        } else {
                            if (zombieArr[i].getHp() > 0 || skeletonArr[j].getHp() <= 0) {
                                player.attackMonster(zombieArr[i]);
                                zombieArr[i].attackPlayer(player);
                            }
                        }
                        whoToAttack++;


                        /*I have two arrays and if one array contains 2 elements, the other 1 I want to stop looping the */

                        // if the players hp is less than 100, ask to flee or stay
                        if (player.getHp() < 100 && count == 0) {
                            fled = Utility.fleeMidBattle(player, sc, zombieArr[i], skeletonArr[j]);
                            count++;
                            // if player successfully flees, break out of the switch statement and continue
                            if (fled) {
                                break;
                            }
                        }

                    }
                    // When the zombie AND skeleton is dead, provide the silver and exp dropped from them
                    if (zombieArr[i].getHp() <= 0 && skeletonArr[j].getHp() <= 0) {
                        // TODO: SetEXP
                        player.setMoney(player.getMoney() + zombieArr[i].getZombieDrop().getSilver());
                        System.out.println(zombieArr[i].silverDrop());
                        player.setMoney(player.getMoney() + skeletonArr[j].getSkeletonDrop().getSilver());
                        System.out.println(skeletonArr[j].silverDrop());
                    }
                }
                break;

            case 2:
//                fled = Utility.fleePreBattle(player, zombieArr[i]);
//                if (fled)
//                    break;
//                else
//                    oneZombie(player);
        }

    }

    public static void zombieBattle(int amountOfZombies, Player player) {
        Zombie[] zombieArr = new Zombie[amountOfZombies];

        for (int i = 0; i < zombieArr.length; i++) {
            zombieArr[i] = new Zombie("Zombie", 70, 15, 10, 3, 5, 1, 5);
        }

        System.out.println("You have run into " + amountOfZombies + " zombie!");
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
                int count = 0;

                for (int i = 0; i < zombieArr.length; i++) {
                    // While either monster AND the player is still alive, keep attacking
                    while (zombieArr[i].getHp() > 0 && player.getHp() > 0) {
                        player.attackMonster(zombieArr[i]);
                        zombieArr[i].attackPlayer(player);
                    }

                    // if the players hp is less than 100, ask to flee or stay
                    if (player.getHp() < 100 && count == 0) {
                        fled = Utility.fleeMidBattle(player, sc, zombieArr[i]);
                        count++;
                        // if player successfully flees, break out of the switch statement and continue
                        if (fled) {
                            break;
                        }
                    }
                    // When the zombie AND skeleton is dead, provide the silver and exp dropped from them
                    if (zombieArr[i].getHp() <= 0) {
                        // TODO: SetEXP
                        player.setMoney(player.getMoney() + zombieArr[i].getZombieDrop().getSilver());
                        System.out.println(zombieArr[i].silverDrop());
                    }
                }
                break;
        }
    }
}
