package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public class LeaseContract extends Contract {

    // Lease Contract Properties
    private double expectedEndingValue;
    private double leaseFee;

    // Lease Contract Constructor
    public LeaseContract(String date, String name, String email,
                         Vehicle vehicle, double totalPrice,
                         double monthlyPayment) {
        super(date, name, email, vehicle, totalPrice, monthlyPayment);
        this.expectedEndingValue = (vehicle.getPrice() / 2);
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    // Lease Contract Inherited Methods
    @Override
    public double getTotalPrice() {
        return (getVehicleSold().getPrice() - expectedEndingValue) + leaseFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 36;
        double interestRate = 4.0 / 1200;
        double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
        monthlyPayment = Math.round(monthlyPayment * 100);
        monthlyPayment /= 100;
        return monthlyPayment;
    }

    // Lease Contract Getters & Setters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }
    public void setExpectedEndingValue(double expectedEndingValue) {
        this.expectedEndingValue = expectedEndingValue;
    }

    public double getLeaseFee() {
        return leaseFee;
    }
    public void setLeaseFee(double leaseFee) {
        this.leaseFee = leaseFee;
    }
}
