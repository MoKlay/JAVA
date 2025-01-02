package com.example.Stage_10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.*;

public class Option_C_Test {
    private final String testInputFilePath = "test_input.txt";
    private final String testOutputDir = "test_output";
    private final String testOutputFilePath = testOutputDir + File.separator + "output.txt";

    @BeforeEach
    void setUp() throws IOException {
        // Создание тестового входного файла с комментариями
        String testCode = "public class Test {\n" +
                          "    // This is a single line comment\n" +
                          "    /* This is a \n" +
                          "       multi-line comment */\n" +
                          "    public void method() {\n" +
                          "        System.out.println(\"Hello, World!\"); // Print message\n" +
                          "    }\n" +
                          "}";
        Files.writeString(Paths.get(testInputFilePath), testCode);
    }

    @AfterEach
    void tearDown() {
        // Удаление тестового входного файла и выходной директории
        try {
            Files.deleteIfExists(Paths.get(testInputFilePath));
            Files.deleteIfExists(Paths.get(testOutputFilePath));
            Files.deleteIfExists(Paths.get(testOutputDir));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testRemoveComments() {
        String codeWithComments = "public class Test {\n" +
                                  "    // This is a single line comment\n" +
                                  "    /* This is a \n" +
                                  "       multi-line comment */\n" +
                                  "    public void method() {\n" +
                                  "        System.out.println(\"Hello, World!\"); // Print message\n" +
                                  "    }\n" +
                                  "}";
        String expectedCode = "public class Test {\n" +
                              "    \n" + 
                              "    \n" +
                              "    public void method() {\n" +
                              "        System.out.println(\"Hello, World!\"); \n" +
                              "    }\n" +
                              "}";
        String resultCode = Option_C.removeComments(codeWithComments);
        assertEquals(expectedCode, resultCode);
    }
}

