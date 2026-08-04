package com.endurancecode.e04;

import java.util.logging.Logger;

public class Robot implements Workable {

  private static final Logger LOGGER = Logger.getLogger(Robot.class.getName());

  @Override
  public void work() {
    LOGGER.info("Robot is working");
  }
}
