package org.example.multithreading;

public class Demo6DeadLock {

    public static void main(String[] args) throws InterruptedException{
        Object m1 = new Object();
        Object m2 = new Object();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 0;
                for (int i = 0; i < 100000; i++) {
                    synchronized (m1) {
                            synchronized (m2) {
                            x++;
                        }
                    }
                }
            }
        });


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                int x = 0;
                for (int i = 0; i < 100000; i++) {
                    synchronized (m2) {
                        synchronized (m1) {
                            x++;
                        }
                    }
                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println("Completed");

    }

}
