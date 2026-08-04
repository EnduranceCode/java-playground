package com.endurancecode.e02;

public class Rectangle extends Shape {
  private final double width;
  private final double height;

  public Rectangle(double width, double height) {
    this.width = width;
    this.height = height;
  }

  public double getWidth() {
    return width;
  }

  public double getHeight() {
    return height;
  }

  @Override
  double calculateArea() {
    return width * height;
  }
}
