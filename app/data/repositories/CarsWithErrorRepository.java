package data.repositories;

import data.dao.CarsDao;
import models.Car;
import models.Valid;

import javax.inject.Inject;
import java.util.List;

public class CarsWithErrorRepository implements CarsRepository {
    @Inject
    private CarsDao carsDao;

    public Valid<Car> select(Long id) {
        return Valid.getInstanceForModel(carsDao.select(id));
    }

    public Valid<List<Car>> selectAll() {
        return Valid.getInstanceForModel(carsDao.selectAll());
    }

    public void add(Valid<Car> car) {
        if (car.isValid()) {
            carsDao.add(car.getModel());
        }
    }

    public void delete(long id) {
        carsDao.delete(id);
    }

    public void update(long id, Valid<Car> car) {
        if (car.isValid()) {
            carsDao.update(id, car.getModel());
        }
    }
}
