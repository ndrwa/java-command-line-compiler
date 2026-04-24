package service;

import model.Car;
import java.util.Set;

import org.apache.commons.lang3.text.WordUtils;
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

        carService.whenCapitalized_thenCorrect();
    }

    public void whenCapitalized_thenCorrect() {
        String toBeCapitalized = "to be capitalized!";
        String result = WordUtils.capitalize(toBeCapitalized);

        System.out.println(toBeCapitalized);
        System.out.println(result);
    }
}