package data.dao;

import com.google.inject.ImplementedBy;
import models.Car;

import java.util.List;

@ImplementedBy(DbCarsDao.class)
public interface CarsDao {

    int size();

    Car select(Long id);

    List<Car> selectRange(int offset, int limit);

    long add(Car car);

    void delete(long id);

    void update(long id, Car car);
}
