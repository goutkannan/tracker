package src.main.java.IoT_tracker.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import src.main.java.IoT_tracker.entity.Vehicle;
import src.main.java.IoT_tracker.exception.NotFoundException;
import src.main.java.IoT_tracker.repository.VehicleRepository;

import java.util.List;

/**
 * Created by Goutham on 5/31/2017.
 */
@Service
public class concreteVehicleService implements  VehicleService {

    @Autowired
    private VehicleRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Vehicle> findAll() {
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Vehicle findOne(String vin) {
        Vehicle vehicleInstance = repository.findOne(vin);
        if(vehicleInstance == null)
            throw new NotFoundException("No matching vehicle found for vin " + vin);
        return vehicleInstance;
    }

    @Override
    @Transactional
    public Vehicle create(Vehicle v) {
        return repository.create(v);
    }

    @Override
    @Transactional
    public Vehicle update(String id, Vehicle v) {
        Vehicle vehicleInstance = repository.findOne(id);
        if(vehicleInstance == null)
            throw new NotFoundException("No matching vehicle found for vin " + id);
        return repository.update(v);
    }

    @Override
    @Transactional
    public void upsert(List<Vehicle> vehicles) {
        for(Vehicle v :vehicles) {
            Vehicle existing = repository.findOne(v.getVin());
            if (existing == null) {
                repository.create(v);
            } else {
                repository.update(v);
            }
        }
    }

    @Override
    @Transactional
    public void delete(String vin) {
            Vehicle existing = repository.findOne(vin);
            if (existing == null) {
                throw new NotFoundException("Vehicle with vin=" + vin + " not found");
            }
            repository.delete(existing);
    }
}
