/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameshop;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Adder
 */
public class GameShop {

    private static Scanner sc = new Scanner(System.in);

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


    public static double getDouble(Scanner sc, String message) {
        System.out.print(message);
        // while the input is not a double, keep looping
        while (!sc.hasNextDouble()) {
            // try-catch if the user inputs anything other than double
            try {
                sc.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("No characters allowed");
                // clear Scanner input
                sc.next();
            }
            System.out.print(message);
        }
        return sc.nextDouble();
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

    // Create a Player
    public static Player createPlayer() {
        // Prompting the user for the Player's name
        System.out.println("Please enter Player name: ");
        String playerName = sc.nextLine();
        // Instantiating a Player
        // Instantiating a Binary Search Tree (BSTree) object
        return new Player(playerName, 45);
    }

    // present the player for a menu
    public static void menu(Player p) {
        // Create a player
        BSTree bst = new BSTree();
        int choice;
        do {
            // the player menu
            System.out.println("** Game Menu **");
            System.out.println("1. Add items to the shop");
            System.out.println("2. Update existing items in the shop");
            System.out.println("3. Delete items from the shop");
            System.out.println("4. Buy from the shop");
            System.out.println("5. View backpack");
            System.out.println("6. View player");
            System.out.println("7. Exit");
            // get the user input
            // if InputMismatchException is found, continue in the next iteration
            try {
                choice = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Please enter 1-7");
                // Clear the Scanner input
                sc.next();
                continue;
            }


            switch (choice) {

                // Add a weapon to the shop
                case 1:
                    addWeapons(bst, sc);
                    break;
                // Update a weapon in the shop
                case 2:
                    updateWeapon(bst, sc);
                    break;
                // Delete a weapon from the shop
                case 3:
                    deleteWeapon(bst, sc, p);
                    break;
                // buy a weapon from the shop
                case 4:
                    showRoom(bst, p, sc);
                    break;
                // Print the players backpack
                case 5:
                    p.printBackpack();
                    break;
                // Print the player
                case 6:
                    p.printCharacter();
                    break;
                // Exit the program
                case 7:
                    System.exit(0);
                    // If none of the case conditions are true
                default:
                    System.out.println("Please enter 1-7");
            }
        } while (true);
    }


    public static void addWeapons(BSTree bst, Scanner sc) {
        System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
        String weaponName;
        System.out.print("Please enter the NAME of the Weapon ('end' to quit): ");
        Scanner newSC = new Scanner(System.in);
        weaponName = newSC.nextLine();
        while (weaponName.compareTo("end") != 0) {
            int weaponRange = getInteger(sc, "Please enter the Range of the Weapon (0-10):");
            while (weaponRange < 0 || weaponRange > 10) {
                weaponRange = getInteger(sc, "The range must be between 0-10");
            }
            int weaponDamage = getInteger(sc, "Please enter the Damage of the Weapon:");
            double weaponWeight = getDouble(sc, "Please enter the Weight of the Weapon (in pounds):");
            double weaponCost = getDouble(sc, "Please enter the Cost of the Weapon:");
            Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
            int quantity = getInteger(sc, "Please enter the quantity in stock:");
            bst.insert(w, quantity);
            System.out.println("Added to the shop:\n" + w.toString());
            System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
            weaponName = newSC.nextLine();
        }
    }

    // Update a weapon in the shop
    public static void updateWeapon(BSTree bst, Scanner sc) {
        System.out.println("***********WELCOME TO THE WEAPON UPDATING MENU*********");
        System.out.print("Please enter the NAME of the weapon you want to update ('end' to quit): ");
        String weaponName;
        Scanner newSC = new Scanner(System.in);
        weaponName = newSC.nextLine();
        // while the input is not in the shop or input != end , keep prompting
        while (bst.search(weaponName) == null && weaponName.compareTo("end") != 0) {
            System.out.print("The item was not in the shop, try again ('end' to quit): ");
            weaponName = newSC.nextLine();
        }
        while (weaponName.compareTo("end") != 0 && bst.search(weaponName) != null) {
            int weaponRange = getInteger(sc, "Please enter the new Range of the Weapon (0-10):");
            while (weaponRange < 0 || weaponRange > 10) {
                weaponRange = getInteger(sc, "The range must be between 0-10");
            }
            int weaponDamage = getInteger(sc, "Please enter the new Damage of the Weapon:");
            double weaponWeight = getDouble(sc, "Please enter the new Weight of the Weapon (in pounds):");
            double weaponCost = getDouble(sc, "Please enter the new Cost of the Weapon:");
            Weapon weapon = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
            int quantity = getInteger(sc, "Please enter the new quantity in stock:");
            bst.update(weapon, quantity);
            System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
            weaponName = newSC.nextLine();
            // while the input is not in the shop or input != end , keep prompting
            while (bst.search(weaponName) == null && weaponName.compareTo("end") != 0) {
                System.out.print("The item was not in the shop, try again ('end' to quit): ");
                weaponName = newSC.nextLine();
            }
        }
    }

    // Delete a weapon in the shop
    public static void deleteWeapon(BSTree bst, Scanner sc, Player p) {
        System.out.println("***********WELCOME TO THE WEAPON DELETION MENU*********");
        System.out.print("Please enter the NAME of the weapon you want to delete ('end' to quit): ");
        Scanner newSC = new Scanner(System.in);
        String weaponName = newSC.nextLine();
        // while the input is not in the shop or input != end , keep prompting
        while (bst.search(weaponName) == null && weaponName.compareTo("end") != 0) {
            System.out.print("The item was not in the shop, try again ('end' to quit): ");
            weaponName = newSC.nextLine();
        }
        // while the item is in the list, ask the player if they want to delete "weapon"
        if (bst.search(weaponName) != null) {
            System.out.println("Enter 'Y' to delete:\n" + bst.search(weaponName).data.item);
            String delete = newSC.nextLine();
            if (delete.equalsIgnoreCase("y")) {
                System.out.println("Successfully deleted: " + bst.search(weaponName).data.item.weaponName +
                        " from the shop");
                bst.delete(weaponName, p);
            }
        }
    }

    public static void showRoomMenu(BSTree bst, Player p) {
        System.out.println("WELCOME TO THE SHOWROOM!!!!");
        bst.inOrderTrav();
        System.out.println("You have " + p.money + " money.");
        System.out.println("Please select a weapon to buy by name('end' to quit):");
    }

    public static void showRoom(BSTree bst, Player p, Scanner sc) {
        String choice;
        showRoomMenu(bst, p);
        choice = sc.next();
        while (choice.compareTo("end") != 0) {
            // if the current node is null, prompt the user
            if (bst.search(choice) == null) {
                System.out.println(" ** " + choice + " not found!! **");
            } else {
                // else assign the current node to a ShopItem
                ShopItem si = bst.search(choice).data;
                // if the item costs more than the player has
                if (si.item.cost > p.money) {
                    System.out.println("Insufficient funds to buy " + si.item.weaponName);
                } else {
                    // else buy the item, withdraw the cost from the player and decrease the stock
                    // if the item is already in the backpack, don't buy
                    // flag to track if item is in backpack
                    boolean flag = false;
                    for (int i = 0; i < p.numItems; i++) {
                        if (p.backpack.search(choice)) {
                            System.out.println("** You already have '" + choice + "' in your backpack **");
                            flag = true;
                        }
                    }
                    if (!flag) {
                        p.buy(si.item);
                        si.numberInStock--;
                    }
                }
            }
            showRoomMenu(bst, p);
            choice = sc.next();
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        Weapon w = new Weapon("Club", 2, 2, 2, 2);
//        BSTree bst = new BSTree();
//        bst.insert(w, 4);
//        w = new Weapon("Club", 3, 5, 4, 10);
//        bst.update(w, 3);
//        bst.inOrderTrav();
        Player p = createPlayer();
        menu(p);
    }

}
