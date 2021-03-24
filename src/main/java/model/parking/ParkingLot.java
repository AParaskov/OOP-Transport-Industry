package model.parking;

import model.BaseVehicle;
import model.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class ParkingLot {
    Map<BaseVehicle, LocalDateTime> vehicles;
    Map<VehicleType, Integer> spots;
    private final double PRICE = 2;

    public ParkingLot(int cars, int planes, int ships, int trains) {
        this.vehicles = new HashMap<>();
        this.spots = new HashMap<>();
        spots.put(VehicleType.ROAD, cars);
        spots.put(VehicleType.AIR, planes);
        spots.put(VehicleType.WATER, ships);
        spots.put(VehicleType.RAIL, trains);
    }

    public void enterParking(BaseVehicle baseVehicle){
        if (vehicles.containsKey(baseVehicle)){
            return;
        }
        VehicleType vehicleType = baseVehicle.getVehicleType();
        int spotsLeft = spots.get(vehicleType);
        if (spotsLeft <= 0){
            System.out.println("There are no free spots at the moment!");
            return;
        }
        spots.put(vehicleType, spotsLeft - 1);
        LocalDateTime issueTime = LocalDateTime.now();
        vehicles.put(baseVehicle, issueTime);
        System.out.printf("Vehicle with registration number %s successfully entered the parking.", baseVehicle.getRegistrationNumber());
        System.out.println();
    }

    public void leaveParking(BaseVehicle baseVehicle){
        LocalDateTime issueTime = vehicles.get(baseVehicle);
        if (issueTime == null){
            System.out.println("There is no such car in the parking!");
            return;
        }
        LocalDateTime leaveTime = LocalDateTime.now();
        double duration = issueTime.until(leaveTime, ChronoUnit.SECONDS);
        VehicleType vehicleType = baseVehicle.getVehicleType();
        int spotsLeft = spots.get(vehicleType);
        spots.put(vehicleType, spotsLeft + 1);
        vehicles.remove(baseVehicle);
        double price = PRICE * duration;
        System.out.printf("Vehicle with registration number %s successfully left the parking. Total cost is: %.2f.", baseVehicle.getRegistrationNumber(), price);
        System.out.println();

    }

}
