package com.endurancecode.playground;

import com.endurancecode.playground.bean.PersistenceConnection;
import com.endurancecode.playground.bean.StatefulConnection;
import com.endurancecode.playground.bean.StatelessConnection;
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
        try {
            StatelessConnection.testStatelessEjbConnection(context, bufferedConsoleReader);
            StatefulConnection.testStatefulEjbConnection(context, bufferedConsoleReader);
            PersistenceConnection.testPersistenceEjbConnection(context, bufferedConsoleReader);
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
