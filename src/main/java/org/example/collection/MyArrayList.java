package org.example.collection;

import java.util.Arrays;
import java.util.Iterator;

public class MyArrayList implements Iterable<Integer> {

    private int[] data = new int[1];
    private int size = 0;

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
       checkIdx(idx);
        return data[idx];
    }

    public void clear() {
        int[] newData = new int[1];
        size = 0;
        data = newData;
    }

    public void remove(int idx) {
        checkIdx(idx);
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }

        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void ensureCapacity(int capacity) {
        if (capacity <= data.length)
            return;

        int[] newData = new int[capacity];

        for (int i = 0 ; i < data.length; i++) {
            newData[i] = data[i];
        }

        data = newData;
    }

    private void checkIdx(int idx) {
        if (size <= idx && idx < 0) {
            throw new IndexOutOfBoundsException("Index " + idx + " Out of Bound of size " + size);
        }
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
        return new Itr();
    }

    private class Itr implements Iterator<Integer>{

        int idx;

        @Override
        public boolean hasNext() {
            return idx < size;
        }

        @Override
        public Integer next() {
            return data[idx++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(idx);
        }
    }
}
