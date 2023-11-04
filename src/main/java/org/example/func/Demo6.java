package org.example.func;

import java.time.Instant;
import java.time.LocalDate;
import java.time.Year;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class Demo6 {

    public static void main(String[] args) {

        //Генерируем новые города
        List<String> names = Arrays.asList("Artem", "Ivan", "Masha", "Zoya", "Tema", "Peter");
        List<String> citiesSuff = Arrays.asList("burg", "grad", "ville", "ostan");

        Random rnd = new Random();
        Supplier<String> leetCity = () -> {
            return names.get(rnd.nextInt(names.size())) + citiesSuff.get(rnd.nextInt(citiesSuff.size()));
        };


//        System.out.println(leetCity.get());

        //Определяем социофобов
        org.example.func.Demo5.Person ivan = new org.example.func.Demo5.Person("Ivan", "Ivanov");
        org.example.func.Demo5.Person elvis = new org.example.func.Demo5.Person("Elvis", "Rockandrolla");
        org.example.func.Demo5.Person dima = new org.example.func.Demo5.Person("Dima", "Petrov");
        org.example.func.Demo5.Person anon =  new org.example.func.Demo5.Person("Anon", "Bezyimya");
        ivan.friends.add(elvis);
        dima.friends.add(ivan);
        Predicate<org.example.func.Demo5.Person> predicate = t -> t.friends.isEmpty();

        System.out.println(anon.name + " is sociophobic person ?\n"  + predicate.test(anon));

//        Function<Long, Instant> f = ?;

        List<String> list = Arrays.asList("1999-09-23", "1999-09-23", "1999-09-24", "1999-09-24", "2007-01-23", "1985-02-01"
                , "1977-12-21", "2013-06-11", "1999-08-12", "2023-09-23", "2023-01-01", "2023-08-23");

        List<LocalDate> localDate = list.stream()
                .map(LocalDate::parse)
                .distinct()
                .toList();

        UnaryOperator<LocalDate> firstDayPrevMonth = ldt -> ldt.withDayOfMonth(1).minusMonths(1);
        Function<LocalDate, LocalDate> func = ldt -> ldt.withDayOfMonth(1).minusMonths(1);

        for (LocalDate ld : localDate) {
            System.out.println(func.apply(ld));
        }

    }

    public static void rnd(String[] args) {
        Random rnd = new Random();
        long a = Stream.generate(() -> rnd.nextInt()).count();
        System.out.println(a);
//        System.out.println(Long.MAX_VALUE + 1);

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