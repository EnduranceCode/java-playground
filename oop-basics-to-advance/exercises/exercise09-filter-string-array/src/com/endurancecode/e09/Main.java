package com.endurancecode.e09;

import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@SuppressWarnings("squid:S106")
public class Main {

  private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.print("Please, enter any words separated by space: ");
    String userInput = sc.nextLine();
    System.out.print("Please, enter minimum word length to filter words: ");
    int minLength = sc.nextInt();

    String[] words = userInput.split("\\s+");
    String[] filteredWords = filterWordsByLength(minLength, words);

    LOGGER.log(Level.INFO, "Filtered words: {0}", Arrays.toString(filteredWords));
  }


  public static String[] filterWordsByLength(int minLength, String[] words) {
    return Arrays.stream(words).filter(word -> word.length() >= minLength).toArray(String[]::new);
  }
}
