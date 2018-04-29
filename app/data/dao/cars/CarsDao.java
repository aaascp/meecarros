package data.dao.cars;

import com.google.inject.ImplementedBy;
import models.Car;

import java.util.List;

@ImplementedBy(DbCarsDao.class)
public interface CarsDao {

    long getLastId();

    int size();

    Car find(long id);

    List<Car> select(long offset, int limit, OrderBy orderBy);

    long add(Car car);

    void delete(long id);

    void update(long id, Car car);

    enum OrderBy {
        ASC("asc"), DESC("desc");

        private String value;

        OrderBy(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

}
