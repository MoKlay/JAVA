package com.example.Stage_11;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
  static boolean isFirstSet = true;
  private static List<Integer> c1 = new ArrayList<>();
  private static List<Integer> c2 = new ArrayList<>();
  private static BufferedReader reader = null;

  public static void main(String[] args) {
    try {
      if (reader == null) {
        try (BufferedReader reader = Resource.getBufferedReader(fileName)) {
          processInput(reader);
        }
      } else {
        processInput(reader);
      }
      System.out.println(c1);
      System.out.println(c2);
      System.out.println(getMergedList());



    } catch (Exception e) {
      e.printStackTrace();
    }


  }

  public static void processInput(BufferedReader reader) throws IOException {
    reader.lines()
        .map(Integer::parseInt)
        .forEach(num -> {
          if (num < 0) {
            isFirstSet = false;
            return;
          }
          if (isFirstSet) {
            addToSortedList(c1, num);
          } else {
            addToSortedList(c2, num);
          }
        });
  }

  public static void setBufferedReader(BufferedReader read) {
    reader = read;
  }

  public static List<Integer> getC1() {
    return new ArrayList<>(c1);
  }

  public static List<Integer> getC2() {
    return new ArrayList<>(c2);
  }

  public static List<Integer> getMergedList() {
    List<Integer> mergedList = new ArrayList<>(c1);
    mergedList.addAll(c2);
    mergedList.sort(Integer::compareTo);
    return mergedList;
  }

  public static void addToSortedList(List<Integer> list, int num) {
    list.add(num);
    list.sort(Integer::compareTo);
  }
}
