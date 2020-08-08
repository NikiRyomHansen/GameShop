package game.zones;

import game.monsters.Skeleton;
import game.monsters.Zombie;

public class MonsterPit extends Zone {

    public Zombie[] zombieArr = new Zombie[10];
    public Skeleton[] skeletonArr = new Skeleton[zombieArr.length];

    // Instantiate a MonsterPit zone width 500, length 500.
    public MonsterPit() {
        super(500, 500);
        Zombie zombie = new Zombie("Zombie",100,15,10,3,5,1);
        Skeleton skeleton = new Skeleton("Skeleton", 50, 20, 5, 10, 3);
        // when instantiating a MonsterPit, also populate two arrays with 10 zombies and 10 skeletons.
        for (int i = 0; i < zombieArr.length; i++) {
            zombieArr[i] = zombie;
            skeletonArr[i] = skeleton;
        }
    }
}
