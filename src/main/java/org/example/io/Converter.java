package org.example.io;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Converter {

    public static void main(String[] args) throws IOException {

        Scanner sc = new Scanner(System.in);


//        int[] a = new int[]{0xd0, 0xbc, 0xd0, 0xb8, 0xd1, 0x80};
        byte[] b =new byte[0];

//        for (int i = 0; i < a.length; i++){
//            b[i]=(byte) a[i];
//        }
        String s = new String(b, StandardCharsets.UTF_8);
//        System.out.println(s);
        byte[] bytes = s.getBytes(Charset.forName("windows-1251"));
        for (byte z : bytes){
            System.out.println(Integer.toHexString(z));
        }
    }
}
