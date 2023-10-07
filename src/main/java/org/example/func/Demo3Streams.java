package org.example.func;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Demo3Streams {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1999-09-23", "2007-01-23", "1985-02-01"
        , "1977-12-21", "2013-06-11", "1999-08-12", "2023-09-23");
        LocalDate localDate = list.stream()
                .map(LocalDate::parse)
                .peek(ld -> System.out.println("peek1 " + ld))
                .filter(ld1 -> ld1.getDayOfWeek() == DayOfWeek.SATURDAY ||
                        ld1.getDayOfWeek() == DayOfWeek.SUNDAY)
//                .peek(ld -> System.out.println("peek2 " + ld))
//                .min((LocalDate d1, LocalDate d2) -> {
//                    if (d1.isBefore(d2))
//                        return -1;
//                    if (d1.isEqual(d2))
//                        return 0;
//                    return 1;
//                })
//                .min((d1, d2) -> d1.compareTo(d2))
                .min(Comparator.naturalOrder())
                .orElseThrow();

        System.out.println(localDate);
    }

    public static void sumInts() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4);
        int a = list.stream()
                .mapToInt(Integer::intValue).sum();
        System.out.println(a);
    }


}
