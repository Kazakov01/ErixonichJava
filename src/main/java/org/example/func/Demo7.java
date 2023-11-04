package org.example.func;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Demo7 {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("Moscow", "london", "India", "cali", "Georgia", "armenia", "Fuji", "tyumen", "calisto");
//        Comparator<String> cmp = (lhs, rhs) -> {
//            lhs = lhs.toLowerCase();
//            rhs = rhs.toLowerCase();
//
//            for (int i = 0; i < Math.min(lhs.length(), rhs.length()); i++) {
//                if (lhs.charAt(i) > rhs.charAt(i))
//                    return 1;
//                if (lhs.charAt(i) < rhs.charAt(i))
//                    return -1;
//            }
//            return lhs.length() - rhs.length();
//        };


        Comparator<String> cmp = (lhs, rhs) -> lhs.compareToIgnoreCase(rhs);
        list.sort(cmp);


        System.out.println(list);


    }
}
