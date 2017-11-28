CREATE DATABASE dentistry;
USE dentistry;
 CREATE TABLE Patients (
    title ENUM('Mr', 'Mrs', 'Miss', 'Ms', 'Dr') NOT NULL,
    forename VARCHAR(20) NOT NULL,
    surname VARCHAR(20) NOT NULL,
    dateOfBirth DATE NOT NULL,
    phoneNumber CHAR(11) NOT NULL,
    houseNumber VARCHAR(5) NOT NULL,
    postcode VARCHAR(8) NOT NULL,
    healthCarePlan VARCHAR(20) NULL,
    prepaidCheckUpsUsed INT NULL,
    prepaidHygieneVisitsUsed INT NULL,
    prepaidRepairsUsed INT NULL,
    patientID INT UNSIGNED NOT NULL AUTO_INCREMENT PRIMARY KEY
);

 CREATE TABLE Addresses (
    houseNumber VARCHAR(5) NOT NULL,
    postcode VARCHAR(8) NOT NULL,
    streetName VARCHAR(20) NOT NULL,
    districtName VARCHAR(20),
    city VARCHAR(20) NOT NULL,
    PRIMARY KEY (houseNumber , postcode)
);

 CREATE TABLE Appointments (
    dateOfAppointment DATE NOT NULL,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL,
    partner ENUM('Dentist', 'Hygienist') NOT NULL,
    patientID INT UNSIGNED NOT NULL DEFAULT 0,
    treatmentName VARCHAR(20) NOT NULL,
	seen BOOLEAN NOT NULL,
    PRIMARY KEY (dateOfAppointment , startTime , partner)
);

 CREATE TABLE Treatments (
    treatmentName VARCHAR(20) PRIMARY KEY NOT NULL,
    cost FLOAT NOT NULL,
	lengthOfTreatment INT NOT NULL
);

 CREATE TABLE HealthCarePlans (
    healthCareName ENUM('NHS','MAINTENANCE','ORALHEALTH','DENTALREPAIR', 'NOPLAN') NOT NULL PRIMARY KEY,
    checkUps INT NOT NULL,
    hygieneVisits INT NOT NULL,
	  repairs INT NULL,
	  monthlyCost FLOAT NULL DEFAULT 0.0
);

 INSERT INTO Patients
 VALUES
   ('Mr', "BLANK", "-", '1973-11-11', "00000000000","-","-",
    "-", 0, 0, 0, default),
   ('Mr', "Dandy", "Adams", '1973-11-11', "04732111910","134","QE3 1LZ",
    "NHS", 0,0,0, default);

 INSERT INTO Addresses
 VALUES
   ("134", "QE3 1LZ", "Lil Lane", "Dilsbry", "York"),
   ("13B", "ZE4 4NZ", "Low Court Drive", "South Central", "York");

 INSERT INTO Appointments
 VALUES
   ('2017-07-27','14:30:00','14:50:00', 'Dentist', 50, "Check-Up",TRUE),
   ('2017-07-30','14:30:00','15:00:00', 'Hygienist', 50, "Hygiene",TRUE),
   ('2017-09-03','14:30:00','15:30:00', 'Dentist', 50, "Gold-Crown",TRUE),
   ('2017-09-10','14:30:00','15:00:00', 'Hygienist', 50, "Hygiene",TRUE),
   ('2017-12-09','14:30:00','14:50:00', 'Dentist', 96, "Check-Up",FALSE),
   ('2018-09-08','14:30:00','14:50:00', 'Dentist', 2, "Check-Up",TRUE),
   ('2018-09-08','14:30:00','14:50:00', 'Hygienist', 3, "Hygiene",FALSE);

 INSERT INTO Treatments
 VALUES
   ("Check-Up", 45.00,30),
   ("Amalgam-Filling", 90.00,60),
   ("WHT-CMPSTE-Filling", 150.00,60),
   ("Gold-Crown", 500.00,60),
   ("Hygiene", 45.00,30);

 INSERT INTO HealthCarePlans
 VALUES
   ('NHS', 2, 2, 6, 0.0),
   ('MAINTENANCE', 2, 2, 0, 15.00),
   ('ORALHEALTH', 2, 4, 0, 21.00),
   ('DENTALREPAIR', 2, 2, 2, 36.00);
   
CREATE USER dentistryuser IDENTIFIED BY 'dentistryuserpw';

grant usage on *.* to dentistryuser@localhost identified by 'dentistryuserpw';
grant all privileges on dentistry.* to dentistryuser@localhost;