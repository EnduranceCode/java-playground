package com.endurancecode.playground;

import com.endurancecode.playground.stateless.LibrarySessionBeanRemote;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBTester {

    private static final Logger LOGGER = Logger.getLogger(EJBTester.class.getName());

    private static final String JNDI_NAME = "ejb:/ejb-library/LibrarySessionBean!com.endurancecode.playground.stateless.LibrarySessionBeanRemote";

    private static final int UI_SCREEN_WIDTH = 100;
    private static final String UI_LINE_BREAK = "\n";
    private static final String UI_TAB = "\t";
    private static final String UI_WHITE_SPACE = " ";
    private static final String UI_VERTICAL_CHAR = "|";
    private static final String UI_SEPARATOR_CHAR = "-";
    private static final String UI_HEADER = "Welcome to Book Store";
    private static final String UI_BOOK_PROMPT = "Enter book name: ";
    private static final String UI_INVALID_CHOICE = "Invalid choice. Please try again.";

    BufferedReader bufferedConsoleReader;
    Properties properties;
    InitialContext context;

    {
        properties = new Properties();
        try (InputStream jndiInputStream = getClass().getClassLoader().getResourceAsStream("jndi.properties")) {
            if (jndiInputStream == null) {
                throw new FileNotFoundException("jndi.properties not found in classpath");
            }
            properties.load(jndiInputStream);
        } catch (IOException exception) {
            LOGGER.log(Level.SEVERE, "Failed to load jndi.properties", exception);
        }

        try {
            context = new InitialContext(properties);
        } catch (NamingException exception) {
            LOGGER.log(Level.SEVERE, "Failed to create InitialContext", exception);
        }
        bufferedConsoleReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public static void main(String[] args) {

        EJBTester ejbTester = new EJBTester();
        ejbTester.testStatelessEjb();
    }

    private void showGUI() {
        String header = String.join(
                UI_WHITE_SPACE, UI_VERTICAL_CHAR, UI_HEADER, generateUiSpaces(UI_SCREEN_WIDTH - UI_HEADER.length() - 5),
                UI_VERTICAL_CHAR
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

    private String generateUiSeparator(int n) {
        return UI_SEPARATOR_CHAR.repeat(Math.max(0, n));
    }

    private String generateUiSpaces(int n) {
        return UI_WHITE_SPACE.repeat(Math.max(0, n));
    }

    private void listBooks(List<String> books, boolean hasInitialLineBreak) {
        if (hasInitialLineBreak) {
            System.out.print(UI_LINE_BREAK);
            System.out.println(generateUiSeparator(UI_SCREEN_WIDTH));
        }
        System.out.println("Book(s) entered so far: " + books.size());
        System.out.println(generateUiSeparator(UI_SCREEN_WIDTH).concat(UI_LINE_BREAK));

        books.stream().map(book -> (books.indexOf(book) + 1) + ". " + book).forEach(System.out::println);

        System.out.print(UI_LINE_BREAK);
    }

    private void testStatelessEjb() {
        try {
            int choice = 1;

            LibrarySessionBeanRemote libraryBeanFirstLookup = (LibrarySessionBeanRemote) context.lookup(JNDI_NAME);

            while (true) {
                showGUI();

                String strChoice = bufferedConsoleReader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print(UI_LINE_BREAK.concat(UI_BOOK_PROMPT));
                    String bookName = bufferedConsoleReader.readLine();
                    libraryBeanFirstLookup.addBook(bookName);
                    System.out.print(UI_LINE_BREAK);
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println(UI_INVALID_CHOICE.concat(UI_LINE_BREAK));
                }
            }

            List<String> booksFromFirstLookup = libraryBeanFirstLookup.getBooks();
            listBooks(booksFromFirstLookup, true);

            LibrarySessionBeanRemote libraryBeanSecondLookup = (LibrarySessionBeanRemote) context.lookup(JNDI_NAME);
            List<String> booksFromSecondLookup = libraryBeanSecondLookup.getBooks();

            System.out.println(generateUiSeparator(UI_SCREEN_WIDTH));
            System.out.println("Using second lookup to get library stateless object");
            listBooks(booksFromSecondLookup, false);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            LOGGER.log(Level.SEVERE, "Exception occurred in testStatelessEjb", exception);
        } finally {
            try {
                if (bufferedConsoleReader != null) {
                    bufferedConsoleReader.close();
                }
            } catch (IOException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
}
