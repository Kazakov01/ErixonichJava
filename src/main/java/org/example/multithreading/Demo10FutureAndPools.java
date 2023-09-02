package org.example.multithreading;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Demo10FutureAndPools {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(4);

        Runnable task = new Runnable() {
            @Override
            public void run() {
                long a = 0;
                for(int i = 0; i < 100000000; i++) {
                    a += i;
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println(a);
            }
        };
        Future<?> future = threadPool.submit(task);
        while (true) {
            System.out.println(future.isDone());
        }

//        threadPool.shutdown();
    }
}
