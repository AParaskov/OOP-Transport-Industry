package core.interfaces;

public interface TrainController {
    String addTrain(String type, String id);
    String removeTrain(String id);
    String trainsCount();
    void getAllTrains();
}
