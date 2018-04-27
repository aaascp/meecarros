package data.repositories;

import com.google.inject.ImplementedBy;
import models.Car;
import models.Valid;

import java.util.List;

@ImplementedBy(CarsWithErrorRepository.class)
public interface CarsRepository {

    Valid<Car> select(Long id);

    Valid<List<Car>> selectAll();

    void add(Valid<Car> car);

    void delete(long id);

    void update(long id, Valid<Car> car);
}