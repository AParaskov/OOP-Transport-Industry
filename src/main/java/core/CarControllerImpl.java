package core;

import core.interfaces.CarController;
import model.BaseVehicle;
import model.VehicleType;
import model.car.AllRoadCar;
import model.car.SportsCar;

import repositories.VehicleRepository;
import repositories.impl.VehicleRepositoryImpl;

import java.util.Comparator;
import java.util.List;

public class CarControllerImpl implements CarController {
    private final VehicleRepository vehicleRepository;

    public CarControllerImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public String addCar(String type, String registrationNumber, String manufacturer) {
        BaseVehicle car;
        if (type.equals("SportsCar")) {
            car = new SportsCar(registrationNumber, manufacturer);
        } else {
            car = new AllRoadCar(registrationNumber, manufacturer);
        }
        this.vehicleRepository.add(car);

        return String.format("Successfully added car %s - %s", manufacturer, type);
    }

    @Override
    public String removeCar(String registrationNumber) {
        BaseVehicle car = vehicleRepository.find(registrationNumber);
        vehicleRepository.remove(car);
        return String.format("Successfully removed car - %s", registrationNumber);
    }


    @Override
    public String carsCount() {
        List<BaseVehicle> cars = vehicleRepository.findAll(VehicleType.ROAD);
        return String.format("There are %d cars in the database", cars.size());
    }


    @Override
    public void getAllCars() {
        if (vehicleRepository.getVehicles()
                .stream()
                .anyMatch(t -> t.getVehicleType().name().equals("ROAD"))) {

            List<BaseVehicle> cars = vehicleRepository.findAll(VehicleType.ROAD);
            cars.sort(Comparator.comparing(BaseVehicle::getRegistrationNumber));
            System.out.println("List all cars: ");
            for (int i = 0; i < cars.size(); i++) {
                if (i <= cars.size() - 2){
                    System.out.printf("%s, ", cars.get(i).getRegistrationNumber());
                } else {
                    System.out.printf("%s ", cars.get(i).getRegistrationNumber());
                }
            }
            System.out.println();
        } else {
            System.out.println("There are no cars in the database!");
        }
    }

}

