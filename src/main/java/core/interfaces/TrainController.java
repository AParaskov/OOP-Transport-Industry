package core.interfaces;

public interface TrainController {
    String addTrain(String type, String registrationNumber, String id);
    String removeTrain(String registrationNumber);
    String trainsCount();
    void getAllTrains();
}
