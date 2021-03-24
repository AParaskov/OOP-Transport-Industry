package core;

import core.interfaces.ShipController;
import model.BaseVehicle;
import model.VehicleType;
import model.ship.CruiseShip;
import model.ship.MilitaryShip;
import repositories.VehicleRepository;
import repositories.impl.VehicleRepositoryImpl;

import java.util.Comparator;
import java.util.List;

public class ShipControllerImpl implements ShipController {
    private final VehicleRepository vehicleRepository;

    public ShipControllerImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public String addShip(String type, String registrationNumber, String name) {
        BaseVehicle ship;
        if (type.equals("CruiseShip")) {
            ship = new CruiseShip(registrationNumber, name);
        } else {
            ship = new MilitaryShip(registrationNumber, name);
        }
        this.vehicleRepository.add(ship);

        return String.format("Successfully added ship %s - %s", name, type);
    }

    @Override
    public String removeShip(String registrationNumber) {
        BaseVehicle ship = vehicleRepository.find(registrationNumber);
        vehicleRepository.remove(ship);
        return String.format("Successfully removed ship - %s", registrationNumber);
    }

    @Override
    public String shipsCount() {
        List<BaseVehicle> ships = vehicleRepository.findAll(VehicleType.WATER);
        return String.format("There are %d ships in the database", ships.size());
    }

    @Override
    public void getAllShips() {
        if (vehicleRepository.getVehicles()
                .stream()
                .anyMatch(t -> t.getVehicleType().name().equals("WATER"))) {

            List<BaseVehicle> ships = vehicleRepository.findAll(VehicleType.WATER);
            ships.sort(Comparator.comparing(BaseVehicle::getRegistrationNumber));
            System.out.println("List all ships: ");
            for (int i = 0; i < ships.size(); i++) {
                if (i <= ships.size() - 2){
                    System.out.printf("%s, ", ships.get(i).getRegistrationNumber());
                } else {
                    System.out.printf("%s ", ships.get(i).getRegistrationNumber());
                }
            }
            System.out.println();
        } else {
            System.out.println("There are no ships in the database!");
        }
    }
}
