package com.example.Inputs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Scanner;

public class InputConsole {
    private static final Scanner scan = new Scanner(System.in);

    public static int[] inputArray() {
        System.out.println("Ввести с консоли n целых чисел.");
        System.out.print("Ввести число n: ");
        int n = scan.nextInt();

        int[] arrnum = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("n" + i + " = ");
            arrnum[i] = scan.nextInt();
        }
        return arrnum;
    }

    public static ArrayList<Integer> inputList() {
        System.out.println("Ввести с консоли n целых чисел.");
        System.out.print("Ввести число n: ");
        int n = scan.nextInt();

        ArrayList<Integer> arrnum = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            System.out.print("n" + i + " = ");
            arrnum.add(scan.nextInt());
        }
        return arrnum;

    }

    public static String readFile(String resourceName) throws NullPointerException {
        try {
            URL url = InputConsole.class.getClassLoader().getResource(resourceName);
            try (InputStream inputStream = url.openStream()) {
                return new String(inputStream.readAllBytes(), StandardCharsets.UTF_8);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading resource: " + resourceName, e);
        }
    }

    public static void main(String[] args) {
        System.out.println(readFile("input.txt"));
    }

}
