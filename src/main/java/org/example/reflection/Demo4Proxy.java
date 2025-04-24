package org.example.reflection;

import java.lang.reflect.Proxy;

public class Demo4Proxy {
    public static void main(String[] a) {
        String s = "abcdef";
        CharSequence cs = (CharSequence) Proxy.newProxyInstance(Demo4Proxy.class.getClassLoader(), new Class<?>[]{CharSequence.class},
                (proxy, method, args) -> {
                    if (method.getName().equals("length")) {
                        return 5;
                    } else {
                        return method.invoke(s, args);
                    }
                });

        System.out.println(cs);
        System.out.println(cs.length());
        System.out.println(cs.charAt(2));
    }
}
