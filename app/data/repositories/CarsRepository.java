package data.repositories;

import com.google.inject.ImplementedBy;
import models.Car;

import java.util.List;

@ImplementedBy(SimpleCarsRepository.class)
public interface CarsRepository {

    Car select(Long id);

    List<Car> selectAll();

    void add(Car car);

    void delete(long id);

    void update(long id, Car car);
}