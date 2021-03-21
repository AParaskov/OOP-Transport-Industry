package model.train;

public abstract class BaseTrain {
    private String id;
    private int seats;
    private int storageInLitres;

    public BaseTrain(String id, int seats, int storageInLitres) {
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
