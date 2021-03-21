package core.interfaces;

public interface CarController {
    String addCar(String type, String manufacturer);
    String removeCar(String manufacturer);
    String carsCount();
    void getAllCars();
}
