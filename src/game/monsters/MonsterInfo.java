package game.monsters;

import game.Player;

public interface MonsterInfo {

    public String getStats();
    public void attackPlayer(Player player);
    public void defendAgainstPlayer(int ap);

}
