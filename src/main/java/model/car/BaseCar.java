package model.car;

public abstract class BaseCar {
    private String manufacturer;
    private int storageInLitres;
    private String fuelType;

    public BaseCar(String manufacturer, int storageInLitres, String fuelType) {
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

    public void setStorageInLitres(int storageInLitres) {
        this.storageInLitres = storageInLitres;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }
}
