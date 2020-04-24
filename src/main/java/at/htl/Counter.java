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
}
