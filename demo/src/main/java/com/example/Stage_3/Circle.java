package com.example.Stage_3;

public class Circle {
  double x, y; // Координаты центра
  double radius;

  public Circle(double x, double y, double radius) {
    this.x = x;
    this.y = y;
    this.radius = radius;
  }

  public double getArea() {
    return Math.PI * radius * radius;
  }

  public double getPerimeter() {
    return 2 * Math.PI * radius;
  }

  @Override
  public String toString() {
    return "Circle{" +
        "x=" + x +
        ", y=" + y +
        ", radius=" + radius +
        '}';
  }

  // Метод для определения, лежат ли три точки на одной прямой (для упрощения, не
  // учитываем коллинеарность)
  public static boolean areCollinear(Circle c1, Circle c2, Circle c3) {
    // Используем формулу площади треугольника: если площадь равна 0, точки
    // коллинеарны.
    return Math.abs(c1.x * (c2.y - c3.y) + c2.x * (c3.y - c1.y) + c3.x * (c1.y - c2.y)) < 1e-6; // 1e-6 - для учета
                                                                                                // погрешности
                                                                                                // вычислений
  }
}
