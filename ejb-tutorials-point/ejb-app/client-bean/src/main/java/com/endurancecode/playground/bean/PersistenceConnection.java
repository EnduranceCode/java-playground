package com.endurancecode.playground.bean;

import com.endurancecode.playground.bean.persistence.LibraryPersistenceSessionBeanRemote;
import com.endurancecode.playground.entity.Book;
import com.endurancecode.playground.ui.UIGenerator;
import java.io.BufferedReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

public class PersistenceConnection {

    private static final Logger LOGGER = Logger.getLogger(PersistenceConnection.class.getName());

    private static final String JNDI_NAME_PERSISTENCE_BEAN = "ejb:/ejb-library/LibraryPersistenceSessionBean!com.endurancecode.playground.bean.persistence.LibraryPersistenceSessionBeanRemote";
    private static final String BEAN_TYPE = "Persistence EJB";

    private PersistenceConnection() {
        super();
    }

    public static void testPersistenceEjbConnection(InitialContext context, BufferedReader reader) {
        try {
            int choice;

            LibraryPersistenceSessionBeanRemote libraryBeanFirstLookup = (LibraryPersistenceSessionBeanRemote) context.lookup(
                    JNDI_NAME_PERSISTENCE_BEAN);

            while (true) {
                UIGenerator.showUI(BEAN_TYPE);

                String strChoice = reader.readLine();
                choice = Integer.parseInt(strChoice);
                if (choice == 1) {
                    System.out.print(UIGenerator.UI_LINE_BREAK.concat(UIGenerator.UI_BOOK_PROMPT));
                    String bookName = reader.readLine();
                    Book book = new Book();
                    book.setName(bookName);
                    libraryBeanFirstLookup.addBook(book);
                    System.out.print(UIGenerator.UI_LINE_BREAK);
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println(UIGenerator.UI_INVALID_CHOICE.concat(UIGenerator.UI_LINE_BREAK));
                }
            }

            List<String> booksFromFirstLookup = libraryBeanFirstLookup.getBooks();
            UIGenerator.listBooks(booksFromFirstLookup, true);

            LibraryPersistenceSessionBeanRemote libraryBeanSecondLookup = (LibraryPersistenceSessionBeanRemote) context.lookup(
                    JNDI_NAME_PERSISTENCE_BEAN);
            List<String> booksFromSecondLookup = libraryBeanSecondLookup.getBooks();

            System.out.println(UIGenerator.generateUiSeparator(UIGenerator.UI_SCREEN_WIDTH));
            System.out.println("Using second lookup to get library persistence object");
            UIGenerator.listBooks(booksFromSecondLookup, false);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            LOGGER.log(Level.SEVERE, "Exception occurred in testPersistenceEjbConnection", exception);
        }
    }
}
