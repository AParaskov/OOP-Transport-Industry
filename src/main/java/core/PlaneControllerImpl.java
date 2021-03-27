package core;

import core.interfaces.PlaneController;
import model.BaseVehicle;
import model.VehicleType;
import model.plane.BasePlane;
import model.plane.CargoPlane;
import model.plane.PassengerPlane;
import repositories.VehicleRepository;
import repositories.impl.VehicleRepositoryImpl;

import java.util.Comparator;
import java.util.List;

public class PlaneControllerImpl implements PlaneController {
    private final VehicleRepository vehicleRepository;

    public PlaneControllerImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public String addPlane(String type, String registrationNumber, String name) {
        BasePlane plane;
        if (type.equals("PassengerPlane")) {
            plane = new PassengerPlane(registrationNumber, name);
        } else {
            plane = new CargoPlane(registrationNumber, name);
        }
        this.vehicleRepository.add(plane);
        this.vehicleRepository.savePlane(plane);

        return String.format("Successfully added plane %s - %s", name, type);
    }

    @Override
    public String removePlane(String registrationNumber) {
        BaseVehicle plane = vehicleRepository.find(registrationNumber);
        vehicleRepository.remove(plane);
        vehicleRepository.deletePlane(plane);
        return String.format("Successfully removed plane - %s", registrationNumber);
    }

    @Override
    public String planesCount() {
        List<BaseVehicle> planes = vehicleRepository.findAll(VehicleType.AIR);
        return String.format("There are %d planes in the database", planes.size());
    }

    @Override
    public void getAllPlanes() {
        if (vehicleRepository.getVehicles()
                .stream()
                .anyMatch(t -> t.getVehicleType().name().equals("AIR"))) {

            List<BaseVehicle> planes = vehicleRepository.findAll(VehicleType.AIR);
            planes.sort(Comparator.comparing(BaseVehicle::getRegistrationNumber));
            System.out.println("List all planes: ");
            for (int i = 0; i < planes.size(); i++) {
                if (i <= planes.size() - 2){
                    System.out.printf("%s, ", planes.get(i).getRegistrationNumber());
                } else {
                    System.out.printf("%s ", planes.get(i).getRegistrationNumber());
                }
            }
            System.out.println();
        } else {
            System.out.println("There are no planes in the database!");
        }
    }
}
