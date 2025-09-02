package com.endurancecode.playground.bean;

import com.endurancecode.playground.bean.persistence.LibraryPersistenceSessionBeanRemote;
import com.endurancecode.playground.entity.Book;
import com.endurancecode.playground.ui.UIGenerator;
import jakarta.jms.ConnectionFactory;
import jakarta.jms.JMSContext;
import jakarta.jms.Queue;
import java.io.BufferedReader;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;

public class MessageConnection {

    private static final Logger LOGGER = Logger.getLogger(MessageConnection.class.getName());

    private static final String JNDI_NAME_PERSISTENCE_BEAN = "ejb:/ejb-library/LibraryPersistenceSessionBean!com.endurancecode.playground.bean.persistence.LibraryPersistenceSessionBeanRemote";
    private static final String BEAN_TYPE = "Message EJB";

    private MessageConnection() {
        super();
    }

    public static void testMessageEjbConnection(InitialContext context, BufferedReader reader) {

        try {
            String username = context.getEnvironment().get("java.naming.security.principal").toString();
            String password = context.getEnvironment().get("java.naming.security.credentials").toString();

            int choice;

            Queue queue = (Queue) context.lookup("jms/queue/BookQueue");
            ConnectionFactory factory = (ConnectionFactory) context.lookup("jms/RemoteConnectionFactory");

            LibraryPersistenceSessionBeanRemote libraryBean = (LibraryPersistenceSessionBeanRemote) context.lookup(
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

                    try (JMSContext jmsContext = factory.createContext(username, password)) {
                        jmsContext.createProducer().send(queue, book);
                    }

                    System.out.print(UIGenerator.UI_LINE_BREAK);
                } else if (choice == 2) {
                    break;
                } else {
                    System.out.println(UIGenerator.UI_INVALID_CHOICE.concat(UIGenerator.UI_LINE_BREAK));
                }
            }

            List<String> booksFromFirstLookup = libraryBean.getBooks();
            UIGenerator.listBooks(booksFromFirstLookup, true);
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
            LOGGER.log(Level.SEVERE, "Exception occurred in testMessageEjbConnection", exception);
        }
    }
}
