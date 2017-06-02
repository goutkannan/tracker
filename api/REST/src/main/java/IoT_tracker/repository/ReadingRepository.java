package src.main.java.IoT_tracker.repository;
import  src.main.java.IoT_tracker.entity.Reading;
import java.util.List;
/**
 * Created by Goutham on 5/31/2017.
 */
public interface ReadingRepository {
    List<Reading> findAll();

    Reading findOne(String readingId);

    List<Reading> findReadingsFromVehicle(String vin);

    Reading create(Reading reading);

    void delete(Reading reading);
}
