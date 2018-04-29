package controllers.api.v1;

import controllers.annotations.paged.LinkHeaderHelper;
import controllers.annotations.paged.Paged;
import data.dao.cars.CarsDao;
import data.repositories.cars.CarsRepository;
import models.Car;
import play.data.Form;
import play.data.FormFactory;
import play.db.jpa.Transactional;
import play.libs.Json;
import play.mvc.*;

import javax.inject.Inject;
import java.util.*;

import static controllers.annotations.paged.PagedActionAnnotation.LINK_HEADER_HELPER_TAG;

public class CarsController extends Controller {
    @Inject
    private FormFactory formFactory;

    @Inject
    private CarsRepository carsRepository;

    @Transactional
    @Paged(CarsRepository.class)
    public Result index() {

        LinkHeaderHelper linkHeaderHelper =
                (LinkHeaderHelper) ctx().args.get(LINK_HEADER_HELPER_TAG);

        long offset = linkHeaderHelper.getOffset();
        int limit = linkHeaderHelper.getLimit();

        List<Car> carsList =
                carsRepository.select(offset, limit, CarsDao.OrderBy.DESC);

        return ok(Json.toJson(carsList));
    }

    @Transactional
    public Result show(long id) {
        Car car = carsRepository.find(id);

        return ok(Json.toJson(car));
    }

    @Transactional
    @Paged(CarsRepository.class)
    public Result create() {
        Optional<Car> car = getRequestCar();

        if (!car.isPresent()) {
            return status(UNPROCESSABLE_ENTITY);
        }

        long id = carsRepository.add(car.get());
        return redirect(controllers.api.v1.routes.CarsController.show(id));
    }


    @Transactional
    public Result update(long id) {
        Optional<Car> car = getRequestCar();

        if (!car.isPresent()) {
            return status(UNPROCESSABLE_ENTITY);
        }

        carsRepository.update(id, car.get());
        return redirect(controllers.api.v1.routes.CarsController.show(id));
    }

    @Transactional
    @Paged(CarsRepository.class)
    public Result delete(long id) {
        carsRepository.delete(id);

        return ok();
    }

    private Optional<Car> getRequestCar() {
        Form<Car> carForm = formFactory.form(Car.class);
        try {
            Car car = carForm.bindFromRequest().get();
            return Optional.of(car);
        } catch (IllegalStateException exception) {
            return Optional.empty();
        }
    }

}
