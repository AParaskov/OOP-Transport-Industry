package core.interfaces;

public interface PlaneController {
    String addPlane(String type, String registrationNumber, String name);
    String removePlane(String registrationNumber);
    String planesCount();
    void getAllPlanes();
}
