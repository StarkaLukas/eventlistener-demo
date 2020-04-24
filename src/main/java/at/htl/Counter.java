package at.htl;

public class Counter {
    private static Counter instance;
    private long counter;
    private long maxValue;

    private Counter() {

    }

    public static Counter getInstance() {
        if (instance == null) {
            instance = new Counter();
        }

        return instance;
    }

    public void initialize(long maxValue) {
        this.maxValue = maxValue;
        this.counter = 0;
    }

    public long getCounter() {
        return counter;
    }

    public void increment(long count) {
        counter += count;

        if (counter >= maxValue) {
            System.out.println("Reached max. value!");
        }
    }
}
