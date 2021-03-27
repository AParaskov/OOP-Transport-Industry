package model.ship;

import model.BaseVehicle;
import model.VehicleType;

public abstract class BaseShip extends BaseVehicle {
    private String name;
    private final int storageInLitres;
    private final int crewMembers;

    public BaseShip(String registrationNumber, String name, int storageInLitres, int crewMembers) {
        super(registrationNumber, VehicleType.WATER);
        this.name = name;
        this.storageInLitres = storageInLitres;
        this.crewMembers = crewMembers;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStorageInLitres() {
        return storageInLitres;
    }

    public int getCrewMembers() {
        return crewMembers;
    }
}
