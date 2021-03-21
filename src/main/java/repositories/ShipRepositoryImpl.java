package repositories;

import model.ship.BaseShip;
import repositories.interfaces.ShipRepository;

import java.util.ArrayList;
import java.util.List;

public class ShipRepositoryImpl implements ShipRepository {
    private List<BaseShip> ships;

    public ShipRepositoryImpl() {
        this.ships = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.ships.size();
    }

    @Override
    public void add(BaseShip ship) {
        if (ship == null){
            throw new IllegalArgumentException("Ship cannot be null!");
        }

        boolean contains = this.ships.stream()
                .anyMatch(s -> s.getName().equals(ship.getName()));

        if (contains){
            throw new IllegalArgumentException(String.format("Ship %s already exists!",ship.getName()));
        }

        this.ships.add(ship);
    }

    @Override
    public boolean remove(BaseShip ship) {
        if (ship == null){
            throw new IllegalArgumentException("Ship cannot be null!");
        }

        return this.ships.remove(ship);
    }

    @Override
    public List<BaseShip> getShips() {
        return this.ships;
    }

    @Override
    public BaseShip find(String name) {
        return this.ships
                .stream()
                .filter(c -> c.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
