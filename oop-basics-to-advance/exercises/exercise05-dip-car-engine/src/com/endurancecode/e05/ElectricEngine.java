package com.endurancecode.e05;

import java.util.logging.Logger;

public class ElectricEngine implements Engine {

  private static final Logger LOGGER = Logger.getLogger(ElectricEngine.class.getName());

  @Override
  public void start() {

    LOGGER.info("Electric engine started.");
  }
}
