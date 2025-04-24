package org.example.reflection;

import java.lang.reflect.Method;
import java.time.LocalDate;

public class Demo3LogLevelMain {

    public static void main(String[] args) throws NoSuchMethodException {
        Class<TestEntity> clazz = TestEntity.class;
        LogAnnoProcessor lap = new LogAnnoProcessor();
        lap.process(new TestEntity(10, "Dima", LocalDate.now(), 200));

    }

    private static String findLogLevel(Method method){
        if (method.isAnnotationPresent(LogAnno.class)) {

        }
        return "";
    }

}
