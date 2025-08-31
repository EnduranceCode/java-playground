package com.endurancecode.playground.ui;

import java.util.List;
import java.util.stream.IntStream;

public final class UIGenerator {

    public static final int UI_SCREEN_WIDTH = 100;
    public static final String UI_LINE_BREAK = "\n";
    private static final String UI_TAB = "\t";
    private static final String UI_WHITE_SPACE = " ";
    private static final String UI_VERTICAL_CHAR = "|";
    private static final String UI_SEPARATOR_CHAR = "-";
    private static final String UI_HEADER = "Welcome to Book Store";
    public static final String UI_BOOK_PROMPT = "Enter book name: ";
    public static final String UI_INVALID_CHOICE = "Invalid choice. Please try again.";

    public static void showUI(String beanType) {
        String header = String.join(
                UI_WHITE_SPACE, UI_VERTICAL_CHAR, UI_HEADER, UI_SEPARATOR_CHAR, beanType,
                generateUiSpaces(UI_SCREEN_WIDTH - UI_HEADER.length() - beanType.length() - 8), UI_VERTICAL_CHAR
        );
        String options = String.join(
                UI_LINE_BREAK, "Options".concat(UI_LINE_BREAK), UI_TAB.concat("1. Add Book"), UI_TAB.concat("2. Exit"),
                UI_LINE_BREAK.concat("Enter Choice: ")
        );

        System.out.println(generateUiSeparator(UI_SCREEN_WIDTH));
        System.out.println(header);
        System.out.println(generateUiSeparator(UI_SCREEN_WIDTH).concat(UI_LINE_BREAK));
        System.out.print(options);
    }

    public static void listBooks(List<String> books, boolean hasInitialLineBreak) {
        if (hasInitialLineBreak) {
            System.out.print(UI_LINE_BREAK);
            System.out.println(generateUiSeparator(UI_SCREEN_WIDTH));
        }
        System.out.println("Book(s) entered so far: " + books.size());
        System.out.println(generateUiSeparator(UI_SCREEN_WIDTH).concat(UI_LINE_BREAK));

        IntStream.range(0, books.size()).mapToObj(i -> (i + 1) + ". " + books.get(i)).forEach(System.out::println);

        System.out.print(UI_LINE_BREAK);
    }

    public static String generateUiSeparator(int n) {
        return UI_SEPARATOR_CHAR.repeat(Math.max(0, n));
    }

    private static String generateUiSpaces(int n) {
        return UI_WHITE_SPACE.repeat(Math.max(0, n));
    }

}
