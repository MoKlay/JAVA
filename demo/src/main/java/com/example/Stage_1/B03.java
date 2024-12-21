package com.example.Stage_1;

import static com.example.Inputs.InputConsole.inputArray;

public class B03 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        // Числа, которые делятся на 3 или на 9.
        System.out.println("Числа, которые делятся на 3 или на 9.");
        for (int el : nums)
            if (el % 3 == 0 || el % 9 == 0)
                System.out.print(el);
    }
}
