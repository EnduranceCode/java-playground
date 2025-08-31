package com.endurancecode.playground.beans;

import com.endurancecode.playground.stateless.LibrarySessionBeanRemote;
import com.endurancecode.playground.ui.UIGenerator;
import java.io.BufferedReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

public final class StatelessConnection {

    private static final Logger LOGGER = Logger.getLogger(StatelessConnection.class.getName());

    private static final String JNDI_NAME_STATELESS_BEAN = "ejb:/ejb-library/LibrarySessionBean!com.endurancecode.playground.stateless.LibrarySessionBeanRemote";
    private static final String BEAN_TYPE = "Stateless EJB";

    private StatelessConnection() {
        super();
    }

    public static void testStatelessEjbConnection(InitialContext context, BufferedReader reader) {
        try {
            int choice;

            LibrarySessionBeanRemote libraryBeanFirstLookup = (LibrarySessionBeanRemote) context.lookup(
                    JNDI_NAME_STATELESS_BEAN);

            while (true) {
                UIGenerator.showUI(BEAN_TYPE);

                String strChoice = reader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print(UIGenerator.UI_LINE_BREAK.concat(UIGenerator.UI_BOOK_PROMPT));
                    String bookName = reader.readLine();
                    libraryBeanFirstLookup.addBook(bookName);
                    System.out.print(UIGenerator.UI_LINE_BREAK);
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println(UIGenerator.UI_INVALID_CHOICE.concat(UIGenerator.UI_LINE_BREAK));
                }
            }

            List<String> booksFromFirstLookup = libraryBeanFirstLookup.getBooks();
            UIGenerator.listBooks(booksFromFirstLookup, true);

            LibrarySessionBeanRemote libraryBeanSecondLookup = (LibrarySessionBeanRemote) context.lookup(
                    JNDI_NAME_STATELESS_BEAN);
            List<String> booksFromSecondLookup = libraryBeanSecondLookup.getBooks();

            System.out.println(UIGenerator.generateUiSeparator(UIGenerator.UI_SCREEN_WIDTH));
            System.out.println("Using second lookup to get library stateless object");
            UIGenerator.listBooks(booksFromSecondLookup, false);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            LOGGER.log(Level.SEVERE, "Exception occurred in testStatelessEjbConnection", exception);
        }
    }
}
