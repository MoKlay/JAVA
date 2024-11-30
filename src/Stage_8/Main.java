package Stage_8;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
  public static void main(String[] args) {
    String resourcePath = "text.txt"; // путь к файлу внутри проекта

    URL resource = Main.class.getClassLoader().getResource(resourcePath);

    if (resource == null) {
      System.err.println("Файл " + resourcePath + " не найден в ресурсах проекта.");
      return;
    }

    File file = new File(resource.getFile());
    try (Scanner scan = new Scanner(System.in)) {
      System.out.println("Введите задание:");
      int task = scan.nextInt();
      switch (task) {
        case 1 -> Task1(file);
        case 2 -> {
          System.out.println("Введите букву:");
          char targetLetter = scan.next().charAt(0);// Буква, по количеству которой сортируем
          Task2(file, targetLetter);
        }
        case 3 -> {
          System.out.println("Введите длину строки:");
          int lenStr = scan.nextInt();
          Task3(file, lenStr);

        }
        default -> {
          System.out.println("Неизвестное задание.");
        }

      }
    }

  }

  static void Task3(File file, int lenStr) {
    try (Scanner scanner = new Scanner(file)) {
      StringBuilder text = new StringBuilder();
      while (scanner.hasNextLine()) {
        text.append(scanner.nextLine()).append(" "); // Добавляем пробел между строками файла
      }
      List<String> formattedLines = formatText(text.toString(), lenStr);

      for (String line : formattedLines) {
        System.out.println(line);
      }
    } catch (IOException e) {
      System.err.println("Ошибка при обработке файла: " + e.getMessage());
    }
  }

  static void Task2(File file, char targetLetter) {
    try (Scanner scanner = new Scanner(file)) {
      List<WordData> wordDataList = extractWords(scanner, targetLetter);
      Collections.sort(wordDataList, Comparator.comparingInt(WordData::getLetterCount)
          .thenComparing(WordData::getWord)); // Сортировка по количеству буквы, затем по алфавиту
      printSortedWords(wordDataList);
    } catch (IOException e) {
      System.err.println("Ошибка при обработке файла: " + e.getMessage());
    }
  }

  static void Task1(File file) {
    try (Scanner scanner = new Scanner(file)) {
      Map<String, Integer> wordCounts = countWordOccurrences(scanner);
      printWordCounts(wordCounts);
    } catch (IOException e) {
      System.err.println("Ошибка при обработке файла: " + e.getMessage());
    }
  }

  // Функция подсчета вхождений слов
  static Map<String, Integer> countWordOccurrences(Scanner scanner) {
    Map<String, Integer> wordCounts = new HashMap<>();
    Pattern pattern = Pattern.compile("\\b\\w+\\b"); // Регулярное выражение для слов
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().toLowerCase();
      Matcher matcher = pattern.matcher(line);
      while (matcher.find()) {
        String word = matcher.group();
        wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
      }
    }
    return wordCounts;
  }

  // Функция вывода результатов
  static void printWordCounts(Map<String, Integer> wordCounts) {
    System.out.println("\nКоличество вхождений слов:");
    for (Map.Entry<String, Integer> entry : wordCounts.entrySet()) {
      System.out.println(entry.getKey() + ": " + entry.getValue());
    }
  }

  // Извлечение слов из текста и подсчет вхождений целевой буквы
  static List<WordData> extractWords(Scanner scanner, char targetLetter) {
    List<WordData> wordDataList = new ArrayList<>();
    Pattern pattern = Pattern.compile("\\b\\w+\\b"); // Регулярное выражение для слов
    while (scanner.hasNextLine()) {
      String line = scanner.nextLine().toLowerCase();
      Matcher matcher = pattern.matcher(line);
      while (matcher.find()) {
        String word = matcher.group();
        int count = countLetterOccurrences(word, targetLetter);
        wordDataList.add(new WordData(word, count));
      }
    }
    return wordDataList;
  }

  // Подсчет вхождений буквы в слове
  static int countLetterOccurrences(String word, char letter) {
    int count = 0;
    for (char c : word.toCharArray()) {
      if (c == letter) {
        count++;
      }
    }
    return count;
  }

  // Вывод отсортированных слов
  static void printSortedWords(List<WordData> wordDataList) {
    System.out.println("\nОтсортированные слова:");
    for (WordData wordData : wordDataList) {
      System.out.println(wordData.getWord() + ": " + wordData.getLetterCount());
    }
  }

  // Внутренний класс для хранения данных о слове
  static class WordData {
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

  public static List<String> formatText(String text, int maxLineLength) {
    List<String> lines = new ArrayList<>();
    String[] words = text.split("\\s+"); // Разбиваем текст на слова
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

    return lines;
  }
}
