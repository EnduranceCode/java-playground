package com.endurancecode.e03;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Shape rectangle = new Rectangle(6, 6);
        Shape square = new Square(6);

        LOGGER.log(Level.INFO, "Area of rectangle: {0}", rectangle.calculateArea());
        LOGGER.log(Level.INFO, "Area of square: {0}", square.calculateArea());
    }
}
