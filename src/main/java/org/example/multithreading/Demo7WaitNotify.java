package org.example.multithreading;

import java.util.concurrent.LinkedBlockingQueue;

public class Demo7WaitNotify {

    static LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<>();
    static int pingCount = 0;
    static int pongCount = 0;
    public static void main(String[] args) throws InterruptedException{

        DataHolder dh = new DataHolder();
        Object mutex = new Object();


        Object m1 = new Object();

        Thread t1 = new Thread(new Runnable(){

            @Override
            public void run() {
                while (true) {
                    synchronized(mutex) {
                        if (!dh.isLastPing) {
                            pingCount++;
                            dh.isLastPing = true;
//                            System.out.println("ping");
                            mutex.notify();
                        } else {
                            try {
                                mutex.wait();
                            }
                            catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }
            }
        });

        Thread t2 = new Thread(new Runnable(){

            @Override
            public void run() {
                while (true) {
                    synchronized (mutex) {
                        if (dh.isLastPing) {
                            pongCount++;
                            dh.isLastPing = false;
//                            System.out.println("pong");
                            mutex.notify();
                        }
                        else {
                            try {
                                mutex.wait();
                            }
                            catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                    }
                }

            }
        });

        t1.start();
        t2.start();

        Thread.sleep(5000);
        System.out.println(pingCount-pongCount);
    }

    public static void saveResponse(String response) {
        lbq.add(response);
    }

    static class DataHolder {
        boolean isLastPing = false;
    }
}
