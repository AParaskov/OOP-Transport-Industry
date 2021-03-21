package core.interfaces;

public interface PlaneController {
    String addPlane(String type, String name);
    String removePlane(String name);
    String planesCount();
    void getAllPlanes();
}
