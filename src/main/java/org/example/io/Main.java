package org.example.io;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\JavaProjects\\JavaEdu\\src\\main\\resources\\text.txt");
        FileReader fr = new FileReader(file);
        int i = fr.read();
        try {
            while (i != -1) {
                System.out.print((char) i);
                i = fr.read();
            }
        } finally {
            fr.close();
        }

        try(FileReader fr1 = new FileReader(file); FileReader fr2 = new FileReader(file)){
            int j;
            while ((j = fr1.read()) != -1) {
                System.out.print((char) j);
            }
        }

//        file.createNewFile();
//        System.out.println("file.exists() = " + file.exists());
//        System.out.println("file.isDirectory() = " + file.isDirectory());


    }
}
