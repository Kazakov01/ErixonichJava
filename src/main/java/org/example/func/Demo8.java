package org.example.func;

import java.util.function.ToIntFunction;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Demo8 {
    public static void main(String[] args) {
        int sum = Stream.of(1, 2, 3, 4)
                .reduce(0, (t, u) -> t + u);
    }

    //Есть стрим с значениями 1-1000 нужно посчитать сумму арифметической прогрессии

    //нужно посчитать сумму геометрической прогрессии с начальным значением 1 и знаменателем геометрической прогрессии d \
    // (чтобы работало для любого d) для первых тысячи членов. Выразить в виде стрима
}
