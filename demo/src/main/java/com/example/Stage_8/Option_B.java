package com.example.Stage_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Option_B {
  private List<WordData> wordDataList;

  public List<WordData> getWordDataList() {
    return wordDataList;
  }

  public Option_B(File file, char targetLetter) throws FileNotFoundException {
    try (Scanner scanner = new Scanner(file)) {
      wordDataList = new ArrayList<>();
      Pattern pattern = Pattern.compile("\\b\\w+\\b"); // Регулярное выражение для слов
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine().toLowerCase();
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
          String word = matcher.group();
          int count = 0;
          for (char c : word.toCharArray()) {
            if (c == targetLetter) {
              count++;
            }
          }
          wordDataList.add(new WordData(word, count));
        }
      }
      Collections.sort(wordDataList, Comparator.comparingInt(WordData::getLetterCount)
          .thenComparing(WordData::getWord));
    }
  }

  public static class WordData {
    private final String word;
    private final int letterCount;

    WordData(String word, int letterCount) {
      this.word = word;
      this.letterCount = letterCount;
    }

    String getWord() {
      return word;
    }

    int getLetterCount() {
      return letterCount;
    }
  }

  public void printSortedWords() {
    System.out.println("\nОтсортированные слова:");
    for (WordData wordData : wordDataList) {
      System.out.println(wordData.getWord() + ": " + wordData.getLetterCount());
    }
  }
}
