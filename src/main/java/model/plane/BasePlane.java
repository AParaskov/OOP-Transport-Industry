package model.plane;

public abstract class BasePlane {
    private String name;
    private int seats;
    private int storageInLitres;

    public BasePlane(String name, int seats, int storageInLitres) {
        this.name = name;
        this.seats = seats;
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

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public int getStorageInLitres() {
        return storageInLitres;
    }

    public void setStorageInLitres(int storageInLitres) {
        this.storageInLitres = storageInLitres;
    }
}
