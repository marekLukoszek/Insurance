package eu.lukoszek.insurance.car;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Car {
    @NotNull
    private String model;
    @NotNull
    private String brand;
    @NotNull
    @Size(min=10)
    private String vin;
    @NotNull
    @RegNumberConstraint
    private String registrationNumber;

    public Car(String model, String brand, String vin, String registrationNumber) {
        this.model = model;
        this.brand = brand;
        this.vin = vin;
        this.registrationNumber = registrationNumber;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }
}
