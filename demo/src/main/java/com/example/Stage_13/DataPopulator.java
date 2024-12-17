package com.example.Stage_13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DataPopulator {
  public static void create(DatabaseConnection dbConnection) {
    try (Connection connection = dbConnection.getConnection()) {
      if (connection != null) {
      } else {
        return;
      }
      try (Statement statement = connection.createStatement()) {
        // Удаляем существующие данные, чтобы начать с чистого листа.
        // В реальном приложении это может быть необязательно,
        // и лучше использовать INSERT IGNORE вместо DELETE.
        statement.executeUpdate("DELETE FROM watches");
        statement.executeUpdate("DELETE FROM manufacturers");
      }

      // Добавляем производителей
      try (PreparedStatement insertManufacturerStatement = connection.prepareStatement(
          "INSERT INTO manufacturers (name, country) VALUES (?, ?)", Statement.RETURN_GENERATED_KEYS)) {
        String[] names = { "Citizen", "Seiko", "Casio", "Omega", "Rolex" };
        String[] countries = { "Япония", "Япония", "Япония", "Швейцария", "Швейцария" };
        for (int i = 0; i < names.length; i++) {
          insertManufacturerStatement.setString(1, names[i]);
          insertManufacturerStatement.setString(2, countries[i]);
          insertManufacturerStatement.executeUpdate();

          try (ResultSet generatedKeys = insertManufacturerStatement.getGeneratedKeys()) {
            if (generatedKeys.next()) {
              int manufacturerId = generatedKeys.getInt(1);
              addWatches(connection, manufacturerId); // Добавляем часы для этого производителя
            }
          }
        }
      }

      System.out.println("Данные успешно добавлены.");
    } catch (SQLException e) {
      System.err.println("Ошибка при добавлении данных: " + e.getMessage());
    }
  }

  // Метод для добавления нескольких часов одному производителю
  private static void addWatches(Connection connection, int manufacturerId) throws SQLException {
    try (PreparedStatement insertWatchStatement = connection.prepareStatement(
        "INSERT INTO watches (brand, type, price, quantity, manufacturer_id) VALUES (?, ?, ?, ?, ?)")) {
      Random rand = new Random();
      for (int i = 0; i < 10; i++) {
        String brand = "Часы " + i;
        String type = rand.nextBoolean() ? "кварцевые" : "механические";
        int price = rand.nextInt(10000) + 1; // Цены от 1 до 10000
        int quantity = rand.nextInt(100) + 1; // Количество от 1 до 100

        insertWatchStatement.setString(1, brand);
        insertWatchStatement.setString(2, type);
        insertWatchStatement.setInt(3, price);
        insertWatchStatement.setInt(4, quantity);
        insertWatchStatement.setInt(5, manufacturerId);
        insertWatchStatement.executeUpdate();
      }
    }
  }
}
