package org.example.func;

import java.math.BigInteger;
import java.util.*;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Demo2 {

    public static void main(String[] args) {
//        List<String> list = new ArrayList<>(Arrays.asList("aaa", "bbb", "ccc"));
//        list.removeIf(t -> t.charAt(0) == 'b');
//        System.out.println(list);

//        List<String> list = new ArrayList<>(Arrays.asList("aaa", "bbb", "cccc", "ddd", "eee", "fff"));
//        list.replaceAll(t -> t + t);
//        System.out.println(list);

//        Map<String, Long> map = new HashMap<>();
//        BiFunction<String, Long, Long> biFunc = (key, oldV) -> {
//            if (oldV == null)
//                return 0L;
//            return oldV + 1;
//        };
//        map.compute("foo", biFunc);
//        System.out.println(map);
//        map.compute("foo", biFunc);
//        System.out.println(map);

        List<String> list = new ArrayList<>(Arrays.asList("aaa", "bbb", "cccc", "ddd", "eee", "fff"));
//        list.forEach(s -> printFormatted(s));
        list.forEach(Demo2::printFormatted);
        list.forEach(System.out::println);
        Optional<BigInteger> opt = Optional.empty();
        opt.orElseGet(BigInteger::new);

    }

    private static void printFormatted(String str) {
        System.out.println("\t\t" +  str);
    }
}
