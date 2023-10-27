package org.example.func;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class Demo5 {

    public static void main(String[] args) {
        Person ivan = new Person("Ivan", "Ivanov");
        Person elvis = new Person("Elvis", "Rockandrolla");
        Person dima = new Person("Dima", "Petrov");
        Person anon =  new Person("Anon", "Bezyimya");

        ivan.friends.add(elvis);
        ivan.friends.add(dima);

        dima.friends.add(anon);

        elvis.friends.add(anon);

        List<String> connections = ivan.friends.stream()
                .flatMap(person -> person.friends.stream())
                .map(friend -> friend.name + " " + friend.surname)
                .distinct()
                .toList();


        System.out.println(connections);
    }

    public static void scheduleExcs(String[] args) {
        Map<DayOfWeek, List<String>> schedule = Map.of(DayOfWeek.MONDAY, List.of("Bob", "Dave"),
                DayOfWeek.TUESDAY, List.of("Ivan", "Boris"),
                DayOfWeek.FRIDAY, List.of("Lisa", "Alina", "Zulfiya"),
                DayOfWeek.SATURDAY, List.of("Arsen"),
                DayOfWeek.SUNDAY, List.of());

        List<DayOfWeek> weekends = Arrays.stream(DayOfWeek.values())
                .filter(day -> !schedule.containsKey(day) || schedule.get(day).isEmpty())
                .toList();

//        List<String> workers = new ArrayList<>();
//        for (Map.Entry<DayOfWeek, List<String>> entry : schedule.entrySet()) {
//            List<String> wrks = entry.getValue();
//            for (String wrk : wrks) {
//                workers.add(wrk);
//            }
//        }

        schedule.values().stream()
                .flatMap(list -> list.stream())
                .toList();


        System.out.println(weekends);
//        System.out.println(workers);

    }

    public static class Person {
        String name;
        String surname;
        List<Person> friends = new ArrayList<>();

        public Person(String name, String surname) {
            this.name = name;
            this.surname = surname;
        }

        public List<Person> getFriends() {
            return friends;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }
    }
}
