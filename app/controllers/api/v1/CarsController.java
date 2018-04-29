package controllers.api.v1;

import data.repositories.CarsRepository;
import models.Car;
import models.Valid;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;
import utils.LinkHeaderHelper;

import javax.inject.Inject;
import java.util.*;

public class CarsController extends Controller {
    @Inject
    private FormFactory formFactory;

    @Inject
    private CarsRepository carsRepository;

    private static final int DEFAULT_ADJUSTMENT = 0;
    private static final int DEFAULT_OFFSET = 0;
    private static final int DEFAULT_LIMIT = 5;
    private static final int MAX_LIMIT = 100;

    @Transactional
    public Result index() {
        LinkHeaderHelper linkHelper =
                new LinkHeaderHelper(
                        request().host(),
                        request().path(),
                        request().secure());

        int adjustment = parseInt(
                request().getQueryString("adjustment"),
                DEFAULT_ADJUSTMENT);

        int offset = parseInt(
                request().getQueryString("offset"),
                DEFAULT_OFFSET);

        int limit = parseInt(
                request().getQueryString("limit"),
                DEFAULT_LIMIT);

        limit = limit < MAX_LIMIT ? limit : MAX_LIMIT;
        Valid<List<Car>> carsList =
                carsRepository.selectRange(
                        offset + adjustment,
                        limit);

        return ok(Json.toJson(carsList.getModel()))
                .withHeader(
                        "Link",
                        linkHelper.getLinkHeader(
                                carsRepository.size(),
                                offset + adjustment,
                                limit
                        ));
    }

    @Transactional
    public Result show(long id) {
        Valid<Car> car = carsRepository.select(id);

        return ok(Json.toJson(car.getModel()));
    }

    @Transactional
    public Result create() {
        Valid<Car> car = getRequestCar();
        long id = carsRepository.add(car);

        if (!car.isValid()) {
            return status(UNPROCESSABLE_ENTITY, Json.toJson(car.getErrors()));
        }

        return redirect(controllers.api.v1.routes.CarsController.show(id));
    }


    @Transactional
    public Result update(long id) {
        Valid<Car> car = getRequestCar();
        carsRepository.update(id, car);

        if (!car.isValid()) {
            return status(UNPROCESSABLE_ENTITY, Json.toJson(car.getErrors()));
        }

        return redirect(controllers.api.v1.routes.CarsController.show(id));
    }

    @Transactional
    public Result delete(long id) {
        carsRepository.delete(id);

        return ok();
    }

    private Valid<Car> getRequestCar() {
        Form<Car> carForm = formFactory.form(Car.class);
        try {
            Car car = carForm.bindFromRequest().get();
            return Valid.getInstanceForModel(car);
        } catch (IllegalStateException exception) {
            return Valid.getInstanceForError(carForm.allErrors());
        }
    }

    private int parseInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception ignored) {
            return defaultValue;
        }
    }
}
