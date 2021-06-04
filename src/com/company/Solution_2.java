package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class SecondVariant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dear user, please input path name of file ");
        String pathName = scanner.nextLine();
        System.out.println("Dear user, please input file name ");
        String fileName = scanner.nextLine();
        String fileExtension = ".txt";
        String fileDirectory = pathName + fileName + fileExtension;
        try {
            int uniqueFilesCount = Arrays.stream(splitTextBySpace(fileDirectory)).distinct().toArray().length;
            System.out.println("Count of unique files = " + uniqueFilesCount);
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public static List<String> readFromFile(String directory) throws IOException {
        return Files.readAllLines(Paths.get(directory), StandardCharsets.UTF_8);
    }

    public static String[] splitTextBySpace(String directory) throws IOException {
        return readFromFile(directory).get(readFromFile(directory).size() - 1).split(" ");
    }
}
