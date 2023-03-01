package org.example.collection;

public class MyHashTableDemo {
    public static void main(String[] args) {
        MyHashMap<Long, String> mht = new MyHashMap<>();
        mht.put(12L, "Vasya");
        mht.put(3L, "Dasha");
        mht.put(2L, "Kolya");
        mht.put(1L, "Dima");

        mht.put(1L, "tolya");
        //mht.put(2L, "Sergey");
        System.out.println(mht);
    }
}
