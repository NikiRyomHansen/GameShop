/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

class Weapon {
    public String weaponName;
    public int range;
    public int damage;
    public double weight;
    public double cost;

    public Weapon(String n, int rang, int dam, double w, double c) {
        weaponName = n;
        damage = dam;
        range = rang;
        weight = w;
        cost = c;
    }

    // Overriding toString()
    @Override
    public String toString() {
        return "Weapon details:" +
                "\nName: " + weaponName +
                "\nRange: " + range +
                "\nDamage: " + damage +
                "\nCost: " + cost +
                "\nWeight: " + weight;
    }
}
