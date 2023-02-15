package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayListDemo {
    public static void main(String[] args) {
       Integer[] arr = new Integer[10];
       Object[] objects = arr;
//       objects[0] = "foo";
       Object[] objs = new Object[10];
       objs[0] = "foo";
    }

    public static void iteratorRemove() {
        MyArrayList<Integer> mal = new MyArrayList<>();
        mal.add(1);
        mal.add(2);
        mal.add(3);
        mal.add(4);

        Iterator<Integer> itr = mal.iterator();
        itr.next();
        itr.remove();

        for(int i : mal){
            System.out.println(i);
        }
    }
}
