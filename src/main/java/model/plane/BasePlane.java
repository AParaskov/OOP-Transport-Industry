package model.plane;

import model.BaseVehicle;
import model.VehicleType;

public abstract class BasePlane extends BaseVehicle {
    private String name;
    private final int seats;
    private final int storageInLitres;

    public BasePlane(String registrationNumber, String name, int seats, int storageInLitres) {
        super(registrationNumber, VehicleType.AIR);
        this.name = name;
        this.seats = seats;
        this.storageInLitres = storageInLitres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
