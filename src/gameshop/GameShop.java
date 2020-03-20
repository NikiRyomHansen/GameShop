/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameshop;

import java.util.Scanner;

/**
 * @author Adder
 */
public class GameShop {

    // TODO: Clean up the double messages when entering the while loop - fix with a do while perhaps?
    public static int getInteger(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextInt()) {
            sc.nextLine(); //clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextInt();
    }

    public static double getDouble(Scanner sc, String message) {
        System.out.print(message);
        while (!sc.hasNextDouble()) {
            sc.nextLine(); //clear the invalid input ...
            System.out.print(message);
        }
        return sc.nextDouble();
    }


    public static void addWeapons(BSTree bst, Scanner sc) {
        System.out.println("***********WELCOME TO THE WEAPON ADDING MENU*********");
        String weaponName;
        int weaponRange;
        int weaponDamage;
        double weaponWeight;
        double weaponCost;
        int quantity;
        System.out.print("Please enter the NAME of the Weapon ('end' to quit):");
        weaponName = sc.next(); // TODO: EXTRA: Make it so weapons can be more than 1 word / token - (nextLine() + next())
        while (weaponName.compareTo("end") != 0) {
            weaponRange = getInteger(sc, "Please enter the Range of the Weapon (0-10):");
            weaponDamage = getInteger(sc, "Please enter the Damage of the Weapon:");
            weaponWeight = getDouble(sc, "Please enter the Weight of the Weapon (in pounds):");
            weaponCost = getDouble(sc, "Please enter the Cost of the Weapon:");
            Weapon w = new Weapon(weaponName, weaponRange, weaponDamage, weaponWeight, weaponCost);
            quantity = getInteger(sc, "Please enter the quantity in stock:");
            bst.insert(w, quantity);
            System.out.print("Please enter the NAME of another Weapon ('end' to quit):");
            weaponName = sc.next();
        }
    }

    public static void showRoomMenu(BSTree bst, Player p) {
        System.out.println("WELCOME TO THE SHOWROOM!!!!");
        bst.inOrderTrav();
        System.out.println("You have " + p.money + " money.");
        System.out.println("Please select a weapon to buy('end' to quit):");
    }

    public static void showRoom(BSTree bst, Player p, Scanner sc) {
        String choice;
        showRoomMenu(bst, p);
        choice = sc.next();
        while (choice.compareTo("end") != 0 && !p.inventoryFull()) {
            // if the current node is null, prompt the user
            if (bst.getCurrentNode(choice) == null) {
                System.out.println(" ** " + choice + " not found!! **");
            } else {
                // else assign the current node to a ShopItem
                ShopItem si = bst.getCurrentNode(choice).data;
                // if the item costs more than the player has
                if (si.item.cost > p.money) {
                    System.out.println("Insufficient funds to buy " + si.item.weaponName);
                } else {
                    // else buy the item, withdraw the cost from the player and decrease the stock
                    // if the item is already in the backpack, don't buy
                    // flag to track if item is in backpack
                    boolean flag = false;
                    for (int i = 0; i < p.numItems; i++) {
                        if (p.backpack[i].weaponName.equalsIgnoreCase(choice)) {
                            System.out.println("** You already have " + choice + " in your backpack **");
                            flag = true;
                        }
                    }
                    if (!flag) {
                        p.buy(si.item);
                        p.withdraw(si.item.cost);
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
        Scanner sc = new Scanner(System.in);
        String pname;
        System.out.println("Please enter Player name:");
        pname = sc.next();
        Player pl = new Player(pname, 45);
        BSTree bst = new BSTree();
        addWeapons(bst, sc);
        showRoom(bst, pl, sc);
        pl.printCharacter();

    }

}
