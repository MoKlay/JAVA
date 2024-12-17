package com.example.Stage_10;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.example.Inputs.Resource;

/*
 * В следующих заданиях требуется ввести последовательность строк из текстового потока и выполнить указанные действия. При этом могут рассматриваться два варианта:
 * • каждая строка состоит из одного слова;
 * • каждая строка состоит из нескольких слов.
 * Имена входного и выходного файлов, а также абсолютный путь к ним могут
 * быть введены как параметры командной строки или храниться в файле.
 * 
 * В каждой строке найти и удалить заданную подстроку
 */

public class Option_A {
  static String inputFileName = null;
  static String outputFileName = null;
  static String subStringToRemove = null;

  public static void main(String[] args) {
    // Обработка параметров командной строки
    if (args.length == 3) {
      inputFileName = args[0];
      outputFileName = args[1];
      subStringToRemove = args[2];
    } else {
      System.out.println("Использование: class <входной_файл> <выходной_файл> <подстрока>");
      return;
    }

    try {
      List<String> processedLines = processStringsFromFile();
      writeStringsToFile(processedLines);
    } catch (IOException e) {
      System.err.println("Ошибка ввода-вывода: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("Произошла ошибка: " + e.getMessage());
    }
  }

  // Функция обработки строк из файла
  static List<String> processStringsFromFile() throws IOException {
    List<String> processedLines = new ArrayList<>();
    try (Scanner scanner = new Scanner(Resource.getResourceFile(inputFileName))) {
      while (scanner.hasNextLine()) {
        processedLines.add(removeSubstring(scanner.nextLine()));
      }
    }
    return processedLines;
  }

  // Функция удаления подстроки из строки
  static String removeSubstring(String line) {
    return line.replace(subStringToRemove, "");
  }

  // Функция записи строк в файл
  static void writeStringsToFile(List<String> lines) throws IOException {
    Path path = Paths.get(outputFileName);
    Files.write(path, lines, StandardCharsets.UTF_8);
  }
}
