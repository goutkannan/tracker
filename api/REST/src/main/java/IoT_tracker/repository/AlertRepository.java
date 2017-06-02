package src.main.java.IoT_tracker.repository;
import java.util.List;
import  src.main.java.IoT_tracker.entity.Alert;

/**
 * Created by Goutham on 5/31/2017.
 */
public interface AlertRepository {
    List<Alert> findAll();

    List<Alert> findAlertsFromVehicle(String vin);

    Alert create(Alert alert);
}
