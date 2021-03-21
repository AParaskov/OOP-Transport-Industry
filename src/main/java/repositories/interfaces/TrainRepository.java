package repositories.interfaces;


import model.train.BaseTrain;

import java.util.List;

public interface TrainRepository {
    int getCount();

    void add(BaseTrain train);

    boolean remove(BaseTrain train);

    List<BaseTrain> getTrains();

    BaseTrain find(String id);
}
