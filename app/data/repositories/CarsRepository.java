package data.repositories;

import com.google.inject.ImplementedBy;
import models.Car;
import models.Valid;

import java.util.List;

@ImplementedBy(CarsWithErrorRepository.class)
public interface CarsRepository {

    int size();

    Valid<Car> select(Long id);

    Valid<List<Car>> selectRange(int offset, int limit);

    long add(Valid<Car> car);

    void delete(long id);

    void update(long id, Valid<Car> car);
}