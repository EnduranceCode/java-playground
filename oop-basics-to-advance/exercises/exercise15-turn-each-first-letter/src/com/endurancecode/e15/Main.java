package com.endurancecode.e15;

import java.util.Scanner;

@SuppressWarnings("squid:S106")
public class Main {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please, enter any text: ");
    String userInput = sc.nextLine();

    System.out.println(firstCharToTitleCase(userInput));
  }

  public static String firstCharToTitleCase(String string) {
    string = string.toLowerCase();
    String[] words = string.trim().split(" ");

    String output = "";
    for (String word : words) {
      if (!word.isEmpty()) {
        word = word.substring(0, 1).toUpperCase() + word.substring(1);
      }
      output = String.join(" ", output, word);
    }

    return output;
  }
}
