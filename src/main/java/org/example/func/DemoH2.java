package org.example.func;

import javax.swing.text.html.Option;
import java.lang.constant.Constable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class DemoH2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1999-09-23", "1999-09-23", "1999-09-24", "1999-09-24", "2007-01-23", "1985-02-01"
                , "1977-12-21", "2013-06-11", "1999-08-12", "2023-09-23", "2023-01-01", "2023-08-23");

        List<LocalDate> localDate = list.stream()
                .map(LocalDate::parse)
                .map((ld -> LocalDate.of(ld.getYear(), ld.getMonth(), 1)))
                .distinct()
                .toList();

        List<LocalDate> localDateSorted = list.stream()
                .map(LocalDate::parse)
                .sorted(Comparator.naturalOrder())
                .distinct()
                .toList();

        String mostPopularDay = list.stream()
                .map(LocalDate::parse)
                .map(ld -> ld.getDayOfWeek().name())
                .collect(Collectors.groupingBy(dw -> dw, Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(en -> en.getKey())
                .orElseThrow();

        System.out.println(localDate);
        System.out.println(localDateSorted);
        System.out.println(mostPopularDay);

    }

    /* есть набор дат
    1) преобразховать данные даты к датам первое число данного месяца (например есть 23 сентября 2022 надо 1 сентября 2022 года и тд)
    + убрать все дубликаты и вывести в консоль
    2) нужно извлечь дни недели и вернуть наиболее популярный день недели среди представленных выше
    3) нужно вернуть список дат в отсортированном порядке по возрастанию
     */

}
