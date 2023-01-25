package org.example.homeworks;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class HomeWork1 {

    public static void main(String[] args) {
        int rnd = random();
        System.out.println(compare(rnd));
    }

    public static int random(){
        return ThreadLocalRandom.current().nextInt(1, 100);
    }

    public static String compare(int rnd) {
        Scanner sc = new Scanner(System.in);
        int num = 0;

        while (true) {
            num = sc.nextInt();

            if (num > 101 || num < 1)
                throw new RuntimeException("What an idiot");
            else if (num > rnd)
                System.out.println("Your number is higher");
            else if (num < rnd)
                System.out.println("Your number is less");
            else
                return "THATS A MATCH!";
        }
    }
}
