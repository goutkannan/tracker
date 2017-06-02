package src.main.java.IoT_tracker.controller;

import org.springframework.stereotype.Component;
import src.main.java.IoT_tracker.entity.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import src.main.java.IoT_tracker.service.VehicleService;

import java.util.List;



/**
 * Created by Goutham on 5/30/2017.
 */

@CrossOrigin(origins = "http://mocker.egen.io", maxAge = 3600)
@RestController
@RequestMapping(value = "vehicles")
public class vehicleController {

    @Autowired

    private VehicleService service;

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll() {
        return service.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}",produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Vehicle findOne(@PathVariable("vin") String vehId) {
        return service.findOne(vehId);
    }

    @RequestMapping(method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public void update( @RequestBody List<Vehicle> vehicles) {
        service.upsert(vehicles);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{vin}")
    public void delete(@PathVariable("vin") String vehId) {
        service.delete(vehId);
    }


}
