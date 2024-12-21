package com.example.Stage_10;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/*
 * Выполнить задания из варианта B гл. 4, сохраняя объекты приложения в одном или нескольких файлах с применением механизма
 * сериализации. Объекты могут содержать поля, помеченные как static, а также transient. Для изменения
 * информации и извлечения информации в файле создать специальный классконнектор с необходимыми для выполнения этих задач
 * методами.
 * 
 * 
 * * * Варианта B гл. 4
 * * Создайте консольное приложение, удовлетворяющее следующим требованиям:
 * Используйте возможности ООП: классы, наследование, полиморфизм, инкапсуляцию.
 * Каждый класс должен иметь осмысленное название и информативный состав.
 * Наследование должно применяться только тогда, когда это имеет смысл.
 * При кодировании должны быть использованы соглашения о форматировании кода Java.
 * Классы должны быть грамотно распределены по пакетам.
 * Консольное меню должно быть минимальным.
 * Для хранения параметров инициализации можно использовать файлы. 
 * 
 * 
 * 
 * Задание: 
 * Авиакомпания. 
 * Определить иерархию самолётов. Создать авиакомпанию. 
 * Рассчитать общую вместимость и грузоподъёмность. 
 * Провести сортировку самолётов компании по дальности полёта. 
 * Найти в компании самолёт, соответствующий заданному диапазону параметров потребления топлива.
 */

// Базовый класс для самолетов
class Airplane implements Serializable {
  private static final long serialVersionUID = 1L; // Для сериализация
  String model;
  int seats;
  int carryingCapacity;
  int flightRange;
  double fuelConsumption;
  transient boolean needsMaintenance = false; // transient поле не сериализуется

  public Airplane(String model, int seats, int carryingCapacity, int flightRange, double fuelConsumption) {
    this.model = model;
    this.seats = seats;
    this.carryingCapacity = carryingCapacity;
    this.flightRange = flightRange;
    this.fuelConsumption = fuelConsumption;
  }

  @Override
  public String toString() {
    return "Model: " + model + ", Seats: " + seats + ", Carrying Capacity: " + carryingCapacity +
        " kg, Flight Range: " + flightRange + " km, Fuel Consumption: " + fuelConsumption + " l/km";
  }

  public static long getSerialVersionUID() {
    return serialVersionUID;
  }

  public String getModel() {
    return model;
  }

  public void setModel(String model) {
    this.model = model;
  }

  public int getSeats() {
    return seats;
  }

  public void setSeats(int seats) {
    this.seats = seats;
  }

  public int getCarryingCapacity() {
    return carryingCapacity;
  }

  public void setCarryingCapacity(int carryingCapacity) {
    this.carryingCapacity = carryingCapacity;
  }

  public int getFlightRange() {
    return flightRange;
  }

  public void setFlightRange(int flightRange) {
    this.flightRange = flightRange;
  }

  public double getFuelConsumption() {
    return fuelConsumption;
  }

  public void setFuelConsumption(double fuelConsumption) {
    this.fuelConsumption = fuelConsumption;
  }

  public boolean isNeedsMaintenance() {
    return needsMaintenance;
  }

  public void setNeedsMaintenance(boolean needsMaintenance) {
    this.needsMaintenance = needsMaintenance;
  }
}

// Класс для пассажирских самолетов
@SuppressWarnings("unused")
class PassengerAirplane extends Airplane implements Serializable {
  private static final long serialVersionUID = 1L;
  boolean businessClass;

  public PassengerAirplane(String model, int seats, int carryingCapacity, int flightRange, double fuelConsumption,
      boolean businessClass) {
    super(model, seats, carryingCapacity, flightRange, fuelConsumption);
    this.businessClass = businessClass;
  }
  // ... геттеры и сеттеры ...

  @Override
  public String toString() {
    return super.toString() + ", Business Class: " + businessClass;
  }
}

// Класс для грузовых самолетов
@SuppressWarnings("unused")
class CargoAirplane extends Airplane implements Serializable {
  private static final long serialVersionUID = 1L;
  int maxCargoWeight;

  public CargoAirplane(String model, int carryingCapacity, int flightRange, double fuelConsumption,
      int maxCargoWeight) {
    super(model, 0, carryingCapacity, flightRange, fuelConsumption);
    this.maxCargoWeight = maxCargoWeight;
  }
  // ... геттеры и сеттеры ...

  @Override
  public String toString() {
    return super.toString() + ", Max Cargo Weight: " + maxCargoWeight + " kg";
  }
}

class Airline implements Serializable {
  private static final long serialVersionUID = 1L;
  List<Airplane> airplanes;
  static int airlineID = 1; // static поле

  public Airline() {
    this.airplanes = new ArrayList<>();
  }
  // ... геттеры и сеттеры ...

  @Override
  public String toString() {
    return "Airline ID: " + airlineID + "\nAirplanes: " + airplanes;
  }
}

class AirlineConnector {
  static void saveAirlineToFile(Airline airline, String fileName) throws IOException {
    try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
      oos.writeObject(airline);
    }
  }

  static Airline loadAirlineFromFile(String fileName) throws IOException, ClassNotFoundException {
    try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
      return (Airline) ois.readObject();
    }
  }
}

public class Option_B {
  public static void main(String[] args) {
    Airline airline = new Airline();
    airline.airplanes.add(new PassengerAirplane("Boeing 737", 150, 10000, 5000, 2.5, true));
    airline.airplanes.add(new CargoAirplane("Anton An-124", 150000, 4000, 5.0, 120000));

    try {
      AirlineConnector.saveAirlineToFile(airline, "airline.dat");
      Airline loadedAirline = AirlineConnector.loadAirlineFromFile("airline.dat");
      System.out.println(loadedAirline);
    } catch (IOException | ClassNotFoundException e) {
      System.err.println("Ошибка: " + e.getMessage());
    }
  }
}
