package src.main.java.IoT_tracker.service;

/**
 * Created by Goutham on 5/31/2017.
 */
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import src.main.java.IoT_tracker.repository.AlertRepository;
import src.main.java.IoT_tracker.entity.Alert;


public class concreteAlertService implements AlertService {
    @Autowired
    private AlertRepository alertRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Alert> findAll() {
        return alertRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Alert> findAlertsFromVehicle(String vin) { return alertRepository.findAlertsFromVehicle(vin); }
}
