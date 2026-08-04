package com.endurancecode.e05;

public class Main {

  public static void main(String[] args) {
    Car gasolineCar = new Car(new GasolineEngine());
    gasolineCar.start();
    Car electricCar = new Car(new ElectricEngine());
    electricCar.start();
  }
}
