package core;

import core.interfaces.CarController;
import model.car.AllRoadCar;
import model.car.BaseCar;
import model.car.SportsCar;

import model.ship.BaseShip;
import model.ship.CruiseShip;
import model.ship.MilitaryShip;
import model.train.BaseTrain;
import model.train.CargoTrain;
import model.train.PassengerTrain;
import repositories.CarRepositoryImpl;
import repositories.PlaneRepositoryImpl;
import repositories.ShipRepositoryImpl;
import repositories.TrainRepositoryImpl;
import repositories.interfaces.CarRepository;
import repositories.interfaces.PlaneRepository;
import repositories.interfaces.ShipRepository;
import repositories.interfaces.TrainRepository;

public class CarControllerImpl implements CarController {
    private final CarRepository carRepository;

    public CarControllerImpl() {
        this.carRepository = new CarRepositoryImpl();
    }

    @Override
    public String addCar(String type, String manufacturer) {
        BaseCar car;
        if (type.equals("SportsCar")) {
            car = new SportsCar(manufacturer);
        } else {
            car = new AllRoadCar(manufacturer);
        }
        this.carRepository.add(car);

        return String.format("Successfully added car %s - %s", manufacturer, type);
    }

    @Override
    public String removeCar(String manufacturer) {
        BaseCar car = carRepository.find(manufacturer);
        carRepository.remove(car);
        return String.format("Successfully removed car - %s", manufacturer);
    }


    @Override
    public String carsCount() {
        return String.format("There are %s cars in the database", carRepository.getCount());
    }


    @Override
    public void getAllCars() {
        if (carRepository.getCars().size() != 0){
            System.out.println("List all cars: ");
            for (int i = 0; i < carRepository.getCars().size(); i++) {
                if (i <= carRepository.getCars().size() - 2){
                    System.out.printf("%s, ", carRepository.getCars().get(i).getManufacturer());
                } else {
                    System.out.printf("%s ", carRepository.getCars().get(i).getManufacturer());
                }
            }
            System.out.println();
        } else {
            System.out.println("There are no cars in the database!");
        }
    }

}

