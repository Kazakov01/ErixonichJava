package org.example;

import java.util.Scanner;

public class HomeWork1 {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rnd = random();
        int num = sc.nextInt();

        if (num < 101) {
            System.out.println(compare(rnd, num));
        } else {
            throw new RuntimeException("What an idiot");
        }
    }

    public static int random() {
        return (int) (Math.random() * 101);
    }

    public static String compare(int rnd, int num) {
        if (num > rnd)
            return "Your number is higher";
        if (num < rnd)
            return "Your number is less";
        if (num == rnd)
            return "THATS A MATCH!";
        return "";
    }
}

