package com.example.Stage_10;

import java.io.File;
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
  public static void main(String[] args) {
    try {
      List<String> processedLines = processStringsFromFile(Resource.getResourceFile(args[0]), args[1]);
      if (!args[3].isEmpty()) {
        Path path = Paths.get(args[3]);
        Files.write(path, processedLines, StandardCharsets.UTF_8);
      }
    } catch (IOException e) {
      System.err.println("Ошибка ввода-вывода: " + e.getMessage());
    } catch (Exception e) {
      System.err.println("Произошла ошибка: " + e.getMessage());
    }
  }

  // Функция обработки строк из файла
  static List<String> processStringsFromFile(File file, String subStringToRemove) throws IOException {
    List<String> processedLines = new ArrayList<>();
    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        processedLines.add(
          scanner.nextLine().replace(subStringToRemove, ""));
      }
    }
    return processedLines;
  }
}
