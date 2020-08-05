package game.monsters;

public interface MonsterInfo {

    public String getStats();
    public void attack(Monster monster);
    public void defend(int ap);

}
