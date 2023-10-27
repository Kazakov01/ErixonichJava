package org.example.func;

import jdk.incubator.vector.VectorOperators;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Demo6 {

    public static void main(String[] args) {
        Random rnd = new Random();
        long a = Stream.generate(() -> rnd.nextInt()).count();
        System.out.println(a);
//        System.out.println(Long.MAX_VALUE + 1);

    }

    public static void homeWork() {

        //написать выражение которое соответствует левой части выражения
        Supplier<String> sup = ?;

        //придерживаться определенной бизнес логики в написании
        Predicate<Demo5.Person> predicate = ?;

        Function<Long, Instant> f = ?;

        UnaryOperator<LocalDate> unary = ?;

    }

    public static void moreThanFour(String[] args) {
        List<String> names = Arrays.asList("Alina", "Dima", "Tonya", "Mr T");
        List<String> cities = Arrays.asList("NY", "LA", "Tokyo", "Moscow", "Ryazan");

        List<String> moreThanFour = Stream.concat(names.stream(), cities.stream())
                .filter(str -> str.length() > 4)
                .toList();


        List<String> moreThanFourAndNotR = Stream.concat(
                        names.stream().filter(str -> str.length() > 4),
                        cities.stream().filter(str -> !str.startsWith("R"))
                )
                .toList();


//        System.out.println(moreThanFour);
        System.out.println(moreThanFourAndNotR);
    }
}
