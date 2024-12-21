package com.example.Stage_7;

import com.example.Inputs.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;



public class SearchCharWithFile {
    Map<Character, Integer> charCounts = new HashMap<>();

    public SearchCharWithFile(String nameFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(Resource.getResourceFile(nameFile)); 
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (char c : line.toLowerCase().toCharArray()) {
                if (Character.isLetter(c)) {
                    charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
                }
            }
        }
        scanner.close();
    }

    public SearchCharWithFile(File file) throws FileNotFoundException {
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            for (char c : line.toLowerCase().toCharArray()) {
                if (Character.isLetter(c)) {
                    charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
                }
            }
        }
        scanner.close();
    }


    public void showCharCount() {
        System.out.println("\nКоличество вхождений символов:");
        for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }




}
