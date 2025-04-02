package org.example.reflection;

import java.lang.reflect.Field;

public class Demo1 {
    private int a = 1;
    private static int b = 2;

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        System.out.println(Demo1.class.getName());
        Class<?> type1 = Demo1.class;
//        Class<?> type2 = Class.forName("org.example.reflection.Demo1");
        Field[] fields = type1.getDeclaredFields();
        for (Field f : fields){
            System.out.println(f);
        }

        Field fieldB = type1.getDeclaredField("b");
        fieldB.set(null, 3);

        System.out.println("b = " + b);

    }

}
