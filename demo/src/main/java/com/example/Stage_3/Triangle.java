package com.example.Stage_3;

public class Triangle {
  public static class Point {
    double x, y;

    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public String toString() {
      return "(" + x + ", " + y + ")";
    }
  }

  Point a, b, c;

  public Triangle(Point a, Point b, Point c) {
    this.a = a;
    this.b = b;
    this.c = c;
  }

  public double getSideLength(Point p1, Point p2) {
    return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
  }

  public double getPerimeter() {
    double ab = getSideLength(a, b);
    double bc = getSideLength(b, c);
    double ca = getSideLength(c, a);
    return ab + bc + ca;
  }

  public double getArea() {
    double ab = getSideLength(a, b);
    double bc = getSideLength(b, c);
    double ca = getSideLength(c, a);
    double s = (ab + bc + ca) / 2;
    return Math.sqrt(s * (s - ab) * (s - bc) * (s - ca));
  }

  public String getType() {
    double ab = getSideLength(a, b);
    double bc = getSideLength(b, c);
    double ca = getSideLength(c, a);

    if (ab == bc && bc == ca)
      return "Равносторонний";
    if (ab == bc || bc == ca || ca == ab)
      return "Равнобедренный";
    if (Math.abs(ab * ab + bc * bc - ca * ca) < 1e-6 || // Проверка на прямоугольный треугольник с учетом погрешности
        Math.abs(ab * ab + ca * ca - bc * bc) < 1e-6 ||
        Math.abs(bc * bc + ca * ca - ab * ab) < 1e-6)
      return "Прямоугольный";
    return "Произвольный";
  }

  @Override
  public String toString() {
    return "Треугольник: " + a + ", " + b + ", " + c + " - Тип: " + getType();
  }
}
