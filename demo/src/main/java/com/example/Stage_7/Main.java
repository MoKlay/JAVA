package com.example.Stage_7;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.example.Inputs.Resource;

/*
 * Вывести коллекцию количества вхождений символа в тексте соответственно из файла.
 */

public class Main {
  public static void main(String[] args) {
    Map<Character, Integer> charCounts = new HashMap<>();
    String name = "text.txt";
    try (Scanner scanner = new Scanner(Resource.getResourceFile(name))) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        for (char c : line.toLowerCase().toCharArray()) {
          if (Character.isLetter(c)) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
          }
        }
      }
      // Вывод результатов
      System.out.println("\nКоличество вхождений символов:");
      for (Map.Entry<Character, Integer> entry : charCounts.entrySet()) {
        System.out.println(entry.getKey() + ": " + entry.getValue());
      }
      scanner.close();
    } catch (java.io.FileNotFoundException e) {
      System.err.println("Файл не найден: " + e.getMessage());
    }

  }
}
