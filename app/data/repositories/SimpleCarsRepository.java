package data.repositories;

import data.dao.CarsDao;
import models.Car;

import javax.inject.Inject;
import java.util.List;

public class SimpleCarsRepository implements CarsRepository {
    @Inject
    private CarsDao carsDao;

    public Car select(Long id) {
        return carsDao.select(id);
    }

    public List<Car> selectAll() {
        return carsDao.selectAll();
    }


    public void add(Car car) {
        carsDao.add(car);
    }

    public void delete(long id) {
        carsDao.delete(id);
    }

    public void update(long id, Car car) {
        carsDao.update(id, car);
    }
}
