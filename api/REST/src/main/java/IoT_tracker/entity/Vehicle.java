package src.main.java.IoT_tracker.entity;
import javax.persistence.*;
import java.util.Date;

/**
 * Created by Goutham on 5/30/2017.
 */

@Entity
@NamedQueries({
        @NamedQuery(name = "Vehicle.findAll",query = "SELECT v FROM Vehicle v")
})

public class Vehicle {
    @Id
    @Column(columnDefinition = "varchar(36)")
    private String vin;
    private String make;
    private String model;
    private int year;
    private int redlineRpm;
    private int maxFuelVol;
    private Date lastServiceDate;

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRedlineRpm() {
        return redlineRpm;
    }

    public void setRedlineRpm(int redlineRpm) {
        this.redlineRpm = redlineRpm;
    }
    public int getMaxFuelVol() {
        return maxFuelVol;
    }

    public void setMaxFuelVol(int maxFuelVol) {
        this.maxFuelVol = maxFuelVol;
    }

    public Date getLastServiceDate() {
        return lastServiceDate;
    }

    public void setLastServiceDate(Date lastServiceDate) {
        this.lastServiceDate = lastServiceDate;
    }
    @Override
    public String toString() {
        return "Vehicle{" +
                "vin='" + vin + '\'' +
                ", make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", redlineRpm=" + redlineRpm +
                ", maxFuelVol=" + maxFuelVol +
                ", lastServiceDate=" + lastServiceDate +
                '}';
    }
}
