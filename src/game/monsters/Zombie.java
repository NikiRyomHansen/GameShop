package game.monsters;

import game.dropTable.ZombieDrop;

public class Zombie extends Monster {

    // fields
    private ZombieDrop zombieDrop;

    // Constructor
    public Zombie(String name, int hp, int ap, int dp, double ms, double exp, int difficulty, double silver) {
        super(name, hp, ap, dp, ms, exp, difficulty, silver);
        this.zombieDrop = new ZombieDrop(difficulty, silver);
    }

    public ZombieDrop getZombieDrop() {
        return zombieDrop;
    }

}
