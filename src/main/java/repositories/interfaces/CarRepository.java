package repositories.interfaces;

import model.car.BaseCar;

import java.util.List;

public interface CarRepository {
    int getCount();

    void add(BaseCar car);

    boolean remove(BaseCar car);

    List<BaseCar> getCars();

    BaseCar find(String manufacturer);
}
