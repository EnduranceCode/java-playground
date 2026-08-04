package com.endurancecode.e02;

public class Circle extends Shape {
  private final double radius;

  public Circle(double radius) {
    this.radius = radius;
  }

  public double getRadius() {
    return radius;
  }

  @Override
  double calculateArea() {
    return Math.PI * radius * radius;
  }
}
