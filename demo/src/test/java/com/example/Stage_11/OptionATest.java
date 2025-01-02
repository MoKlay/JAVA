package com.example.Stage_11;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class OptionATest {

    @Test
    void testAddPolynomials() {
        // Первый многочлен: 2x^2 - x + 3
        Map<Integer, Double> poly1 = new HashMap<>();
        poly1.put(2, 2.0);
        poly1.put(1, -1.0);
        poly1.put(0, 3.0);

        // Второй многочлен: x^2 + 2x + 4
        Map<Integer, Double> poly2 = new HashMap<>();
        poly2.put(2, 1.0);
        poly2.put(1, 2.0);
        poly2.put(0, 4.0);

        // Ожидаемый результат: 3x^2 + x + 7
        Map<Integer, Double> expected = new HashMap<>();
        expected.put(2, 3.0);
        expected.put(1, 1.0);
        expected.put(0, 7.0);

        // Сложение многочленов
        Map<Integer, Double> result = Option_A.addPolynomials(poly1, poly2);

        // Проверка результата
        assertEquals(expected, result);
    }

    @Test
    void testAddPolynomialsWithZeroCoefficients() {
        // Первый многочлен: 2x^2 - x + 3
        Map<Integer, Double> poly1 = new HashMap<>();
        poly1.put(2, 2.0);
        poly1.put(1, -1.0);
        poly1.put(0, 3.0);

        // Второй многочлен: 0 (пустой многочлен)
        Map<Integer, Double> poly2 = new HashMap<>();

        // Ожидаемый результат: 2x^2 - x + 3
        Map<Integer, Double> expected = new HashMap<>();
        expected.put(2, 2.0);
        expected.put(1, -1.0);
        expected.put(0, 3.0);

        // Сложение многочленов
        Map<Integer, Double> result = Option_A.addPolynomials(poly1, poly2);

        // Проверка результата
        assertEquals(expected, result);
    }

    @Test
    void testAddPolynomialsWithNegativeCoefficients() {
        // Первый многочлен: -2x^2 + 3
        Map<Integer, Double> poly1 = new HashMap<>();
        poly1.put(2, -2.0);
        poly1.put(0, 3.0);

        // Второй многочлен: 2x^2 + x - 4
        Map<Integer, Double> poly2 = new HashMap<>();
        poly2.put(2, 2.0);
        poly2.put(1, 1.0);
        poly2.put(0, -4.0);

        // Ожидаемый результат: x - 1
        Map<Integer, Double> expected = new HashMap<>();
        expected.put(1, 1.0);
        expected.put(0, -1.0);

        // Сложение многочленов
        Map<Integer, Double> result = Option_A.addPolynomials(poly1, poly2);

        // Проверка результата
        assertEquals(expected, result);
    }

    @Test
    void testAddPolynomialsWithAllZeroCoefficients() {
        // Первый многочлен: 0
        Map<Integer, Double> poly1 = new HashMap<>();

        // Второй многочлен: 0
        Map<Integer, Double> poly2 = new HashMap<>();

        // Ожидаемый результат: 0 (пустой многочлен)
        Map<Integer, Double> expected = new HashMap<>();

        // Сложение многочленов
        Map<Integer, Double> result = Option_A.addPolynomials(poly1, poly2);

        // Проверка результата
        assertEquals(expected, result);
    }
}

