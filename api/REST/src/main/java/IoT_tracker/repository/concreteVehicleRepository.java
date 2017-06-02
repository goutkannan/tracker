package src.main.java.IoT_tracker.repository;

import org.springframework.stereotype.Repository;
import src.main.java.IoT_tracker.entity.Vehicle;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * Created by Goutham on 5/31/2017.
 */
@Repository
public class concreteVehicleRepository implements VehicleRepository  {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Vehicle> findAll() {
        TypedQuery<Vehicle> query = em.createNamedQuery("Vehicle.findAll",Vehicle.class);

        return query.getResultList();
    }

    @Override
    public Vehicle findOne(String vin) {
        return em.find(Vehicle.class, vin);
    }

    @Override
    public Vehicle create(Vehicle v) {
        em.persist(v);
        return v;
    }

    @Override
    public Vehicle update(Vehicle v) {
        return em.merge(v);
    }

    @Override
    public void delete(Vehicle v) {
        em.remove(v);
    }
}
