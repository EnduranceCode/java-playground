package com.endurancecode.e14;

@SuppressWarnings("squid:S106")
public class Main {

  public static final String INPUT_DATA =
      "Login;Name;Email" + System.lineSeparator() + "peterson;Chris Peterson;peterson@outlook.com"
          + System.lineSeparator() + "james;Derek James;james@gmail.com" + System.lineSeparator()
          + "jackson;Walter Jackson;jackson@gmail.com" + System.lineSeparator()
          + "gregory;Mike Gregory;gregory@yahoo.com";

  public static void main(String[] args) {
    System.out.println("===== Convert 1 demo =====");
    System.out.println(convert1(INPUT_DATA));

    System.out.println("===== Convert 2 demo =====");
    System.out.println(convert2(INPUT_DATA));
  }

  public static String convert1(String input) {
    String convertedString = "";

    String[] rawData = getRawData(input);
    for (String row : rawData) {
      String[] rowData = row.split(";");
      convertedString += rowData[0] + " ==> " + rowData[2] + System.lineSeparator();
    }

    return convertedString;
  }


  public static String convert2(String input) {
    String convertedString = "";

    String[] rawData = getRawData(input);
    for (String row : rawData) {
      String[] rowData = row.split(";");
      convertedString += rowData[1] + "(email: " + rowData[2] + ")" + System.lineSeparator();
    }

    return convertedString;
  }

  private static String[] getRawData(String input) {
    String[] split = input.split(System.lineSeparator());

    for (int i = 0; i < split.length; i++) {
      if (split[i].equals("Login;Name;Email")) {
        System.arraycopy(split, i + 1, split, i, split.length - i - 1);
      }
    }

    return split;
  }
}
