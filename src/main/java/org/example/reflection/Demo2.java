package org.example.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDate;
import java.time.Month;

public class Demo2 {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // когда один объект
        Class<TestEntity> clazz = TestEntity.class;
        Constructor<TestEntity> ctor = clazz.getDeclaredConstructor(int.class, String.class, LocalDate.class);
        ctor.setAccessible(true);
        TestEntity te = ctor.newInstance(1, "Vasya", LocalDate.of(1999, Month.DECEMBER, 20));
//        System.out.println(te.getName());


        // Конструкция ниже аналог данного кода te.getBirthday();
        Method mthd = clazz.getDeclaredMethod("getBirthday");
        LocalDate ld = (LocalDate) mthd.invoke(te);
//        System.out.println(ld);


        TestEntity te1 = createEntity(1, "Serezha", LocalDate.of(1998, Month.APRIL, 02), true);
        TestEntity te2 = createEntity(1, "Petya", LocalDate.of(1997, Month.MAY, 12), true);
        TestEntity te3 = createEntity(3, "Vanya", LocalDate.of(1996, Month.JUNE, 3), false);
        TestEntity te4 = createEntity(4, "Misha", LocalDate.of(1995, Month.JULY, 9), false);
        TestEntity te5 = createEntity(5, "Sasha", LocalDate.of(1994, Month.AUGUST, 29), true);



        System.out.println(te4.getId() + " " + te3.getId());

    }

    public static TestEntity createEntity (int id, String name, LocalDate birthday, boolean isAnnoContructor) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<TestEntity> clazz = TestEntity.class;
        Constructor<TestEntity> ctor = clazz.getDeclaredConstructor(int.class, String.class, LocalDate.class);
        ctor.setAccessible(true);


        Annotation[][] parameterAnnotations = ctor.getParameterAnnotations();

        for (Annotation[] annotations : parameterAnnotations) {
            for (Annotation annotation : annotations) {
                if (annotation instanceof PlusOneAnno) {
                    id++;
                    return ctor.newInstance(id, name, birthday);
                }
            }
        }
        return ctor.newInstance(id, name, birthday);
    }
}
