package com.pluralsight.contract;

public class SalesContract extends Contract {
    private final double salesTaxAmount = 0.05;
    private final double recordingFee = 100;
    private boolean isFinancing;



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

    public double getProcessingFee() {
        if (this.vehicle.getPrice() < 10000)
            return 295;
        else {
            return 495;
        }
    }
}
// TifFany's Advice
// -
