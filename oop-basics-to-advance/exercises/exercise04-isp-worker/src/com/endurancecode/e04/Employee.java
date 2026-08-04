package com.endurancecode.e04;

import java.util.logging.Logger;

public class Employee implements Workable, Eatable, Sleepable {

  private static final Logger LOGGER = Logger.getLogger(Employee.class.getName());


  @Override
  public void work() {
    LOGGER.info("Employee is working");
  }

  @Override
  public void eat() {
    LOGGER.info("Employee is eating");
  }

  @Override
  public void sleep() {
    LOGGER.info("Employee is sleeping");
  }
}
