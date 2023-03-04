package org.example.collection;

public class MyHashTableDemo {
    public static void main(String[] args) {
        MyHashMap<Long, String> mht = new MyHashMap<>();


        mht.put(1L, "Karl");
        mht.put(2L, "Rita");
        mht.put(3L, "Anton");
        mht.put(4L, "Yana");
        mht.put(5L, "Vasya");
        mht.put(6L, "John");
//        mht.put(7L, "Ira");
//        mht.put(8L, "Arsen");
//        mht.put(9L, "Dasha");
//        mht.put(10L, "Kolya");
//        mht.put(11L, "Dima");

//        mht.put(12L, "X");
//        mht.put(13L, "Katerina");
//        mht.put(14L, "Mila");
//        mht.put(15L, "Tymir");
//        mht.put(16L, "Ada");
//        mht.put(17L, "Barry");
//        mht.put(18L, "Tim");
//        mht.put(19L, "Kim");

        System.out.println(mht);
    }
}
