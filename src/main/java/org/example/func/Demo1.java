package org.example.func;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Demo1 {

    public static void main(String[] args) {
        Optional<Exception> error = Math.random()>1.0 ? Optional.of(new RuntimeException()) : Optional.empty();
        Exception e = error.orElseGet(() -> {
            return new IllegalArgumentException();
        });
    }

    public static void consumerUsage(String[] args) {
        List<String> array = new ArrayList<>();
        array.add("aaa");
        array.add("bbb");
        array.add("ccc");

        StringBuilder stringBuilder = new StringBuilder();

        Consumer<String> cons = (String it) -> {
            stringBuilder.append(it).append(", ");
        };

        array.forEach(cons);

        System.out.println(stringBuilder);


//        array.forEach((item)-> {
//            System.out.println(item);
//            System.out.println(item);
//        });

        Optional<String> opt = Optional.of("foo");
        opt.ifPresent((String s)->{
            System.out.println(s);
        });

        Optional<String> empty = Optional.empty();
        empty.ifPresent((String s)->{
            System.out.print(s);
        });

        String res;
        if (opt.isPresent()) {
            res = opt.get();
        } else {
            res = "";
        }

        res = opt.orElse("");
    }
}
