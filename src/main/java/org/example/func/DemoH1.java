package org.example.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DemoH1 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1000, 250, 360, 5000, 780, 100, 244);
        List<Integer> sink = new ArrayList<>();

        int x = 777;

        list.forEach((item)-> {
            if (item > x) {
                sink.add(item);
            }
        });

        System.out.println(sink);
    }
}
