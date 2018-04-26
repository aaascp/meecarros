package controllers.api.v1;

import com.fasterxml.jackson.databind.JsonNode;
import models.Car;
import play.Logger;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.*;

public class CarsController extends Controller {
    @Inject
    FormFactory formFactory;

    private static final Map<Long, Car> carsRepository = new HashMap<>();
    static {
        carsRepository.put(
                1L,
                new Car(1, 1, "Punto", 2008, "Vermelho"));
    }

    public Result index() {
        List<Car> carsList = new ArrayList<>(carsRepository.values());

        return ok(Json.toJson(carsList));
    }

    public Result show(long id) {
        Car car = carsRepository.get(id);
        JsonNode carJson = Json.toJson(car);

        return ok(carJson);
    }

    public Result create() {
        Form<Car> carForm = formFactory.form(Car.class);
        Car car = carForm.bindFromRequest().get();

        List<Long> indexes = new ArrayList<>(carsRepository.keySet());
        Collections.sort(indexes);

        Long id = 0L;
        if (!indexes.isEmpty()) {
            id = indexes.get(indexes.size() - 1) + 1;
        }

        car.setId(id);

        carsRepository.put(id, car);
        List<Car> carsList = new ArrayList<>(carsRepository.values());
        return ok(Json.toJson(carsList));
    }


    public Result update(long id) {
        Form<Car> carForm = formFactory.form(Car.class);
        Car car = carForm.bindFromRequest().get();

        carsRepository.put(id, car);
        List<Car> carsList = new ArrayList<>(carsRepository.values());

        return ok(Json.toJson(carsList));
    }

    public Result delete(long id) {
        carsRepository.remove(id);
        List<Car> carsList = new ArrayList<>(carsRepository.values());

        return ok(Json.toJson(carsList));
    }

}
