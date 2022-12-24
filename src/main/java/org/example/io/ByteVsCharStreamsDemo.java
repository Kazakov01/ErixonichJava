package org.example.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class ByteVsCharStreamsDemo {
    public static void main(String[] args) throws IOException {

        int[] a = new int[]{0xd0, 0xbc, 0xd0, 0xb8, 0xd1, 0x80};
        byte[] b = new byte[a.length];

        for (int i = 0; i < a.length; i++){
            b[i]=(byte) a[i];
        }
        String s = new String(b, StandardCharsets.UTF_8);
//        System.out.println(s);
        byte[] bytes = s.getBytes(Charset.forName("windows-1251"));
        for (byte z : bytes){
            System.out.println(Integer.toHexString(z));
        }
    }

    private static void usingCharStreams() throws IOException {
        File file = new File("C:\\JavaProjects\\JavaEdu\\src\\main\\resources\\Foo.txt");
        FileReader fr = new FileReader(file, Charset.forName("windows-1251"));
        int i;
        int cnt = 0;
        while ((i = fr.read()) != -1) {
//            cnt++;
            System.out.print((char) i);
        }
//        System.out.println(cnt);
    }

    private static void usingByteStreams() throws IOException {
        File file = new File("C:\\JavaProjects\\JavaEdu\\src\\main\\resources\\Foo.txt");
        FileInputStream fis = new FileInputStream(file);
        int i;
        int cnt = 0;
        while ((i = fis.read()) != -1) {
            cnt++;
            System.out.print(Integer.toHexString(i) + " ");
        }
        System.out.println(cnt);
    }


}