package com.endurancecode.e03;

public class Rectangle extends Shape {

  private int width;
  private int height;

  public Rectangle(int width, int height) {
    if (width <= 0) {
      throw new IllegalArgumentException("Invalid width value");
    }

    if (height <= 0) {
      throw new IllegalArgumentException("Invalid height value");
    }

    this.width = width;
    this.height = height;
  }

  @Override
  public int calculateArea() {
    return width  * height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    if (width <= 0) {
      throw new IllegalArgumentException("Invalid width value");
    }

    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    if (height <= 0) {
      throw new IllegalArgumentException("Invalid height value");
    }

    this.height = height;
  }
}
