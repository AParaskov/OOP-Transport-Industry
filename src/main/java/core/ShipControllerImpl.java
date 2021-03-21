package core;

import core.interfaces.ShipController;
import model.ship.BaseShip;
import model.ship.CruiseShip;
import model.ship.MilitaryShip;
import repositories.ShipRepositoryImpl;
import repositories.interfaces.ShipRepository;

public class ShipControllerImpl implements ShipController {
    private final ShipRepository shipRepository;

    public ShipControllerImpl() {
        this.shipRepository = new ShipRepositoryImpl();
    }

    @Override
    public String addShip(String type, String name) {
        BaseShip ship;
        if (type.equals("CruiseShip")) {
            ship = new CruiseShip(name);
        } else {
            ship = new MilitaryShip(name);
        }
        this.shipRepository.add(ship);

        return String.format("Successfully added ship %s - %s", name, type);
    }

    @Override
    public String removeShip(String name) {
        BaseShip ship = shipRepository.find(name);
        shipRepository.remove(ship);
        return String.format("Successfully removed ship - %s", name);
    }

    @Override
    public String shipsCount() {
        return String.format("There are %s ships in the database", shipRepository.getCount());
    }

    @Override
    public void getAllShips() {
        if (shipRepository.getShips().size() != 0){
            System.out.println("List all ships: ");
            for (int i = 0; i < shipRepository.getShips().size(); i++) {
                if (i <= shipRepository.getShips().size() - 2){
                    System.out.printf("%s, ", shipRepository.getShips().get(i).getName());
                } else {
                    System.out.printf("%s ", shipRepository.getShips().get(i).getName());
                }
            }
            System.out.println();
        } else {
            System.out.println("There are no ships in the database!");
        }
    }
}
