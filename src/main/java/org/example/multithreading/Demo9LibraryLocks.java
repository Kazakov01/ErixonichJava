package org.example.multithreading;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo9LibraryLocks {
    static boolean isPing = false;

    public static void main(String[] args) {
        int[] mass = new int[2000];
        ReadWriteLock rwLock = new ReentrantReadWriteLock();
        Lock writeLock = rwLock.writeLock();
        Lock readLock = rwLock.readLock();
        Thread writer = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    int i = random.nextInt(2000);
                    writeLock.lock();
                    try {
                        mass[i] = random.nextInt();
                    } finally {
                        writeLock.unlock();
                    }
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        });
        writer.start();

        createReader(mass, readLock);
        createReader(mass, readLock);
        createReader(mass, readLock);

    }

    private static void createReader(int[] mass, Lock readLock) {
        Thread reader = new Thread(new Runnable() {

            @Override
            public void run() {
                while (true) {
                    ThreadLocalRandom random = ThreadLocalRandom.current();
                    int i = random.nextInt(2000);
                    readLock.lock();
                    int a;
                    try {
                        a = mass[i];
                    } finally {
                        readLock.unlock();
                    }
                    System.out.println(a);
                }
            }
        });
        reader.start();
    }

    public static void reentrantLockUsage(String[] args) {

        Object mutex = new Object();
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread (new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try {
                        if (!isPing) {
                            System.out.println("ping");
                            isPing = true;
                        }
                    } finally {
                        lock.unlock();
                    }

                }
            }
        });

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    lock.lock();
                    try{
                        if (isPing) {
                            System.out.println("pong");
                            isPing = false;
                        }
                    } finally {
                        lock.unlock();
                    }
                }
            }
        });

        t1.start();
        t2.start();
    }
}
