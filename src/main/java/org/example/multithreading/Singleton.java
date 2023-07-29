package org.example.multithreading;

public class Singleton {
    private static volatile Singleton instance;
    private static Object mutex = new Object();

    private int data = 10;


    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (mutex) { //synchronized (Singleton.class)
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }

    public int getData() {
        return data;
    }
}
