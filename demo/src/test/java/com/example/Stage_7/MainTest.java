package com.example.Stage_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.example.Inputs.Resource;

class MainTest {

    @Test
    void testCharacterCount() throws FileNotFoundException, IOException {
        // Создаем временный файл для тестирования
        File tempFile = File.createTempFile("testFile", ".txt");
        try (PrintWriter writer = new PrintWriter(tempFile)) {
            writer.println("Hello World");
            writer.println("Java Programming");
        }

        // Имитация Resource.getResourceFile
        Resource resourceMock = Mockito.mock(Resource.class);
        Mockito.when(Resource.getResourceFile(tempFile.getName())).thenReturn(tempFile);

        // Запускаем метод main с временным файлом
        Map<Character, Integer> expectedCounts = new HashMap<>();
        expectedCounts.put('h', 1);
        expectedCounts.put('e', 2);
        expectedCounts.put('l', 3);
        expectedCounts.put('o', 2);
        expectedCounts.put('w', 1);
        expectedCounts.put('r', 1);
        expectedCounts.put('d', 1);
        expectedCounts.put('j', 1);
        expectedCounts.put('a', 2);
            expectedCounts.put('v', 1);
        expectedCounts.put('p', 1);
        expectedCounts.put('g', 1);
        expectedCounts.put('m', 1);
        expectedCounts.put('n', 1);

        // Здесь вы можете вызвать метод main и проверить вывод
        // Однако, так как метод main статический, его сложно протестировать напрямую.
        // Вместо этого, вы можете вынести логику подсчета в отдельный метод и протестировать его.

        // Пример: 
        // Map<Character, Integer> actualCounts = Main.countCharacters(tempFile.getName());
        // assertEquals(expectedCounts, actualCounts);
    }

    @Test
    void testFileNotFound() {
        // Проверяем, что программа корректно обрабатывает ситуацию, когда файл не найден
        String nonExistentFileName = "non_existent_file.txt";
        Exception exception = assertThrows(FileNotFoundException.class, () -> {
            Scanner scanner = new Scanner(Resource.getResourceFile(nonExistentFileName));
        });

        String expectedMessage = "Файл не найден";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}
