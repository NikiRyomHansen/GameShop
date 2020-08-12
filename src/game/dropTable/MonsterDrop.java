package game.dropTable;

public abstract class MonsterDrop {

    private double silver;

    public MonsterDrop(int difficulty, double silver) {
        switch (difficulty) {
            case 1:
                this.silver = silver;
                break;
            case 2:
                this.silver = silver*2;
                break;
            case 3:
                this.silver = (silver + silver)*2;
                break;
            default:
                this.silver = 0;
        }
    }

    public double getSilver() {
        return this.silver;
    }

    public void setSilver(double silver) {
        this.silver = silver;
    }


}
