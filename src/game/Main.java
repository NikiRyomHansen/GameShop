package game;

import game.menus.Zones;

public class Main {

    public static void main(String[] args) {

        Player player = GameShop.createPlayer();
        GameShop.menu(player);
        Zones.zones();

    }

}
