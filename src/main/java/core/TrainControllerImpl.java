package core;

import core.interfaces.TrainController;
import model.BaseVehicle;

import model.VehicleType;
import model.train.BaseTrain;
import model.train.CargoTrain;
import model.train.PassengerTrain;

import repositories.impl.VehicleRepositoryImpl;
import repositories.VehicleRepository;

import java.util.Comparator;
import java.util.List;

public class TrainControllerImpl implements TrainController {
    private final VehicleRepository vehicleRepository;

    public TrainControllerImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public String addTrain(String type, String registrationNumber, String id) {
        BaseTrain train;
        if (type.equals("PassengerTrain")) {
            train = new PassengerTrain(registrationNumber, id);
        } else {
            train = new CargoTrain(registrationNumber, id);
        }
        this.vehicleRepository.add(train);
        this.vehicleRepository.saveTrain(train);

        return String.format("Successfully added train %s - %s", id, type);
    }

    @Override
    public String removeTrain(String registrationNumber) {
        BaseVehicle train = vehicleRepository.find(registrationNumber);
        vehicleRepository.remove(train);
        vehicleRepository.deleteTrain(train);
        return String.format("Successfully removed train - %s", registrationNumber);
    }

    @Override
    public String trainsCount() {
        List<BaseVehicle> trains = vehicleRepository.findAll(VehicleType.RAIL);
        return String.format("There are %d trains in the database", trains.size());
    }

    @Override
    public void getAllTrains() {
        if (vehicleRepository.getVehicles()
                .stream()
                .anyMatch(t -> t.getVehicleType().name().equals("RAIL"))) {


            List<BaseVehicle> trains = vehicleRepository.findAll(VehicleType.RAIL);
            trains.sort(Comparator.comparing(BaseVehicle::getRegistrationNumber));
            System.out.println("List all trains: ");
            for (int i = 0; i < trains.size(); i++) {
                    if (i <= trains.size() - 2){
                        System.out.printf("%s, ", trains.get(i).getRegistrationNumber());
                    } else {
                        System.out.printf("%s ", trains.get(i).getRegistrationNumber());
                    }
            }
            System.out.println();
        } else {
            System.out.println("There are no trains in the database!");
        }
    }

}
