package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);

        Iterator<Integer> it = list.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }

    }
}
