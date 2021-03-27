package model.train;

import model.BaseVehicle;
import model.VehicleType;

public abstract class BaseTrain extends BaseVehicle {
    private String name;
    private final int seats;
    private final int storageInLitres;

    public BaseTrain(String registrationNumber, String name, int seats, int storageInLitres) {
        super(registrationNumber, VehicleType.RAIL);
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

    public int getSeats() {
        return seats;
    }

    public int getStorageInLitres() {
        return storageInLitres;
    }
}
