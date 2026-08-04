package com.endurancecode.e01;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
    String username = "john_doe";
    String password = "Password123";

    if (UserRegistration.registerUser(username, password)) {
      LOGGER.log(Level.INFO, "User {0} registered successfully.", username);
    } else {
      LOGGER.log(Level.INFO, "User {0} registration failed.", username);
    }

    if (UserAuthenticator.authenticateUser(username, password)) {
      LOGGER.log(Level.INFO, "User {0} logged in successfully.", username);
    } else {
      LOGGER.log(Level.INFO, "Invalid username or password for user {0}.", username);
    }
  }
}
