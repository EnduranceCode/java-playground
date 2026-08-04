package com.endurancecode.e12;

import java.util.Scanner;

@SuppressWarnings("squid:S106")
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please, enter two numbers separated by space: ");
    String userInput = sc.nextLine();

    String[] inputArgumentsArray = userInput.split("\\s+");
    int number1 = Integer.parseInt(inputArgumentsArray[0]);
    int number2 = Integer.parseInt(inputArgumentsArray[1]);

    System.out.println(gcdRecursive(number1, number2));
  }

  public static int gcdRecursive(int firstNumber, int secondNumber) {
    firstNumber = Math.abs(firstNumber);
    secondNumber = Math.abs(secondNumber);

    int bigger;
    int smaller;

    if (firstNumber > secondNumber) {
      bigger = firstNumber;
      smaller = secondNumber;
    } else {
      bigger = secondNumber;
      smaller = firstNumber;
    }

    if (bigger % smaller == 0) {
      return smaller;
    } else {
      return gcdRecursive(smaller, bigger % smaller);
    }
  }
}
