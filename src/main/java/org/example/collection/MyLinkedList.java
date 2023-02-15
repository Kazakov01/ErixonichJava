package org.example.collection;


public class MyLinkedList {
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

    private static class Node {
        Node next;
        String val;

        public Node(String val) {
            this.val = val;
        }
    }
}
