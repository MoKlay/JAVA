package com.example.Stage_1;

import java.util.Scanner;

public class A03 {
    public static void main(String[] args) {
        // Вывести заданное количество случайных чисел с переходом и без перехода на
        // новую строку
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Ввести число: ");
            int num = scan.nextInt();
            System.out.println();
            for (int i = 0; i < num; i++) {
                System.out.println((int) (Math.random() * 20));
            }
            System.out.println();
            for (int i = 0; i < num; i++) {
                System.out.print((int) (Math.random() * 20) + " ");
            }
            System.out.println();
        }
    }
}
