package data.dao;

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

    public Car select(Long id) {
        return jpaApi.withTransaction(entityManager ->
                entityManager.find(Car.class, id));
    }

    public List<Car> selectAll() {
        return jpaApi.withTransaction(entityManager -> {
            String sql = "from Car";
            EntityManager em = jpaApi.em();
            Query query = em.createQuery(sql);
            return (List<Car>) query.getResultList();
        });
    }


    public void add(Car car) {
        jpaApi.withTransaction(() -> {
            EntityManager em = jpaApi.em();
            em.persist(car);
        });
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