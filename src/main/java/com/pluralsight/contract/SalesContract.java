package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public class SalesContract extends Contract {

    // SalesContract Properties
    private double salesTaxAmount = 0.05;
    private double recordingFee = 100;
    private double processingFee;
    private boolean isFinancing;

    // SalesContract Constructor
    public SalesContract(String date, String name, String email, Vehicle vehicle, double totalPrice,
                         double monthlyPayment, double salesTaxAmount, double recordingFee,
                         double processingFee, boolean isFinancing) {
        super(date, name, email, vehicle, totalPrice, monthlyPayment);
        this.salesTaxAmount = salesTaxAmount;
        this.recordingFee = recordingFee;
        this.processingFee = processingFee;
        this.isFinancing = isFinancing;
    }

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

    //Getters & Setters
    public double getProcessingFee() {
        if (this.vehicle.getPrice() < 10000)
            return 295;
        else {
            return 495;
        }
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


