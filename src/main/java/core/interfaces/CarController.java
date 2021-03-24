package core.interfaces;

public interface CarController {
    String addCar(String type, String registrationNumber, String manufacturer);
    String removeCar(String registrationNumber);
    String carsCount();
    void getAllCars();
}
