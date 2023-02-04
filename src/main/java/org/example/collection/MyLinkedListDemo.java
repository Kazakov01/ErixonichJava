package org.example.collection;

public class MyLinkedListDemo {
    public static void main(String[] args) {
//       abc qwe foo bar zxc

        Node node5 = new Node("zxc", null);
        Node node4 = new Node("bar", node5);
        Node node3 = new Node("foo", node4);
        Node node2 = new Node("qwe", node3);
        Node head = new Node("abc", node2);

        node5.next = head;


    }

    public static void print(Node node) {
//вывод содержимого
        //*вывести содержимое если цикл имеется
    }

    public static class Node {
        String value;
        Node next;

        public Node(String value, Node next) {
            this.value = value;
            this.next = next;
        }
    }
}
