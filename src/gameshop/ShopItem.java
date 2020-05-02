package gameshop;

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
