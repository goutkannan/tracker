package src.main.java.IoT_tracker.service;
import src.main.java.IoT_tracker.entity.Alert;
import java.util.List;
/**
 * Created by Goutham on 5/31/2017.
 */
public interface AlertService {
    List<Alert> findAll();

    List<Alert> findAlertsFromVehicle(String vin);
}
