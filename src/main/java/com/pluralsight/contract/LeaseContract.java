package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public class LeaseContract extends Contract {

    // Lease Contract Properties
    private final double expectedEndingValue;
    private final double leaseFee;

    // Lease Contract Constructor
    public LeaseContract(String date, String name, String email,
                         Vehicle vehicle, double totalPrice,
                         double monthlyPayment) {
        super(date, name, email, vehicle, totalPrice, monthlyPayment);
        this.expectedEndingValue = (vehicle.getPrice() / 2);
        this.leaseFee = vehicle.getPrice() * 0.07;
    }

    // Vehicle Contract toString
    @Override
    public String toString() {

        StringBuilder salesContractBuilder = new StringBuilder();
        Vehicle stringVehicle = getVehicleSold();

        salesContractBuilder.append("L").append("|");
        salesContractBuilder.append(date).append("|");
        salesContractBuilder.append(name).append("|");
        salesContractBuilder.append(email).append("|");
        salesContractBuilder.append(stringVehicle.getVin()).append("|");
        salesContractBuilder.append(stringVehicle.getYear()).append("|");
        salesContractBuilder.append(stringVehicle.getMake()).append("|");
        salesContractBuilder.append(stringVehicle.getModel()).append("|");
        salesContractBuilder.append(stringVehicle.getVehicleType()).append("|");
        salesContractBuilder.append(stringVehicle.getColor()).append("|");
        salesContractBuilder.append(stringVehicle.getOdometer()).append("|");
        salesContractBuilder.append(stringVehicle.getPrice()).append("|");
        salesContractBuilder.append(salesTaxAmount).append("|");
        salesContractBuilder.append(recordingFee).append("|");
        salesContractBuilder.append(processingFee).append("|");
        salesContractBuilder.append(getTotalPrice()).append("|");
        salesContractBuilder.append(isFinancing).append("|");
        salesContractBuilder.append(getMonthlyPayment());

        return salesContractBuilder.toString();
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

    // Lease Contract Getters
    public double getExpectedEndingValue() {
        return expectedEndingValue;
    }
    public double getLeaseFee() {
        return leaseFee;
    }

}
