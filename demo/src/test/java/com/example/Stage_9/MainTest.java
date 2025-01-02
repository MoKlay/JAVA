package com.example.Stage_9;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import org.junit.jupiter.api.Test;


public class MainTest {
  @Test
  void test1() throws IOException {
    File tempFile = File.createTempFile("temp", ".txt");
    try (PrintWriter pWriter = new PrintWriter(tempFile)) {
      pWriter.println("123.45");
      pWriter.println("234,56 de_DE");
      pWriter.println("-10.5 en_GB");
    }
    assertThrows(Main.InvalidNumberFormatException.class, () -> {
      Main.processNumbersFromFile(tempFile);
    });
  }
}
