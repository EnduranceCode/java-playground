package com.endurancecode.e02;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());
    private static final List<Shape> shapes = new ArrayList<>();

    static {
        shapes.add(new Circle(6));
        shapes.add(new Rectangle(6, 6));
    }

    public static void main(String[] args) {
        ShapeCalculator calculator = new ShapeCalculator();
        LOGGER.log(Level.INFO, "Total Area: {0}", calculator.calculateTotalArea(shapes));
    }
}
