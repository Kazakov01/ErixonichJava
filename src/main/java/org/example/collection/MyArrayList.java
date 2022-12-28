package org.example.collection;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList implements Iterable<Integer> {

    int[] data = new int[1];
    int size = 0;

    public void add(int x) {
       if (size == data.length) {
            resize();
        }
        data[size] = x;
        size++;
    }

    public int size() {
        return size;
    }

    public int get(int idx) {
        if (size <= idx) {
            throw new IndexOutOfBoundsException("Index " + idx + " Out of Bound of size " + size);
        }
        return data[idx];
    }

    private void resize() {
        int[] newData = new int[data.length*2];

        for (int i = 0 ; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    @Override
    public String toString() {
        if (size == 0){
            return "[]";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("[");

        for (int i = 0; i < size-1; i++){
            sb.append(data[i]).append(", ");
        }
        sb.append(data[size-1]).append("]");

        return sb.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }
}
