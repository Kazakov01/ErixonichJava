package org.example.collection;

import java.util.Iterator;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList mal = new MyArrayList();
        mal.add(1);
        mal.add(2);
        mal.add(3);
        mal.add(4);

        for(int i : mal){
            System.out.println(i);
        }
        for (Iterator<Integer> it = mal.iterator(); it.hasNext(); ){
            int x  = it.next();
            System.out.println(x);
        }
    }
}
