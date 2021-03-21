package repositories.interfaces;


import model.plane.BasePlane;

import java.util.List;

public interface PlaneRepository {
    int getCount();

    void add(BasePlane plane);

    boolean remove(BasePlane plane);

    List<BasePlane> getPlanes();

    BasePlane find(String name);
}
