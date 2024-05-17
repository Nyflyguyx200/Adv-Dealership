package com.yearup.dealership;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ContractFileManager {
    private static final String FILE_PATH = "src/main/resources/contracts.txt";
    private static final double SALES_TAX_RATE = 0.05 ;
    private static final double RECORDING_FEE = 100.0;
    private static final double LOW_PRICE_PROCESSING_FEE = 295.0;
    private static final double HIGH_PRICE_PROCESSING_FEE = 495.0;
    private static final double LEASE_FEE_RATE = 0.07;


    // Method to save contract
    public static void saveContract(Contract contract) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            if (contract instanceof SalesContract salesContract) {
                writer.write(String.format("SALE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f|%s|%.2f%n",
                        salesContract.getDate(),
                        salesContract.getCustomerName(),
                        salesContract.getCustomerEmail(),
                        salesContract.getVehicle().getVin(),
                        salesContract.getVehicle().getYear(),
                        salesContract.getVehicle().getMake(),
                        salesContract.getVehicle().getModel(),
                        salesContract.getVehicle().getVehicleType(),
                        salesContract.getVehicle().getColor(),
                        salesContract.getVehicle().getOdometer(),
                        salesContract.getVehicle().getPrice(),
                        salesContract.getVehicle().getPrice() * SALES_TAX_RATE, RECORDING_FEE,
                        (salesContract.getVehicle().getPrice() < 10000) ? LOW_PRICE_PROCESSING_FEE : HIGH_PRICE_PROCESSING_FEE,
                        salesContract.getTotalPrice(),
                        salesContract.isFinance() ? "YES" : "NO",
                        salesContract.getMonthlyPayment()
                ));
            } else if (contract instanceof LeaseContract leaseContract) {
                writer.write(String.format("LEASE|%s|%s|%s|%d|%d|%s|%s|%s|%s|%d|%.2f|%.2f|%.2f|%.2f%n",
                        leaseContract.getDate(),
                        leaseContract.getCustomerName(),
                        leaseContract.getCustomerEmail(),
                        leaseContract.getVehicle().getVin(),
                        leaseContract.getVehicle().getYear(),
                        leaseContract.getVehicle().getMake(),
                        leaseContract.getVehicle().getModel(),
                        leaseContract.getVehicle().getVehicleType(),
                        leaseContract.getVehicle().getColor(),
                        leaseContract.getVehicle().getOdometer(),
                        leaseContract.getVehicle().getPrice(),
                        leaseContract.getVehicle().getPrice() * 0.5,
                        leaseContract.getVehicle().getPrice() * LEASE_FEE_RATE,
                        leaseContract.getTotalPrice(),
                        leaseContract.getMonthlyPayment()
                ));
            }
        } catch (IOException e) {
            System.out.println("Error saving contract: " + e.getMessage());
        }
    }
}
