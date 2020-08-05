package game.monsters;

public class Skeleton extends Monster {

    // Fields
    private int attackPoints;
    private int defencePoints;
    private double movementSpeed;

    // Constructor
    public Skeleton(String name, int hp, int ap, int dp, double ms) {
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

    // TODO: Take DP into consideration and negate that amount before the hp
    @Override
    public void defend(int ap) {
        setHp(this.getHp() - ap);
        System.out.println(this.getName() + " took " + ap + " damage!");
    }

    @Override
    public void attack(Monster monster) {

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
