package repositories;

import model.plane.BasePlane;
import repositories.interfaces.PlaneRepository;

import java.util.ArrayList;
import java.util.List;

public class PlaneRepositoryImpl implements PlaneRepository {
    private List<BasePlane> planes;

    public PlaneRepositoryImpl() {
        this.planes = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.planes.size();
    }

    @Override
    public void add(BasePlane plane) {
        if (plane == null){
            throw new IllegalArgumentException("Plane cannot be null!");
        }

        boolean contains = this.planes.stream()
                .anyMatch(p -> p.getName().equals(plane.getName()));

        if (contains){
            throw new IllegalArgumentException(String.format("Plane %s already exists!",plane.getName()));
        }

        this.planes.add(plane);
    }

    @Override
    public boolean remove(BasePlane plane) {
        if (plane == null){
            throw new IllegalArgumentException("Plane cannot be null!");
        }

        return this.planes.remove(plane);
    }

    @Override
    public List<BasePlane> getPlanes() {
        return this.planes;
    }

    @Override
    public BasePlane find(String name) {
        return this.planes
                .stream()
                .filter(p -> p.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}
