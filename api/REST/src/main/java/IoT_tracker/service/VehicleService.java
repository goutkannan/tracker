/**
 * Created by Goutham on 5/31/2017.
 */

package src.main.java.IoT_tracker.service;

import src.main.java.IoT_tracker.entity.Vehicle;
import java.util.List;


public interface VehicleService {
    List<Vehicle> findAll();

    Vehicle findOne(String vin);

    Vehicle create(Vehicle v);

    Vehicle update(String id, Vehicle v);

    void upsert(List<Vehicle> vehicles);

    void delete(String vin);
}
