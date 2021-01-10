package Lexicon.CarStillPlusJson.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;


import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Car implements Serializable {
    private final UUID carid = UUID.randomUUID();
    private String regnnumber;
    private String brand;
    private String Model;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
   private LocalDate regnstnDate  ;

   @JsonBackReference
    private Owner owner;

    public Car() {

    }

    public Car(String regnnumber, String brand, String model, LocalDate regnstnDate) {
        this.regnnumber = regnnumber;
        this.brand = brand;
        Model = model;
        this.regnstnDate = regnstnDate;

    }

    public UUID getCarid() {
        return carid;
    }

    public String getRegnnumber() {
        return regnnumber;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return Model;
    }

    public LocalDate getRegnstnDate() {
        return regnstnDate;
    }

    public Owner getOwner() {
        return owner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Car)) return false;
        Car car = (Car) o;
        return getCarid().equals(car.getCarid()) && getRegnnumber().equals(car.getRegnnumber()) && getBrand().equals(car.getBrand()) && getModel().equals(car.getModel()) && getRegnstnDate().equals(car.getRegnstnDate()) && getOwner().equals(car.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCarid(), getRegnnumber(), getBrand(), getModel(), getRegnstnDate(), getOwner());
    }

    public void setRegnnumber(String regnnumber) {
        this.regnnumber = regnnumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        Model = model;
    }


    @Override
    public String toString() {
        return "Car{" +
                "carid=" + carid +
                ", regnnumber='" + regnnumber + '\'' +
                ", brand='" + brand + '\'' +
                ", Model='" + Model + '\'' +
                ", regnstnDate=" + regnstnDate +
                '}';
    }
}
