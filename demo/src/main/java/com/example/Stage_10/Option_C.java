package com.example.Stage_10;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.example.Inputs.Resource;


/*
 * При выполнении следующих заданий для вывода результатов создавать новую директорию и файл средствами класса File.
 * Из текста Java-программы удалить все виды комментариев.
 */

public class Option_C {
  static String inputFilePath = "input.txt"; // путь к входному файлу
  static String outputDir = "output"; // имя выходной директории

  public static void main(String[] args) {

    try {
      String javaCode = readFile();
      String codeWithoutComments = removeComments(javaCode);
      System.err.println("Код без комментариев: " + codeWithoutComments);

      // Создание директории
      File dir = new File(outputDir);
      if (!dir.exists() && !dir.mkdirs()) {
        throw new IOException("Не удалось создать директорию: " + outputDir);
      }

      // Запись результата в файл
      String outputFilePath = outputDir + File.separator + "output.txt";
      writeFile(outputFilePath, codeWithoutComments);

      System.out.println("Код без комментариев записан в файл: " + outputFilePath);

    } catch (IOException e) {
      System.err.println("Ошибка: " + e.getMessage());
    }
  }

  // Удаление комментариев из Java-кода
  static String removeComments(String code) {
    code = code.replaceAll("//.*", "");
    Pattern pattern = Pattern.compile("/(\\\\*.*?\\\\*/)?", Pattern.DOTALL);
    Matcher matcher = pattern.matcher(code);

    return matcher.replaceAll("");
  }

  // Чтение текста из файла
  static String readFile() throws IOException {
    byte[] bytes = Resource.getResourceStream(inputFilePath).readAllBytes();
    return new String(bytes, StandardCharsets.UTF_8);
  }

  // Запись текста в файл
  static void writeFile(String filePath, String text) throws IOException {
    Files.writeString(Paths.get(filePath), text);
  }
}
