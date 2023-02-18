package org.example.collection;


import java.util.Iterator;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addLast(T val) {
        size++;
        Node<T> node = new Node<T>(val);
        if (head == null){
            head = node;
            tail = node;
            return;
        }
        tail.next = node;
        tail = tail.next;
    }

    // добавление в начале списка в качестве дз
    public void addFirst(T val) {

        size++;
        Node<T> node = new Node<T>(val);
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
        Node<T> cur = head;
        StringBuilder sb = new StringBuilder();

        while (cur != null){
            sb.append(cur.val).append(" -> ");
            cur = cur.next;
        }
        sb.append("null");

        return sb.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new Itr();
    }

    private static class Node<T> {
        Node<T> next;
        T val;

        public Node(T val) {
            this.val = val;
        }
    }

    private class Itr implements Iterator<T> {

        Node<T> curr = null;
        Node<T> prev = null;

        @Override
        public boolean hasNext() {
            return (curr == null && head != null) || (curr != null && curr.next != null);
        }

        @Override
        public T next() {
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
