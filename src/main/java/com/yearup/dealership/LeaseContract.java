package com.yearup.dealership;

import com.pluralsight.Vehicle;

public class LeaseContract extends Contract {
    private double leaseFeeRate;
    private double interestRate;
    private int leaseTerm;

    public LeaseContract(String date, String customerName, String customerEmail, Vehicle vehicle) {
        super(date, customerName, customerEmail, vehicle);
        this.leaseFeeRate = 0.07;
        this.interestRate = 0.04;
        this.leaseTerm = 36;
    }

    public double getTotalPrice() {
        double price = getVehicle().getPrice();
        double endingValue = price * 0.5;
        double leaseFee = price * leaseFeeRate;
        return price - endingValue + leaseFee;
    }

    public double getMonthlyPayment() {
        double price = getVehicle().getPrice();
        double endingValue = price * 0.5;
        double leaseFee = price * leaseFeeRate;
        double loanAmount = price - endingValue + leaseFee;

        double monthlyInterestRate = interestRate / 12;

        return (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -leaseTerm));
    }

    @Override
    public void calculateTotalPrice() {

    }

    @Override
    public void calculateMonthlyPayment() {

    }

    public double getLeaseFeeRate() {
        return leaseFeeRate;
    }

    public void setLeaseFeeRate(double leaseFeeRate) {
        this.leaseFeeRate = leaseFeeRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public int getLeaseTerm() {
        return leaseTerm;
    }

    public void setLeaseTerm(int leaseTerm) {
        this.leaseTerm = leaseTerm;
    }
}

