package core;

import core.interfaces.PlaneController;
import model.plane.BasePlane;
import model.plane.CargoPlane;
import model.plane.PassengerPlane;
import repositories.PlaneRepositoryImpl;
import repositories.interfaces.PlaneRepository;

public class PlaneControllerImpl implements PlaneController {
    private final PlaneRepository planeRepository;

    public PlaneControllerImpl() {
        this.planeRepository = new PlaneRepositoryImpl();
    }

    @Override
    public String addPlane(String type, String name) {
        BasePlane plane;
        if (type.equals("PassengerPlane")) {
            plane = new PassengerPlane(name);
        } else {
            plane = new CargoPlane(name);
        }
        this.planeRepository.add(plane);

        return String.format("Successfully added plane %s - %s", name, type);
    }

    @Override
    public String removePlane(String name) {
        BasePlane plane = planeRepository.find(name);
        planeRepository.remove(plane);
        return String.format("Successfully removed plane - %s", name);
    }

    @Override
    public String planesCount() {
        return String.format("There are %s planes in the database", planeRepository.getCount());
    }

    @Override
    public void getAllPlanes() {
        if (planeRepository.getPlanes().size() != 0){
            System.out.println("List all planes: ");
            for (int i = 0; i < planeRepository.getPlanes().size(); i++) {
                if (i <= planeRepository.getPlanes().size() - 2){
                    System.out.printf("%s, ", planeRepository.getPlanes().get(i).getName());
                } else {
                    System.out.printf("%s ", planeRepository.getPlanes().get(i).getName());
                }
            }
            System.out.println();
        } else {
            System.out.println("There are no planes in the database!");
        }
    }
}
