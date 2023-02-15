package org.example.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class MyArrayList<T> implements Iterable<T> {

    private Object[] data = new Object[1];
    private int size = 0;

    public void add(T x) {
       if (size == data.length) {
            resize();
        }
        data[size] = x;
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int idx) {
       checkIdx(idx);
        return (T) data[idx];
    }

    public void clear() {
        Object[] newData = new Object[1];
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

        Object[] newData = new Object[capacity];

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
        Object[] newData = new Object[data.length*2];

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
    public Iterator<T> iterator() {
        return new Itr();
    }

    private class Itr implements Iterator<T>{

        int idx;

        @Override
        public boolean hasNext() {
            return idx < size;
        }

        @Override
        public T next() {
            return (T)data[idx++];
        }

        @Override
        public void remove() {
            MyArrayList.this.remove(idx);
        }
    }
}
