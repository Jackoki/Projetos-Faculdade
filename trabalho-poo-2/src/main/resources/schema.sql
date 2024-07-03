CREATE DATABASE IF NOT EXISTS DB;
USE DB;

CREATE TABLE IF NOT EXISTS User(
    id INT AUTO_INCREMENT PRIMARY KEY,
    category INT NOT NULL,
    name VARCHAR(50) UNIQUE NOT NULL,
    address VARCHAR(50),
    email VARCHAR(70),
    phone VARCHAR(50),
    password VARCHAR(50)
);

CREATE TABLE IF NOT EXISTS Customer(
    idUser INT PRIMARY KEY,
    cnh VARCHAR(50) NOT NULL,
    FOREIGN KEY (idUser) REFERENCES User(id)
);


CREATE TABLE IF NOT EXISTS Employee(
    idUser INT PRIMARY KEY,
    lvlPermission INT NOT NULL,
    FOREIGN KEY (idUser) REFERENCES User(id)
);

CREATE TABLE IF NOT EXISTS Schedule(
    idUser INT,
    date DATE,
    FOREIGN KEY (idUser) REFERENCES User(id)
);

CREATE TABLE IF NOT EXISTS Vehicle(
    plate VARCHAR(50) PRIMARY KEY,
    idUser INT,
    idChassis VARCHAR(50) NOT NULL,
    brand VARCHAR(50),
    model VARCHAR(50),
    yearMade INT,
    color VARCHAR(50),
    available BOOLEAN,
    sold BOOLEAN,
    FOREIGN KEY (idUser) REFERENCES User(id)
);


CREATE TABLE IF NOT EXISTS Motorcycle(
    idPlate VARCHAR(50) PRIMARY KEY,
    saddlebag BOOLEAN,
    FOREIGN KEY (idPlate) REFERENCES Vehicle(plate)
);


CREATE TABLE IF NOT EXISTS Car(
    idPlate VARCHAR(50) PRIMARY KEY,
    quantAirbag INT,
    FOREIGN KEY (idPlate) REFERENCES Vehicle(plate)
);