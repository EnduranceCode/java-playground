package com.endurancecode.e16;

import java.util.Scanner;

@SuppressWarnings("squid:S106")
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    mainLoop:
    while (true) {
      System.out.print(
          "Please, select mode. If you want to convert Roman " + "numbers to decimal - type 'R2D' and press enter."
              + System.lineSeparator()
              + "If you want to convert decimal numbers to Roman - type 'D2R' and press enter: ");

      String mode = sc.next();
      if (mode.equalsIgnoreCase("R2D")) {
        while (true) {
          System.out.print("Please, enter Roman number you want to convert: ");
          String romanNumber = sc.next();
          if (isRomanNumberValid(romanNumber)) {
            System.out.println(roman2Decimal(romanNumber));
            break mainLoop;
          } else {
            System.out.println("You entered invalid Roman number. " + "Please, try one more time.");
            continue;
          }
        }
      } else if (mode.equalsIgnoreCase("D2R")) {
        while (true) {
          System.out.print("Please, enter decimal number " + "you want to convert: ");
          int decimalNumber = sc.nextInt();
          if (isDecimalNumberValid(decimalNumber)) {
            System.out.println(decimal2Roman(decimalNumber));
            break mainLoop;
          } else {
            System.out.println("Please, enter positive integer from 1 to 100.");
            continue;
          }
        }
      }

      System.out.println("Please, enter 'R2D' or 'D2R.");
    }
  }


  /**
   * Converts decimal numbers to Roman.
   *
   * Takes int value as a parameter. Works only with numbers from 1 to 100.
   *
   * @param number to convert to Roman.
   * @return string of Roman number.
   */
  public static String decimal2Roman(int number) {
    String[] a = new String[]{"I", "IV", "V", "IX", "X", "XL", "L", "XC", "C"};
    int[] b = new int[]{1, 4, 5, 9, 10, 40, 50, 90, 100};
    StringBuilder s = new StringBuilder();
    for (int i = a.length - 1; i >= 0; i--) {
      while (number >= b[i]) {
        s.append(a[i]);
        number -= b[i];
      }
    }
    return s.toString();
  }

  /**
   * Converts Roman numbers to decimal.
   *
   * Takes string value with Roman number as a parameter.
   *
   * At first method validates if input string could be Roman number. After method
   * uses algorithm to convert Roman numeral to decimal.
   *
   * @param romanNumber
   * @return decimal representation of Roman number
   */

  public static int roman2Decimal(String romanNumber) {
    String normalizedInput = romanNumber.trim().toUpperCase();

    char[] charArray = normalizedInput.toCharArray();

    int[] decimalArray = new int[charArray.length];
    for (int i = 0; i < charArray.length; i++) {
      switch (charArray[i]) {
        case 'I':
          decimalArray[i] = 1;
          break;
        case 'V':
          decimalArray[i] = 5;
          break;
        case 'X':
          decimalArray[i] = 10;
          break;
        case 'L':
          decimalArray[i] = 50;
          break;
        case 'C':
          decimalArray[i] = 100;
          break;
        case 'D':
          decimalArray[i] = 500;
          break;
        case 'M':
          decimalArray[i] = 1000;
          break;
        default:
          break;
      }
    }

    for (int i = 0; i < decimalArray.length; i++) {

      if (i < decimalArray.length - 1 && decimalArray[i] < decimalArray[i + 1]) {
        decimalArray[i] = -1 * decimalArray[i];
      }
    }

    int value = 0;
    for (int j : decimalArray) {
      value += j;
    }

    return value;
  }


  /**
   * Validation for Roman numbers.
   *
   * Use regular expression which is checking if string really could be Roman
   * number.
   *
   * @param romanNumber
   * @return true if String is Roman number
   */
  public static boolean isRomanNumberValid(String romanNumber) {
    String normalizedInput = romanNumber.trim().toUpperCase();
    return normalizedInput.matches("^(?=[MDCLXVI])M{0,3}(C[MD]|D?C{0,3})(X[CL]|L?X{0,3})(I[XV]|V?I{0,3})$");
  }

  public static boolean isDecimalNumberValid(int decimalNumber) {
    return decimalNumber >= 1 && decimalNumber <= 100;
  }
}
