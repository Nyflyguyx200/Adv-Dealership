package com.yearup.dealership;

import com.pluralsight.Vehicle;

public class SalesContract extends Contract {
    private double salesTaxRate;
    private double recordingFee;
    private double lowPriceProcessingFee;
    private double highPriceProcessingFee;
    private double lowPriceInterestRate;
    private double highPriceInterestRate;
    private int lowPriceLoanTerm;
    private int highPriceLoanTerm;
    private boolean finance;

    public SalesContract(String date, String customerName, String customerEmail, String email, Vehicle vehicle, boolean finance) {
        super(date, customerName, customerEmail, vehicle);
        this.salesTaxRate = 0.05;
        this.recordingFee = 100.0;
        this.lowPriceProcessingFee = 295.0;
        this.highPriceProcessingFee = 495.0;
        this.lowPriceInterestRate = 0.0525;
        this.highPriceInterestRate = 0.0425;
        this.lowPriceLoanTerm = 24;
        this.highPriceLoanTerm = 48;
        this.finance = finance;
    }

    public double getTotalPrice() {
        double price = getVehicle().getPrice();
        double salesTax = price * salesTaxRate;
        double processingFee = (price < 10000) ? lowPriceProcessingFee : highPriceProcessingFee;
        return price + salesTax + recordingFee + processingFee;
    }

    public double getMonthlyPayment() {
        if (!finance) {
            return 0.0;
        }

        double price = getVehicle().getPrice();
        double interestRate = (price < 10000) ? lowPriceInterestRate : highPriceInterestRate;
        int loanTerm = (price < 10000) ? lowPriceLoanTerm : highPriceLoanTerm;

        double monthlyInterestRate = interestRate / 12;
        double loanAmount = getTotalPrice();

        return (loanAmount * monthlyInterestRate) /
                (1 - Math.pow(1 + monthlyInterestRate, -loanTerm));
    }

    @Override
    public void calculateTotalPrice() {

    }

    @Override
    public void calculateMonthlyPayment() {

    }

    public boolean isFinance() {
        return finance;
    }

    public void setFinance(boolean finance) {
        this.finance = finance;
    }
}
