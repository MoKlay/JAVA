package Stage_9;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    String resourcePath = "numbers.txt"; // путь к файлу
    try {
      double sum = processNumbersFromFile(resourcePath);
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
  static double processNumbersFromFile(String resourcePath)
      throws IOException, InvalidNumberFormatException, NumberFormatException, OutOfMemoryError, FileNotFoundException {
    URL resource = Main.class.getClassLoader().getResource(resourcePath);

    if (resource == null) {
      throw new FileNotFoundException("Файл " + resourcePath + " не найден.");
    }

    File file = new File(resource.getFile());

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
