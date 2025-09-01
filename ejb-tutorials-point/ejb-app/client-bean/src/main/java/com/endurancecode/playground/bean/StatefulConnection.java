package com.endurancecode.playground.bean;

import com.endurancecode.playground.bean.stateful.LibraryStatefulSessionBeanRemote;
import com.endurancecode.playground.ui.UIGenerator;
import java.io.BufferedReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

public final class StatefulConnection {

    private static final Logger LOGGER = Logger.getLogger(StatefulConnection.class.getName());

    private static final String JNDI_NAME_STATEFUL_BEAN = "ejb:/ejb-library/LibraryStatefulSessionBean!com.endurancecode.playground.bean.stateful.LibraryStatefulSessionBeanRemote";
    private static final String BEAN_TYPE = "Stateful EJB";

    private StatefulConnection() {
        super();
    }

    public static void testStatefulEjbConnection(InitialContext context, BufferedReader reader) {
        try {
            int choice;

            LibraryStatefulSessionBeanRemote libraryBeanFirstLookup = (LibraryStatefulSessionBeanRemote) context.lookup(
                    JNDI_NAME_STATEFUL_BEAN);

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

            LibraryStatefulSessionBeanRemote libraryBeanSecondLookup = (LibraryStatefulSessionBeanRemote) context.lookup(
                    JNDI_NAME_STATEFUL_BEAN);
            List<String> booksFromSecondLookup = libraryBeanSecondLookup.getBooks();

            System.out.println(UIGenerator.generateUiSeparator(UIGenerator.UI_SCREEN_WIDTH));
            System.out.println("Using second lookup to get library stateful object");
            UIGenerator.listBooks(booksFromSecondLookup, false);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            LOGGER.log(Level.SEVERE, "Exception occurred in testStatefulEjbConnection", exception);
        }
    }
}
