package com.endurancecode.e07;

import java.util.Scanner;

@SuppressWarnings("squid:S106")
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please, enter height of rectangle: ");
    int height = sc.nextInt();
    System.out.print("Please, enter width of rectangle: ");
    int width = sc.nextInt();

    drawRectangle(height, width);
  }

  public static void drawRectangle(int height, int width) {

    if (height < 2) {
      throw new IllegalArgumentException("Height must be greater than or equal to 2");
    }

    if (width < 2) {
      throw new IllegalArgumentException("Width must be greater than or equal to 2");
    }

    String topBottomLine = "*".repeat(width);
    String middleLines = "*" + " ".repeat(width - 2) + "*";

    System.out.println(topBottomLine);
    for (int i = 0; i < height - 2; i++) {
      System.out.println(middleLines);
    }
    System.out.println(topBottomLine);
  }
}
