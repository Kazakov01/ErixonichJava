package org.example;

public class MyClass {
    public static void bar() {
        try {
            Main.foo(-1);
        } catch (IllegalArgumentException e){
            System.out.println("Illegal argument: " + e.getMessage());
        }
        catch (RuntimeException e){
            System.err.println(e.getMessage());
        }

    }
}
