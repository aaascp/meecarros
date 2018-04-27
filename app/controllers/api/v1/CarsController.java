package controllers.api.v1;

import data.repositories.CarsRepository;
import models.Car;
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
        List<Car> carsList = carsRepository.selectAll();

        return ok(Json.toJson(carsList));
    }

    @Transactional
    public Result show(long id) {
        Car car = carsRepository.select(id);

        return ok(Json.toJson(car));
    }

    @Transactional
    public Result create() {
        Car car = getRequestCar();
        carsRepository.add(car);

        return redirect(controllers.api.v1.routes.CarsController.index());
    }


    @Transactional
    public Result update(long id) {
        Car car = getRequestCar();
        carsRepository.update(id, car);

        return redirect(controllers.api.v1.routes.CarsController.index());
    }

    @Transactional
    public Result delete(long id) {
        carsRepository.delete(id);

        return redirect(controllers.api.v1.routes.CarsController.index());
    }

    private Car getRequestCar() {
        Form<Car> carForm = formFactory.form(Car.class);
        return carForm.bindFromRequest().get();
    }

}
