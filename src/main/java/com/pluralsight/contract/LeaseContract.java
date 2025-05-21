package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public class LeaseContract extends Contract {

    // Lease Contract Properties (using final so values do not change)
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

        StringBuilder leaseContractBuilder = new StringBuilder();
        Vehicle vehicle = getVehicleSold();
        leaseContractBuilder.append("LEASE").append("|");
        leaseContractBuilder.append(date).append("|");
        leaseContractBuilder.append(name).append("|");
        leaseContractBuilder.append(email).append("|");
        leaseContractBuilder.append(vehicle.getVin()).append("|");
        leaseContractBuilder.append(vehicle.getYear()).append("|");
        leaseContractBuilder.append(vehicle.getMake()).append("|");
        leaseContractBuilder.append(vehicle.getModel()).append("|");
        leaseContractBuilder.append(vehicle.getVehicleType()).append("|");
        leaseContractBuilder.append(vehicle.getColor()).append("|");
        leaseContractBuilder.append(vehicle.getOdometer()).append("|");
        leaseContractBuilder.append(vehicle.getPrice()).append("|");
        leaseContractBuilder.append(expectedEndingValue).append("|");
        leaseContractBuilder.append(leaseFee).append("|");
        leaseContractBuilder.append(getTotalPrice()).append("|");
        leaseContractBuilder.append(getMonthlyPayment());

        return leaseContractBuilder.toString();
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
