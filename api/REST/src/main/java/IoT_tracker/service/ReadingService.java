package src.main.java.IoT_tracker.service;
import src.main.java.IoT_tracker.entity.Reading;
import java.util.List;
/**
 * Created by Goutham on 5/31/2017.
 */
public interface ReadingService {
    List<Reading> findAll();

    List<Reading> findReadingsFromVehicle(String vin);

    Reading create(Reading reading);

    void delete(String readingId);

}
