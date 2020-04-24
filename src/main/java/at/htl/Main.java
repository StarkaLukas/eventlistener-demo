package at.htl;


public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter.getInstance().initialize(500);

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 40; i++) {
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 1 increments counter");
                Counter.getInstance().increment(10);
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Thread 2 increments counter");
                Counter.getInstance().increment(10);
            }
        });

        Counter.getInstance().addListener(propertyChangeEvent -> {
            System.out.println("Got info that limit was reached");
        });
        
        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println("Main finished");
    }
}