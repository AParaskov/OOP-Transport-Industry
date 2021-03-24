package model;

import java.util.Objects;

public abstract class BaseVehicle{
    private String registrationNumber;
    private VehicleType vehicleType;


    public BaseVehicle(String registrationNumber, VehicleType vehicleType) {
        this.registrationNumber = registrationNumber;
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseVehicle that = (BaseVehicle) o;
        return registrationNumber.equals(that.registrationNumber);

    }

    @Override
    public int hashCode() {
        return Objects.hash(registrationNumber);
    }
}
