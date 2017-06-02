package src.main.java.IoT_tracker.repository;

/**
 * Created by Goutham on 5/31/2017.
 */
import src.main.java.IoT_tracker.entity.Vehicle;
import java.util.List;

public interface VehicleRepository {

    List<Vehicle> findAll();
    Vehicle findOne(String vin);
    Vehicle create(Vehicle v);
    Vehicle update(Vehicle v);
    void delete(Vehicle v);


}
