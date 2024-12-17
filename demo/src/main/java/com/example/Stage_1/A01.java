package com.example.Stage_1;

public class A01 {
    public static void main(String[] args) {
        // Приветствовать любого пользователя при вводе его имени через командную строку
        if (args.length != 0) {
            System.out.println("Приветствую, " + args[0]);
        } else {
            System.out.println("Задайте свое имя в аргументе!!!");
        }
    }
}
