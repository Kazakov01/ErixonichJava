package org.example.multithreading;

public class Demo8Singleton {

    public static void main(String[] args) {
        Singleton snglt = Singleton.getInstance();
        System.out.println(snglt.getData());
    }
}
