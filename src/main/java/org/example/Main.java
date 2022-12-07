package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        MyClass.bar();
        System.out.println("Hello");
    }

    /**
     *
     * @param a just a number.
     * @throws RuntimeException if odd number is passed.
     */
    public static void foo(int a) {
        if (a%2==0)
            System.out.println(a*a);
        else if (a > 0)
            throw  new RuntimeException("should use even number");
        else
            throw new IllegalArgumentException("should use positive number ");

        Date date = new Date();

    }
    }