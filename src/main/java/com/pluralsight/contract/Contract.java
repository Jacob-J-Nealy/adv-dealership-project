package com.pluralsight.contract;

import com.pluralsight.Vehicle;

public abstract class Contract {

    // Attributes
    public String  date;
    public String  name;
    public String  email;
    public Vehicle vehicle;
    public double  totalPrice;
    public double  monthlyPayment;

    //Constructor
    public Contract(String date, String name, String email,
                    Vehicle vehicle, double totalPrice,
                    double monthlyPayment) {
        this.date = date;
        this.name = name;
        this.email = email;
        this.vehicle = vehicle;
        this.totalPrice = totalPrice;
        this.monthlyPayment = monthlyPayment;
    }

    // Constructor: Default
    public Contract() {
    }

    // Abstract Methods
    public abstract double getTotalPrice();

    public abstract double getMonthlyPayment();
}
