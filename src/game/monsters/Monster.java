package game.monsters;

public abstract class Monster implements MonsterInfo{

    // Fields
    private String name;
    private int hp;

    // Constructor
    public Monster(String name, int hp) {
        this.name = name;
        this.hp = hp;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return this.hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

}
