package game.zones;

import game.monsters.Skeleton;
import game.monsters.Zombie;

public class MonsterPit extends Zone {

    public Zombie[] zombieArr = new Zombie[10];
    public Skeleton[] skeletonArr = new Skeleton[zombieArr.length];

    public MonsterPit() {
        super(500, 500);
        // when instantiating a MonsterPit, also initialize two arrays with 10 zombies and 10 skeletons.
        for (int i = 0; i < zombieArr.length; i++) {
            Zombie zombie = new Zombie("Zombie", 100, 15, 10, 3);
            Skeleton skeleton = new Skeleton("Skeleton", 50, 20, 5, 10);
            zombieArr[i] = zombie;
            skeletonArr[i] = skeleton;
        }
    }
}
