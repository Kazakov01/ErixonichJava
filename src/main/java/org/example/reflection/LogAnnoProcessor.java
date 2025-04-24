package org.example.reflection;

import java.lang.reflect.Method;

public class LogAnnoProcessor {

    public Object process(Object obj){
        Method[] mthds = obj.getClass().getDeclaredMethods();
        for (Method mtd : mthds) {
            if (mtd.isAnnotationPresent(LogAnno.class)) {

//                System.out.println(mtd.getName() + " level of logging is " + mtd.getAnnotation(LogAnno.class).lvl());
            }
        }
        return obj;
    }


}
