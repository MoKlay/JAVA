package com.example.Stage_4.Circle;

public class Point {
    double x, y;
    

    // класс Точка
    public Point(double x, double y) {
      this.x = x;
      this.y = y;
    }
  
    
  
    @Override
    public String toString() {
      return "(" + x + ", " + y + ")";
    }



    @Override
    public int hashCode() {
      final int prime = 31;
      int result = 1;
      long temp;
      temp = Double.doubleToLongBits(x);
      result = prime * result + (int) (temp ^ (temp >>> 32));
      temp = Double.doubleToLongBits(y);
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
      Point other = (Point) obj;
      if (Double.doubleToLongBits(x) != Double.doubleToLongBits(other.x))
        return false;
      return Double.doubleToLongBits(y) == Double.doubleToLongBits(other.y);
    }
  }
