CREATE DATABASE dentistry;
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
    cost FLOAT NULL,
    treatmentName VARCHAR(20) NOT NULL,
    PRIMARY KEY (dateOfAppointment , startTime , partner)
);

 CREATE TABLE Treatments (
    treatmentName VARCHAR(20) PRIMARY KEY NOT NULL,
    cost FLOAT NOT NULL
);

 CREATE TABLE Health_Care_Plans (
    healthCareName VARCHAR(20) NOT NULL PRIMARY KEY,
    checkUps INT NOT NULL,
    hygieneVisits INT NOT NULL,
	repairs INT NULL,
	monthlyCost FLOAT NULL DEFAULT 0.0
);

 INSERT INTO Patients 
 VALUES
   ('Mr', "BLANK", "-", 1973-11-11, "00000000000","-","-",
    "-"),
   ('Mr', "Dandy", "Adams", 1973-11-11, "04732111910","134","QE3 1LZ",
    "Lil Lane"),
   ('Mrs', "Sandy", "Adams", 1986-10-10, "04732111910","134", "QE3 1LZ",
    "Lil Lane"),
   ('Ms', "Mandy", "Yams", 1983-11-11, "05832321961","132", "ZE4 4NZ",
    " Low Court Drive");  
  
 INSERT INTO Addresses 
 VALUES
   ("134", "QE3 1LZ", "Lil Lane", "Dilsbry", "York"),
   ("13B", "ZE4 4NZ", "Low Court Drive", "South Central", "York"); 
 
 INSERT INTO Appointments
 VALUES
   (2018-09-08,14:30:00,14:50:00, 'Dentist', 2, 45.00, "Check-Up"),
   (2018-09-08,14:30:00,14:50:00, 'Hygienist', 3, 45.00, "Hygiene");
 
 INSERT INTO Treatments 
 VALUES
   ("Check-Up", 45.00),
   ("Amalgam-Filling", 90.00),
   ("White-Composite-Filling", 150.00),
   ("Gold-Crown", 500.00),
   ("Hygiene", 45.00);  
 
 INSERT INTO Health_Care_Plans 
 VALUES
   ("NHS-Free-Plan", 2, 2, 6),
   ("Maintenance-Plan", 2, 2, 0, 15.00),
   ("Oral-Health-Plan", 2, 4, 0, 21.00),
   ("Dental-Repair-Plan", 2, 2, 2, 36.00); 
