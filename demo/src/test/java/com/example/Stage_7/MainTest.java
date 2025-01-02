package com.example.Stage_7;

import com.example.Inputs.Resource;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;



class MainTest {

    SearchCharWithFile searchCharWithFile;

    @Test
    void testCharacterCount() throws FileNotFoundException, IOException {
        // Создаем временный файл для тестирования
        File tempFile = File.createTempFile("testFile", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("Hello World");
            writer.println("Java Programming");
        }


        new SearchCharWithFile(tempFile);
    }

    @Test
    void testFileNotFound() {
        // Проверяем, что программа корректно обрабатывает ситуацию, когда файл не найден
        String nonExistentFileName = "non_existent_file.txt";
        assertThrows(RuntimeException.class, () -> {
            try (Scanner scanner = new Scanner(Resource.getResourceFile(nonExistentFileName))) {

            }
        });
    }
}
