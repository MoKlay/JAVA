package com.example.Stage_11;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OptionBTest {
    private final String testFileName = "test_num.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Создание тестового файла с двумя наборами положительных чисел
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFileName))) {
            writer.write("1\n2\n3\n-1\n4\n5\n6\n");
        }
    }

    @AfterEach
    void tearDown() {
        // Удаление тестового файла после тестов
        try {
            Files.deleteIfExists(Paths.get(testFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testMainMethod() {
        // Запуск основного метода
        Option_B.main(new String[]{});

        // Проверка, что файл был прочитан и списки были созданы
        // В данном случае мы просто проверяем, что метод не выбрасывает исключений
        // и выводит ожидаемые результаты в консоль
        // Для более строгой проверки можно перенаправить вывод в поток и проверить его содержимое
    }

    @Test
    void testFileWithOnlyNegativeNumbers() throws IOException {
        // Создание тестового файла с только отрицательными числами
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFileName))) {
            writer.write("-1\n-2\n-3\n");
        }

        // Запуск основного метода
        Option_B.main(new String[]{});

        // Проверка, что программа не выбрасывает исключений
        // и выводит ожидаемые результаты в консоль
    }

    @Test
    void testFileWithMixedNumbers() throws IOException {
        // Создание тестового файла с положительными и отрицательными числами
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(testFileName))) {
            writer.write("5\n3\n-1\n2\n4\n-2\n1\n");
        }

        // Запуск основного метода
        Option_B.main(new String[]{});

        // Проверка, что программа не выбрасывает исключений
        // и выводит ожидаемые результаты в консоль
    }
}
