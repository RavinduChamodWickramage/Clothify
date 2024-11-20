# Clothify - POS System for Clothing Stores
Clothify is a modern Point-of-Sale (POS) system built for clothing stores. It offers features for inventory management, order management, and more, all integrated with a JavaFX frontend. The application is powered by Spring Boot and Hibernate for backend logic, with a MySQL database to store the data. JFoenix is used for the modern UI components to give a sleek, professional look.
This project follows a layered architecture with clearly defined layers for Controller, Service, Repository, and Entities. It also provides enhanced security by using encryption for sensitive data.
Clothify can be packaged into an executable .exe file using Launch4j for easier distribution.  

# Features  

**Inventory Management**: Manage products, categories, and stock levels.
**Order Management**: Create, update, delete, and view customer orders.
**Staff Management**: Add, update, and view staff details.
**Supplier Management**: Manage suppliers for the products.
**User Authentication**: Admin and staff login using secure authentication.
**Reporting**: Generate various reports for sales, inventory, and suppliers.
**POS System**: Process orders, calculate totals, and apply discounts.
**Modern UI**: A JavaFX-based UI using JFoenix for sleek design.
**Encryption**: Secure user credentials with encryption.
**Database**: Use MySQL for persistent data storage.
**Packaging**: Package the app into an .exe using Launch4j for easy distribution.  

# Tech Stack  

**Java 11+**
**Spring Boot** (for the backend logic)
**Hibernate** (for ORM and database interaction)
**MySQL** (for the database)
**JavaFX** (for the frontend UI)
**JFoenix** (for Material Design UI components)
**Launch4j** (for packaging as an .exe file)
**Maven** (for dependency management and building)
**JasperReports** (for report generation)
**ModelMapper** (for object mapping)
**Lombok** (for reducing boilerplate code)  

# Prerequisites  

Before you start, ensure you have the following installed:

**Java 11+** (preferably JDK 11)
**Maven** (for building the project)
**MySQL** (for the database)
**IDE** (like IntelliJ IDEA or Eclipse)
**Launch4j** (for packaging the project as .exe file)  

# Setup and Installation  

**Clone the repository**
First, clone this repository to your local machine:  

```git clone https://github.com/RavinduChamodWickramage/Clothify.git```  

# Import into IDE  

Open your IDE (IntelliJ IDEA, Eclipse, etc.)
Import the project as a Maven project
Set up JDK 11+ if it’s not already set  

# Database Configuration  

Create a MySQL database named Clothify:  
```CREATE DATABASE Clothify;```  

Run the schema script to set up the necessary tables:  
```
-- Create the database and switch to it
CREATE DATABASE Clothify;
USE Clothify;

-- Create the Admin table to store admin users
CREATE TABLE Admin (
    AdminID VARCHAR(10) PRIMARY KEY,
    Username VARCHAR(100) NOT NULL,
    Password VARCHAR(30) NOT NULL,
    PhoneNumber VARCHAR(15)
);

-- Create the Staff table to store staff member details
CREATE TABLE Staff (
    StaffID VARCHAR(10) PRIMARY KEY,
    Username VARCHAR(100) NOT NULL,
    Password VARCHAR(100) NOT NULL,
    FullName VARCHAR(100),
    Address TEXT,
    PhoneNumber VARCHAR(15),
    NIC VARCHAR(15),
    DOB DATE,
    Salary DECIMAL(10,2)
);

-- Create the Supplier table to store supplier details
CREATE TABLE Supplier (
    SupplierID VARCHAR(10) PRIMARY KEY,
    Name VARCHAR(100),
    Company VARCHAR(50),
    Email VARCHAR(100),
    PhoneNumber VARCHAR(15)
);

-- Create the Product table to store product details
CREATE TABLE Product (
    ProductID VARCHAR(10) PRIMARY KEY,
    Name VARCHAR(100),
    Category VARCHAR(30),
    Size VARCHAR(10),
    UnitPrice DECIMAL(10,2),
    QtyOnHand INT
);

-- Create the Supply table to manage supply transactions (composite key)
CREATE TABLE SupplyProduct (
    SupplyID VARCHAR(10),
    ProductID VARCHAR(10),
    SupplierID VARCHAR(10),
    UnitCost DECIMAL(10,2),
    Qty INT,
    Total DECIMAL(10,2),
    DateAndTime DATETIME,
    PRIMARY KEY (SupplyID, ProductID, SupplierID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID),
    FOREIGN KEY (SupplierID) REFERENCES Supplier(SupplierID)
);

-- Create the Order table to store customer orders
CREATE TABLE Orders (
    OrderID VARCHAR(10) PRIMARY KEY,
    NetTotal DECIMAL(10,2),
    TotalDiscount DECIMAL(10,2),
    OrderDateAndTime DATETIME,
    StaffID VARCHAR(10),
    CustomerEmail VARCHAR(100),
    CustomerPhoneNumber VARCHAR(10),
    FOREIGN KEY (StaffID) REFERENCES Staff(StaffID) ON DELETE SET NULL
);

-- Create the OrderDetail table to store the details of each product in an order
CREATE TABLE OrderDetail (
    OrderID VARCHAR(10),
    ProductID VARCHAR(10),
    UnitPrice DECIMAL(10,2),
    Qty INT,
    Discount DECIMAL(10,2),
    Total DECIMAL(10,2),
    PRIMARY KEY (OrderID, ProductID),
    FOREIGN KEY (OrderID) REFERENCES Orders(OrderID),
    FOREIGN KEY (ProductID) REFERENCES Product(ProductID)
);
```  

Update the database connection details in the application.properties file located under src/main/resources:  
```
spring.datasource.url=jdbc:mysql://localhost:3306/Clothify
spring.datasource.username=root
spring.datasource.password=yourpassword
spring.jpa.hibernate.ddl-auto=update
```  

# Running the Application  

Using IDE:
Run the ClothifyApplication.java class (Spring Boot application) from your IDE. This will start the application.
Using Maven Command:
Alternatively, you can use Maven to build and run the application:
```
mvn clean install
mvn spring-boot:run
```  

# Acknowledgments  

**JasperReports** for report generation.
**Hibernate** for ORM and database interaction.
**JavaFX** and **JFoenix** for the modern UI design.
**Spring Boot** for creating the backend.
