package org.example;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
//        MyClass.bar();
        System.out.println(divide(4,0));
    }

    /**
     * @param a just a number.
     * @throws RuntimeException if odd number is passed.
     */
    public static void foo(int a) {
        if (a % 2 == 0)
            System.out.println(a * a);
        else if (a > 0)
            throw new RuntimeException("should use even number");
        else
            throw new IllegalArgumentException("should use positive number ");

        Date date = new Date();

    }

    public static int divide(int a, int b)  {
        try {
            return a/b;
        }
        catch (ArithmeticException e){
//            throw new MyException("division error occurred");
//            throw new MyException(e);
            throw new RuntimeException("division error occurred", e);
        }
    }
}