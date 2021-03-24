package repositories.impl;

import model.BaseVehicle;
import model.VehicleType;
import repositories.VehicleRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleRepositoryImpl implements VehicleRepository {
    private final List<BaseVehicle> vehicles;

    public VehicleRepositoryImpl() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void add(BaseVehicle vehicle) {
        if (vehicle == null){
            throw new IllegalArgumentException("Vehicle cannot be null!");
        }

        boolean contains = this.vehicles.stream()
                .anyMatch(s -> s.getRegistrationNumber().equals(vehicle.getRegistrationNumber()));

        if (contains){
            throw new IllegalArgumentException(String.format("Vehicle %s already exists!",vehicle.getRegistrationNumber()));
        }

        this.vehicles.add(vehicle);
    }

    @Override
    public boolean remove(BaseVehicle vehicle) {
        if (vehicle == null){
            throw new IllegalArgumentException("Vehicle cannot be null!");
        }

        return this.vehicles.remove(vehicle);
    }

    @Override
    public List<BaseVehicle> getVehicles() {
        return this.vehicles;
    }

    @Override
    public BaseVehicle find(String registrationNumber) {
        return this.vehicles
                .stream()
                .filter(v -> v.getRegistrationNumber().equals(registrationNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BaseVehicle> findAll(VehicleType vehicleType) {
        return this.vehicles
                .stream()
                .filter(v -> v.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
    }


}
