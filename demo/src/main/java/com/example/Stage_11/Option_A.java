package com.example.Stage_11;

import java.util.HashMap;
import java.util.Map;

/*
 * Сложить два многочлена заданной степени, если коэффициенты многочленов хранятся в объекте HashMap
 */
public class Option_A {
  public static Map<Integer, Double> addPolynomials(Map<Integer, Double> poly1, Map<Integer, Double> poly2) {
    Map<Integer, Double> result = new HashMap<>();

    // Объединяем ключи из обоих HashMap
    result.putAll(poly1);
    result.putAll(poly2);

    // Складываем коэффициенты при одинаковых степенях
    for (Map.Entry<Integer, Double> entry : result.entrySet()) {
      int degree = entry.getKey();
      double coeff1 = poly1.getOrDefault(degree, 0.0);
      double coeff2 = poly2.getOrDefault(degree, 0.0);
      result.put(degree, coeff1 + coeff2);
    }

    // Удаляем элементы с нулевыми коэффициентами
    result.entrySet().removeIf(entry -> entry.getValue() == 0.0);

    return result;
  }

  public static void main(String[] args) {
    Map<Integer, Double> poly1 = new HashMap<>();
    poly1.put(2, 2.0);
    poly1.put(1, -1.0);
    poly1.put(0, 3.0);

    Map<Integer, Double> poly2 = new HashMap<>();
    poly2.put(2, 1.0);
    poly2.put(1, 2.0);
    poly2.put(3, 4.0);

    Map<Integer, Double> sum = addPolynomials(poly1, poly2);

    System.out.print("Сумма многочленов: ");
    for (Map.Entry<Integer, Double> entry : sum.entrySet()) {
      int degree = entry.getKey();
      double coeff = entry.getValue();
      if (coeff != 0) {
        if (degree == 0) {
          System.out.print(coeff);
        } else if (coeff == 1) {
          System.out.print("x^" + degree);
        } else if (coeff == -1) {
          System.out.print("-x^" + degree);
        } else {
          System.out.print(coeff + "x^" + degree);
        }
        if (sum.size() > 1 && sum.keySet().contains(degree) && entry.getKey() != sum.size() - 1)
          System.out.print(" + ");
      }
    }
    System.out.println();
  }
}
