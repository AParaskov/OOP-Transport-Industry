package repositories.impl;

import model.BaseVehicle;
import model.VehicleType;
import model.car.BaseCar;
import model.plane.BasePlane;
import model.ship.BaseShip;
import model.train.BaseTrain;
import repositories.VehicleRepository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class VehicleRepositoryImpl implements VehicleRepository {
    private final List<BaseVehicle> vehicles;

    public VehicleRepositoryImpl() {
        this.vehicles = new ArrayList<>();
    }

    @Override
    public void add(BaseVehicle vehicle) {
        if (vehicle == null){
            throw new IllegalArgumentException("Vehicle cannot be null!");
        }

        boolean contains = this.vehicles.stream()
                .anyMatch(s -> s.getRegistrationNumber().equals(vehicle.getRegistrationNumber()));

        if (contains){
            throw new IllegalArgumentException(String.format("Vehicle %s already exists!",vehicle.getRegistrationNumber()));
        }

        this.vehicles.add(vehicle);
    }

    @Override
    public boolean remove(BaseVehicle vehicle) {
        if (vehicle == null){
            throw new IllegalArgumentException("Vehicle cannot be null!");
        }

        return this.vehicles.remove(vehicle);
    }

    @Override
    public List<BaseVehicle> getVehicles() {
        return this.vehicles;
    }

    @Override
    public BaseVehicle find(String registrationNumber) {
        return this.vehicles
                .stream()
                .filter(v -> v.getRegistrationNumber().equals(registrationNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<BaseVehicle> findAll(VehicleType vehicleType) {
        return this.vehicles
                .stream()
                .filter(v -> v.getVehicleType().equals(vehicleType))
                .collect(Collectors.toList());
    }

    @Override
    public void saveCar(BaseCar baseCar) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_industry", "root", "mypass")){
            try(PreparedStatement preparedStatement = connection.prepareStatement("insert into transport_industry.car (registration_number, vehicle_type, manufacturer, storage_in_litres, fuel_type) values (?, ?, ?, ?, ?)")){
                preparedStatement.setString(1, baseCar.getRegistrationNumber());
                preparedStatement.setString(2, baseCar.getVehicleType().name());
                preparedStatement.setString(3, baseCar.getManufacturer());
                preparedStatement.setInt(4, baseCar.getStorageInLitres());
                preparedStatement.setString(5, baseCar.getFuelType());

                preparedStatement.executeUpdate();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public void savePlane(BasePlane basePlane) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_industry", "root", "mypass")){
            try(PreparedStatement preparedStatement = connection.prepareStatement("insert into transport_industry.plane (registration_number, vehicle_type, `name`, storage_in_litres, seats) values (?, ?, ?, ?, ?)")){
                preparedStatement.setString(1, basePlane.getRegistrationNumber());
                preparedStatement.setString(2, basePlane.getVehicleType().name());
                preparedStatement.setString(3, basePlane.getName());
                preparedStatement.setInt(4, basePlane.getStorageInLitres());
                preparedStatement.setInt(5, basePlane.getSeats());

                preparedStatement.executeUpdate();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public void saveShip(BaseShip baseShip) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_industry", "root", "mypass")){
            try(PreparedStatement preparedStatement = connection.prepareStatement("insert into transport_industry.ship (registration_number, vehicle_type, `name`, storage_in_litres, crew_members) values (?, ?, ?, ?, ?)")){
                preparedStatement.setString(1, baseShip.getRegistrationNumber());
                preparedStatement.setString(2, baseShip.getVehicleType().name());
                preparedStatement.setString(3, baseShip.getName());
                preparedStatement.setInt(4, baseShip.getStorageInLitres());
                preparedStatement.setInt(5, baseShip.getCrewMembers());

                preparedStatement.executeUpdate();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public void saveTrain(BaseTrain baseTrain) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_industry", "root", "mypass")){
            try(PreparedStatement preparedStatement = connection.prepareStatement("insert into transport_industry.train (registration_number, vehicle_type, `name`, storage_in_litres, seats) values (?, ?, ?, ?, ?)")){
                preparedStatement.setString(1, baseTrain.getRegistrationNumber());
                preparedStatement.setString(2, baseTrain.getVehicleType().name());
                preparedStatement.setString(3, baseTrain.getName());
                preparedStatement.setInt(4, baseTrain.getStorageInLitres());
                preparedStatement.setInt(5, baseTrain.getSeats());

                preparedStatement.executeUpdate();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public void deleteCar(BaseVehicle baseVehicle) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_industry", "root", "mypass")){
            try(PreparedStatement preparedStatement = connection.prepareStatement("delete from transport_industry.car where registration_number = ?;")){
                preparedStatement.setString(1, baseVehicle.getRegistrationNumber());

                preparedStatement.executeUpdate();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public void deletePlane(BaseVehicle baseVehicle) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_industry", "root", "mypass")){
            try(PreparedStatement preparedStatement = connection.prepareStatement("delete from transport_industry.plane where registration_number = ?;")){
                preparedStatement.setString(1, baseVehicle.getRegistrationNumber());

                preparedStatement.executeUpdate();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public void deleteShip(BaseVehicle baseVehicle) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_industry", "root", "mypass")){
            try(PreparedStatement preparedStatement = connection.prepareStatement("delete from transport_industry.ship where registration_number = ?;")){
                preparedStatement.setString(1, baseVehicle.getRegistrationNumber());

                preparedStatement.executeUpdate();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }

    @Override
    public void deleteTrain(BaseVehicle baseVehicle) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try(Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/transport_industry", "root", "mypass")){
            try(PreparedStatement preparedStatement = connection.prepareStatement("delete from transport_industry.train where registration_number = ?;")){
                preparedStatement.setString(1, baseVehicle.getRegistrationNumber());

                preparedStatement.executeUpdate();

                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }
    }


}
