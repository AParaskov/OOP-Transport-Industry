package repositories;

import model.car.BaseCar;
import repositories.interfaces.CarRepository;

import java.util.ArrayList;
import java.util.List;

public class CarRepositoryImpl implements CarRepository {
    private List<BaseCar> cars;

    public CarRepositoryImpl() {
        this.cars = new ArrayList<>();
    }


    @Override
    public int getCount() {
        return this.cars.size();
    }

    @Override
    public void add(BaseCar car) {
        if (car == null){
            throw new IllegalArgumentException("Car cannot be null!");
        }

        boolean contains = this.cars.stream()
                .anyMatch(c -> c.getManufacturer().equals(car.getManufacturer()));

        if (contains){
            throw new IllegalArgumentException(String.format("Car %s already exists!",car.getManufacturer()));
        }

        this.cars.add(car);

    }

    @Override
    public boolean remove(BaseCar car) {
        if (car == null){
            throw new IllegalArgumentException("Car cannot be null!");
        }

        return this.cars.remove(car);
    }

    @Override
    public List<BaseCar> getCars() {
        return this.cars;
    }

    @Override
    public BaseCar find(String manufacturer) {
        return this.cars
                .stream()
                .filter(c -> c.getManufacturer().equals(manufacturer))
                .findFirst()
                .orElse(null);
    }
}
