package com.endurancecode.e03;

public class Square extends Shape {

  private int side;

  public Square(int side) {
    if (side <= 0) {
      throw new IllegalArgumentException("Invalid side value");
    }

    this.side = side;
  }

  @Override
  public int calculateArea() {
    return side * side;
  }

  public int getSide() {
    return side;
  }

  public void setSide(int side) {
    if (side <= 0) {
      throw new IllegalArgumentException("Invalid side value");
    }

    this.side = side;
  }
}
