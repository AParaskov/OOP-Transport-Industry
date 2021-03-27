create database transport_industry;

create table car(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
registration_number VARCHAR(6) NOT NULL UNIQUE,
vehicle_type ENUM('ROAD', 'AIR', 'WATER', 'RAIL') NOT NULL,
manufacturer VARCHAR(30) NOT NULL,
storage_in_litres INT NOT NULL,
fuel_type VARCHAR(30) NOT NULL
);

create table plane(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
registration_number VARCHAR(6) NOT NULL UNIQUE,
vehicle_type ENUM('ROAD', 'AIR', 'WATER', 'RAIL') NOT NULL,
`name` VARCHAR(30) NOT NULL,
storage_in_litres INT NOT NULL,
seats INT NOT NULL
);

create table ship(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
registration_number VARCHAR(6) NOT NULL UNIQUE,
vehicle_type ENUM('ROAD', 'AIR', 'WATER', 'RAIL') NOT NULL,
`name` VARCHAR(30) NOT NULL,
storage_in_litres INT NOT NULL,
crew_members INT NOT NULL
);

create table train(
id INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
registration_number VARCHAR(6) NOT NULL UNIQUE,
vehicle_type ENUM('ROAD', 'AIR', 'WATER', 'RAIL') NOT NULL,
`name` VARCHAR(30) NOT NULL,
storage_in_litres INT NOT NULL,
seats INT NOT NULL
);