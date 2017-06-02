package src.main.java.IoT_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import src.main.java.IoT_tracker.entity.Alert;
import src.main.java.IoT_tracker.entity.Reading;
import src.main.java.IoT_tracker.entity.Vehicle;
import src.main.java.IoT_tracker.exception.NotFoundException;
import src.main.java.IoT_tracker.repository.AlertRepository;
import src.main.java.IoT_tracker.repository.ReadingRepository;
import src.main.java.IoT_tracker.repository.VehicleRepository;

/**
 * Created by Goutham on 5/31/2017.
 */
public class concreteReadinService implements ReadingService {
    @Autowired
    private ReadingRepository repository;
    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private AlertRepository alertRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Reading> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reading> findReadingsFromVehicle(String vin) { return repository.findReadingsFromVehicle(vin); }

    @Override
    @Transactional
    public Reading create(Reading reading) {
        Vehicle currentVehicle = vehicleRepository.findOne(reading.getVin());
        if(currentVehicle!=null) {
            List<Alert> alerts = getAlerts(reading,currentVehicle);
            for(Alert tempAlert : alerts) {
                alertRepository.create(tempAlert);
            }
        }
        return repository.create(reading);
    }

    @Override
    @Transactional
    public void delete(String readingId) {
        Reading existing = repository.findOne(readingId);
        if (existing == null) {
            throw new NotFoundException("Reading with readingId=" + readingId + " not found");
        }
        repository.delete(existing);
    }


    private List<Alert> getAlerts(Reading reading, Vehicle currentVehicle) {
        List<Alert> result = new ArrayList<Alert>();

        if(reading.getEngineRpm()>currentVehicle.getRedlineRpm()) {
            Alert newAlert = new Alert();
            newAlert.setAlertCreationTime(Calendar.getInstance().getTime());
            newAlert.setVin(reading.getVin());
            newAlert.setAlertCleared(false);
            newAlert.setAlertPriority("HIGH");
            newAlert.setAlertType("Engine RPM");
            result.add(newAlert);
        }

        if(reading.getFuelVolume()< (0.1*currentVehicle.getMaxFuelVol())) {
            Alert newAlert = new Alert();
            newAlert.setAlertCreationTime(Calendar.getInstance().getTime());
            newAlert.setVin(reading.getVin());
            newAlert.setAlertCleared(false);
            newAlert.setAlertPriority("MEDIUM");
            newAlert.setAlertType("Fuel volume");
            result.add(newAlert);
        }

        if(reading.getTires().getFrontLeft()<32 || reading.getTires().getFrontLeft()>36) {
            Alert newAlert = new Alert();
            newAlert.setAlertCreationTime(Calendar.getInstance().getTime());
            newAlert.setVin(reading.getVin());
            newAlert.setAlertCleared(false);
            newAlert.setAlertPriority("LOW");
            newAlert.setAlertType("Front left tire pressure");
            result.add(newAlert);
        }

        if(reading.getTires().getFrontRight()<32 || reading.getTires().getFrontRight()>36) {
            Alert newAlert = new Alert();
            newAlert.setAlertCreationTime(Calendar.getInstance().getTime());
            newAlert.setVin(reading.getVin());
            newAlert.setAlertCleared(false);
            newAlert.setAlertPriority("LOW");
            newAlert.setAlertType("Front right tire pressure");
            result.add(newAlert);
        }

        if(reading.getTires().getRearLeft()<32 || reading.getTires().getRearLeft()>36) {
            Alert newAlert = new Alert();
            newAlert.setAlertCreationTime(Calendar.getInstance().getTime());
            newAlert.setVin(reading.getVin());
            newAlert.setAlertCleared(false);
            newAlert.setAlertPriority("LOW");
            newAlert.setAlertType("Rear left tire pressure");
            result.add(newAlert);
        }

        if(reading.getTires().getRearRight()<32 || reading.getTires().getRearRight()>36) {
            Alert newAlert = new Alert();
            newAlert.setAlertCreationTime(Calendar.getInstance().getTime());
            newAlert.setVin(reading.getVin());
            newAlert.setAlertCleared(false);
            newAlert.setAlertPriority("LOW");
            newAlert.setAlertType("Rear right tire pressure");
            result.add(newAlert);
        }

        if(reading.isCheckEngineLightOn()||reading.isEngineCoolantLow()) {
            Alert newAlert = new Alert();
            newAlert.setAlertCreationTime(Calendar.getInstance().getTime());
            newAlert.setVin(reading.getVin());
            newAlert.setAlertCleared(false);
            newAlert.setAlertPriority("LOW");
            if(reading.isCheckEngineLightOn()) {
                newAlert.setAlertType("Check Engine light on");
            } else  {
                newAlert.setAlertType("Engine coolant low on");
            }
            result.add(newAlert);
        }

        return result;
    }
}
