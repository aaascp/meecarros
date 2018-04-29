package data.dao;

import models.Car;
import play.db.jpa.JPAApi;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class DbCarsDao implements CarsDao {

    @Inject
    JPAApi jpaApi;

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

    public Car select(Long id) {
        return jpaApi.withTransaction(entityManager ->
                entityManager.find(Car.class, id));
    }

    public List<Car> selectRange(int offset, int limit) {
        return jpaApi.withTransaction(entityManager -> {
            String sql = "from Car as c order by c.id desc";
            EntityManager em = jpaApi.em();
            Query query = em.createQuery(sql)
                    .setFirstResult(offset)
                    .setMaxResults(limit);
            List<Car> carsList = query.getResultList();
            return carsList;
        });
    }

    public long add(Car car) {
        jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            em.persist(car);
        });
        return car.getId();
    }

    public void delete(long id) {
        jpaApi.withTransaction(() -> {
            EntityManager entityManager = jpaApi.em();
            String sql = "delete from Car where id=?1";
            Query query = entityManager.createQuery(sql);
            query.setParameter(1, id);
            query.executeUpdate();
        });
    }

    public void update(long id, Car car) {
        jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            em.merge(car);
        });
    }
}