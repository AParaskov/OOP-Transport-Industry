package model.train;

import model.BaseVehicle;
import model.VehicleType;

public abstract class BaseTrain extends BaseVehicle {
    private String id;
    private final int seats;
    private final int storageInLitres;

    public BaseTrain(String registrationNumber, String id, int seats, int storageInLitres) {
        super(registrationNumber, VehicleType.RAIL);
        this.id = id;
        this.seats = seats;
        this.storageInLitres = storageInLitres;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
