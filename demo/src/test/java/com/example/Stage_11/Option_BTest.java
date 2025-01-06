package com.example.Stage_11;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;


public class Option_BTest {

    @Test
    public void testAddToSortedList() {
        List<Integer> list = new ArrayList<>();
        Option_B.addToSortedList(list, 5);
        Option_B.addToSortedList(list, 3);
        Option_B.addToSortedList(list, 8);
        Option_B.addToSortedList(list, 1);

        List<Integer> expected = List.of(1, 3, 5, 8);
        assertEquals(expected, list);
    }

    @Test
    public void testMainLogic() throws IOException {
        String input = "1\n2\n3\n-1\n4\n5\n6\n";
        BufferedReader reader = new BufferedReader(new StringReader(input));

        Option_B.setBufferedReader(reader);

        // Запускаем основной метод
        Option_B.main(new String[]{});

        // Проверяем, что списки заполнены правильно
        List<Integer> expectedC1 = List.of(1, 2, 3);
        List<Integer> expectedC2 = List.of(4, 5, 6);
        List<Integer> expectedMerged = List.of(1, 2, 3, 4, 5, 6);

        assertEquals(expectedC1, Option_B.getC1());
        assertEquals(expectedC2, Option_B.getC2());
        assertEquals(expectedMerged, Option_B.getMergedList());
    }
}
