package com.example.Stage_10;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class Option_B_Test {
    private Airline airline;
    private final String testFileName = "test_airline.dat";

    @BeforeEach
    void setUp() {
        airline = new Airline();
        airline.airplanes.add(new PassengerAirplane("Boeing 737", 150, 10000, 5000, 2.5, true));
        airline.airplanes.add(new CargoAirplane("Anton An-124", 150000, 4000, 5.0, 120000));
    }

    @AfterEach
    void tearDown() {
        File file = new File(testFileName);
        if (file.exists()) {
            file.delete();
        }
    }

    @Test
    void testSaveAndLoadAirline() {
        try {
            // Сохранение авиакомпании в файл
            AirlineConnector.saveAirlineToFile(airline, testFileName);

            // Загрузка авиакомпании из файла
            Airline loadedAirline = AirlineConnector.loadAirlineFromFile(testFileName);

            // Проверка, что загруженная авиакомпания соответствует сохраненной
            assertNotNull(loadedAirline);
            assertEquals(airline.airplanes.size(), loadedAirline.airplanes.size());
            assertEquals(airline.airplanes.get(0).getModel(), loadedAirline.airplanes.get(0).getModel());
            assertEquals(airline.airplanes.get(1).getModel(), loadedAirline.airplanes.get(1).getModel());
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }

    @Test
    void testLoadNonExistentFile() {
        assertThrows(IOException.class, () -> {
            AirlineConnector.loadAirlineFromFile("non_existent_file.dat");
        });
    }

    @Test
    void testSaveAirlineWithTransientField() {
        try {
            airline.airplanes.get(0).setNeedsMaintenance(true);
            AirlineConnector.saveAirlineToFile(airline, testFileName);
            Airline loadedAirline = AirlineConnector.loadAirlineFromFile(testFileName);
            assertFalse(loadedAirline.airplanes.get(0).isNeedsMaintenance(), "Transient field should not be serialized");
        } catch (IOException | ClassNotFoundException e) {
            fail("Exception should not be thrown: " + e.getMessage());
        }
    }
}

