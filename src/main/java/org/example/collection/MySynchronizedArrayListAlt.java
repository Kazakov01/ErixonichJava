package org.example.collection;

import java.util.Iterator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MySynchronizedArrayListAlt<T> implements Iterable<T> {

    ReadWriteLock rwLock = new ReentrantReadWriteLock();
    private Object[] data = new Object[1];
    private int size = 0;

    public void add(T x) {
        Lock readLock = rwLock.readLock();
        Lock writeLock = rwLock.writeLock();
        readLock.lock();
        try {
            if (size == data.length) {
                resize();
            }
        } finally {
            readLock.unlock();
        }
        writeLock.lock();
        try {
            data[size] = x;
            size++;
        } finally {
            writeLock.unlock();
        }
    }

    public int size() {
        Lock readLock = rwLock.readLock();
        try {
            return size;
        } finally {
            readLock.unlock();
        }
    }

    public T get(int idx) {
       checkIdx(idx);
       Lock readLock = rwLock.readLock();
       try {
           return (T) data[idx];
       } finally {
           readLock.unlock();
       }
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

        Lock writeLock = rwLock.writeLock();
        writeLock.lock();
        try {
            data = newData;
        } finally {
            writeLock.unlock();
        }
    }

    private void checkIdx(int idx) {
        Lock readLock = rwLock.readLock();
        readLock.lock();
        try {
            if (size <= idx && idx < 0) {
                throw new IndexOutOfBoundsException("Index " + idx + " Out of Bound of size " + size);
            }
        } finally {
            readLock.unlock();
        }
    }

    private void resize() {
        Lock readLock = rwLock.readLock();
        readLock.lock();
        Object[] newData = new Object[data.length*2];

        readLock.lock();
        try {
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
        } finally {
            readLock.unlock();
        }

        Lock writeLock = rwLock.writeLock();
        writeLock.lock();
        try {
            data = newData;
        } finally {
            writeLock.unlock();
        }
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
            MySynchronizedArrayListAlt.this.remove(idx);
        }
    }
}
