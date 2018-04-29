package data.repositories;

import data.dao.CarsDao;
import models.Car;
import models.Valid;

import javax.inject.Inject;
import java.util.List;

public class CarsWithErrorRepository implements CarsRepository {
    @Inject
    private CarsDao carsDao;

    public int size() {
        return carsDao.size();
    }

    public Valid<Car> select(Long id) {
        return Valid.getInstanceForModel(carsDao.select(id));
    }

    public Valid<List<Car>> selectRange(int offset, int limit) {
        return Valid.getInstanceForModel(
                carsDao.selectRange(
                        offset,
                        limit));
    }

    public long add(Valid<Car> car) {
        return carsDao.add(car.getModel());
    }

    public void delete(long id) {
        carsDao.delete(id);
    }

    public void update(long id, Valid<Car> car) {
        carsDao.update(id, car.getModel());

    }
}
