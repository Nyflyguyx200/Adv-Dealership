## Project Name: Adv Car Dealership 

## Description:
The Adv Car Dealership is a Java application designed to manage vehicle inventory, sales, and leasing operations for a car dealership.
It provides functionalities such as searching vehicles by various criteria, adding new vehicles, removing vehicles, selling vehicles, and leasing vehicles. 
The Dealership also handles contract management for sales and leases.

## Features:
1. Search vehicles within a price range
2. Search vehicles by make/model
3. Search vehicles by year range
4. Search vehicles by color
5. Search vehicles by mileage
6. Search vehicles by type (car, truck, SUV, van)
7. List all vehicles in the inventory
8. Sell a vehicle
9. Remove a vehicle
10. Lease a vehicle

## Getting Started:
To run the Car Dealership Management System:
Clone the repository to your local machine.
Open the project in your preferred Java IDE.
Compile and run the mainApp.java file to start the application.
Follow the on-screen instructions to navigate through the menu and perform various operations.

## Usage:
Upon launching the application, you will be presented with a menu of options.
Choose an option by entering the corresponding number.
Follow the prompts to input any necessary information.
The application will execute the selected operation and provide feedback or results accordingly.
Repeat steps 2-4 as needed to perform additional operations.

## One Piece of Interesting Code
This code is interesting because it demonstrates the use of the instanceof operator combined with pattern matching to determine the type of contract (SalesContract or LeaseContract) and dynamically handle each case accordingly. 
This approach allows the saveContract() method to accommodate different types of contracts without the need for separate methods or excessive branching logic.
