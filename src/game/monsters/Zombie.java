package game.monsters;

public class Zombie extends Monster {

    // fields
    private int attackPoints;
    private int defencePoints;
    private double movementSpeed;

    // Constructor
    public Zombie(String name, int hp, int ap, int dp, double ms) {
        super(name, hp);
        this.attackPoints = ap;
        this.defencePoints = dp;
        this.movementSpeed = ms;
    }

    /* Accessors and mutators */
    public int getAttackPoints() {
        return attackPoints;
    }

    public void setAttackPoints(int ap) {
        this.attackPoints = ap;
    }

    public int getDefencePoints() {
        return defencePoints;
    }

    public void setDefencePoints(int dp) {
        this.defencePoints = dp;
    }

    public double getMovementSpeed() {
        return movementSpeed;
    }

    public void setMovementSpeed(double ms) {
        this.movementSpeed = ms;
    }

    public void defend(int ap) {
        setHp(this.getHp() - ap);
        System.out.println(this.getName() + " took " + ap + " damage!");
    }

    public void attack(Monster monster) {
        monster.setHp(monster.getHp() - this.attackPoints);
        System.out.println("Attacked " + monster.getName() + " for " + this.attackPoints + " damage!");
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
