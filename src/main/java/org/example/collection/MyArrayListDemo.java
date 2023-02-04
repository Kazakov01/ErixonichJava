package org.example.collection;

import java.util.ArrayList;
import java.util.Iterator;

public class MyArrayListDemo {
    public static void main(String[] args) {
        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(2);
        array.add(3);
        array.add(3);
        array.add(4);
        array.add(5);
        array.add(6);
        array.add(7);

//        Iterator<Integer> itr = array.iterator();

        for (Iterator<Integer> it = array.iterator(); it.hasNext(); ){
            int x  = it.next();
            if (x % 2 != 0)
                it.remove();

        }

        System.out.println(array);
    }

    public static void iteratorRemove() {
        MyArrayList mal = new MyArrayList();
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
