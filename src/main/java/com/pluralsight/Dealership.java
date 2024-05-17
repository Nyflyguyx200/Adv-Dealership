package com.pluralsight;

import java.util.ArrayList;
import java.util.List;


public class Dealership {

    private String name;
    private String address;
    private String phone;
    private List<Vehicle> inventory;

    public Dealership(String name, String address, String phone) {
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.inventory = new ArrayList<>();
    }

    public List<Vehicle> searchByPriceRange(double min, double max) {
        return null;
    }

    public List<Vehicle> searchByMakeAndModel(String make, String model) {
        return null;
    }

    public List<Vehicle> searchByYearRange(int minYear, int maxYear) {
        return null;
    }

    public List<Vehicle> searchByColor(String color) {
        return null;
    }

    public List<Vehicle> searchByMileageRange(int minMileage, int maxMileage) {
        return null;
    }

    public List<Vehicle> searchByType(String vehicleType) {
        return null;
    }

    public void addVehicle(Vehicle vehicle) {
        inventory.add(vehicle);
    }

    public void removeVehicle(Vehicle vehicle) {

    }

    public List<Vehicle> getAllVehicles() {
        return inventory;
    }

    public String getName() {
        return name;
    }

    public List<Vehicle> getInventory() {
        return inventory;
    }

    public void setInventory(List<Vehicle> inventory) {
        this.inventory = inventory;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void sellVehicle(Vehicle vehicleToSell, String customerName, String customerEmail) {
    }

    public void leaseVehicle(Vehicle vehicle, String customerName, String customerEmail) {

    }
}


