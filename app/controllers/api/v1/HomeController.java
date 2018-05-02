package controllers.api.v1;

import data.repositories.cars.CarsRepository;
import models.Car;
import play.db.jpa.Transactional;
import play.mvc.Controller;
import play.mvc.Result;

import javax.inject.Inject;
import java.util.Arrays;
import java.util.List;

public class HomeController extends Controller {

    @Inject
    private CarsRepository carsRepository;

    private static final List<Car> carsList = Arrays.asList(
            newCar("Up", 1L, 2016, "preto"),
            newCar("Punto", 2L, 2008, "verde"),
            newCar("Grand Livina", 1L, 2015, "branco"),
            newCar("Palio", 2L, 1999, "branco"),
            newCar("Scenic", 1L, 2004, "verde"),
            newCar("Celta", 1L, 2004, "branco"),
            newCar("Santana", 2L, 1995, "verde"),
            newCar("Gol", 1L, 1994, "branco"),
            newCar("Monza", 1L, 1992, "verde"),
            newCar("Fusca", 1L, 1988, "branco"),
            newCar("Amarok", 2L, 2018, "preto"),
            newCar("Sandero", 1L, 2011, "preto"),
            newCar("Ranger", 1L, 2018, "verde")
    );

    @Transactional
    public Result seed() {
        for (Car car : carsList) {
            carsRepository.add(car);
        }

        return ok();
    }

    private static Car newCar(String model, long userId, int year, String color) {
        Car car = new Car();
        car.setModel(model);
        car.setUserId(userId);
        car.setYear(year);
        car.setColor(color);

        return car;
    }
}
