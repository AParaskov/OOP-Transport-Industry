package model.ship;

public abstract class BaseShip {
    private String name;
    private int storageInLitres;
    private int crewMembers;

    public BaseShip(String name, int storageInLitres, int crewMembers) {
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

    public void setStorageInLitres(int storageInLitres) {
        this.storageInLitres = storageInLitres;
    }

    public int getCrewMembers() {
        return crewMembers;
    }

    public void setCrewMembers(int crewMembers) {
        this.crewMembers = crewMembers;
    }
}
