package repositories;


import model.BaseVehicle;
import model.VehicleType;
import model.car.BaseCar;
import model.plane.BasePlane;
import model.ship.BaseShip;
import model.train.BaseTrain;

import java.util.List;

public interface VehicleRepository {
    void add(BaseVehicle vehicle);

    boolean remove(BaseVehicle vehicle);

    List<BaseVehicle> getVehicles();

    BaseVehicle find(String id);

    List<BaseVehicle> findAll(VehicleType vehicleType);

    void saveCar(BaseCar baseCar);

    void savePlane(BasePlane basePlane);

    void saveShip(BaseShip baseShip);

    void saveTrain(BaseTrain baseTrain);

    void deleteCar(BaseVehicle baseVehicle);

    void deletePlane(BaseVehicle baseVehicle);

    void deleteShip(BaseVehicle baseVehicle);

    void deleteTrain(BaseVehicle baseVehicle);

}
