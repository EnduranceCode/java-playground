package com.endurancecode.e01;

public class UserRegistration {

  public static boolean registerUser(String username, String password) {
    return UserValidator.validateUsername(username) && UserValidator.validatePassword(password);
  }
}
