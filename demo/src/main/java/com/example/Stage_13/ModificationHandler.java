package com.example.Stage_13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModificationHandler {
  private final Connection connection;

  public ModificationHandler(DatabaseConnection dbConnection) throws SQLException {
    this.connection = dbConnection.getConnection();
    if (this.connection == null)
      throw new SQLException("Ошибка подключения");
  }

  public void addManufacturer(String name, String country) throws SQLException {
    try (PreparedStatement statement = connection.prepareStatement(
        "INSERT INTO manufacturers (name, country) VALUES (?, ?)")) {
      statement.setString(1, name);
      statement.setString(2, country);
      statement.executeUpdate();
    }
  }

  // Другие методы для модификации (update, delete)
}
