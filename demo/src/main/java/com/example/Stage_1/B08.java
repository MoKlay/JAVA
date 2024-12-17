package com.example.Stage_1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.example.Inputs.InputConsole.inputArray;

public class B08 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        // Отсортированные числа в порядке возрастания и убывания.
        Map<Integer, Integer> frequency = new HashMap<>();

        // Подсчитываем частоту встречаемости каждого числа
        for (int number : nums) {
            frequency.put(number, frequency.getOrDefault(number, 0) + 1);
        }

        // Сортируем числа по убыванию частоты
        List<Map.Entry<Integer, Integer>> sortedNumbers = new ArrayList<>(frequency.entrySet());
        sortedNumbers.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Выводим результат
        for (Map.Entry<Integer, Integer> entry : sortedNumbers) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
