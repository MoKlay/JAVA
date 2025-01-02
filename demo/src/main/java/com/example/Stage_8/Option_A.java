package com.example.Stage_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Option_A {
  private Map<String, Integer> wordCounts;

  public Option_A(File file) throws FileNotFoundException {
    try (Scanner scanner = new Scanner(file)) {
      wordCounts = new HashMap<>();
      Pattern pattern = Pattern.compile("\\b\\w+\\b");
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().toLowerCase();
        System.out.println(line);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
          String word = matcher.group();
          wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }
      }
    } 
  }
  public Map<String, Integer> getWordCounts() {
    return wordCounts;
  }
  public void printWordCounts() {
    System.out.println("\nКоличество вхождений слов:");
    for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }
}
