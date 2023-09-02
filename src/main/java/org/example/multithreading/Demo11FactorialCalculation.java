package org.example.multithreading;

import java.math.BigInteger;
import java.util.concurrent.*;


public class Demo11FactorialCalculation {

    static  ExecutorService threadPool = Executors.newFixedThreadPool(8);

    public static void main(String[] args) throws Exception {
        Future<BigInteger> a = factorialAsync(5);
        Future<BigInteger> b = factorialAsync(1_000_000);
        Future<BigInteger> c = factorialAsync(100);
        b.get(300, TimeUnit.MILLISECONDS);
        threadPool.shutdown();

    }

    public static Future<BigInteger> factorialAsync(int n) throws Exception{
        Callable<BigInteger> task = new Callable<>() {
            @Override
            public BigInteger call() {
                BigInteger res = BigInteger.ONE;
                for (int i = 1; i <= n; i++) {
                    res = res.multiply(BigInteger.valueOf(i));
                }
                System.out.println("completed for " + n);
                return res;
            }
        };
        Future<BigInteger> result = threadPool.submit(task);

        return result;
    }
}
