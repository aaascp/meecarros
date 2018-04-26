package controllers.api.v1;

import com.fasterxml.jackson.databind.JsonNode;
import models.Car;
import play.data.Form;
import play.data.FormFactory;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.*;

public class CarsController extends Controller {
    @Inject
    private FormFactory formFactory;

    private static final Map<Long, Car> carsRepository = new HashMap<>();

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
        Car car = getRequestCar();

        List<Long> indexes = new ArrayList<>(carsRepository.keySet());
        Collections.sort(indexes);

        Long id = 1L;
        if (!indexes.isEmpty()) {
            id = indexes.get(indexes.size() - 1) + 1;
        }

        car.setId(id);
        carsRepository.put(id, car);

        return redirect(controllers.api.v1.routes.CarsController.index());
    }


    public Result update(long id) {
        Car car = getRequestCar();
        carsRepository.put(id, car);

        return redirect(controllers.api.v1.routes.CarsController.index());
    }

    public Result delete(long id) {
        carsRepository.remove(id);

        return redirect(controllers.api.v1.routes.CarsController.index());
    }

    private Car getRequestCar() {
        Form<Car> carForm = formFactory.form(Car.class);
        return carForm.bindFromRequest().get();
    }

}
