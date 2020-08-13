package game.monsters;

import game.Player;
import game.dropTable.MonsterDrop;
import game.dropTable.SkeletonDrop;
import game.dropTable.ZombieDrop;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class Monster implements MonsterInfo{

    // Fields
    private String name;
    private int hp;
    private int attackPoints;
    private int defencePoints;
    private double movementSpeed;
    private double exp;
    private MonsterDrop monsterDrop;


    // Constructor
    public Monster(String name, int hp, int ap, int dp, double ms, double exp, int difficulty, double silver) {
        this.name = name;
        this.hp = hp;
        this.attackPoints = ap;
        this.defencePoints = dp;
        this.movementSpeed = ms;
        this.exp = exp;
        if (name.equalsIgnoreCase("zombie")) {
            this.monsterDrop = new ZombieDrop(difficulty, silver);
        } else if (name.equalsIgnoreCase("skeleton")) {
            this.monsterDrop = new SkeletonDrop(difficulty, silver);

        }
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

    public double getExp() {
        return exp;
    }

    public void setExp(double exp) {
        this.exp = exp;
    }

    public MonsterDrop getMonsterDrop() {
        return monsterDrop;
    }

    public void setMonsterDrop(MonsterDrop monsterDrop) {
        this.monsterDrop = monsterDrop;
    }

    public String getSilverDrop() {
        return this.getName() + " dropped " + monsterDrop.getSilver() + " silver!";
    }

    @Override
    public void attackPlayer(Player player) {
        // When attacking a Player, call defendAgainstMonster() from the Player class and consider the monster AP
        if (this.hp > 0) {
            player.defendAgainstMonster(this.attackPoints, this);
        }
        // if the Player dies from the hit:
        if (player.getHp() <= 0) {
            System.out.println("The final blow just struck you, " + this.getName() + " killed you!");
            return;
        }
    }

    // Defend against a player attack
    @Override
    public void defendAgainstPlayer(int ap) {
        int hpLost;
        // negate the damage taken with DP and the remainder is the hp lost from the attack
        if (this.defencePoints > ap) {
            System.out.println(this.name + " is too strong! You're not even scratching it!");
            hpLost = 0;
        } else {
            // subtract the hp lost from the current hp.
            hpLost = this.defencePoints - ap;
        }
        this.hp += hpLost;

    }

    @Override
    public String getStats() {
        return "Monster " + this.getName() +
                " has " + this.getHp() +
                " HP, " + this.attackPoints +
                " AP, " + this.defencePoints +
                " DP and " + this.movementSpeed +
                " Movement Speed";
    }
}
