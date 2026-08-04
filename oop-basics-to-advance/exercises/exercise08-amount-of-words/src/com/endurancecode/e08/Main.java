package com.endurancecode.e08;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("squid:S106")
public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please, enter any text: ");

    String userInput = sc.nextLine();
    int amountOfWords = getWordsAmount(userInput);

    LOGGER.log(Level.INFO, "Amount of words in your text: {0}", amountOfWords);
  }

  private static int getWordsAmount(String text) {
    if (text == null || text.isEmpty()) {
      return 0;
    }
    String[] words = text.trim().split("\\s+");
    return words.length;
  }
}
