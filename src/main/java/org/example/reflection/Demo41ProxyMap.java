package org.example.reflection;

import java.beans.ConstructorProperties;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.Proxy;
import java.util.*;

public class Demo41ProxyMap {

    public static void main(String[] args) throws NoSuchMethodException {
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> nMap = (Map<Integer, String>) Proxy.newProxyInstance(Demo41ProxyMap.class.getClassLoader(), new Class<?>[]{Map.class},
                (proxy, method, args1) -> {
                    if (method.getName().equals("put") && args1[0].equals(42)) {
                        throw new IllegalArgumentException("not Allowed to put 42");
                    } else {
                        return method.invoke(map, args1);
                    }
                });

//        List<Parameter> params
//                = Arrays.asList(Map.class.getDeclaredMethod("put", Object.class).getParameters());

//        List<Method> methods
//                = Arrays.asList(HashMap.class.getDeclaredMethods());
//        System.out.println(methods);


//        Optional<Parameter> parameter
//                = params.stream().filter(Parameter::isNamePresent).findFirst();

        nMap.put(42, "Haha");
        System.out.println(nMap.get(42));
        nMap.put(32, "This will work");
        System.out.println(nMap.get(32));
    }
}
