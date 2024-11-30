package Stage_3;

import Stage_3.Triangle.Point;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
  private static final List<Product> products = new ArrayList<>();
  private static final List<Circle> circles = new ArrayList<>();
  private static final List<Triangle> triangles = new ArrayList<>();

  public static void main(String[] args) {

    try (Scanner scanner = new Scanner(System.in)) {
      System.err.println("Введите задание: ");
      int task = scanner.nextInt();
      switch (task) {
        case 1 -> Task1();
        case 2 -> Task2();
        case 3 -> Task3();
        default -> System.out.println("Нет такого задания");
      }

    } catch (Exception e) {
    }

  }

  private static void Task1() {
    products.add(new Product(1, "Молоко", "123456789012", "Компания А", 1.5, 7, 100));
    products.add(new Product(2, "Хлеб", "987654321098", "Компания Б", 1.0, 2, 50));
    products.add(new Product(3, "Молоко", "123456789013", "Компания В", 1.7, 5, 75));
    products.add(new Product(4, "Йогурт", "000000000000", "Компания А", 2.0, 14, 200));
    products.add(new Product(5, "Хлеб", "987654321099", "Компания Б", 1.2, 3, 60));
    products.add(new Product(6, "Молоко", "123456789012", "Компания А", 1.5, 7, 100));
    products.add(new Product(7, "Хлеб", "987654321098", "Компания Б", 1.0, 2, 50));
    products.add(new Product(8, "Молоко", "123456789013", "Компания В", 1.7, 5, 75));
    products.add(new Product(9, "Йогурт", "000000000000", "Компания А", 2.0, 14, 200));
    products.add(new Product(10, "Хлеб", "987654321099", "Компания Б", 1.2, 3, 60));
    products.add(new Product(11, "Молоко", "123456789012", "Компания А", 1.5, 7, 100));
    products.add(new Product(12, "Хлеб", "987654321098", "Компания Б", 1.0, 2, 50));
    products.add(new Product(13, "Молоко", "123456789013", "Компания В", 1.7, 5, 75));
    products.add(new Product(14, "Йогурт", "000000000000", "Компания А", 2.0, 14, 200));
    products.add(new Product(15, "Хлеб", "987654321099", "Компания Б", 1.2, 3, 60));
    products.add(new Product(16, "Молоко", "123456789012", "Компания А", 1.5, 7, 100));
    products.add(new Product(17, "Хлеб", "987654321098", "Компания Б", 1.0, 2, 50));
    products.add(new Product(18, "Молоко", "123456789013", "Компания В", 1.7, 5, 75));
    products.add(new Product(19, "Йогурт", "000000000000", "Компания А", 2.0, 14, 200));
    products.add(new Product(20, "Хлеб", "987654321099", "Компания Б", 1.2, 3, 60));
 
    // a) Список товаров для заданного наименования
    String name = "Молоко";
    System.out.println("a) Список товаров с наименованием '" + name + "':");
    for (Product product : products) {
      if (product.getName().equals(name)) {
        System.out.println(product);
      }
    }

    // b) Список товаров для заданного наименования, цена которых не превосходит
    // заданную
    double maxPrice = 1.5;
    System.out.println("\nb) Список товаров с наименованием '" + name + "' и ценой не более " + maxPrice + ":");
    for (Product product : products) {
      if (product.getName().equals(name)) {
        if (product.getPrice() <= maxPrice) {
          System.out.println(product);
        }
      }
    }

    // c) Список товаров, срок хранения которых больше заданного
    int shelfLife = 5;
    System.out.println("\nc) Список товаров со сроком хранения больше " + shelfLife + " дней:");
    for (Product product : products) {
      if (product.getName().equals(name)) {
        if (product.getRetentionPeriod() > shelfLife) {
          System.out.println(product);
        }
      }
    }
  }

  private static void Task2() {
    circles.add(new Circle(1, 1, 2));
    circles.add(new Circle(2, 2, 3));
    circles.add(new Circle(3, 3, 1));
    circles.add(new Circle(1, 5, 4)); // Не на прямой с предыдущими
    circles.add(new Circle(4, 4, 2.5)); // на прямой с первыми тремя
    circles.add(new Circle(5, 5, 1));

    System.out.println("Группы окружностей с центрами на одной прямой:");
    for (int i = 0; i < circles.size(); i++) {
      for (int j = i + 1; j < circles.size(); j++) {
        for (int k = j + 1; k < circles.size(); k++) {
          if (Circle.areCollinear(circles.get(i), circles.get(j), circles.get(k))) {
            System.out.println(circles.get(i) + ", " + circles.get(j) + ", " + circles.get(k));
          }
        }
      }
    }

    double minArea = Double.MAX_VALUE;
    double maxArea = Double.MIN_VALUE;
    Circle minCircle = null;
    Circle maxCircle = null;

    for (Circle c : circles) {
      double area = c.getArea();
      if (area < minArea) {
        minArea = area;
        minCircle = c;
      }
      if (area > maxArea) {
        maxArea = area;
        maxCircle = c;
      }
    }
    System.out.println("\nОкружность с наименьшей площадью: " + minCircle);
    System.out.println("Окружность с наибольшей площадью: " + maxCircle);

    double minPerimeter = Double.MAX_VALUE;
    double maxPerimeter = Double.MIN_VALUE;
    minCircle = null;
    maxCircle = null;

    for (Circle c : circles) {
      double perimeter = c.getPerimeter();
      if (perimeter < minPerimeter) {
        minPerimeter = perimeter;
        minCircle = c;
      }
      if (perimeter > maxPerimeter) {
        maxPerimeter = perimeter;
        maxCircle = c;
      }
    }
    System.out.println("\nОкружность с наименьшим периметром: " + minCircle);
    System.out.println("Окружность с наибольшим периметром: " + maxCircle);
  }

  private static void Task3() {
    triangles.add(new Triangle(new Point(0, 0), new Point(1, 0), new Point(0.5, Math.sqrt(3) / 2))); // Равносторонний
    triangles.add(new Triangle(new Point(0, 0), new Point(1, 0), new Point(1, 1))); // Прямоугольный
    triangles.add(new Triangle(new Point(0, 0), new Point(1, 1), new Point(2, 0))); // Произвольный
    triangles.add(new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, 1))); // Равнобедренный
    triangles.add(new Triangle(new Point(1, 1), new Point(3, 1), new Point(2, 3))); // Равнобедренный
    triangles.add(new Triangle(new Point(0, 0), new Point(2, 0), new Point(1, 0))); // Вырожденный (площадь = 0)

    Map<String, List<Triangle>> trianglesByType = new HashMap<>();
    for (Triangle triangle : triangles) {
      trianglesByType.computeIfAbsent(triangle.getType(), _ -> new ArrayList<>()).add(triangle);
    }

    for (Map.Entry<String, List<Triangle>> entry : trianglesByType.entrySet()) {
      System.out.println("\nТреугольники типа: " + entry.getKey());
      double minArea = Double.MAX_VALUE;
      double maxArea = Double.MIN_VALUE;
      double minPerimeter = Double.MAX_VALUE;
      double maxPerimeter = Double.MIN_VALUE;
      Triangle minAreaTriangle = null;
      Triangle maxAreaTriangle = null;
      Triangle minPerimeterTriangle = null;
      Triangle maxPerimeterTriangle = null;

      for (Triangle t : triangles) {
        double area = t.getArea();
        double perimeter = t.getPerimeter();
        if (area < minArea) {
          minArea = area;
          minAreaTriangle = t;
        }
        if (area > maxArea) {
          maxArea = area;
          maxAreaTriangle = t;
        }
        if (perimeter < minPerimeter) {
          minPerimeter = perimeter;
          minPerimeterTriangle = t;
        }
        if (perimeter > maxPerimeter) {
          maxPerimeter = perimeter;
          maxPerimeterTriangle = t;
        }
      }

      System.out.println("Наименьшая площадь: " + minArea + "  Треугольник: " + minAreaTriangle);
      System.out.println("Наибольшая площадь: " + maxArea + "  Треугольник: " + maxAreaTriangle);
      System.out.println("Наименьший периметр: " + minPerimeter + "  Треугольник: " + minPerimeterTriangle);
      System.out.println("Наибольший периметр: " + maxPerimeter + "  Треугольник: " + maxPerimeterTriangle);

    }

  }
}
