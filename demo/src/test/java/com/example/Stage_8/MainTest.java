package com.example.Stage_8;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.Stage_8.Option_B.WordData;

public class MainTest {
  File tempFile;

  @BeforeEach
  void setUp() throws IOException {
    tempFile = File.createTempFile("testFile", ".txt");
    try (PrintWriter writer = new PrintWriter(tempFile)) {
      writer.println("Hello World");
      writer.println("Java Programming");
      writer.println("Hello World");
      writer.println("Java Programming");
    }
  }

  @Test
  void testA() throws FileNotFoundException {
    Option_A oA = new Option_A(tempFile);
    Map<String, Integer> map = oA.getWordCounts();

    assertEquals(2, map.get("hello"));
    assertEquals(2, map.get("world"));
    assertEquals(2, map.get("java"));
    assertEquals(2, map.get("programming"));
  }

  @Test
  void testB() throws FileNotFoundException {
    Option_B oB = new Option_B(tempFile, 'o');
    List<WordData> list = oB.getWordDataList();
    oB.printSortedWords();

    assertEquals(0, list.get(0).getLetterCount());
    assertEquals(0, list.get(1).getLetterCount());
    assertEquals(1, list.get(2).getLetterCount());
    assertEquals(1, list.get(3).getLetterCount());
  }

}
