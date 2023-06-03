package org.example.multithreading;

import java.util.concurrent.atomic.AtomicInteger;

public class Demo5Atomics {

    public static void main(String[] args) throws InterruptedException {
        DataHolder dh = new DataHolder();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    dh.num.incrementAndGet();
                }
            }
        }
        );


        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    dh.num.incrementAndGet();
                }
            }
        }
        );

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(dh.num);
    }

    public static class DataHolder {
        AtomicInteger num = new AtomicInteger();
    }
}
