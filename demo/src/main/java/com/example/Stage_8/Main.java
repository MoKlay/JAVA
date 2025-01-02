package com.example.Stage_8;
/*
 * Вариант A
 * Определить, сколько раз повторяется в тексте каждое слово, которое встречается в нем.
 * 
 * Вариант B
 * Все слова текста рассортировать по возрастанию количества заданной буквы в слове. 
 * Слова с одинаковым количеством расположить в алфавитном порядке
 * 
 * Вариант C
 * Осуществить форматирование заданного текста с выравниванием по левому краю. 
 * Программа должна разбивать текст на строки с длиной, не превосходящей заданного количества символов. 
 * Если очередное слово не помещается в текущей строке, его необходимо переносить на следующую.
 */

import java.io.File;
import java.util.Scanner;

import com.example.Inputs.Resource;

public class Main {
  private static String resourcePath = "text.txt";

  public static void main(String[] args) {
    File file = Resource.getResourceFile(resourcePath);
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Введите задание:");
      int task = scan.nextInt();
      try {
        switch (task) {
          case 1 -> {
            Option_A oA = new Option_A(file);
            oA.printWordCounts();
          }
          case 2 -> {
            System.out.println("Введите букву:");
            char targetLetter = scan.next().charAt(0);// Буква, по количеству которой сортируем
            Option_B oB = new Option_B(file, targetLetter);
            oB.printSortedWords();
          }
          case 3 -> {
            System.out.println("Введите длину строки:");
            int lenStr = scan.nextInt();
            Option_C oC = new Option_C(file);
            System.out.println(oC.toString(lenStr));
          }
          default -> {
            System.out.println("Неизвестное задание.");
          }

        }
      } catch (Exception e) {
        e.printStackTrace();
      }

    }

  }

}
