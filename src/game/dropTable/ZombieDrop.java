package game.dropTable;

/* All drops the zombies can drop when killed */
public class ZombieDrop {

    private double silver;

    public ZombieDrop(int difficulty) {
        switch (difficulty) {
            case 1:
                this.silver = 5;
                break;
            case 2:
                this.silver = 10;
                break;
            case 3:
                this.silver = 15;
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
