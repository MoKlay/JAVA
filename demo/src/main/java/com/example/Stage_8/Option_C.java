package com.example.Stage_8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Option_C {

  private String textFile;

  public Option_C(File file) throws FileNotFoundException {
    try (Scanner scanner = new Scanner(file)) {
      StringBuilder text = new StringBuilder();
      while (scanner.hasNextLine()) {
        text.append(scanner.nextLine()).append(" ");
      }
      textFile = text.toString();
    } 
  }

  public String toString(int maxLineLength) {
    List<String> lines = new ArrayList<>();
    String[] words = textFile.split("\\s+");
    StringBuilder currentLine = new StringBuilder();

    for (String word : words) {
      if (currentLine.length() == 0) { // Первое слово в строке
        currentLine.append(word);
      } else if (currentLine.length() + word.length() + 1 <= maxLineLength) { // Слово помещается
        currentLine.append(" ").append(word);
      } else { // Слово не помещается, переносим на следующую строку
        lines.add(currentLine.toString());
        currentLine = new StringBuilder(word);
      }
    }

    if (currentLine.length() > 0) { // Добавляем последнюю строку
      lines.add(currentLine.toString());
    }
    currentLine = new StringBuilder();
    for (String line : lines) {
      currentLine.append(line).append("\n");
    }
    return currentLine.toString();

  }
  public String toString() {
    return textFile;
  }
  
}
