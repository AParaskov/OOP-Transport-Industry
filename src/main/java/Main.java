import core.CarControllerImpl;
import core.PlaneControllerImpl;
import core.ShipControllerImpl;
import core.TrainControllerImpl;
import core.interfaces.CarController;
import core.interfaces.PlaneController;
import core.interfaces.ShipController;
import core.interfaces.TrainController;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CarController carController = new CarControllerImpl();
        PlaneController planeController = new PlaneControllerImpl();
        ShipController shipController = new ShipControllerImpl();
        TrainController trainController = new TrainControllerImpl();

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
                    System.out.println(carController.addCar(tokens[1], tokens[2]));
                    break;
                case "AddPlane":
                    System.out.println(planeController.addPlane(tokens[1], tokens[2]));
                    break;
                case "AddShip":
                    System.out.println(shipController.addShip(tokens[1], tokens[2]));
                    break;
                case "AddTrain":
                    System.out.println(trainController.addTrain(tokens[1], tokens[2]));
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
            }


        }
        reader.close();
    }
}
