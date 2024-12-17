package com.example.Stage_1;

import java.util.Arrays;

import static com.example.Inputs.InputConsole.inputArray;

public class B07 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        // Отсортированные числа в порядке возрастания и убывания.
        System.out.println("Отсортированные числа в порядке возрастания ");

        int[] arr = nums;
        Arrays.sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println("\nОтсортированные числа в порядке возрастания ");
        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
