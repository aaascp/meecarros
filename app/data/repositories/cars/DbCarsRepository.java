package data.repositories.cars;

import data.dao.cars.CarsDao;
import models.Car;

import javax.inject.Inject;
import java.util.List;

public class DbCarsRepository implements CarsRepository {

    @Inject
    private CarsDao dao;

    public long getLastId() {
        return dao.getLastId();
    }

    public int size() {
        return dao.size();
    }

    public Car find(long id) {
        return dao.find(id);
    }

    public List<Car> select(long offset, int limit, CarsDao.OrderBy orderBy) {
        return dao.select(
                offset,
                limit,
                orderBy);
    }

    public long add(Car car) {
        return dao.add(car);
    }

    public void delete(long id) {
        dao.delete(id);
    }

    public void update(long id, Car car) {
        dao.update(id, car);
    }
}
