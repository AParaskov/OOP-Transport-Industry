package repositories;

import model.train.BaseTrain;
import repositories.interfaces.TrainRepository;

import java.util.ArrayList;
import java.util.List;

public class TrainRepositoryImpl implements TrainRepository {
    private List<BaseTrain> trains;

    public TrainRepositoryImpl() {
        this.trains = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return this.trains.size();
    }

    @Override
    public void add(BaseTrain train) {
        if (train == null){
            throw new IllegalArgumentException("Train cannot be null!");
        }

        boolean contains = this.trains.stream()
                .anyMatch(t -> t.getId().equals(train.getId()));

        if (contains){
            throw new IllegalArgumentException(String.format("Train %s already exists!",train.getId()));
        }

        this.trains.add(train);
    }

    @Override
    public boolean remove(BaseTrain train) {
        if (train == null){
            throw new IllegalArgumentException("Train cannot be null!");
        }

        return this.trains.remove(train);
    }

    @Override
    public List<BaseTrain> getTrains() {
        return this.trains;
    }

    @Override
    public BaseTrain find(String id) {
        return this.trains
                .stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
