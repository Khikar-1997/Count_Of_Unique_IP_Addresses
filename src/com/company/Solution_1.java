package com.company;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Dear user, please input path name of file ");
        String pathName = scanner.nextLine();
        System.out.println("Dear user, please input file name ");
        String fileName = scanner.nextLine();
        String fileExtension = ".txt";
        String fileDirectory = pathName + fileName + fileExtension;

        try {
            int strings = uniqueIPAddressesCount( fileDirectory);
            System.out.println(strings);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readFromFile(String directory) throws IOException {
        return Files.readAllLines(Paths.get(directory), StandardCharsets.UTF_8);
    }

    public static String[] splitTextBySpace(String directory) throws IOException {
        return readFromFile(directory).get(readFromFile(directory).size() - 1).split(" ");
    }

    public static String[] splitTextByPoint(String directory) throws IOException{
        String[] text = splitTextBySpace(directory);
        for (int i = 0; i < text.length; i++) {
            String splitText = text[i].split("\\.")[0] + text[i].split("\\.")[1] +text[i].split("\\.")[2] + text[i].split("\\.")[3];
            text[i] = splitText;
        }
        return text;
    }

    public static int[] parsingStringToInteger(String directory) throws IOException {
        String[] textArray = splitTextByPoint(directory);
        int[] numbersArray = new int[textArray.length];
        for (int i = 0; i < textArray.length; i++) {
            numbersArray[i] = Integer.parseInt(textArray[i]);
        }
        return numbersArray;
    }

    public static int uniqueIPAddressesCount(String directory) throws IOException {
        int[] numbers = parsingStringToInteger(directory);
        Arrays.sort(numbers);
        int j = 0;
        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i] != numbers[i + 1]) {
                numbers[j] = numbers[i];
                j++;
            }
        }
        numbers[j] = numbers[numbers.length - 1];
        return j;
    }
}

