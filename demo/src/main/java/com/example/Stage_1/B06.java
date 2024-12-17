package com.example.Stage_1;

import java.math.BigInteger;

import static com.example.Inputs.InputConsole.inputArray;

public class B06 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        // Все трехзначные числа, в десятичной записи которых нет одинаковых цифр.
        System.out.println("Простые числа.");

        for (int elem : nums) {
            if (BigInteger.valueOf(elem).isProbablePrime((int) Math.log(elem))) {
                System.out.println(elem);
            }
        }
    }
}
