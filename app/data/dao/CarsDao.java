package data.dao;

import com.google.inject.ImplementedBy;
import models.Car;

import java.util.List;

@ImplementedBy(DbCarsDao.class)
public interface CarsDao {

    Car select(Long id);

    List<Car> selectAll();

    void add(Car car);

    void delete(long id);

    void update(long id, Car car);
}
