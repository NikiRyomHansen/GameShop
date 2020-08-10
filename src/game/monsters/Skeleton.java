package game.monsters;

import game.dropTable.SkeletonDrop;

public class Skeleton extends Monster {

    private SkeletonDrop skeletonDrop;

    // Constructor
    public Skeleton(String name, int hp, int ap, int dp, double ms, double exp, int difficulty, double silver) {
        super(name, hp, ap, dp, ms, exp, difficulty, silver);
        this.skeletonDrop = new SkeletonDrop(difficulty, silver);
    }

    public SkeletonDrop getSkeletonDrop() {
        return skeletonDrop;
    }

    public String silverDrop() {
        return this.getName() + " dropped " + skeletonDrop.getSilver() + " silver!";
    }
}
