package com.example.Stage_7;

import java.io.FileNotFoundException;


/*
 * Вывести коллекцию количества вхождений символа в тексте соответственно из файла.
 */

public class Main {
  public static void main(String[] args) {
    String name = "text.txt";

    try {
      new SearchCharWithFile(name).showCharCount();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }
}
