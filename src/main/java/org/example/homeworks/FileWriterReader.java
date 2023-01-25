package org.example.homeworks;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;


public class FileWriterReader {
    public static void main(String[] args) throws IOException {
        String filePath1 = "C:/JavaProjects/JavaEdu/src/main/resources/1file.txt";
        String filePath2 = "C:/JavaProjects/JavaEdu/src/main/resources/2file.txt";
        String filePath3 = "C:/JavaProjects/JavaEdu/src/main/resources/3file.txt";
        String filePathFinal = "C:/JavaProjects/JavaEdu/src/main/resources/result.txt";

        File file1 = new File(filePath1);
        File file2 = new File(filePath2);
        File file3 = new File(filePath3);
        File fileFinal = new File(filePathFinal);

        List<String> words = new ArrayList<>();

        readFile(file1,words);
        readFile(file2,words);
        readFile(file3,words);
        Collections.sort(words);
        writeFile(fileFinal, words);
    }

    private static void readFile(File file, List<String> words) throws IOException {
        try (FileReader fr = new FileReader(file); Scanner sc = new Scanner(fr);) {
            while (sc.hasNextLine()) {
                words.add(sc.nextLine());
            }
        }
    }

    private static void writeFile(File file, List<String> words) throws IOException {
        try (FileWriter fw = new FileWriter(file, true)) {
            for (String s : words) {
                fw.write(s + "\n");
            }
        }
    }
}


