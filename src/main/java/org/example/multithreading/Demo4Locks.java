package org.example.multithreading;

public class Demo4Locks {

    public static void main(String[] args) throws InterruptedException{
        DataHolder dh = new DataHolder();
        Object mutex = new Object();
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10000; i++) {
                synchronized (mutex) {
                    dh.num++;
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    synchronized (mutex) {
                        dh.num++;
                    }                }
            }
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(dh.num);
    }

    public static void foo(DataHolder dh) {
        synchronized (Demo4Locks.class) {
            dh.num++;
        }
    }

    public static synchronized void bar(DataHolder dh) {
        dh.num++;
    }

    public static class DataHolder {
        int num;
    }
}
