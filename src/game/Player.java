/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import game.monsters.Monster;
import game.monsters.Zombie;

// TODO: Incorporate critical chance and critical damage
public class Player {
    private String name;
    public Backpack backpack;
    // numItems tracks the amount of items that is in the players backpack
    public int numItems;
    public double money;
    private int hp;
    private int attackPoints;
    private int defencePoints;
    private double movementSpeed;
    // TODO: Add experience functionality
    private double playerLevel;
    private double currentExp;

    public Player(String name, double money) {
        this.name = name;
        this.money = money;
        this.hp = 300;
        this.attackPoints = 25;
        this.defencePoints = 20;
        this.movementSpeed = 8;
        this.numItems = 0;
        this.backpack = new Backpack();
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

    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int attackPoints) {
        this.attackPoints = attackPoints;
    }

    public int getDefencePoints() {
        return defencePoints;
    }

    public void setDefencePoints(int defencePoints) {
        this.defencePoints = defencePoints;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double movementSpeed) {
        this.movementSpeed = movementSpeed;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    // Attack a monster
    public void attackMonster(Monster monster) {
        // When attacking a monster, call defendAgainstPlayer() from the Monster class and consider the player AP
        monster.defendAgainstPlayer(this.attackPoints);
        if (monster.getHp() <= 0) {
            System.out.println("The final blow just struck " + monster.getName() + " and it is now dead! Well done!");
            return;
        }
        System.out.println("You have damaged " + monster.getName() + " " +
                (monster.getDefencePoints() - this.attackPoints) + " HP! It now has " + monster.getHp() + " left.");
    }

    // Defend against a monster
    public void defendAgainstMonster(int ap) {
        int hpLost;
        // negate the damage taken with DP and the remainder is the hp lost from the attack
        if (this.defencePoints > ap) {
            System.out.println("Your defensive power is too great for this pathetic being hitting you");
            hpLost = 0;
        } else {
            // subtract the hp lost from the current hp.
            hpLost = this.defencePoints - ap;
            System.out.println("You have taken " + hpLost + " damage! You have " + this.hp + " hp left.");
        }
        this.hp += hpLost;
    }
}
