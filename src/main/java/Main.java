import core.*;
import core.interfaces.*;
import model.parking.ParkingLot;

import repositories.VehicleRepository;
import repositories.impl.VehicleRepositoryImpl;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        VehicleRepositoryImpl vehicleRepository = new VehicleRepositoryImpl();
        CarController carController = new CarControllerImpl(vehicleRepository);
        PlaneController planeController = new PlaneControllerImpl(vehicleRepository);
        ShipController shipController = new ShipControllerImpl(vehicleRepository);
        TrainController trainController = new TrainControllerImpl(vehicleRepository);
        ParkingLot parkingLot = new ParkingLot(10, 10, 10, 10);

        Scanner reader = null;
        File test = new File("test.txt");

        try {
            reader = new Scanner(test);
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        }

        if (reader == null) {
            return;
        }


        while (reader.hasNextLine()) {
            String input = reader.nextLine();
            String[] tokens = input.split(" ");

            String command = tokens[0];


            switch (command) {
                case "AddCar":
                    System.out.println(carController.addCar(tokens[1], tokens[2], tokens[3]));
                    break;
                case "AddPlane":
                    System.out.println(planeController.addPlane(tokens[1], tokens[2], tokens[3]));
                    break;
                case "AddShip":
                    System.out.println(shipController.addShip(tokens[1], tokens[2], tokens[3]));
                    break;
                case "AddTrain":
                    System.out.println(trainController.addTrain(tokens[1], tokens[2], tokens[3]));
                    break;
                case "RemoveCar":
                    System.out.println(carController.removeCar(tokens[1]));
                    break;
                case "RemovePlane":
                    System.out.println(planeController.removePlane(tokens[1]));
                    break;
                case "RemoveShip":
                    System.out.println(shipController.removeShip(tokens[1]));
                    break;
                case "RemoveTrain":
                    System.out.println(trainController.removeTrain(tokens[1]));
                    break;
                case "CarsCount":
                    System.out.println(carController.carsCount());
                    break;
                case "PlanesCount":
                    System.out.println(planeController.planesCount());
                    break;
                case "ShipsCount":
                    System.out.println(shipController.shipsCount());
                    break;
                case "TrainsCount":
                    System.out.println(trainController.trainsCount());
                    break;
                case "GetAllCars":
                    carController.getAllCars();
                    break;
                case "GetAllPlanes":
                    planeController.getAllPlanes();
                    break;
                case "GetAllShips":
                    shipController.getAllShips();
                    break;
                case "GetAllTrains":
                    trainController.getAllTrains();
                    break;
                case "EnterParking":
                    parkingLot.enterParking(vehicleRepository.find(tokens[1]));
                    break;
                case "LeaveParking":
                    parkingLot.leaveParking(vehicleRepository.find(tokens[1]));
                    break;
                case "Sleep":
                    Thread.sleep(Long.parseLong(tokens[1]));
                    break;
            }


        }
        reader.close();
    }
}
