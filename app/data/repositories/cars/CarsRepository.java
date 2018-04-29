package data.repositories.cars;

import com.google.inject.ImplementedBy;
import data.Repository;
import models.Car;


@ImplementedBy(DbCarsRepository.class)
public interface CarsRepository extends Repository<Car> {
    long add(Car item);

    void delete(long id);

    void update(long id, Car car);
}

