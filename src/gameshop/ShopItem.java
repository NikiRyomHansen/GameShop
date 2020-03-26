/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameshop;

/**
 * @author Adder
 */
public class ShopItem {
    Weapon item;
    int numberInStock;

    public ShopItem(Weapon w, int nInStock) {
        item = w;
        numberInStock = nInStock;
    }

    @Override
    public String toString() {
        return "Weapon details:" +
                "\nName: " + item.weaponName +
                "\nRange: " + item.range +
                "\nDamage: " + item.damage +
                "\nCost: " + item.cost +
                "\nWeight: " + item.weight;
    }
}
