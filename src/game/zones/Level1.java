package game.zones;

import game.monsters.Skeleton;
import game.monsters.Zombie;

public class Level1 extends Zone {

    public Zombie[] zombieArr = new Zombie[5];
    public Skeleton[] skeletonArr = new Skeleton[zombieArr.length];

    // Instantiate a MonsterPit zone width 500, length 500.
    public Level1() {
        super(500, 500);
        // when instantiating a Level1, also populate two arrays with x zombies and x skeletons.
        for (int i = 0; i < zombieArr.length; i++) {
            zombieArr[i] = new Zombie("Zombie",70,15,10,3,5, 1, 5);
            skeletonArr[i] = new Skeleton("Skeleton", 50, 20, 5, 10, 3, 1, 7);
        }
    }
}
