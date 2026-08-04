package com.endurancecode.e05;

import java.util.logging.Logger;

public class GasolineEngine implements Engine {

  private static final Logger LOGGER = Logger.getLogger(GasolineEngine.class.getName());

  @Override
  public void start() {

    LOGGER.info("Gasoline engine started.");
  }
}
