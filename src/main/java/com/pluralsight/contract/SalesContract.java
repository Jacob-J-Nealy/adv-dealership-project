package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public class SalesContract extends Contract {

    // Sales Contract Properties
    private double salesTaxAmount;
    private double recordingFee = 100;
    private double processingFee;
    private boolean isFinancing;

    // Sales Contract Constructor
    public SalesContract(String date, String name, String email, Vehicle vehicle, boolean isFinancing) {
        super(date, name, email, vehicle);
        if (this.vehicle.getPrice() < 10000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }
        this.salesTaxAmount = vehicle.getPrice() * 0.05;
        this.isFinancing = isFinancing;
    }

    // Sales Contract toString
    @Override
    public String toString() {

        StringBuilder salesContractBuilder = new StringBuilder();
        Vehicle vehicle = getVehicleSold();

        salesContractBuilder.append("SALE").append("|");
        salesContractBuilder.append(date).append("|");
        salesContractBuilder.append(name).append("|");
        salesContractBuilder.append(email).append("|");
        salesContractBuilder.append(vehicle.getVin()).append("|");
        salesContractBuilder.append(vehicle.getYear()).append("|");
        salesContractBuilder.append(vehicle.getMake()).append("|");
        salesContractBuilder.append(vehicle.getModel()).append("|");
        salesContractBuilder.append(vehicle.getVehicleType()).append("|");
        salesContractBuilder.append(vehicle.getColor()).append("|");
        salesContractBuilder.append(vehicle.getOdometer()).append("|");
        salesContractBuilder.append(vehicle.getPrice()).append("|");
        salesContractBuilder.append(salesTaxAmount).append("|");
        salesContractBuilder.append(recordingFee).append("|");
        salesContractBuilder.append(processingFee).append("|");
        salesContractBuilder.append(getTotalPrice()).append("|");
        salesContractBuilder.append(isFinancing).append("|");
        salesContractBuilder.append(getMonthlyPayment());

        return salesContractBuilder.toString();
    }

    // Sales Contract Inherited Methods
    @Override
    public double getTotalPrice() {
        return getVehicleSold().getPrice() + salesTaxAmount + recordingFee + processingFee;
    }

    @Override
    public double getMonthlyPayment() {
        int numberOfPayments = 0;
        double interestRate = 0;
        if (isFinancing) {
            if (getVehicleSold().getPrice() >= 10000) {
                numberOfPayments = 48;
                interestRate = 4.25 / 1200;
            } else {
                numberOfPayments = 24;
                interestRate = 5.25 / 1200;
            }

            double monthlyPayment = getTotalPrice() * (interestRate * Math.pow(1 + interestRate, numberOfPayments)) / (Math.pow(1 + interestRate, numberOfPayments) - 1);
            monthlyPayment = Math.round(monthlyPayment * 100);
            monthlyPayment /= 100;
            return monthlyPayment;
        } else {
            return 0.0;
        }
    }

    // Sales Contract Getters & Setters
    public double getProcessingFee() {
        return processingFee;
    }
    public void setProcessingFee(double processingFee) {
        this.processingFee = processingFee;
    }

    public double getSalesTaxAmount() {
        return salesTaxAmount;
    }
    public void setSalesTaxAmount(double salesTaxAmount) {
        this.salesTaxAmount = salesTaxAmount;
    }

    public double getRecordingFee() {
        return recordingFee;
    }
    public void setRecordingFee(double recordingFee) {
        this.recordingFee = recordingFee;
    }

    public boolean isFinancing() {
        return isFinancing;
    }
    public void setFinancing(boolean financing) {
        isFinancing = financing;
    }
}


