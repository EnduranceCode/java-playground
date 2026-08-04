package com.endurancecode.e05;

public class Car {

  private Engine engine;

  public Car(Engine engine) {
    this.engine = engine;
  }

  public void start() {
    this.engine.start();
  }

  public Engine getEngine() {
    return engine;
  }

  public void setEngine(Engine engine) {
    this.engine = engine;
  }
}
