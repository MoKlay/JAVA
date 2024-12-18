package Stage_4;

import Stage_4.Airline.CargoAirplane;
import Stage_4.Airline.PassengerAirplane;
import Stage_4.Circle.Point;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    try (Scanner scanner = new Scanner(System.in)) {
      System.err.println("Введите задание:");
      int task = scanner.nextInt();
      switch (task) {
        case 1 -> Task1();
        case 2 -> Task2();
        default -> System.out.println("Неизвестное задание");
      }
    } catch (Exception e) {
    }
  }

  private static void Task1() {
    Point center = new Point(1, 1);
    Circle circle = new Circle(center, 2); // Создание объекта Circle, используя класс Point

    System.out.println("Исходный круг: " + circle);

    circle.changeRadius(3);
    System.out.println("Круг после изменения радиуса: " + circle);

    Point p1 = new Point(2, 2);
    Point p2 = new Point(5, 5);

    System.out.println("Точка " + p1 + " внутри круга: " + circle.contains(p1));
    System.out.println("Точка " + p2 + " внутри круга: " + circle.contains(p2));

    circle.setSize(new Point(0, 0), 1);
    System.out.println("Круг после изменения размера: " + circle);
  }

  private static void Task2() {
    Airline airline = new Airline();

    airline.addAirplane(new PassengerAirplane("Boeing 737", 150, 10000, 5000, 2.5, true));
    airline.addAirplane(new PassengerAirplane("Airbus A320", 180, 12000, 6000, 2.8, false));
    airline.addAirplane(new CargoAirplane("Antonov An-124", 150000, 4000, 5.0, 120000));
    airline.addAirplane(new CargoAirplane("Boeing 747F", 130000, 8000, 4.5, 110000));

    System.out.println("Общая вместимость самолетов: " + airline.getTotalCapacity() + " мест");
    System.out.println("Общая грузоподъемность самолетов: " + airline.getTotalCarryingCapacity() + " кг");

    System.out.println("\nСамолеты, отсортированные по дальности полета:");
    airline.sortPlanesByFlightRange().forEach(System.out::println);

    System.out.println("\nСамолеты с расходом топлива в диапазоне [2.0, 3.0] л/км:");
    airline.findPlanesByFuelConsumption(2.0, 3.0).forEach(System.out::println);
  }
}
