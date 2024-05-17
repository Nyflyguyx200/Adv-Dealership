package com.pluralsight;

import com.yearup.dealership.ContractFileManager;
import com.yearup.dealership.SalesContract;

import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private Dealership dealership;

    public UserInterface() {
        init();
    }

    private void init() {
        DealershipFileManager dealershipFileManager = new DealershipFileManager();
        this.dealership = dealershipFileManager.getDealership();
    }

    public void display() {
        init();
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            displayMenu();
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    processGetByPriceRequest();
                    break;
                case 2:
                    processGetByMakeModelRequest();
                    break;
                case 3:
                    processGetByYearRequest();
                    break;
                case 4:
                    processGetByColorRequest();
                    break;
                case 5:
                    processGetByMileageRequest();
                    break;
                case 6:
                    processGetByVehicleTypeRequest();
                    break;
                case 7:
                    processAllVehiclesRequest();
                    break;
                case 8:
                    processSellVehicleRequest(scanner);
                    break;
                case 9:
                    processRemoveVehicleRequest();
                    break;
                case 10:
                    processLeaseVehicleRequest(scanner);
                    break;
                case 99:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 99);
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\n==== Dealership Menu ====");
        System.out.println("1. Find vehicles within a price range");
        System.out.println("2. Find vehicles by make/model");
        System.out.println("3. Find vehicles by year range");
        System.out.println("4. Find vehicles by color");
        System.out.println("5. Find vehicles by mileage");
        System.out.println("6. Find vehicles by type (car, truck, SUV, van)");
        System.out.println("7. List ALL vehicles");
        System.out.println("8. Sell a vehicle");
        System.out.println("9. Remove a vehicle");
        System.out.println("99. Quit");
    }

    private void processAllVehiclesRequest() {
        List<Vehicle> allVehicles = dealership.getAllVehicles();
        if (allVehicles.isEmpty()) {
            System.out.println("No vehicles found.");
        } else {
            System.out.println("==== All Vehicles ====");
            for (Vehicle vehicle : allVehicles) {
                System.out.println(vehicle);
            }
        }
    }

    // Update the processSellVehicleRequest method in the UserInterface class
    private void processSellVehicleRequest(Scanner scanner) {
        System.out.print("Enter VIN of the vehicle to sell: ");
        int vin = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        // Find vehicle in inventory
        Vehicle vehicleToSell = null;
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                vehicleToSell = vehicle;
                break;
            }
        }
        if (vehicleToSell != null) {
            System.out.print("Enter customer name: ");
            String customerName = scanner.nextLine();
            System.out.print("Enter customer email: ");
            String customerEmail = scanner.nextLine();

            // Sell the vehicle
            dealership.sellVehicle(vehicleToSell, customerName, customerEmail);
            System.out.println("Vehicle sold successfully!");

            SalesContract salesContract = new SalesContract(
                    vehicleToSell.getMake(),
                    vehicleToSell.getModel(),
                    customerName,
                    customerEmail,
                    vehicleToSell,
                    false // Assuming financed is false for now
            );
            // Save the contract
            ContractFileManager.saveContract(salesContract);
        } else {
            System.out.println("Vehicle with VIN " + vin + " not found.");
        }
    }

    private void processLeaseVehicleRequest(Scanner scanner) {
        System.out.println("Enter VIN of the vehicle to lease:");
        int vin = scanner.nextInt();
        // Find the vehicle in inventory by VIN
        Vehicle vehicle = findVehicleByVIN(vin);
        if (vehicle != null) {
            System.out.println("Enter customer name:");
            String customerName = scanner.next();
            System.out.println("Enter customer email:");
            String customerEmail = scanner.next();
            // Lease the vehicle
            dealership.leaseVehicle(vehicle, customerName, customerEmail);
            System.out.println("Vehicle leased successfully.");
        } else {
            System.out.println("Vehicle not found.");
        }
    }

    private Vehicle findVehicleByVIN(int vin) {
        for (Vehicle vehicle : dealership.getAllVehicles()) {
            if (vehicle.getVin() == vin) {
                return vehicle;
            }
        }
        return null;
    }
    private void processGetByPriceRequest () {
    }

    private void processGetByMakeModelRequest () {
    }

    private void processGetByYearRequest () {
    }

    private void processGetByColorRequest () {
    }

    private void processGetByMileageRequest () {
    }

    private void processGetByVehicleTypeRequest () {
    }

    private void processAddVehicleRequest () {
    }

    private void processRemoveVehicleRequest () {
    }
}





