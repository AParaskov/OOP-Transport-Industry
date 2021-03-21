package core;

import core.interfaces.TrainController;
import model.train.BaseTrain;
import model.train.CargoTrain;
import model.train.PassengerTrain;
import repositories.TrainRepositoryImpl;
import repositories.interfaces.TrainRepository;

public class TrainControllerImpl implements TrainController {
    private final TrainRepository trainRepository;

    public TrainControllerImpl() {
        this.trainRepository = new TrainRepositoryImpl();
    }

    @Override
    public String addTrain(String type, String id) {
        BaseTrain train;
        if (type.equals("PassengerTrain")) {
            train = new PassengerTrain(id);
        } else {
            train = new CargoTrain(id);
        }
        this.trainRepository.add(train);

        return String.format("Successfully added train %s - %s", id, type);
    }

    @Override
    public String removeTrain(String id) {
        BaseTrain train = trainRepository.find(id);
        trainRepository.remove(train);
        return String.format("Successfully removed train - %s", id);
    }

    @Override
    public String trainsCount() {
        return String.format("There are %s trains in the database", trainRepository.getCount());
    }

    @Override
    public void getAllTrains() {
        if (trainRepository.getTrains().size() != 0){
            System.out.println("List all trains: ");
            for (int i = 0; i < trainRepository.getTrains().size(); i++) {
                if (i <= trainRepository.getTrains().size() - 2){
                    System.out.printf("%s, ", trainRepository.getTrains().get(i).getId());
                } else {
                    System.out.printf("%s ", trainRepository.getTrains().get(i).getId());
                }
            }
            System.out.println();
        } else {
            System.out.println("There are no trains in the database!");
        }
    }
}
