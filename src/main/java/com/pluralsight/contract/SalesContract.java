package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public class SalesContract extends Contract {

    // Sales Contract Properties
    private double salesTaxAmount;
    private double recordingFee = 100;
    private double processingFee;
    private boolean isFinancing;

    // Sales Contract Constructor
    public SalesContract(String date, String name, String email, Vehicle vehicle, double totalPrice,
                         double monthlyPayment, boolean isFinancing) {
        super(date, name, email, vehicle, totalPrice, monthlyPayment);
        if (this.vehicle.getPrice() < 10000) {
            this.processingFee = 295;
        } else {
            this.processingFee = 495;
        }
        this.salesTaxAmount = vehicle.getPrice() * 0.05;
        this.isFinancing = isFinancing;
    }

    @Override
    public String toString() {
        StringBuilder salesContractBuilder = new StringBuilder();
        // Type|contract date|name|email|car id|year|make|model|vehicle type|color|odometer|price|sales tax|recording fee|processing fee|total cost|finance|monthly payment
        salesContractBuilder.append("SALE");
        salesContractBuilder.append("|");
        salesContractBuilder.append(date);
        salesContractBuilder.append("|");
        salesContractBuilder.append(name);
        salesContractBuilder.append("|");
        salesContractBuilder.append(email);
        salesContractBuilder.append("|");
        salesContractBuilder.append();
//        return "SalesContract{" +
//                "salesTaxAmount=" + salesTaxAmount +
//                ", recordingFee=" + recordingFee +
//                ", processingFee=" + processingFee +
//                ", isFinancing=" + isFinancing +
//                ", date='" + date + '\'' +
//                ", name='" + name + '\'' +
//                ", email='" + email + '\'' +
//                ", vehicle=" + vehicle +
//                '}';
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


