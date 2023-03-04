package org.example.collection;

public class MyHashMap<K, V> {
    private Node<K, V>[] nodeArr = new Node[10];
    private final double targetLoadFactor = 0.75;
    private int size = 0;

    public V put(K key, V val) {


        Node<K, V> existingNode = getNode(key);
        if (existingNode!= null) {
            V oldValue = existingNode.val;
            existingNode.val = val;
            return oldValue;
        } else {
            int bucket = getBucketNumber(key);
            Node<K, V> node= new Node<>(key, val);
            node.next = nodeArr[bucket];
            nodeArr[bucket] = node;
            size++;
            return null;
        }
    }

    public V get(K key) {
        Node<K, V> node = getNode(key);
        return node == null ? null: node.val;

    }

    public V remove(K key) {
        Node<K, V> node = getNode(key);
        if (node != null) {
            int bucket = getBucketNumber(key);
            if (nodeArr[bucket] == node) {
                V oldValue = nodeArr[bucket].val;
                nodeArr[bucket] = node.next;
                return oldValue;
            }
            Node<K, V> currNode = nodeArr[bucket];
            while (currNode.next != node) {
                currNode = currNode.next;
            }
            currNode.next=node.next;
            size--;
        }
        return node==null?null:node.val;
    }

    public boolean containsKey(K key) {
        return getNode(key) != null;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (int i = 0; i < nodeArr.length; i++) {
            Node<K, V> cur = nodeArr[i];
            while (cur != null) {
                sb.append(cur.key).append("=").append(cur.val).append(", ");
                cur = cur.next;
            }
        }
        sb.delete(sb.length()-2, sb.length()).append("}");
        return sb.toString();
    }

    public int size() {
        return size;
    }

    private int getBucketNumber(K key) {
        return key.hashCode() % nodeArr.length;
    }

    private Node<K, V> getNode(K key) {
        int bucket = getBucketNumber(key);
        Node<K, V> curr = nodeArr[bucket];
        while (curr != null){
            if (key.equals(curr.key)){
                return curr;
            }
            curr = curr.next;
        }
        return null;
    }

    private void rehash1() {

        double currLoadFactor = (double) size/nodeArr.length;
        if (currLoadFactor >= targetLoadFactor) {

            Node<K ,V>[] oldNodeArr = nodeArr;
            Node<K, V>[] nodeArr = new Node[oldNodeArr.length*2];

            size= 0 ;

            for (int i = 0; i < oldNodeArr.length; i++) {

                Node<K, V> head = oldNodeArr[i];
                while (head != null) {
                    K key = head.key;
                    V val = head.val;

                    put(key, val);
                    head = head.next;
                }
            }
        }
    }





    private static class Node<K, V> {
        K key;
        V val;
        Node<K, V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }
}



//Написать рехэширование которое позволяет перенести вусе норды в больший массив при достижении таргет лоад фактора
//Либо переиспеользовать пут
//Либо зайти в каждый бакет пройтись по нодам и записать их в новый массив. Если в текущем массиве они в цепи то в новом массиве они будут уже не в цепи
//***** В ориг хэш мапе есть пут нод