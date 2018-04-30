package data.dao.cars;

import models.Car;
import play.Logger;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DbCarsDao implements CarsDao {

    @Inject
    JPAApi jpaApi;

    public long getLastId() {
        return jpaApi.withTransaction(entityManager -> {
            String sql = "select max(car.id) from Car car";
            EntityManager em = jpaApi.em();
            Object maxId = em.createQuery(sql).getSingleResult();
            if (maxId != null) {
                return (Long) maxId;
            } else {
                return 0L;
            }
        });
    }

    @Override
    @SuppressWarnings("unchecked")
    public int size() {
        return jpaApi.withTransaction(entityManager -> {
            String sql = "select count(*) from Car";
            EntityManager em = jpaApi.em();
            List<Long> count = em.createQuery(sql).getResultList();
            if (count != null) {
                return count.get(0).intValue();
            } else {
                return 0;
            }
        });
    }

    @Override
    public Car find(long id) {
        return jpaApi.withTransaction(entityManager ->
                entityManager.find(Car.class, id));
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Car> select(
            long offset,
            int limit,
            OrderBy orderBy) {

        String comparator = orderBy == OrderBy.DESC ? "<=" : ">=";

        return jpaApi.withTransaction(entityManager -> {
            String sql = "FROM Car as c WHERE c.id " +
                    comparator + " " + offset +
                    " ORDER BY c.id " + orderBy;
            EntityManager em = jpaApi.em();
            Query query = em.createQuery(sql)
                    .setMaxResults(limit);

//            query.setParameter("orderBy", orderBy.getValue());
//            query.setParameter("offset", offset);
            List<Car> carsList = query.getResultList();
            return carsList;
        });
    }

    @Override
    public long add(Car car) {
        jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            em.persist(car);
        });
        return car.getId();
    }

    @Override
    public void delete(long id) {
        jpaApi.withTransaction(() -> {
            EntityManager entityManager = jpaApi.em();
            String sql = "delete from Car where id=?1";
            Query query = entityManager.createQuery(sql);
            query.setParameter(1, id);
            query.executeUpdate();
        });
    }

    @Override
    public void update(long id, Car car) {
        car.setId(id);
        jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            em.merge(car);
        });
    }
}