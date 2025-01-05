import java.util.ArrayList;

public class DealershipApp {
	public static void main (String[] args) {
		Car car = new Car();
		car.make = "Peugeot";
		car.model = "5008";
		car.year = 2012;

		Dealership dealer = new Dealership();
		dealer.addCar(car);

		dealer.showCars();
	}
}

class Car {
       	String make;
        String model;
       	int year;
}

class Dealership {
        ArrayList<Car> cars = new ArrayList<>();

        public void addCar (Car car) {
                cars.add(car);
        }

        public void removeCar (Car car)  {
                cars.remove(car);
        }

        public void showCars() {
                for (Car car : cars) {
                        System.out.println(
                                "Make:  " + car.make + "\n" +
                                "Model: " + car.model + "\n" +
                                "Year:  " + car.year
                         );
                }
        }
}
