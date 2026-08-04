package com.endurancecode.e13;

import java.util.Scanner;

@SuppressWarnings("squid:S106")
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please, enter integer: ");
    int number = sc.nextInt();

    int sumOfDigits = sumDigitsInNumber(number);
    System.out.println(sumOfDigits);
  }

  public static int sumDigitsInNumber(int number) {
    number = Math.abs(number);

    String numberString = String.valueOf(number);

    return numberString.chars().map(Character::getNumericValue).sum();
  }
}
