package org.example.multithreading;

import java.util.Random;

public class Demo2SumOfArray {

    public static void main(String[] args) throws InterruptedException{
        int[] arr = new int[1_000_000];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10_000);
        }

        CountSumTask cst = new CountSumTask(arr, 0, arr.length/2);
        CountSumTask cst2 = new CountSumTask(arr, arr.length/2, arr.length);
        Thread t1 = new Thread(cst);
        Thread t2 = new Thread(cst2);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(cst.sum + cst2.sum);
    }

    private static long countSumMultithreaded(int[] arr, int threadCount) {
        // посчитать сумму массива в указанном количестве потоков учитывая равномерную их загруженность
        return 0;
    }

    private static long countSum(int[] arr, int begin, int end) {
        long sum = 0;
        for (int i = begin; i < end; i++) {
            sum += arr[i];
        }
        return sum;
    }

    private static class CountSumTask implements Runnable {
        int[] arr;
        long sum;
        int begin;
        int end;

        public CountSumTask(int[] arr, int begin, int end) {
            this.arr = arr;
            this.begin = begin;
            this.end = end;
        }

        @Override
        public void run() {
            sum = countSum(arr, begin, end);
        }


    }
}
