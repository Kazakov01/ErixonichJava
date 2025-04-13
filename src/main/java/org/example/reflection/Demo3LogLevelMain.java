package org.example.reflection;

import java.lang.reflect.Method;

public class Demo3LogLevelMain {

    public static void main(String[] args) {
        Class<TestEntity> clazz = TestEntity.class;
        Method[] methods = clazz.getDeclaredMethods();

        System.out.println("Hello world");
//        for (Method m : methods){
//            if (m.isAnnotationPresent())
//        }

    }

    private static String findLogLevel(Method method){
        if (method.isAnnotationPresent(LogAnno.class)) {

        }
        return "";
    }


}
