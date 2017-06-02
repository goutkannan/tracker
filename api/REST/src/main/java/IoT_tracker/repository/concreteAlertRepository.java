package src.main.java.IoT_tracker.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import src.main.java.IoT_tracker.entity.Alert;

/**
 * Created by Goutham on 5/31/2017.
 */
@Repository
public class concreteAlertRepository implements AlertRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Alert> findAll() {
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findAll", Alert.class);
        return query.getResultList();
    }

    @Override
    public List<Alert> findAlertsFromVehicle(String vin) {
        TypedQuery<Alert> query = em.createNamedQuery("Alert.findByVin", Alert.class);
        query.setParameter("pVin", vin);
        return query.getResultList();
    }

    @Override
    public Alert create(Alert alert) {
        em.persist(alert);
        return alert;
    }
}