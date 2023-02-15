package org.example.collection;


import java.util.Iterator;

public class MyLinkedList implements Iterable<String> {
    private Node head;
    private Node tail;
    private int size;

    public void addLast(String val) {
        size++;
        Node node = new Node(val);
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = tail.next;
    }

    // добавление в начале списка в качестве дз
    public void addFirst(String val) {

        size++;
        Node node = new Node(val);
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        node.next = head;
        head = node;

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        Node cur = head;
        StringBuilder sb = new StringBuilder();

        while (cur != null){
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.append("null");

        return sb.toString();
    }

    @Override
    public Iterator<String> iterator() {
        return new Itr();
    }

    private static class Node {
        Node next;
        String val;

        public Node(String val) {
            this.val = val;
        }
    }

    private class Itr implements Iterator<String> {

        Node curr = head;
        Node prev = null;

        @Override
        public boolean hasNext() {
            return curr.next != null;
        }

        @Override
        public String next() {
            if (curr == null){
                curr = head;
            } else {
                prev = curr;
                curr = curr.next;
            }
            return curr.val;
        }

        @Override
        public void remove() {
            prev.next = curr.next;
            curr = prev.next;
        }
    }
    //обобщить линкд лист
}
