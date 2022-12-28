package org.example.collection;

public class MyArrayListDemo {
    public static void main(String[] args) {
        MyArrayList mal = new MyArrayList();

        for (int i = 0; i < 5; i++) {
            mal.add(1);
        }
        System.out.println(mal.get(5));
        System.out.println(mal);
        System.out.println(new MyArrayList());
    }
}
