package repositories;


import model.BaseVehicle;
import model.VehicleType;

import java.util.List;

public interface VehicleRepository {
    void add(BaseVehicle vehicle);

    boolean remove(BaseVehicle vehicle);

    List<BaseVehicle> getVehicles();

    BaseVehicle find(String id);

    List<BaseVehicle> findAll(VehicleType vehicleType);
}
