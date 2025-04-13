package org.example.reflection;

import java.beans.ConstructorProperties;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Parameter;
import java.time.LocalDate;
import java.time.Month;

public class Demo2PlusOneAnnoImpl {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // когда один объект
        Class<TestEntity> clazz = TestEntity.class;

        TestEntity te1 = createEntity(1, "Serezha", LocalDate.of(1998, Month.APRIL, 02), 10, true);
        TestEntity te2 = createEntity(1, "Petya", LocalDate.of(1997, Month.MAY, 12), 9, true);
        TestEntity te3 = createEntity(3, "Vanya", LocalDate.of(1996, Month.JUNE, 3), 11,false);
        TestEntity te4 = createEntity(4, "Misha", LocalDate.of(1995, Month.JULY, 9), 12,false);
        TestEntity te5 = createEntity(5, "Sasha", LocalDate.of(1994, Month.AUGUST, 29), 20,true);

        System.out.println(te4.getId() + " " + te3.getId());

    }

    public static TestEntity createEntity(int id, String name, LocalDate birthday, long balance, boolean isAnnoContructor) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<TestEntity> clazz = TestEntity.class;
        Constructor<TestEntity> ctor = clazz.getDeclaredConstructor(int.class, String.class, LocalDate.class, long.class);
        ctor.setAccessible(true);

//      альтернативный способ получить параметризированную аннотацию
//      Annotation[][] parameterAnnotations = ctor.getParameterAnnotations();

        Parameter[] params = ctor.getParameters();
        ConstructorProperties constrProps = ctor.getAnnotation(ConstructorProperties.class);
        String[] paramNames = constrProps.value();
        for (int i = 0; i < params.length; i++) {
            if (isNumeric(params[i].getType()) && params[i].isAnnotationPresent(PlusOneAnno.class)) {
                if (paramNames[i].equals("id")){
                    id++;
                }
                if (paramNames[i].equals("balance")){
                    balance++;
                }
            }
        }
        return ctor.newInstance(id, name, birthday, balance);
    }

    private static boolean isNumeric(Class<?> type){
        return type == int.class
                || type == long.class
                || type == double.class
                || type == float.class;
    }
}
