package com.example.Stage_1;

import static com.example.Inputs.InputConsole.inputArray;

public class B04 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        // Числа, которые делятся на 5 и на 7.
        System.out.println("Числа, которые делятся на 5 и на 7.");
        for (int el : nums)
            if (el % 5 == 0 && el % 7 == 0)
                System.out.print(el);
    }
}
