package core.interfaces;

public interface ShipController {
    String addShip(String type, String name);
    String removeShip(String name);
    String shipsCount();
    void getAllShips();
}
