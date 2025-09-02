package com.endurancecode.playground;

import com.endurancecode.playground.bean.MessageConnection;
import com.endurancecode.playground.bean.PersistenceConnection;
import com.endurancecode.playground.bean.StatefulConnection;
import com.endurancecode.playground.bean.StatelessConnection;
import com.endurancecode.playground.ui.UIGenerator;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EJBClient {

    private static final Logger LOGGER = Logger.getLogger(EJBClient.class.getName());

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

        EJBClient ejbClient = new EJBClient();
        ejbClient.testEjbConnections();
    }

    private void testEjbConnections() {
        int choice;

        UIGenerator.showConnectionsMenu();

        try {
            String strChoice = bufferedConsoleReader.readLine();
            choice = Integer.parseInt(strChoice);

            switch (choice) {
                case 1:
                    StatelessConnection.testStatelessEjbConnection(context, bufferedConsoleReader);
                    break;
                case 2:
                    StatefulConnection.testStatefulEjbConnection(context, bufferedConsoleReader);
                    break;
                case 3:
                    PersistenceConnection.testPersistenceEjbConnection(context, bufferedConsoleReader);
                    break;
                case 4:
                    MessageConnection.testMessageEjbConnection(context, bufferedConsoleReader);
                    break;
                default:
                    System.out.println("Exiting application.");
                    System.exit(0);
            }
        } catch (IOException exception) {
            System.out.println(exception.getMessage());
            LOGGER.log(Level.SEVERE, "Exception occurred in testEjbConnections", exception);
        } finally {
            if (bufferedConsoleReader != null) {
                try {
                    bufferedConsoleReader.close();
                } catch (IOException exception) {
                    LOGGER.log(Level.SEVERE, "Failed to close BufferedReader", exception);
                }
            }
        }
    }
}
