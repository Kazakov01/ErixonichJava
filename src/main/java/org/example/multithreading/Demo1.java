package org.example.multithreading;

public class Demo1 {

    public static void main(String[] args) throws InterruptedException{
        MyThread myThread = new MyThread();
//        myThread.run();

        myThread.start();
        myThread.join();
    }

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("Hello from My thread");
        }
    }
}
