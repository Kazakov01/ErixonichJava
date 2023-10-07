package org.example.func;

import java.util.*;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo4 {

    public static void main(String[] args) {
        List<String> strs = List.of("Aaaa", "asdasd", "bbbb", "cccc", "dddddddd", "EeEeEe");
        String first = strs.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElseThrow();

        String second = strs.stream()
                .sorted(Comparator.reverseOrder())
                .findAny()
                .orElseThrow();

        System.out.println(first);
        System.out.println(second);

    }

    public static void makeSquaresFromInts(String[] args) {

        IntStream stream = IntStream.rangeClosed(1, 1000);

//        Stream<Integer> stream = Stream.of(1,2,3,4,5);
        List<Integer> squares = stream
                .map(i -> i * i)
                .boxed()
                .toList();

        System.out.println(squares);

    }

    public static void excludeNameLogically(String[] args) {

        List<String> list = Arrays.asList("Tonya", "Bob", "Anya", "Dave", "Kate", "Max", "Aram");

        Set<String> womenNames = Set.of("Kate", "Tonya", "Anya");

        List<String> newList = list.stream()
                .filter(name -> !name.startsWith("A"))
                .filter(name -> !womenNames.contains(name))
                .toList();

        System.out.println(newList);
        //отфильтровать имена на а + убрать все женские имена
    }
}
