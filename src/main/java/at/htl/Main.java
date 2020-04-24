package at.htl;

public class Main {
    public static void main(String[] args) {
        Counter.getInstance().initialize(500);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 50; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Counter.getInstance().increment(10);
            }
        });
        
        thread1.start();
        System.out.println("Main finished");
    }
}
