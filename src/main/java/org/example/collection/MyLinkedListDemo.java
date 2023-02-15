package org.example.collection;

import java.util.Iterator;

public class MyLinkedListDemo {
    public static void main(String[] args) {
//       abc qwe foo bar zxc

//        Node node5 = new Node("zxc", null);
//        Node node4 = new Node("bar", node5);
//        Node node3 = new Node("foo", node4);
//        Node node2 = new Node("qwe", node3);
//        Node head = new Node("abc", node2);

//        node5.next = head;

        MyLinkedList mll = new MyLinkedList();
        mll.addLast("abc");
        mll.addLast("xyz");
        mll.addFirst("SSS");
        mll.addLast("def");
        mll.addFirst("AAA");
        mll.addFirst("BBB");


        for(Iterator<String> it = mll.iterator(); it.hasNext();){
            String s = it.next();
            if (s.startsWith("a"))
                it.remove();
            System.out.println(s);
        }

        System.out.println(mll);

    }

    public static void print(Node head) {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.value + " -> ");
            cur = cur.next;
        }
    }


    public static void printWithCycle(Node head) {}
    //функция успешно должна вывести список в консоль со списком

    public static class Node {
        String value;
        Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
