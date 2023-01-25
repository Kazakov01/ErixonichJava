package org.example.collection;

import java.util.ArrayList;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList mal = new MyArrayList();
        mal.add(1);
        mal.add(2);
        mal.add(3);
        mal.ensureCapacity(2);
        System.out.println(mal.get(2));

        new ArrayList<>();

    }
}
