package controllers.api.v1;

import data.repositories.CarsRepository;
import models.Car;
import models.Valid;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.*;

public class CarsController extends Controller {
    @Inject
    private FormFactory formFactory;

    @Inject
    private CarsRepository carsRepository;

    @Transactional
    public Result index() {
        Valid<List<Car>> carsList = carsRepository.selectAll();

        return ok(Json.toJson(carsList.getModel()));
    }

    @Transactional
    public Result show(long id) {
        Valid<Car> car = carsRepository.select(id);

        return ok(Json.toJson(car.getModel()));
    }

    @Transactional
    public Result create() {
        Valid<Car> car = getRequestCar();
        carsRepository.add(car);

        if (!car.isValid()) {
            return status(UNPROCESSABLE_ENTITY, car.getErrorMessage());
        }

        return redirect(controllers.api.v1.routes.CarsController.index());
    }


    @Transactional
    public Result update(long id) {
        Valid<Car> car = getRequestCar();
        carsRepository.update(id, car);

        if(!car.isValid()) {
            return status(UNPROCESSABLE_ENTITY, car.getErrorMessage());
        }

        return redirect(controllers.api.v1.routes.CarsController.index());
    }

    @Transactional
    public Result delete(long id) {
        carsRepository.delete(id);

        return redirect(controllers.api.v1.routes.CarsController.index());
    }

    private Valid<Car> getRequestCar() {
        try {
            Form<Car> carForm = formFactory.form(Car.class);
            Car car = carForm.bindFromRequest().get();
            return Valid.getInstaceForModel(car);
        } catch (IllegalStateException exception) {
            return Valid.getInstaceForError(exception.getMessage());
        }
    }
}
