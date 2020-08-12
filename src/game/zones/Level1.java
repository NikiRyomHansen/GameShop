package game.zones;

import game.monsters.Skeleton;
import game.monsters.Zombie;

public class Level1 extends Zone {

    private int sizeOfArray = 10;

    public Zombie[] zombieArr = new Zombie[sizeOfArray];
    public Skeleton[] skeletonArr = new Skeleton[sizeOfArray];

    // Constructor
    public Level1() {
        super(500, 500);
        // when instantiating a Level1, also populate two arrays with x zombies and x skeletons.
        for (int i = 0; i < sizeOfArray; i++) {
            zombieArr[i] = new Zombie("Zombie",70,15,10,3,5, 1, 5);
            skeletonArr[i] = new Skeleton("Skeleton", 50, 20, 5, 10, 3, 1, 7);
        }
    }


    public int getSizeOfArray() {
        return sizeOfArray;
    }

}
