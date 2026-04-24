package service;

import model.Car;
import java.util.Set;

import com.google.common.collect.ImmutableSet;

public class CarService {

    public Set<Car> getCars() {

        Car car1 = new Car();
        Car car2 = new Car();

        ImmutableSet<Car> cars = ImmutableSet.<Car>builder()
          .add(car1)
          .add(car2)
          .build();
        return cars;
    }

    public static void main(String[] args) {
        CarService carService = new CarService();
        System.out.println(carService.getCars());

    }
}