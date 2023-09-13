package utils.random;

public class Random {
    private int min;
    private int max;

    public Random(int min, int max) {
        this.min = min;
        this.max = max;
    }

    public int random() {
        int rnd = (int) Math.floor(Math.random() * (max + min) - min);
        return rnd;
    }
}
