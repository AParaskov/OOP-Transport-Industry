package core.interfaces;

public interface ShipController {
    String addShip(String type, String registrationNumber, String name);
    String removeShip(String registrationNumber);
    String shipsCount();
    void getAllShips();
}
