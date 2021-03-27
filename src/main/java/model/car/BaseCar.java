package model.car;

import model.BaseVehicle;
import model.VehicleType;

public abstract class BaseCar extends BaseVehicle {
    private String manufacturer;
    private final int storageInLitres;
    private final String fuelType;

    public BaseCar(String registrationNumber, String manufacturer, int storageInLitres, String fuelType) {
        super(registrationNumber, VehicleType.ROAD);
        this.manufacturer = manufacturer;
        this.storageInLitres = storageInLitres;
        this.fuelType = fuelType;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getStorageInLitres() {
        return storageInLitres;
    }

    public String getFuelType() {
        return fuelType;
    }
}
