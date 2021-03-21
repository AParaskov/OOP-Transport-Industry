package repositories.interfaces;


import model.ship.BaseShip;

import java.util.List;

public interface ShipRepository {
    int getCount();

    void add(BaseShip ship);

    boolean remove(BaseShip ship);

    List<BaseShip> getShips();

    BaseShip find(String name);
}
