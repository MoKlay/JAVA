package com.example.Stage_13;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QueryExecutor {
  private final Connection connection;

  private final PreparedStatement getWatchBrandsByTypeStatement;
  private final PreparedStatement getMechanicalWatchesStatement;
  private final PreparedStatement getWatchesByCountryStatement;
  private final PreparedStatement getManufacturersByTotalValueStatement;

  public QueryExecutor(DatabaseConnection dbConnection) throws SQLException {
    this.connection = dbConnection.getConnection();
    if (this.connection == null)
      throw new SQLException("Ошибка подключения");

    getWatchBrandsByTypeStatement = connection.prepareStatement("SELECT brand FROM watches WHERE type = ?");
    getMechanicalWatchesStatement = connection.prepareStatement(
        "SELECT brand, price, quantity FROM watches WHERE type = 'механические' AND price <= ?");
    getWatchesByCountryStatement = connection.prepareStatement(
        "SELECT w.brand FROM watches w JOIN manufacturers m ON w.manufacturer_id = m.id WHERE m.country = ?");
    getManufacturersByTotalValueStatement = connection.prepareStatement(
        "SELECT m.name FROM manufacturers m JOIN watches w ON m.id = w.manufacturer_id GROUP BY m.name HAVING SUM(w.price * w.quantity) <= ?");
  }

  public List<String> getWatchBrandsByType(String type) throws SQLException {
    return executeStringQuery(getWatchBrandsByTypeStatement, type);
  }

  public List<Watch> getMechanicalWatches(int maxPrice) throws SQLException {
    return executeWatchQuery(getMechanicalWatchesStatement, maxPrice);
  }

  public List<String> getWatchesByCountry(String country) throws SQLException {
    return executeStringQuery(getWatchesByCountryStatement, country);
  }

  public List<String> getManufacturersByTotalValue(int maxTotalValue) throws SQLException {
    return executeStringQuery(getManufacturersByTotalValueStatement, maxTotalValue);
  }

  private List<String> executeStringQuery(PreparedStatement statement, Object param) throws SQLException {
    List<String> result = new ArrayList<>();
    statement.setObject(1, param);
    try (ResultSet rs = statement.executeQuery()) {
      while (rs.next()) {
        result.add(rs.getString(1));
      }
    }
    return result;
  }

  private List<Watch> executeWatchQuery(PreparedStatement statement, Object param) throws SQLException {
    List<Watch> result = new ArrayList<>();
    statement.setObject(1, param);
    try (ResultSet rs = statement.executeQuery()) {
      while (rs.next()) {
        result.add(new Watch(
            rs.getString("brand"),
            rs.getInt("price"),
            rs.getInt("quantity")));
      }
    }
    return result;
  }

  // Добавлен класс для хранения информации о часах
  static class Watch {
    String brand;
    int price;
    int quantity;

    public Watch(String brand, int price, int quantity) {
      this.brand = brand;
      this.price = price;
      this.quantity = quantity;
    }

    @Override
    public String toString() {
      return "Watch{" +
          "brand='" + brand + '\'' +
          ", price=" + price +
          ", quantity=" + quantity +
          '}';
    }
  }
}
