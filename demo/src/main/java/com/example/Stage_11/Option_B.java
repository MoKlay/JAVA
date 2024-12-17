package com.example.Stage_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.example.Inputs.Resource;
/*
 * Во входном файле расположены два набора положительных чисел; между
 * наборами стоит отрицательное число. Построить два списка C1 и С2, элементы которых содержат соответственно числа 1-го и
 * 2-го набора таким
 * образом, чтобы внутри одного списка числа были упорядочены по возрастанию. Затем объединить списки C1 и С2 в один
 * упорядоченный список,
 * изменяя только значения полей ссылочного типа
 */

public class Option_B {
  static String fileName = "num.txt";

  public static void main(String[] args) {
    try (BufferedReader reader = Resource.getBufferedReader(fileName)) {
      List<Integer> c1 = new ArrayList<>();
      List<Integer> c2 = new ArrayList<>();

      reader.lines()
          .map(Integer::parseInt) // Преобразуем строки в числа
          .forEach(num -> {
            if (num < 0) {
              return; // Пропускаем отрицательные числа
            }
            if (c1.isEmpty()) {
              c1.add(num);
              return; // Если c1 пустой, добавляем сразу
            }

            // Попробуем добавить в c1, если можно
            int last = c1.get(c1.size() - 1);
            if (num >= last) {
              c1.add(num);
              return;
            }

            // Если не получилось, переключаемся на c2 и продолжаем добавлять в c1
            c2.add(num);
          });

      // Объединяем, сортируем и выводим
      List<Integer> mergedList = c1.stream()
          .sorted()
          .collect(Collectors.toList());
      mergedList.addAll(c2.stream()
          .sorted()
          .collect(Collectors.toList()));

      System.out.println("Список C1: " + c1);
      System.out.println("Список C2: " + c2);
      System.out.println("Объединенный отсортированный список: " + mergedList);
    } catch (IOException | NumberFormatException e) {
      System.err.println("Ошибка: " + e.getMessage());
    }
  }
}
