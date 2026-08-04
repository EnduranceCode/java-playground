package com.endurancecode.e06;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("squid:S106")
public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please, enter integer numbers separated by space: ");

    String userInput = sc.nextLine();
    String[] strArray = userInput.split(" ");
    int[] intArray = new int[strArray.length];
    for (int i = 0; i < strArray.length; i++) {
      intArray[i] = Integer.parseInt(strArray[i]);
    }
    int maxInt = findMaxIntInArray(intArray);

    LOGGER.log(Level.INFO, "Initial Array: {0}", Arrays.toString(intArray));
    LOGGER.log(Level.INFO, "Max number in array: {0}", maxInt);
  }


  public static int findMaxIntInArray(int[] intArray) {

    if (intArray.length == 0) {
      throw new IllegalArgumentException("Array is empty");
    }

    int maxInt = Integer.MIN_VALUE;

    for (int item : intArray) {
      if (item > maxInt) {
        maxInt = item;
      }
    }

    return maxInt;
  }
}
