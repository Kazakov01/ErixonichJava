package org.example.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.ThreadLocalRandom;

public class IterableDemo {

    public static void main(String[] args) {
        IterableRandom itr = new IterableRandom(7);
        Iterator<Integer> it = itr.iterator();
//        while (it.hasNext()) {
//            System.out.println(it.next());
//        }

        for (Integer x : itr){
            System.out.println(x);
        }
    }

    /**
     * Выдает заданное количество случайных числе при итерации на объекте
     */
    public static class IterableRandom implements Iterable<Integer> {
        private int n;

        public IterableRandom(int n) {
            this.n = n;
        }


        private class It implements Iterator<Integer> {
            @Override
            public boolean hasNext() {
                if (n > 0)
                    return true;
                else return false;
            }

            @Override
            public Integer next() {
                System.out.println("*");
                if (n != 0)
                    n--;
                else throw new NoSuchElementException("No such element exc");
                return ThreadLocalRandom.current().nextInt();
            }
        }

        @Override
        public Iterator<Integer> iterator() {
            It it = new It();
            return it;

        }

    }
}
