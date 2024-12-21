package com.example.Stage_4.Circle;


public class Circle {
  
  Point center;
  double radius;

  public Circle(Point center, double radius) {
    this.center = center;
    this.radius = radius;
  }

  // Метод класса Circle: задание размеров (конструктор уже делает это)
  public void setSize(Point newCenter, double newRadius) { // принадлежность методу Circle: изменяет свойства объекта
                                                           // Circle
    this.center = newCenter;
    this.radius = newRadius;
  }

  // Метод класса Circle: изменение радиуса
  public void changeRadius(double newRadius) { // принадлежность методу Circle: изменяет свойство объекта Circle
    this.radius = newRadius;
  }

  // Метод класса Circle: определение принадлежности точки данному кругу
  public boolean contains(Point p) { // принадлежность методу Circle: работает с точкой и свойствами объекта Circle
    double distance = Math.sqrt(Math.pow(p.x - center.x, 2) + Math.pow(p.y - center.y, 2));
    return distance <= radius;
  }

  

  @Override
  public String toString() {
    return "Circle{" +
        "center=" + center +
        ", radius=" + radius +
        '}';
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((center == null) ? 0 : center.hashCode());
    long temp;
    temp = Double.doubleToLongBits(radius);
    result = prime * result + (int) (temp ^ (temp >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    Circle other = (Circle) obj;
    if (center == null) {
      if (other.center != null)
        return false;
    } else if (!center.equals(other.center))
      return false;
    return Double.doubleToLongBits(radius) == Double.doubleToLongBits(other.radius);
  }
}
