package com.example.Stage_13;

import java.sql.Connection;
import java.sql.SQLException;

/*
 * В каждом из заданий необходимо выполнить следующие действия:
 * • организацию соединения с базой данных вынести в отдельный класс, метод
 * которого возвращает соединение;
 * • создать БД. Привести таблицы к одной из нормальных форм;
 * • создать класс для выполнения запросов на извлечение информации из БД
 * с использованием компилированных запросов;
 * • создать класс на модификацию информации.
 * 
 * 
 * 
 * Магазин часов. В БД хранится информация о часах, продающихся в магазине.
 * Для часов необходимо хранить:
 * • марку;
 * • тип (кварцевые, механические);
 * • стоимость;
 * • количество;
 * • реквизиты производителя.
 * Для производителей необходимо хранить:
 * • название;
 * • страна.
 * • Вывести марки заданного типа часов.
 * • Вывести информацию о механических часах, стоимость которых не превышает заданную.
 * • Вывести марки часов, изготовленных в заданной стране.
 * • Вывести производителей, общая сумма часов которых в магазине не превышает заданную.
 */

public class WatchStore {
  public static void main(String[] args) throws SQLException {
    

    // Подключение к БД
    

    DatabaseConnection dbConnection = new DatabaseConnection();

    // DataPopulator.create(dbConnection);
    try (Connection connection = dbConnection.getConnection()) {
      if (connection == null)
        return;

      QueryExecutor queryExecutor = new QueryExecutor(dbConnection);
      // Примеры запросов
      System.out.println("Марки кварцевых часов: " + queryExecutor.getWatchBrandsByType("кварцевые"));
      System.out.println("Механические часы до 10000 руб: " + queryExecutor.getMechanicalWatches(10000));
      System.out.println("Часы из Швейцарии: " + queryExecutor.getWatchesByCountry("Швейцария"));
      System.out.println(
          "Производители с общей стоимостью до 50000 руб: " + queryExecutor.getManufacturersByTotalValue(50000));

    } catch (SQLException e) {
      System.err.println("Ошибка: " + e.getMessage());
    }
  }
}
