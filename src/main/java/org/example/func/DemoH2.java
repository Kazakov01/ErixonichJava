package org.example.func;

import java.lang.constant.Constable;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class DemoH2 {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1999-09-23", "2007-01-23", "1985-02-01"
                , "1977-12-21", "2013-06-11", "1999-08-12", "2023-09-23");
//        LocalDate localDate = list.stream()
//                .map(LocalDate::parse)
//                .peek(ld -> System.out.println("1 " + ld.getMonth() + " " + ld.getYear()))
//                .min(Comparator.naturalOrder())
//                .orElseThrow();

        List <LocalDate> localDate = list.stream()
                .map(LocalDate::parse)
                .peek(ld -> System.out.println("1 " + ld.getMonth() + " " + ld.getYear()))
                .toList();


    }

    /* есть набор дат
    1) преобразховать данные даты к датам первое число данного месяца (например есть 23 сентября 2022 надо 1 сентября 2022 года и тд)
    + убрать все дубликаты и вывести в консоль
    2) нужно извлечь дни недели и вернуть наиболее популярный день недели среди представленных выше
    3) нужно вернуть список дат в отсортированном порядке по возрастанию
     */

}
