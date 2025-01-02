package com.example.Stage_9;

import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

import com.example.Inputs.Resource;

/*
 * В символьном файле находится информация об N числах с плавающей запятой 
 * с указанием локали каждого числа отдельно. Прочитать информацию из файла.
 * Проверить на корректность, то есть являются ли числа числами. Преобразовать
 * к числовым значениям и вычислить сумму и среднее значение прочитанных чисел.
 * Создать собственный класс исключения. Предусмотреть обработку исключений, возникающих при нехватке памяти, отсутствии
 * самого файла по заданному адресу, отсутствии или некорректности требуемой записи в файле, недопустимом значении числа
 * (выходящим за пределы максимально допустимых
 * значений) и т.д.
 */

public class Main {
  static String resourcePath = "numbers.txt"; // путь к файлу

  public static void main(String[] args) {
    try {
      double sum = processNumbersFromFile(Resource.getResourceFile(resourcePath));
      System.out.println("Сумма чисел: " + sum);
    } catch (FileNotFoundException e) {
      System.err.println("Файл не найден: " + e.getMessage());
    } catch (InvalidNumberFormatException e) {
      System.err.println("Ошибка в формате числа: " + e.getMessage());
    } catch (NumberFormatException e) {
      System.err.println("Ошибка преобразования числа: " + e.getMessage());
    } catch (OutOfMemoryError e) {
      System.err.println("Нехватка памяти: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Ошибка ввода-вывода: " + e.getMessage());
    } catch (Exception e) { // Обработка других исключений
      System.err.println("Произошла неизвестная ошибка: " + e.getMessage());
    }
  }

  // Функция обработки чисел из файла
  public static double processNumbersFromFile(File file)
      throws IOException, InvalidNumberFormatException, NumberFormatException, OutOfMemoryError, FileNotFoundException {

    double sum = 0;
    int count = 0;

    try (Scanner scanner = new Scanner(file)) {
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        String[] parts = line.split("\\s+"); // Разбиваем строку на части

        if (parts.length != 2) {
          throw new InvalidNumberFormatException("Некорректный формат строки: " + line);
        }

        String numberStr = parts[0];
        String localeStr = parts[1];

        Locale locale = Locale.forLanguageTag(localeStr); // Создаём Locale из строки
        NumberFormat format = NumberFormat.getInstance(locale);
        Number number;

        try {
          number = format.parse(numberStr);
          double num = number.doubleValue();
          if (Double.isInfinite(num) || Double.isNaN(num)) {
            throw new NumberFormatException("Недопустимое числовое значение: " + num);
          }
          sum += num;
          count++;
        } catch (ParseException e) {
          throw new InvalidNumberFormatException(
              "Невозможно преобразовать строку '" + numberStr + "' к числу с локалью '" + localeStr + "'", e);
        }
      }
    }

    if (count == 0) {
      throw new InvalidNumberFormatException("Файл не содержит чисел");
    }

    return sum;
  }

  // Собственный класс исключения
  static class InvalidNumberFormatException extends Exception {
    InvalidNumberFormatException(String message) {
      super(message);
    }

    InvalidNumberFormatException(String message, Throwable cause) {
      super(message, cause);
    }
  }

  // Исключение для отсутствия файла
  static class FileNotFoundException extends Exception {
    FileNotFoundException(String message) {
      super(message);
    }
  }
}
