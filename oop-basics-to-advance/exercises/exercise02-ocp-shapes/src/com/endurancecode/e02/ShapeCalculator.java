package com.endurancecode.e02;

import java.util.List;

public class ShapeCalculator {

  public double calculateTotalArea(List<Shape> shapes) {
    double area = 0.0;

    if (shapes == null || shapes.isEmpty()) {
      return area;
    }

    for (Shape shape : shapes) {
      if (shape != null) {
        area += shape.calculateArea();
      }
    }
    return area;
  }
}
