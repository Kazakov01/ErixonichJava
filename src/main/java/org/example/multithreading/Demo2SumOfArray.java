package org.example.multithreading;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Demo2SumOfArray {

    public static void main(String[] args) throws InterruptedException{
        int[] arr = new int[100_000];
        Random rnd = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = rnd.nextInt(10);
        }



//        CountSumTask cst = new CountSumTask(arr, 0, arr.length/2);
//        CountSumTask cst2 = new CountSumTask(arr, arr.length/2, arr.length);
//        Thread t1 = new Thread(cst);
//        Thread t2 = new Thread(cst2);
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        System.out.println(countSumMultithreaded(arr, Runtime.getRuntime().availableProcessors()));

        System.out.println("Arrays.stream(arr).sum() = " + Arrays.stream(arr).sum());
    }

    private static long countSumMultithreaded (int[] arr, int threadCount) throws InterruptedException{
//        int begin = 0;
//        int end = arr.length / threadCount-1;


        long sum = 0;
        int numbersPerTask = arr.length / threadCount;
        List<CountSumTask> tasks = new ArrayList<>();
        List<Thread> threads = new ArrayList<>();
        for (int i = 0; i < threadCount; i++){
            int end;
            if (i == threadCount - 1) {
                end = arr.length;
            } else {
                end = numbersPerTask * (i + 1);
            }
            CountSumTask cst = new CountSumTask(arr, numbersPerTask * i, end );
            Thread t = new Thread(cst);
            t.start();
            threads.add(t);
            tasks.add(cst);

        }

        for (Thread t : threads) {
            t.join();
        }

        for (CountSumTask task : tasks) {
            sum += task.sum;
        }
        return sum;
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
