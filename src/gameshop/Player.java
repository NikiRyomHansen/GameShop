/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameshop;

class Player {
    public String name;
    public Backpack backpack;
    public int numItems;
    public double money;

    public Player(String n, double m) {
        name = n;
        money = m;
        numItems = 0;
        backpack = new Backpack();
    }

    public void buy(Weapon w) {
        // if the weight limit is exceeded upon buying a weapon, reject the purchase
        if (backpack.presentWeight + w.weight > backpack.maxWeight) {
            System.out.println("Weight limit reached, backpack too heavy");
        } else {
            System.out.println(w.weaponName + " bought...");
            backpack.append(w);
            numItems++;
            withdraw(w.cost);
        }
        System.out.println("Weapons in your backpack: " + numItems);
    }

    public void withdraw(double amt) {
        money = money - amt;
    }

    public void printCharacter() {
        System.out.println("Player details:");
        System.out.println("Name:" + name + "\nMoney:" + money + "\n");
        printBackpack();
    }

    public void printBackpack() {
        System.out.println("Total items in backback: " + numItems);
        backpack.printList();
    }
}
