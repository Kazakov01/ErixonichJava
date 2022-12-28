package org.example.io;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


public class FileWriterReader {
    public static void main(String[] args) throws IOException {
        String filePath1 = "C:/JavaProjects/JavaEdu/src/main/resources/1file.txt";
        String filePath2 = "C:/JavaProjects/JavaEdu/src/main/resources/2file.txt";
        String filePath3 = "C:/JavaProjects/JavaEdu/src/main/resources/3file.txt";
        String filePathFinal = "C:/JavaProjects/JavaEdu/src/main/resources/result.txt";

        File f1 = new File(filePath1);
        File f2 = new File(filePath2);
        File f3 = new File(filePath3);
        File filefinal = new File(filePathFinal);

        filefinal.delete();

        Set<String> s1 = readFile(f1);
        writeFile(filefinal, s1);

        s1 = readFile(f2);
        writeFile(filefinal, s1);

        s1 = readFile(f3);
        writeFile(filefinal, s1);
    }

    private static Set<String> readFile(File file) throws IOException {
        Set<String> s1 = new TreeSet<>();

        try (FileReader fr = new FileReader(file); Scanner sc = new Scanner(fr);) {
            while (sc.hasNextLine()) {
                s1.add(sc.nextLine());
            }
        }
        return s1;
    }

    private static File writeFile(File file, Set<String> s1) throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            for (String s : s1) {
                fw.write(s + "\n");
            }
        }
        return file;
    }
}


