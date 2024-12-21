package com.example.Stage_13;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseConnection {
  static Connection connection;

  public DatabaseConnection() throws SQLException {
    String url = "jdbc:postgresql://localhost:5432/watch_store";
    String user = "postgres";
    String password = "postgres";
    try (Scanner scanner = new Scanner(System.in)) {
      System.out.println("Пользователь (" + user + "): ");
      String userInput = scanner.nextLine();
      if (!userInput.isEmpty())
        user = userInput;

      System.out.println("Пароль (" + password + "): ");
      String passwordInput = scanner.nextLine();
      if (!passwordInput.isEmpty())
        password = passwordInput;
    } catch (Exception e) {
    }
    try {
      Class.forName("org.postgresql.Driver");
      connection = DriverManager.getConnection(url, user, password);
    } catch (ClassNotFoundException e) {
      throw new SQLException("Драйвер JDBC не найден: " + e.getMessage());
    } catch (SQLException e) {
      throw new SQLException("Ошибка подключения к БД: " + e.getMessage());
    }
  }

  public Connection getConnection() {
    return connection;
  }
}
