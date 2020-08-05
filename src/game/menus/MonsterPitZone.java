package game.menus;

import game.zones.MonsterPit;
import game.input.Input;

import java.util.Scanner;

public class MonsterPitZone {

    private Scanner sc = new Scanner(System.in);

    public void monsterPit() {
        System.out.println("** You have entered the Monster Pit **");
        System.out.println("Your first battle is against a single zombie");
        System.out.println("What would you like to do?");
        System.out.println("1. Attack");
        System.out.println("2. Flee");

        int choice;
        choice = Input.getInteger(sc);

        switch (choice) {
            case 1:

        }

        MonsterPit monsterPit = new MonsterPit();
    }

}
