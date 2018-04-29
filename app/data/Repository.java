package data;

import data.dao.cars.CarsDao;


import java.util.List;

public interface Repository<T> {

    int size();

    long getLastId();

    T find(long id);

    List<T> select(long offset, int limit, CarsDao.OrderBy orderBy);
}
