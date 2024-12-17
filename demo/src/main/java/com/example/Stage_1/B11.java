package com.example.Stage_1;

import static com.example.Inputs.InputConsole.inputArray;

public class B11 {
    public static void main(String[] args) {
        int[] nums = inputArray();
        if (nums.length > 3) {
            for (int i = 1; i < nums.length - 1; i++) {
                int sum = nums[i - 1] + nums[i + 1];
                if (nums[i] == sum / 2) {
                    System.out.println(nums[i]);
                }
            }
        }
    }
}
