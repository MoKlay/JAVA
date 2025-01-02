package com.example.Stage_10;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import org.junit.jupiter.api.Test;

public class Option_A_Test {
  @Test
  void test() throws IOException {
    File tempFile = File.createTempFile("temp", ".txt");
    try (PrintWriter pWriter = new PrintWriter(tempFile)) {
      pWriter.println("Hello World!!! error");
    }
    List<String> list = Option_A.processStringsFromFile(tempFile, "error");

    assertEquals("Hello World!!! ", list.get(0));
  }
}
